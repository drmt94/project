package com.project.Controllers;

import com.project.Models.Call;
import com.project.Persist;
import com.project.Utils.Repositories;
import com.project.Utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.List;




@RestController
@Transactional
public class PhoneCallController {
    @Autowired
    Repositories repositories;
    @Autowired
    Persist persist;
    @Autowired
    Validator validator;

    @RequestMapping(value = "/receiveData", method = RequestMethod.POST)
    public void receiveData(
            @RequestParam String callDate,
            @RequestParam String callState,
            @RequestParam int callDuration,
            @RequestParam String phoneNumber
    ) throws Exception {
        if (repositories.getBlackList().contains(phoneNumber)){
            throw new Exception("The phone number is on a Black List!");
        } else if (!validator.isValidState(callState))
        {
            throw new Exception("Invalid call status");
        }
        else {
            Call c = new Call(callDate, callState, callDuration, phoneNumber, validator.isContact(phoneNumber));
            persist.save(c);
        }
    }


    @RequestMapping(value = "/getAllRecords", method = RequestMethod.GET)
    public List getAllRecords(String phoneNumber)
    {

        List<Call> filteredCallsList = persist.getQuerySession().createQuery("FROM Call WHERE phoneNumber = :phoneNumber")

                .setParameter("phoneNumber", phoneNumber)
                .list();
        return filteredCallsList;
    }
    @RequestMapping(value = "/getAllDurationLimitCalls", method = RequestMethod.GET)
    public List getAllDurationLimitCalls(int duration)
    {

        List<Call> filteredCallsList = persist.getQuerySession().createQuery("FROM Call WHERE duration > :duration")

                .setParameter("duration", duration)
                .list();
        return filteredCallsList;
    }

    @RequestMapping(value = "/updatePhoneNumber", method = RequestMethod.POST)
    public void updatePhoneNumber(String oldNumber, String newNumber)
    {
        persist.getQuerySession().createQuery("UPDATE Call c SET c.phoneNumber = :newNumber, c.savedContact = :savedContact WHERE c.phoneNumber = :oldNumber")
        .setParameter("newNumber",newNumber)
        .setParameter("oldNumber", oldNumber)
        .setParameter("savedContact",validator.isContact(newNumber))
                .executeUpdate();

    }

}

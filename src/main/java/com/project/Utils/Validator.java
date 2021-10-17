package com.project.Utils;

import com.project.Objects.Entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validator {
    @Autowired Repositories repositories;
    public boolean isContact(String phoneNumber)
    {
        List contactList = repositories.getContactList();
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = (Contact) contactList.get(i);
            if(phoneNumber.equals(contact.getPhoneNumber())){
                return true;
            }
        }
        return false;
    }
    public boolean isValidState(String callState)
    {
        return (callState.toLowerCase().equals("incoming") ||
                callState.toLowerCase().equals("outgoing"));

    }


}

package com.project.Utils;

import com.project.Objects.Entities.Contact;
import org.springframework.stereotype.Component;
import java.util.ArrayList; // import the ArrayList class
import java.util.List;

@Component
public class Repositories {
    public List getBlackList(){
        return new ArrayList<String>(){{
            add("0560265187");
            add("0563803925");
            add("0510888303");
            add("0567457626");
            add("0595760680");
        }};
    }

    public List getContactList() {
        List list =  new ArrayList<Contact>(){{
            add(new Contact("moshe","0513153847"));
            add(new Contact("david","0518617755"));
            add(new Contact("dana","0596580283"));
            add(new Contact("michal","0594372654"));
            add(new Contact("erez","0511142653"));
            add(new Contact("guy","0598558770"));
        }};
        return list;
    }

}

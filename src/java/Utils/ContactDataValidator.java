/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import DataModel.BirthDay;
import DataModel.Person;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * This class has one method that will deal with user entered data for validation
 * before the data is save into the Map. 
 * @author Ryan Hilsabeck
 */
public class ContactDataValidator {
    
    public static void validate(HttpServletRequest req, Person p, Map errorMap)
    {
        //This will get the first name parameter entered by user and check
        //the length. If the user didn't enter anything in, then an error
        //message will be entered in the error map.
        String firstname = req.getParameter("FirstName");
        if(firstname.length() == 0)
        {
            errorMap.put("First Name","First Name is a required field." );
        }
        
        //This will get the last name parameter entered by user and check
        //the length. If the user didn't enter anything in, then an error
        //message will be entered in the error map.
        String lastname = req.getParameter("LastName");
        if(lastname.length() == 0)
        {
            errorMap.put("Last Name", "Last Name is a required field.");
        }
        //This will get the phone parameter entered by user and check
        //the length. If the user didn't enter anything in, then an error
        //message will be entered in the error map.
        String phone = req.getParameter("Phone");
        if(phone.length() == 0)
        {
            errorMap.put("Phone", "Phone number is a required field.");
        }
        //This else statement will check if the user did enter something into
        //the phone field but it is in the incorrect format and will add
        //an error message to error map if this is the case.
        else
        {
            Pattern phonePattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
            Matcher phoneMatcher = phonePattern.matcher(phone);
            
            if(!phoneMatcher.matches())
            {
            errorMap.put("PhoneSyntax","Phone number required in form 123-456-7899");
            }
        }
        //We will then add all the fields entered by user into the empty person
        //object and this will either be used to add the contact to the database/
        //edit contacts info, or if their were errors entered into the errormap,
        //it will be used to fill out the form again with what the user entered 
        //in.
        BirthDay bDay = new BirthDay(req.getParameter("BirthDay"));
        p.setFirstName(firstname);
        p.setLastName(lastname);
        p.setBirthDay(bDay);
        p.setPhone(phone);
  
        
    }
    
}

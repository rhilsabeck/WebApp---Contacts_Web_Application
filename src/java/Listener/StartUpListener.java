/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listener;

import DataModel.BirthDay;
import DataModel.Person;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 * This is a listener that does context initializations when the web app starts
 * up. It creates a  new Map, adds two person objects to Map and then adds
 * the map as an attribute to the servlet context so it can be available by 
 * all of the web apps resources.
 * @author Ryan Hilsabeck
 */
public class StartUpListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String,Person> contactMap = new TreeMap<>();
        
        BirthDay bday1 = new BirthDay(12,7,1980);
        Person contact1 = new Person("Bill", "Miller", "555-655-5433", bday1);
        contactMap.put(contact1.getLastName(), contact1);
        
        BirthDay bday2 = new BirthDay(4, 3, 1977);
        Person contact2 = new Person("Lucy", "Swann", "555-322-0888", bday2);
        contactMap.put(contact2.getLastName(), contact2);
       
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("MyContactMap", contactMap);    
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

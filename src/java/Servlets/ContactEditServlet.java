/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import DataModel.BirthDay;
import DataModel.Person;
import Utils.ContactDataValidator;
import Utils.HtmlForms;
import Utils.HtmlUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *This servlet will handle the edit details portion of the contact web app. It 
 * will grab a form template that will be filled out with the contact details
 * that the user can edit. Once edited, the user can submit that changes/additions
 * and it will run through a validation process and either send back the form
 * with the filled out fields the user entered with error messages, or it will
 * modify the object and then send a message back to user stating this has been
 * done.
 * @author Ryan Hilsabeck
 */
@WebServlet(name = "ContactEditServlet", urlPatterns = {"/ContactEditServlet"})
public class ContactEditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactEditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContactEditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //The below will get the key of the contact's person object from the
        //url query string and use that to get the person object values for 
        //that contact. It will then pre-fill out a form template with those 
        //details for the user to edit and then the user can either submit, reset,
        //or go back to the main page.
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactsEditServlet</title>"); 
            out.println("<style type=\"text/css\">\n" +
            "tr:nth-child(even) {background: #FFF}\n" +
            "tr:nth-child(odd) {background: #CCC}\n" +
            "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>CSC 415/515 Contacts Database Web App</h2>");
            ServletContext req = request.getServletContext();
            Map<String, Person> foundMap = (Map<String, Person>) req.getAttribute("MyContactMap");
            String key = request.getParameter("lastname");
            out.println("<b>Edit Details for " + key + "</b>");
            out.println("<br>");
            out.println("<b>Entries marked * are required</b>");
            Person pdetails = foundMap.get(key);
            String fname = pdetails.getFirstName();
            String lname = pdetails.getLastName();
            BirthDay bDay = pdetails.getBirthDay();
            String sbDay = bDay.toString();
            String phone = pdetails.getPhone();
            String form = String.format(HtmlForms.contactEditForm, fname, lname, sbDay,phone,key);
            out.print(form);
            out.println("<br>");
            out.println(HtmlUtils.link("Return to Main Page", "index.html"));
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,String> errorMap = new HashMap();  //create empty error map
        Person p = new Person();                      //create empty person object
        //pass the request, person object, and errormap to the validate method
        //to do validation of the user entered/modified data
        ContactDataValidator.validate(request, p, errorMap);
        ServletContext req = request.getServletContext();
        Map<String, Person> foundMap = (Map<String, Person>) req.getAttribute("MyContactMap");
        //Grab the key value again from the request so we can keep track of the
        //contact we are editing
        String key = request.getParameter("keyvalue");
        //check error map, if kept, do below
        if(errorMap.isEmpty())
        {
        //this will remove the original object by the original key from the contact
        foundMap.remove(key);
        //this will create a new mapping for the edited person object
        foundMap.put(p.getLastName(), p);
        //This will then print out to user that the contact has been modified
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactEditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>CSC 415/515 Contacts Database Web App</h2>");
            out.println("<p>The contact infomation for " + p.toString() + 
                        " has been modified.</p>");
            out.println(HtmlUtils.link("Return to Main Page", "index.html"));
            out.println("</body>");
            out.println("</html>");
          }
        }
        //if the error map is not empty, that means that the data entered by the
        //user was not validated correctly. So we pull the values from the person
        //object created in the validation method.
        else
        {
        String fname = p.getFirstName();
        String lname = p.getLastName();
        String phone = p.getPhone();
        BirthDay bday = p.getBirthDay();
        String strBday = bday.toString();
        //We put the error messages into a collection
        Collection<String> errorMessages = errorMap.values();
            
        response.setContentType("text/html;charset=UTF-8");
        //We can then give the user back the form that they had filled out with
        //the error messages to let them know what needs to be corrected/added.
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactEditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>CSC 415/515 Contacts Database Web App</h2>");
            out.println("Edit Details for " + request.getParameter("keyvalue"));
            out.println("<br>");
            out.println("<span style='color:red;'>");
            for(String error : errorMessages)
            {
                out.println(error);
                out.println("<br>");
            }
            out.println("</span>\n");
            out.println("Entries Marked * are required");
            String form = String.format(HtmlForms.contactEditErrorForm,fname,lname,strBday,phone,key);
            out.print(form);
            out.println("<br>");
            out.println("<a href='index.html'>Return to Main Page</a>");
            out.println("</body>");
            out.println("</html>");
        } 
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

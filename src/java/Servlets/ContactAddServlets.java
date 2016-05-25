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
 * This servlet will only handle post requests from the addcontact.html static
 * web page.It will handle validation of the user entered data and then either
 * storing the data into a new person object and storing that into the map or
 * if validation did not pass, it will send the form back to the user with
 * the fields they had filled out with the error messages for the fields that
 * need corrections.
 * @author Ryan
 */
@WebServlet(name = "ContactAddServlets", urlPatterns = {"/ContactAddServlets"})
public class ContactAddServlets extends HttpServlet {

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
            out.println("<title>Servlet ContactAddServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContactAddServlets at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        Map<String,String> errorMap = new HashMap(); //create empty errormap
        Person p = new Person();                    //create empty person object
        //pass request, person and errormap for validation
        ContactDataValidator.validate(request, p, errorMap);
        //check errormap, if empty, then do below
        if(errorMap.isEmpty())
        {
        //Obtain servlet context and the map for contact storage
        ServletContext req = request.getServletContext();
        Map<String, Person> foundMap = (Map<String, Person>) req.getAttribute("MyContactMap");
        //put new contact into map storage
        foundMap.put(p.getLastName(), p);
        //output html code for user to see that contact has been added and
        //link back to main page.
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactAddServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>CSC 415/515 Contacts Database Web App</h2>");
            out.println("<p>The contact infomation for " + p.toString() + 
                        " has been added.</p>");
            out.println(HtmlUtils.link("Return to Main Page", "index.html"));
            out.println("</body>");
            out.println("</html>");
          }
        }
        //Will go here if errormap is not empty.That means the data did not pass
        //validation. We will pull the data fields entered in by user from the
        //person object created inside validation method.
        else
        {
        String fname = p.getFirstName();
        String lname = p.getLastName();
        String phone = p.getPhone();
        BirthDay bday = p.getBirthDay();
        String strBday = bday.toString();
        //Create collection to hold error messages that were added to erromap
        Collection<String> errorMessages = errorMap.values();
        //Below will create html code with add contact error form that will
        //include the error messages and the fields filled out to what the user
        //had previously entered. 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactAddServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>CSC 415/515 Contacts Database Web App</h2>");
            out.println("<h2>Add a Contact</h2>");
            out.println("<span style='color:red;'>");
            for(String error : errorMessages)
            {
                out.println(error);
                out.println("<br>");
            }
            out.println("</span>\n");
            out.println("Entries Marked * are required");
            String form = String.format(HtmlForms.contactAddErrorForm, fname, lname, strBday,phone);
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

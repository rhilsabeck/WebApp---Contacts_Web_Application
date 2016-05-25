/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import DataModel.BirthDay;
import DataModel.Person;
import Utils.HtmlForms;
import Utils.HtmlUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet will be brought up when the user clicks on the delete link on 
 * that contacts row in the contact details page. It is read only and will give 
 * the option of the user to delete the contact or they can cancel the request
 * and head back to the home page.
 * @author Ryan Hilsabeck
 */
@WebServlet(name = "ContactDeleteServlet", urlPatterns = {"/ContactDeleteServlet"})
public class ContactDeleteServlet extends HttpServlet {

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
            out.println("<title>Servlet ContactDeleteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContactDeleteServlet at " + request.getContextPath() + "</h1>");
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
        //This will bring back a form that will be read only and will be filled
        //out with the user details and have a submit button and a cancel and
        //return to main page button.
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactsDeleteServlet</title>"); 
            out.println("<style type=\"text/css\">\n" +
            "tr:nth-child(even) {background: #FFF}\n" +
            "tr:nth-child(odd) {background: #CCC}\n" +
            "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CSC 415/515 Contacts Database Web App</h1>");
            ServletContext req = request.getServletContext();
            Map<String, Person> foundMap = (Map<String, Person>) req.getAttribute("MyContactMap");
            //This will get the parameter that is passed into the query string in
            //the url(last name of contact which is the key in the map.
            String key = request.getParameter("lastname");
            out.println("<b>Delete Contact Information for " + key + "</b>");
            //Use the key to get person object from and get all details to fill
            //in the placeholders in template form
            Person pdetails = foundMap.get(key);
            String fname = pdetails.getFirstName();
            String lname = pdetails.getLastName();
            BirthDay bDay = pdetails.getBirthDay();
            String sbDay = bDay.toString();
            String phone = pdetails.getPhone();
            String form = String.format(HtmlForms.contactDeleteForm, fname, lname, sbDay,phone,lname);
            out.print(form);
           out.println("<br>");
           out.println("<a href=index.html> Cancel and Return to Main Page</a>");
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
        String fname = request.getParameter("FirstName");
        String lname = request.getParameter("LastName");
        String key = request.getParameter("keyvalue");
        ServletContext req = request.getServletContext();
        Map<String, Person> foundMap = (Map<String, Person>) req.getAttribute("MyContactMap");
        //When the user hits the submit button on the delete form, the request
        //will go to this method and the person object will be deleted from 
        //the contact map.
        foundMap.remove(key);
        //Below gives html code that tells user that the contact info has been
        //deleted from contact list and has a link back to the main page.
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactDeleteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>CSC 415/515 Contacts Database Web App</h2>");
            out.println("<p>The contact infomation for " + fname + " " + lname +
                        " has been deleted.</p>");
            out.println(HtmlUtils.link("Return to Main Page", "index.html"));
            out.println("</body>");
            out.println("</html>");
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

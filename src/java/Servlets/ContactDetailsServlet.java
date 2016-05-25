/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import DataModel.BirthDay;
import DataModel.Person;
import Utils.HtmlForms;
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
 * This servlet will handle displaying the details of a selected contact in a 
 * read only form.
 * @author Ryan Hilsabeck
 */
@WebServlet(name = "ContactDetailsServlet", urlPatterns = {"/ContactDetailsServlet"})
public class ContactDetailsServlet extends HttpServlet {

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
            out.println("<title>Servlet ContactDetailsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContactDetailsServlet at " + request.getContextPath() + "</h1>");
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
    //The do get method is called by this servlet when a user clicks on the see
    //details link by the contact they want to see the details
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactsDetailsServlet</title>"); 
            out.println("<style type=\"text/css\">\n" +
            "tr:nth-child(even) {background: #FFF}\n" +
            "tr:nth-child(odd) {background: #CCC}\n" +
            "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>CSC 415/515 Contacts Database Web App</h2>");
            ServletContext req = request.getServletContext();
            Map<String, Person> foundMap = (Map<String, Person>) req.getAttribute("MyContactMap");
            //Gets the parameter sent through the query string in the url. This
            //is the key of the person object(last name) so we can obtain the 
            //person object values.
            String key = request.getParameter("lastname");
            out.println("<b>View Details for " + key + "</b>");
            //Get person object via key and put values into strings.
            Person pdetails = foundMap.get(key);
            String fname = pdetails.getFirstName();
            String lname = pdetails.getLastName();
            BirthDay bDay = pdetails.getBirthDay();
            String strbDay = bDay.toString();
            String phone = pdetails.getPhone();
            //Put the user details into the fields of a form template that is
            //read only.
            String form = String.format(HtmlForms.contactDetailsForm, fname, lname, strbDay,phone);
            out.print(form);
           out.println("<br>");
           out.println("<a href=index.html>Return to Main Page</a>");
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
        processRequest(request, response);
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

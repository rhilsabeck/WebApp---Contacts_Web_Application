/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import DataModel.Person;
import Utils.HtmlUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet will show the list of contacts that have been stored in the map.
 * It will show first and last name, and then have 3 links to do certain things 
 * with that contact(see details, edit, or delete).
 * @author Ryan Hilsabeck
 */
@WebServlet(name = "ContactsDisplayServlet", urlPatterns = {"/ContactsDisplayServlet"})
public class ContactsDisplayServlet extends HttpServlet {

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
            out.println("<title>Servlet ContactsDisplayServlet</title>"); 
            out.println("<style type=\"text/css\">\n" +
            "tr:nth-child(even) {background: #FFF}\n" +
            "tr:nth-child(odd) {background: #CCC}\n" +
            "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>CSC 415/515 Contacts Database Web App</h2>");
            ServletContext req = request.getServletContext();
            Map<String, Person> foundMap = (Map<String, Person>) req.getAttribute("MyContactMap");
            //This checks to see if map stored in servlet context is empty. If
            //no contacts are currentely being stored, it will show the below message.
            if(foundMap.isEmpty())
            {
                out.println("<p>There are no contacts to display</p>");
            }
            //If the map is not empty, then it will print out a table with the
            //lists of contacts. It will cycle through each contact, obtaining
            //the first and last name, the key(which is also the last name),and
            //will have three links so the usercan see details, edit, or delete
            //that contact(the links have a query string with the contact's
            //key so we can obtain their info in another servlet.
            else
            {
            out.println("<b>List of Contacts</b>");
            out.println("<table border='1' cellspacing='0' cellpadding='5'>");
            out.println("<tbody>");      
            Set<Map.Entry<String, Person>> contacts = foundMap.entrySet();
            for(Map.Entry<String, Person> entry : contacts)
            {
                Person p = entry.getValue();
                String k = entry.getKey();
                String fname = p.getFirstName();
                String lname = p.getLastName();
                out.println("<tr>");
                out.println("<td><b>" + fname + "</b></td>");
                out.println("<td><b>" + lname + "</b></td>");
                out.println("<td>" + HtmlUtils.link("ContactDetailsServlet", "lastname", k, "See Details") + "</td>");
                out.println("<td>" + HtmlUtils.link("ContactEditServlet","lastname", k, "Edit") + "</td>");
                out.println("<td>" + HtmlUtils.link("ContactDeleteServlet", "lastname", k, "Delete") + "</td>");
                out.println("</tr>");  
  
            }
            out.println("</tbody>");
            out.println("</table>");
            }
           out.println("<br>");
           out.println("<pre><a href=addContact.html>Add Contact</a>  " +
                "<a href=index.html>Return to Main Page</a></pre>");
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

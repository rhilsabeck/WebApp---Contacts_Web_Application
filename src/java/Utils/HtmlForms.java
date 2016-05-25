/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

/**
 *This class is to hold String templates for the different forms that will be
 * used in this web app.
 * @author Ryan Hilsabeck
 */
public class HtmlForms {
    
  public static final String contactDetailsForm =    
    "<form method = 'post' action='ContactDetailsServlet'>\n" +
    "<table border='1' cellspacing='0' cellpadding='5'>\n" +
        "<tbody>\n" +
            "<tr>\n" +
                "<td> <b>First Name</b>  </td>\n" +
                "<td>  <input type='text' Style= 'background:#CCC;' name='FirstName' value='%s' size='25' readonly /> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Last Name</b>   </td>\n" +
                "<td>  <input type='text' Style= 'background:#CCC;' name='LastName' value='%s' size='25' readonly/> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> BirthDay</b>  </td>\n" +
                "<td>  <input type='text' Style= 'background:#CCC;'  name='BirthDay' value='%s' size='25' readonly/>  </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Phone</b>   </td>\n" +
                "<td>  <input type='text' Style= 'background:#CCC;' name='Phone' value='%s' size='20' readonly/> * </td>\n" +
            "</tr>\n" +
          "</tbody>\n" +
         "</table>\n" +        
        "<br/>\n" +
      "</form>\n";
  
  
  
  public static final String contactDeleteForm =    
    "<form method = 'post' action='ContactDeleteServlet'>\n" +
    "<table border='1' cellspacing='0' cellpadding='5'>\n" +
        "<tbody>\n" +
            "<tr>\n" +
                "<td> <b>First Name</b>  </td>\n" +
                "<td>  <input type='text' Style= 'background:#CCC;' name='FirstName' value='%s' size='25' readonly /> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Last Name</b>   </td>\n" +
                "<td>  <input type='text' Style= 'background:#CCC;' name='LastName' value='%s' size='25' readonly/> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> BirthDay</b>  </td>\n" +
                "<td>  <input type='text' Style= 'background:#CCC;' name='BirthDay' value='%s' size='25' readonly/>  </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Phone</b>   </td>\n" +
                "<td>  <input type='text' Style= 'background:#CCC;' name='Phone' value='%s' size='20' readonly/> * </td>\n" +
            "</tr>\n" +
          "</tbody>\n" +
         "</table>\n" +        
        "<br/>\n" +
        "<input type='submit' value='Submit'/>\n" +
        "<input type='hidden' name ='keyvalue' value='%s'>" +
      "</form>\n";
  
   public static final String contactEditForm =    
    "<form method = 'post' action='ContactEditServlet'>\n" +
    "<table border='1' cellspacing='0' cellpadding='5'>\n" +
        "<tbody>\n" +
            "<tr>\n" +
                "<td> <b>First Name</b>  </td>\n" +
                "<td>  <input type='text' name='FirstName' value='%s' size='25' /> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Last Name</b>   </td>\n" +
                "<td>  <input type='text' name='LastName' value='%s' size='25'/> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> BirthDay</b>  </td>\n" +
                "<td>  <input type='text' name='BirthDay' value='%s' size='25'/>  </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Phone</b>   </td>\n" +
                "<td>  <input type='text' name='Phone' value='%s' size='20'/> * </td>\n" +
            "</tr>\n" +
          "</tbody>\n" +
         "</table>\n" +        
        "<br/>\n" +
        "<input type='reset' value='Reset' /><input type='submit' value='Submit' />\n" +
        "<input type='hidden' name ='keyvalue' value='%s'>\n" +
      "</form>\n";
   
   
  public static final String contactAddErrorForm =    
    "<form method = 'post' action='ContactAddServlets'>\n" +
    "<table border='1' cellspacing='0' cellpadding='5'>\n" +
        "<tbody>\n" +
            "<tr>\n" +
                "<td> <b>First Name</b>  </td>\n" +
                "<td>  <input type='text' name='FirstName' value='%s' size='25' /> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Last Name</b>   </td>\n" +
                "<td>  <input type='text' name='LastName' value='%s' size='25' /> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> BirthDay</b>  </td>\n" +
                "<td>  <input type='text'  name='BirthDay' value='%s' size='25'/>  </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Phone</b>   </td>\n" +
                "<td>  <input type='text' name='Phone' value='%s' size='20' /> * </td>\n" +
            "</tr>\n" +
          "</tbody>\n" +
         "</table>\n" +        
        "<br/>\n" +
        "<input type='reset' value='Reset' /><input type='submit' value='Submit' />\n" +
      "</form>\n";
  
  
  public static final String contactEditErrorForm =
    "<form method = 'post' action='ContactEditServlet'>\n" +
    "<table border='1' cellspacing='0' cellpadding='5'>\n" +
        "<tbody>\n" +
            "<tr>\n" +
                "<td> <b>First Name</b>  </td>\n" +
                "<td>  <input type='text' name='FirstName' value='%s' size='25' /> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Last Name</b>   </td>\n" +
                "<td>  <input type='text' name='LastName' value='%s' size='25'/> * </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> BirthDay</b>  </td>\n" +
                "<td>  <input type='text' name='BirthDay' value='%s' size='25'/>  </td>\n" +
            "</tr>\n" +
            "<tr>\n" +
                "<td><b> Phone</b>   </td>\n" +
                "<td>  <input type='text' name='Phone' value='%s' size='20'/> * </td>\n" +
            "</tr>\n" +
          "</tbody>\n" +
         "</table>\n" +        
        "<br/>\n" +
        "<input type='reset' value='Reset' /><input type='submit' value='Submit' />\n" +
        "<input type='hidden' name ='keyvalue' value='%s'>\n" +
      "</form>\n";
          
    
}

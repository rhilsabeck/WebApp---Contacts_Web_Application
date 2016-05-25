/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.io.PrintWriter;
/**
 *This is the htmlutils class which methods can be used to simplify writing
 * out html code inside java code.
 * @author Ryan Hilsabeck
 */
public class HtmlUtils
{
    private static PrintWriter out = null; // Response writer to write to
    /**
     * Sets the Response writer to write to
     * @param out 
     */
    public static void setWriter(PrintWriter out)
    {
       HtmlUtils.out = out;
    }
    /**
     * Outputs the start of a HTML tag
     * @param tag 
     */
    public static void startTag(String tag)
    {
        out.printf("<%s> ", tag);
    }
    /**
     * Outputs the start tag with the given attribute-value pairs
     * @param tag
     * @param attrs : names of attributes
     * @param vals : values for the attributes
     */
    public static void startTag(String tag, String [] attrs, String[] vals)
    {
        out.printf("<%s ", tag); 
        for (int k = 0; k < attrs.length; k++)
        {
            out.printf("%s = %s ", attrs[k], vals[k]);
        }
        out.printf(">");
    }
    /**
     * Outputs the closing end of the tag
     * @param tag 
     */
    public static void endTag(String tag)
    {
        out.printf("</%s>", tag);
    }
    /**
     * Outputs a start and end tag pair enclosing the given innerHTML
     * @param tag
     * @param innerHTML 
     */
    public static void doElement(String tag, Object innerHTML)
    {
        out.printf("<%s> %s </%s>", tag, innerHTML, tag);
    }
    /**
     * Outputs a tag with the given attribute-value pairs enclosing 
     * the innerHTML string as the tag content
     * @param tag
     * @param innerHTML
     * @param attrs: names of the attributes
     * @param vals : values for the attributes
     */
    public static void doElement(String tag, Object innerHTML, 
                               String [] attrs, String[] vals)
    {
        startTag(tag, attrs, vals);
        out.print(innerHTML);
        endTag(tag);
    }
    /**
     * Returns a link of the form <a href='action'> label </a>
     * @param label
     * @param action
     * @return 
     */
    public static String link(String label, String action)
    {
        return String.format("<a href='%s'> %s </a>", action, label);
    }
    /**
     * Returns a link of the form <a href='action?queryVarName=queryValue'> label </a>
     * @param action
     * @param queryVarName
     * @param queryValue
     * @param label
     * @return 
     */
    public static String link( String action, String queryVarName, String queryValue, String label)
    {
        return String.format("<a href='%s?%s=%s'> %s </a>", action, queryVarName, queryValue, label);
    }    
}

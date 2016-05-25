/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataModel;

/**
 *This class is to deal with birth days entered and how to get them turned
 * from a birthday class objects into a string object.
 * @author Ryan Hilsabeck
 */
import java.util.Scanner;
public class BirthDay
{
    private int month;
    private int day;
    private int year;
    public BirthDay()
    {
    }
    public BirthDay(String bDay)
    {
        if (bDay.length()== 0)
        {           
            return;
        }
        Scanner sc = new Scanner(bDay).useDelimiter("/");
        month = sc.nextInt();      
        day = sc.nextInt();      
        year = sc.nextInt();        
    }
    public BirthDay(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }
    public int getMonth()
    {
        return month;
    }
    public void setMonth(int month)
    {
        this.month = month;
    }
    public int getDay()
    {
        return day;
    }
    public void setDay(int day)
    {
        this.day = day;
    }
    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    } 
    @Override
    public String toString()
    {
        return String.format("%d/%d/%d", month, day, year);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataModel;

/**
 *This class handles created new person objects and several constructors and 
 * methods that deal with the person class.
 * @author Ryan Hilsabeck
 */

public class Person
{
   private String firstName;
   private String lastName;
   private String phone;
   private BirthDay birthDay;
   
   public Person(){}
   public Person(String firstName, String lastName, String phone, BirthDay bDay)
   {
       this.firstName = firstName;
       this.lastName = lastName;
       this.phone = phone;
       this.birthDay = bDay;
   }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public BirthDay getBirthDay()
    {
        return birthDay;
    }
    public void setBirthDay(BirthDay birthDay)
    {
        this.birthDay = birthDay;
    }
    
   @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}

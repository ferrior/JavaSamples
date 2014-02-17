/**
 * 
 */
package com.bliu.mockito;

/**
 * @author bliu
 *
 */
public class Person
{
    private final Integer personID;
    private final String personName;
    public Person( Integer personID, String personName )
    {
        this.personID = personID;
        this.personName = personName;
    }
    
    public Integer getPersonID(int id)
    {
        return personID;
    }
    
    public Integer getPersonID()
    {
        return personID;
    }
    public String getPersonName()
    {
        return personName;
    }
    
    public String getPersonName(Person p, int id, PersonType type)
    {
        return personName;
    }
    
    
} 

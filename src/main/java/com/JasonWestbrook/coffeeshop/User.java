package com.JasonWestbrook.coffeeshop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users_Database")
public class User
{

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String gender;
    String password;
    String passwordHash;
    byte[] salt;
    Boolean adminRights;
    
    public User() {}
    
    public User(Long id, String userName, String firstName, String lastName, String email, 
                 String gender, String password, String passwordHash, byte[] salt,Boolean adminRights)
    {
        super();
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.adminRights = adminRights;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName(String lastName)
    {
        return this.lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPasswordHash()
    {
        return this.passwordHash;
    }
    
    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }
    
    public byte[] getSalt()
    {
       return this.salt;
    }
    
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setSalt(byte[] salt)
    {
        this.salt = salt;
    }
    
    public boolean getAdminRights()
    {
        return this.adminRights;
    }
    
    public void setAdminRights(Boolean adminRights)
    {
        this.adminRights = adminRights;
    }
}

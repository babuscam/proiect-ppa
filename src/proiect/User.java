/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

/**
 *
 * @author
 */
public class User {
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String phone;

    public User(String lastname, String firstname, String email, String phone) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
    }
    
    public int getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }

	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

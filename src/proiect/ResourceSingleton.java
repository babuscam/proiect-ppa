package proiect;

import java.util.ArrayList;

public final class ResourceSingleton {
	private static ResourceSingleton INSTANCE;
	private int LoginFails = 0;
	private int NrUsers = 0;
	private int NrTasks = 0;
	private ArrayList<User> users = new ArrayList<User>();
	
    public static ResourceSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ResourceSingleton();
        }
        
        return INSTANCE;
    }
    
    public User getUser(String name) {
    	for(User user: users) {
    		if(user.getLastname().equals(name)) {
    			return user;
    		}
    	}
    	
    	return null;
    }
    
    public void addUser(User user) {
    	users.add(user);
    }
	
    public int getLoginFails() {
		return LoginFails;
	}
    
    public int getNrTasks() {
		return NrTasks;
	}
    
    public int getNrUsers() {
		return NrUsers;
	}
    
    public void addLoginFails() {
		LoginFails++;
	}
    
    public void setNrTasks(int nrTasks) {
		NrTasks = nrTasks;
	}
    
    public void setNrUsers(int nrUsers) {
		NrUsers = nrUsers;
	}
}

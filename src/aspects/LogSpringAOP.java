package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import proiect.LogService;
import proiect.ResourceSingleton;
import proiect.User;
import proiect.UserService;

@Aspect
public class LogSpringAOP{
	
	@After("execution(* UserService.addUser(User)) && args(user)")
	public void UserAdd(User user) {
		String message = "[Spring-AOP]A fost adaugat utilizatorul " + user.getEmail();
		LogService.addLog(message);
		
		ResourceSingleton resource = ResourceSingleton.getInstance();
		resource.setNrUsers(resource.getNrUsers() + 1);
	}
	
	@Before("execution(* UserService.deleteUser(int)) && args(id)")
	public void UserDelete(int id) {
		User user = UserService.getUserById(id);
		
		if(user != null) {
			String message = "[Spring-AOP]A fost sters utilizatorul " + user.getEmail();
			LogService.addLog(message);
		}
		
		ResourceSingleton resource = ResourceSingleton.getInstance();
		int currentNrUsers = resource.getNrUsers();
		
		resource.setNrUsers(currentNrUsers > 0 ? currentNrUsers - 1 : 0);
		resource.removeUser(user);
	}
}
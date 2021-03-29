package aspects;

import java.sql.SQLException;

import proiect.*;
public aspect LogAspect {
	pointcut callUserAdd(User user): execution(* UserService.addUser(User)) && args(user);
	pointcut callUserDelete(int id): execution(* UserService.deleteUser(int)) && args(id);

	after(User user):callUserAdd(user){
		String message = "A fost adaugat utilizatorul " + user.getEmail();
		LogService.addLog(message);
		
		ResourceSingleton resource = ResourceSingleton.getInstance();
		resource.setNrUsers(resource.getNrUsers() + 1);
	}
	
	before(int id):callUserDelete(id){
		User user = UserService.getUserById(id);
		
		if(user != null) {
			String message = "A fost sters utilizatorul " + user.getEmail();
			LogService.addLog(message);
		}
		
		ResourceSingleton resource = ResourceSingleton.getInstance();
		int currentNrUsers = resource.getNrUsers();
		
		resource.setNrUsers(currentNrUsers > 0 ? currentNrUsers - 1 : 0);
		resource.removeUser(user);
	}
}

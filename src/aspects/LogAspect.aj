package aspects;

import java.sql.SQLException;

import proiect.LogService;
import proiect.Task;
import proiect.TaskService;
import proiect.User;
import proiect.UserService;
import proiect.*;
public aspect LogAspect {
	pointcut callUserAdd(User user): call(void UserService.addUser(User)) && args(user);
	pointcut callTaskAdd(Task task): call(void TaskService.addTask(Task)) && args(task);
	
	pointcut callUserDelete(int id): call(void UserService.deleteUser(int)) && args(id);
	pointcut callTaskDelete(int id): call(void TaskService.deleteTask(int)) && args(id);
	
	after(User user):callUserAdd(user){
		String message = "A fost adaugat utilizatorul " + user.getEmail();
		LogService.addLog(message);
	}
	
	after(Task task):callTaskAdd(task){
		String message = "A fost adaugat taskul " + task.getName();
		LogService.addLog(message);
	}
	
	before(int id):callUserDelete(id){
		User user = null;
	
		user = UserService.getUserById(id);
	
		if(user != null) {
			String message = "A fost sters utilizatorul " + user.getEmail();
			LogService.addLog(message);
		}
	}
	
	before(int id):callTaskDelete(id){
		Task task = TaskService.getTaskById(id);
		
		String message = "A fost sters taskul " + task.getName();
		LogService.addLog(message);
	}
}

package aspects;

import proiect.User;
import proiect.UserService;
import proiect.UserService;

public aspect CachedUserAspect {
	pointcut execGetUser(String name): execution(* UserService.getUser(String)) && args(name);
	
	User around(String name): execGetUser(name){
		User user = proceed(name);
		
		if(user == null) {
			return UserService.getDbUser(name);
		}
		
		return  user;
	}
}

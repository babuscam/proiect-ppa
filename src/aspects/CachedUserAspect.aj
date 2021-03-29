package aspects;

import proiect.User;
import proiect.UserService;

public aspect CachedUserAspect {
	pointcut execGetUser(String name): execution(* UserService.getUser(String)) && args(name);
	
	User around(String name): execGetUser(name){
		User user = proceed(name);
		
		if(user == null) {
			System.out.println("Utlizatorul " + name + " a fost luat din DB.");
			return UserService.getDbUser(name);
		}
		
		System.out.println("Utlizatorul " + name + " a fost luat din cache.");
		
		return  user;
	}
}

package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import proiect.User;
import proiect.UserService;

@Aspect
public class CachedUserSpringAOP{
	@Around("execution(* UserService.getUser(String)) && args(name)")
	 public Object GetUser(ProceedingJoinPoint pjp, String name) throws Throwable {
		User user = (User)pjp.proceed();
			
		if(user == null) {
			System.out.println("Utlizatorul " + name + " a fost luat din DB-Spring.");
			return UserService.getDbUser(name);
		}
		
		System.out.println("Utlizatorul " + name + " a fost luat din cache-Spring.");
		
		return  user;
	 }
}

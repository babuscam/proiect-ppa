package aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import proiect.ResourceSingleton;
import proiect.UserService;
import shared.LoginFailException;

@Aspect
public class LoginSpringAOP{
	final int MAX_TRIES = 3;
	
	@AfterReturning(pointcut = "execution(* UserService.login(String, char[]))", returning = "value")
	public void Login(boolean value) throws Exception {
		ResourceSingleton resource = ResourceSingleton.getInstance();
		
		if(!value) {
			resource.addLoginFails();
			if(resource.getLoginFails() > MAX_TRIES) {
				throw new LoginFailException("[Spring-AOT]Credentiale gresite. Aplicatia a fost inchisa.");
			}
		}else {
			resource.setNrUsers(UserService.getNrUsers());
		}
	}
}
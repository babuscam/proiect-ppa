package aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import proiect.LogService;
import proiect.ResourceSingleton;
import proiect.UserService;
import shared.LoginFailException;

/*public aspect LoginAspect {
	final int MAX_TRIES = 3;
	
	pointcut callLogin(): call(* UserService.login(String, char[]));
	
	after() returning(boolean value): callLogin(){
		ResourceSingleton resource = ResourceSingleton.getInstance();
		
		if(!value) {
			resource.addLoginFails();
			if(resource.getLoginFails() > MAX_TRIES) {
				LogService.addLog("Credentiale gresite. Aplicatia a fost inchisa.");
				System.exit(0);
			}
		}else {
			resource.setNrUsers(UserService.getNrUsers());
		}

	}
}*/



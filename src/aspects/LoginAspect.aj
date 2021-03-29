package aspects;

import proiect.LogService;
import proiect.ResourceSingleton;
import proiect.UserService;

public aspect LoginAspect {
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
}

package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import proiect.LogService;
import shared.ConnectionFailException;
import shared.LoginFailException;

@Aspect
public class ExceptionHandlerAspect {
	
	@AfterThrowing(pointcut = "execution(* *..*(..))", throwing = "error")
	public void afterThrowingEx(JoinPoint jp, Throwable error) {
		
		if(error instanceof ConnectionFailException) {
			System.out.println("Va rugam verificati conexiunea la baza de date.");
			System.exit(0);
		}else if(error instanceof LoginFailException) {
			System.out.println("Credentiale gresite. Verifica log-urile.");
			System.exit(0);
		}
		
		String message = "A aparut o eroare la:\n" + jp.getSignature() + "\nEroare:" + error;
		LogService.addLog(message);
	}
}

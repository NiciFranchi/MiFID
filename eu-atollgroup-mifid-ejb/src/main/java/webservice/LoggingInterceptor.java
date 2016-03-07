package webservice;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class LoggingInterceptor {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		String methodName = ic.getMethod().getName();
		System.out.println("Calling " + methodName + "()");
		Object ret = ic.proceed();
		System.out.println("Returned from " + methodName + "()");
		return ret;
	}

	@AroundConstruct
	public void aroundConstruct(InvocationContext ic) {
		try {
			ic.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Bean constructed.");
	}
}

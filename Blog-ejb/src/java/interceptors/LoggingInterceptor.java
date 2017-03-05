/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Marek
 */
public class LoggingInterceptor {
    @AroundInvoke
    public Object methodInterceptor(InvocationContext context) throws Exception
    {
       System.out.println("Call to method: " + context.getMethod().getName() + " in a class: " + context.getTarget().getClass().getName());
       return context.proceed();
    }
}

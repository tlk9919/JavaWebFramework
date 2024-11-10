package aop.tx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @classnam TxAspect
 * @time 16:44
 * @date 2024/10/19
 */
@Aspect //该类是一个切面，可以定义切入点和通知。
@Component
public class TxAspect {
    @Around("execution(public Boolean aop.tx.*.*(..))")
    public Object addTx(ProceedingJoinPoint joinPoint){
Object result=null;
try{
    System.out.println("执行开启事务逻辑");
    result=joinPoint.proceed();  //调用目标方法，并获取其返回结果。如果目标方法执行成功，将会继续执行后面的提交逻辑。
    System.out.println("执行提交事务逻辑");
} catch (Throwable e) {
    System.out.println("执行回滚事务逻辑");
    throw new RuntimeException(e);
}
return result;
    }
}

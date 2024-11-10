package aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author admin
 * @classnam SecurityAspect
 * @time 17:29
 * @date 2024/10/19
 */
@Aspect
@Component
public class SecurityAspect {

    @Pointcut("execution(* aop..addUser*(..))") //在包名中，..表示匹配该包及其所有子包,(..)表示匹配任意数量和类型的参数。
    public void addUserPointCut(){}

    @Pointcut("execution(* aop..deleteUser*(..))")
    public void deletePointCut(){}

    @Pointcut("execution(* aop..updateUser*(..))")
    public void updatePointCut(){}

    @Before("addUserPointCut() || deletePointCut() || updatePointCut()")
    public void beforeOperate(JoinPoint joinPoint){
        System.out.println(getTime()+" XX 正在执行 "+joinPoint.getSignature().getName()+"方法");
    }
    public String getTime(){
        // 获取当前的日期和时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 定义日期时间格式（可选）
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化当前时间为指定格式的字符串（可选）
        return currentTime.format(formatter);
    }
}

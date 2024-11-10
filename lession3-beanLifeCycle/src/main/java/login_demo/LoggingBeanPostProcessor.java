package login_demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author admin
 * @classnam LoggingBeanPostProcessor
 * @time 16:04
 * @date 2024/10/8
 */
public class LoggingBeanPostProcessor implements BeanPostProcessor {
@Override
public Object postProcessBeforeInitialization (Object bean,String beanName) throws BeansException{
    System.out.println(beanName +"初始化前逻辑");
    return bean;
}
    @Override
    public Object postProcessAfterInitialization (Object bean,String beanName) throws BeansException{
        System.out.println(beanName +"初始化后逻辑");
        return bean;
    }
}

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @classnam TestSpring
 * @time 16:25
 * @date 2024/9/24
 */
public class TestSpring {
    @Test
    public void test1(){
        //根据配置文件，构建Spring容器
        ApplicationContext context=new ClassPathXmlApplicationContext( "application.xml");
       //从Spring容器取出对象
//        User user= (User) context.getBean("zs");
        User user=context.getBean("zs",User.class);
        //调用say
        user.say();
    }
}

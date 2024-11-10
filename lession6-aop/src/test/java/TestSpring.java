import aop.tx.SpringConfig;
import aop.tx.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @classnam TestSpring
 * @time 17:00
 * @date 2024/10/19
 */
public class TestSpring {
    @Test
    public void testAopTx(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController=context.getBean("userController", UserController.class);
        String res=userController.shopping();
        System.out.println(res);
    }
}

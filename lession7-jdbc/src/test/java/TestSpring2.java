import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tx.AccountController;
import tx.SpringConfig;

/**
 * @author admin
 * @classnam TestSpring2
 * @time 17:52
 * @date 2024/10/22
 */

public class TestSpring2 {
    @Test
    public  void  test() throws  Exception  {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountController accountController=context.getBean("accountController",AccountController.class);
        String res = accountController.transfer();
        System.out.println(res);
    }
}

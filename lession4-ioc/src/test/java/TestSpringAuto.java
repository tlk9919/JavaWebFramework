import auto.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAuto {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-auto.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.getUser();
    }
}

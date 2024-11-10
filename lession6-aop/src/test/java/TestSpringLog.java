import aop.log.SpringConfiglog;
import aop.log.UserControllerlog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @classnam TestSpringLog
 * @time 17:39
 * @date 2024/10/19
 */
public class TestSpringLog {
    @Test
    public void testAopLog(){
        ApplicationContext context =  new AnnotationConfigApplicationContext(SpringConfiglog.class);
        UserControllerlog userController = context.getBean("userControllerlog", UserControllerlog.class);
        userController.add();
        userController.delete();
        userController.update();
        userController.query();
    }
}

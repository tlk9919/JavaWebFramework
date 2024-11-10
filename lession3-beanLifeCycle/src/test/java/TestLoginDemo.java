import login_demo.LoginController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @classnam TestLoginDemo
 * @time 16:16
 * @date 2024/10/8
 */
public class TestLoginDemo {
//    加载配置文件
@Test
    public void testLogin()

    {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //获取LoginController的两个实例，演示singleton 和 prototype的区别
        LoginController controller1 = context.getBean("loginController", LoginController.class);
        LoginController controller2 = context.getBean("loginController", LoginController.class);
//使用controller1进行登陆操作
        controller1.login();
        //使用controller2进行登出操作
        controller2.logout();
//再次登录，展示singleton作用域下的用户计数器的变化
        controller1.login();
        //手动销毁容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}
import constructor.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @classnam TestSpring
 * @time 15:09
 * @date 2024/10/12
 */
public class TestSpring {
    @Test
public void testConstructor(){

    ApplicationContext context=new ClassPathXmlApplicationContext("application-constructor.xml");
Student zs=context.getBean("zs", Student.class);
    System.out.println(zs);
}
}

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pet.Dog;
import staff.Worker;

/**
 * @author admin
 * @classnam springTest
 * @time 14:47
 * @date 2024/9/29
 */
public class springTest {
    @Test
    public void test1(){
        ApplicationContext context =new ClassPathXmlApplicationContext("PetshopConfig.xml");
//        User user=(User) context.getBean("zs");
        System.out.println("宠物店基本信息");
        System.out.println("员工：");
        Worker w1 =context.getBean("worker01", Worker.class);
        System.out.println(w1);
        Worker w2=context.getBean("worker02", Worker.class);
        System.out.println(w2);

        System.out.println("宠物");
        Dog d1=context.getBean("dog01", Dog.class);
        System.out.println(d1);
        Dog d2=context.getBean("dog02", Dog.class);
        System.out.println(d2);

        System.out.println("老板");
        Worker boss=context.getBean("boss", Worker.class);
        System.out.println(boss);
    }

}

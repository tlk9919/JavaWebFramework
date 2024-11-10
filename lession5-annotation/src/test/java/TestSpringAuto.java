import com.example.springAuto.BookController;
import com.example.springAuto.JdbcConfig;
import com.example.springAuto.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @classnam TestSpringAuto
 * @time 17:14
 * @date 2024/10/15
 */
public class TestSpringAuto {
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcConfig jdbcConfig = context.getBean(JdbcConfig.class);
        System.out.println("数据库配置："+jdbcConfig);
        BookController bookController = context.getBean("bookController",BookController.class);
        bookController.saveBook();
        bookController.findBookByIsbn("123456abc");

    }
}
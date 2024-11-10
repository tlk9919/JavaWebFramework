package example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 * @classnam HelloServlet
 * @time 15:42
 * @date 2024/10/22
 */
@Controller
public class HelloController {

    @RequestMapping("/h")
    @ResponseBody
    public String hello() {
        return "hello SpringMVC!我是annontation";
    }
}
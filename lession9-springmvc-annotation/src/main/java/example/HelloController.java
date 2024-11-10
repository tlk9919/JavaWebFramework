package example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 * @classnam HelloServlet
 * @time 15:42
 * @date 2024/10/22
 */
@RestController//@Controller + @ResponseBody
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(value = "/h",method = RequestMethod.POST)
    @ResponseBody
    public String say( @RequestBody  User user){
        System.out.println(user);
        return user.toString();
    }

    public String hello() {
        return "hello SpringMVC!";
    }
//
    @GetMapping("/h1/{args1}")
    public String home1(@PathVariable("args1") String a) {
        System.out.println(a);
        return "receive args : " +a ;
    }
    @PostMapping("/h2/{args1}")
    public String home2(@RequestParam("args1") String a,@RequestParam("args2") String b) {
        System.out.println(a);
        return "receive  args: " +a + "receive  args: " +b;
    }

}
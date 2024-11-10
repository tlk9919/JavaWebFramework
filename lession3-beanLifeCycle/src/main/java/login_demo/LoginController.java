package login_demo;

/**
 * @author admin
 * @classnam LoginController
 * @time 15:56
 * @date 2024/10/8
 */
public class LoginController {
    private LoginService loginService;
    public void setLoginService(LoginService loginService){
        this.loginService=loginService;
    }
    public void init(){
        System.out.println("LoginController initialized");
    }
public void login(){
        loginService.userLoggedOn();
}
public  void logout(){
        loginService.userLoggedOff();
}
}

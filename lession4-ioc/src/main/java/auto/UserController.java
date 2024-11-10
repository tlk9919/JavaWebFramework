package auto;

public class UserController {
    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getUser() {
        System.out.println("UserController: getUser");
        return userService.getUserByid().toString();
    }
}

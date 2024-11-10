package login_demo;

/**
 * @author admin
 * @classnam LoginService
 * @time 15:45
 * @date 2024/10/8
 */
public class LoginService {
    //    记录在线用户户数
    private int onlineUsersCount = 0;


    public void init() {
        System.out.println("LoginService initialized");
    }
    public void destroy(){
        System.out.println("LoginService destroyed");
    }
public synchronized void userLoggedOn(){
        //登录在线用户+1
    onlineUsersCount++;
    System.out.println(" User Logged on. Current count " +onlineUsersCount);
}
public synchronized void userLoggedOff(){
        //退出 在线用户少一
    onlineUsersCount--;
    System.out.println("User Logged Off. Current count :" +onlineUsersCount);
}
    public int getOnlineUsersCount(){
        return onlineUsersCount;
    }
}
package aop.tx;

import org.springframework.stereotype.Service;

/**
 * @author admin
 * @classnam OrderService
 * @time 16:24
 * @date 2024/10/19
 */
@Service
public class OrderService {
    //创建订单
    public Boolean create(){
        System.out.println("OrderService:创建订单");
        return true;
    }
}

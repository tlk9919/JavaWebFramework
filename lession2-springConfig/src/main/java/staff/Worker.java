package staff;

/**
 * @author admin
 * @classnam Worker
 * @time 16:00
 * @date 2024/9/29
 */
public class Worker {
//    工号
    private Integer num;
//    姓名
private String name;

    public Integer getNum() {
        return num;
    }
    public void  setNum(Integer num){
        this.num=num;
    }
    public String getName(){
        return name;
    }
    public void  setName(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return "worker{"+ "num="+num+",name='"+name +'\''+'}';
    }
}

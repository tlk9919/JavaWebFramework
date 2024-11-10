package pet;

/**
 * @author admin
 * @classnam Dog
 * @time 15:59
 * @date 2024/9/29
 */
public class Dog {

    /*
     * 品种
     * */
    private String breed;

    /*
     * 名字
     * */
    private String name;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
public  String toString(){
return "Dog{"+
        "breed='"+breed +'\''+
    ",name='"+name +'\''+'}';
}
}
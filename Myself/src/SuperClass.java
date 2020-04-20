/**
 * @Author AceDJH
 * @Date 2020/4/20 17:32
 */
class Father{
    public Father() {
        System.out.println("father");
    }
    public Father(int i){
        System.out.println("father" + i);
    }
}

class Son extends Father{
    public Son() {
        System.out.println("son");
    }
    public Son(int i){
        System.out.println("son" + i);
    }

}
public class SuperClass {
    public static void main(String[] args) {
        Son son = new Son();
        Son son1 = new Son(2);
    }
}





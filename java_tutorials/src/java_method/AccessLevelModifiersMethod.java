package java_method;
class Greeting{
    //public, private
    public static void hi(){
        System.out.println("Hi");
        //private 같은 클래스 안에서만 사용할수있는것.
        //public 클래스 바깥에서도 사용할 수 있는 것.
    }
}
public class AccessLevelModifiersMethod {

    public static void main(String[] args){
        Greeting.hi();

    }
}

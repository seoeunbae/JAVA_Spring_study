package java_method;
class Print{
    public String delimiter;
    //    static이 있는 건 class의 method이다.
    //    no static은 instance의 method이다.
    public void a(){
        System.out.println(this.delimiter);
        System.out.println("a");
        System.out.println("a");

    }
    public void b(){
        System.out.println(this.delimiter);
        System.out.println("b");
        System.out.println("b");
    }

    public static void c(String delimiter){
        System.out.println(delimiter);
        System.out.println("b");
        System.out.println("b");
    }
}
public class staticMethod {

    //method가 instance 소속일때는 static을 빼야 한다. 반대로 class 소속일때는 static을 넣어야 한다
    //ex.변수 a가 static으로 정의된후에 instance값을 변경하면 모든 instance의 a의 값이 변경된다.
    //변수 b가 nonstatic으로 정의되었다면 instance하나의 값을 변경해도 다른 instance의 b의 값이 변경되지 않는다.
    public static void main(String[] args){
//        Print.a("-");
//        Print.b("-");

        Print t1 = new Print();
        t1.delimiter = "-";
        t1.a();
        t1.b();
        Print.c(")");

        Print t2 = new Print();
        t2.delimiter = "*";
        t2.a();
        t2.b();

//        Print.a("*");
//        Print.b("*");
    }
}

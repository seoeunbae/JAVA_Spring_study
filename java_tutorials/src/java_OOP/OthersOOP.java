package java_OOP;

import java.io.FileWriter;
import java.io.IOException;

public class OthersOOP {

    public static void main(String[] args) throws IOException {
        System.out.println(Math.PI);//변수
        System.out.println(Math.floor(1.8));//메소드
        System.out.println(Math.ceil(1.8));//변수와메소드들을 그룹핑한 것 클래스

        FileWriter f1=new FileWriter("data.txt");
        f1.write("Hello");
        f1.write(" Java");


        FileWriter f2=new FileWriter("data2.txt");
        f2.write("Hello");
        f2.write(" Java2");
        f2.close();

        f1.write("!!!");
        f1.close();
    }
}

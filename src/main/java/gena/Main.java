package gena;

public class Main {
    public static void main(String[] args) {
       // String myName = new String("Hello Vlad" + "my name is Gena");
       // System.out.println(myName);
        Integer value = 1;
        change(value);
        System.out.println(value);
    }

    public static void change(Integer value) {
        ++value;
    }


}

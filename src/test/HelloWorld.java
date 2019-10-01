package test;

public class HelloWorld {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Hello, World!");
        System.out.println(HelloWorld.class);
        final Object clone = new HelloWorld().clone();
        System.out.println(clone.getClass());
    }
}

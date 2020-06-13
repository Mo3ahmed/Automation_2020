package Day03_04182020;

public class custom_method {

    //user define custom method will be created here

    //lets create one for void first
    public static void  voidAdd(int a, int b){
        int results = a+b;
        System.out.println("My addition result is "+ results);


    }// end of void method
    // create same method as return method
    public static int returnAdd(int a, int b){
        int c = a+b;
        System.out.println("My addition result is "+ c);
        return c;//will return the result c
}
}//end of java class

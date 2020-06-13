package Day03_04182020;

public class method_execution_class {
    public static void main(String[] args) {
        //call the method to be executed
        custom_method.voidAdd(100,200);

        //call the return add method
        int c = custom_method.returnAdd( 300,  500);
        //add the value with the results
        System.out.println("New results is " + (c-123));





    }
}

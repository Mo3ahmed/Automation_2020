package Day02_04122020;

public class while_loop {
    public static void main(String[] args) {

        String[] states = new String[5];
        states[0] = "New York";
        states[1] = "New Jersey";
        states[2] = "Connecticut";
        states[3] = "Virgina";
        states[4] = "Arizona";

        //While loop is more of broken down into statement
        //if the argument is true/false then perform some action
        int i = 0;
        while(i <states.length) {
            System.out.println("My state is " + states[i]);
            i = i + 1;//incrementation and you put this at the end of statement(Same thing as i++)
        }// end of while loop

    }//end of main method


}// end of class

package Day02_04122020;

public class parctice_loop_while {
    public static void main(String[] args) {
        //declaring dynamic string array variable
        String[] userName;
        //declaring dynamic int array variable
        int[] userPassword;
        //defining dynamic string array with the length(size) of the variable
        userName = new String[5];
        userName[0] = " Moeahmed";
        userName[1] = " Mohammed95";
        userName[2] = " Samir123";
        userName[3] = " Moe7899";
        userName[4] = " Xyg143";
        //defining dynamic int array with the length(Size) of the variable
        userPassword = new int[5];
        userPassword[0] = 123456;
        userPassword[1] = 65456376;
        userPassword[2] = 3452673;
        userPassword[3] = 746398;
        userPassword[4] = 812482;
        //print all statement from 0 to the last value in sequences
        //i represent the initial starting point of your index
        for(int i = 0; i<userName.length; i++) {
            System.out.println("My User Name is" + userName[i] + " My password is " + userPassword[i]);
        }//end of for loop

        System.out.println("");

        //if the argument is true/false then perform some action
        int x = 0;
        while(x<userPassword.length){
            System.out.println("My User Name is" + userName[x] + " My password is " + userPassword[x]);
            x = x+1;// same thing as i++
        }//end of while loop


    }//end of main method


}//end of class



package Day02_04122020;

public class action_item0 {
    public static void main(String[] args) {
        //declaring dynamic string array variables
        String[] names;
        //declaring dynamic int array variables
        int[] age;
        //defining dynamic string array by the length(size) of the variables
        names = new String[5];
        names[0] = "Anaiya ";
        names[1] = "Mohammed ";
        names[2] = "Samir ";
        names[3] = "Shamu ";
        names[4] = "Munna ";
        //defining dynamic int array by the length(size) of the variables
        age = new int[5];
        age[0] = 3;
        age[1] = 24;
        age[2] = 9;
        age[3] = 25;
        age[4] = 23;
        //print all statements from 0 to last value in sequences
        //i represent initial starting point of your index
        for(int i = 0; i <names.length; i++) {
            System.out.println("My name is " + names[i] + "and my age is " + age[i]);
        }//end of for loop
        System.out.println("");
        //if the argument is true/false then perform some action
        int x = 0;
        while(x <age.length) {
        System.out.println("My name is " + names[x] + "and my age is " + age[x]);
        x = x + 1;
        }// end of while loop
    }//end of main method


}//end of class

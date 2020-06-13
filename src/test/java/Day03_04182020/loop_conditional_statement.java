package Day03_04182020;

public class loop_conditional_statement {
    public static void main(String[] args) {
//only print out city when it is brooklyn or queens
        String[] city = new String[4];
        city[0] = "Brooklyn";
        city[1] = "Queens";
        city[2] = "Manhattan";
        city[3] = "Bronx";

        for (int i = 0; i<city.length; i++) {
            //using if else if condition
            //strings can have equal() command or == but integer must have ==
            //equal command when the expected value is matching the array value
            //equalIgnoreCase command will ignore case sensitivity as long as the array value
            //spelling is correct
        /*
            if (city[i] == "Brooklyn") {
                System.out.println("my city is" + city[i]);
            } else if (city[i] == "Queens") {
                System.out.println("My city is" + city[i]);
            }//end of if else condition

         */
            //different operators are &&, ||, >, <, <=, >=, ==
            //using operators to do the same
            if(city[i].equals("Brooklyn") || city[i] == "Queens"){
                System.out.println("My city is " + city[i]);

            }//end of operator command

        }//end of for loop

    }//end of main method

}//end of class

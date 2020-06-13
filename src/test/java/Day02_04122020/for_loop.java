package Day02_04122020;

public class for_loop {
    public static void main(String[] args) {
        String[] states = new String[5];
        states[0] = "New York";
        states[1] = "New Jersey";
        states[2] = "Connecticut";
        states[3] = "Virgina";
        states[4] = "Arizona";


        //print all the states from 0 to the last value in sequence
        //i++ each time is adding +1 to 1
        // i represent your initial/starting point of your index
        for (int i = 0; i < states.length; i++) {
            System.out.println("My state is " + states[i]);
        }
        System.out.println("");
        System.out.println("Cities names are listed below:");

        String[] Cities = new String[4];
        Cities[0] = " Queens ";
        Cities[1] = " Brooklyn ";
        Cities[2] = " Manhattan ";
        Cities[3] = " Staten Island ";

        for (int a = 0; a < Cities.length; a++) {
            System.out.println("My cities are" + Cities[a]);
        }
        //end of main method



    }


}//end of class

package Day02_04122020;

public class Liner_Array {
    public static void main(String[] args) {
        //declare empty array variables
        String[] locations, countries, places;

        //declare the empty int array variables first
        int [] number, HouseAddress;
        //define the variables
        locations = new String[]{"New York","new Jersey","Virginia"};
        countries = new String[]{"Bangladesh","U.S.A","Canada","India"};
        places = new String[]{"Casino","Beach","Restaurant","Movie theater"};

        //defining int array variables
        number = new int[]{1,2,3,4,5};
        HouseAddress = new int[]{222,567,321};
        // Print the las value from location variable
        System.out.println("My location is " + locations[2] + " is in array index " + number[1] + " " + " And " + number[0]);



    }//end of main method


}//end of java class

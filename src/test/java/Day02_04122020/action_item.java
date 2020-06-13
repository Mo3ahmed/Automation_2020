package Day02_04122020;

public class action_item {
    public static void main(String[] args) {
      //declaring dynamic string array variable
        String[] zipCodes;
      //declaring dynamic int array variable
        int[] streetNumber;
      //defining dynamic array with the length(size) of the variable

      zipCodes = new String[4];
      zipCodes[0] = "11416 ";
      zipCodes[1] = "11208 ";
      zipCodes[2] = "11218 ";
      zipCodes[3] = "11238 ";

      //defining dynamic int array with the length(size) of the variables
      streetNumber = new int[4];
      streetNumber[0] = 424;
      streetNumber[1] = 78;
      streetNumber[2] = 321;
      streetNumber[3] = 572;
      //print all statement 0 to last value in sequence
      // i represent initial starting point of your index
      for(int i = 0; i <zipCodes.length; i++) {

          System.out.println("My zip code is " + zipCodes[i] + "and my street number is " + streetNumber[i]);
      }//end of for loop
        System.out.println("");

     int j = 0;
     while(j <streetNumber.length){
         System.out.println("My zip code is " + zipCodes[j] + "and my street number is " + streetNumber[j]);
         j = j + 1;
     }//end of while loop

    }//end of main method


}//end of class

package Day03_04182020;

public class if_else_with_operators {
    public static void main(String[] args) {

       //scenarios is if student grade is 90 to 100 its A
       //if student grade is 80 to below then its B
       // if student grade is 70 to below its C
       //if anything below 65 is failure (F)
        //define a variable which will represent grade number
        int grade = 89;


       if(grade >=90 && grade <= 101){
           System.out.println("Student grade is A");
       }else if(grade >=80 && grade < 90){
           System.out.println("student grade is B");
       }else if(grade >= 70 && grade < 80){
           System.out.println("Student grade is C");
       }else{
           System.out.println("student grade is F");
       }//end of if else condition

    }//end of main method

}//end of class

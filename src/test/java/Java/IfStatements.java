package Java;

import java.util.Scanner;

public class IfStatements {
    public static void main(String[] args) {

        int apples=4;
        int oranges=9;
        System.out.println("This is BEFORE if");
        //"Hi" if the number of apples less than number of oranges
        if (apples < oranges){
            System.out.println("Hi");
        }
        System.out.println("This is AFTER if");

        //print "there are same numbers of fruits" when apples and oranges are same amount
        if (apples == oranges){
            System.out.println("there are same numbers of fruits");

        }
        String str = "yes";
        if (str.equals("yes")){
            System.out.println("Welcome");
        }

        Scanner input=new Scanner(System.in);
        System.out.println("Please enter an integer value between 1 and 5");
        int num= input.nextInt();
        if (num == 1) {
            System.out.println("Monday");
        }
        if (num==2){
            System.out.println("Tuesday");
        }
        if (num==3){
            System.out.println("Wednesday");
        }
        if (num==4){
            System.out.println("Thursday");
        }
        if (num==5){
            System.out.println("Friday");
        }
        if (num<1 || num>5){
            System.out.println("Your entry is out of range");
        }
        //////////////////////////////////////////////////////////////////////////
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter the first letter of the day");
        String letter=""+scanner.nextLine().charAt(0);
        System.out.println(letter);

        if (letter.equals("M")){
            System.out.println("your day is Monday");
        }
        if (letter.equals("T")){
            System.out.println("your day is Tuesday or Thursday");
        }
        if (letter.equals("W")){
            System.out.println("your day is Wednesday");
        }
        if (letter.equals("F")){
            System.out.println("your day is Friday");
        }
        if (letter.equals("S")){
            System.out.println("your day is Saturday or Sunday");
        }
    }

}

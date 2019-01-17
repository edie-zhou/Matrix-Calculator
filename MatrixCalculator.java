/**
 * The Matrix Calculator class is a matrix calculator capable of taking input
 * from the user and performing matrix operations with the input data.
 * Created by Edie Zhou on 1/16/2019.
 */

import java.util.Scanner;

public class MatrixCalculator {
    public static void main(String[] args){
        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // Program run status
        boolean status = true;

        // User input choice for calculator operation
        String choice;

        while(status){
            System.out.println();
            System.out.println("This is a matrix calculator");
            System.out.println("Enter 1 to run calculator");
            System.out.println("Enter 0 to exit calculator");
            choice = input.next();
            while((!choice.equals("1"))&&(!choice.equals("0"))){
                System.out.println("Input must be 0 or 1, please try again");
                choice = input.next();
            }
            if(choice.equals("1"))
                CalculatorRunner.runCalculator();
            else
                status = false;
        }
        System.out.println("User has exited the calculator");
    }
}

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Doc on 1/14/16.
 */
public class Guessing {
    private Random rand;
    private Scanner scanner;
    private int tries = 0; // number of tries counter.
    private int input = 0;
    private int prevInput = 0;
    private int secretNumber;
    private boolean firstTry = true;

    public static void main(String args[]){
        Guessing guessGame = new Guessing();
    }

    //Constructor. Initializes all variables and calls start point.
    public Guessing(){
        //Random generator.
        rand = new Random();
        //Input scanner to receive input from user.
        scanner = new Scanner(System.in);
        //Generate secret number.
        secretNumber = rand.nextInt(Integer.SIZE - 1);
        //Get input from user and print out message.
        checkNumber();
        //When checkNumber returns, print the number of tries needed.
        System.out.println("The number of tries you needed was "+tries);
    }


    public void checkNumber(){
        System.out.println("Enter the secret number:");

        input = scanner.nextInt();
        //Check if we are not in the first try and if current number is the same as the last.
        //The boolean makes sure that the user doesn't get penalized if their first try is 0.
        if(input != prevInput || firstTry && input == 0) {
            tries++;
        }else if(firstTry && input == 0) {
            firstTry = false;
            tries++;
        }else{
            firstTry = false;
        }


        if(input == secretNumber){
            System.out.println("Congratulations, "+ secretNumber+" is the secret number!");
            return;
        }



        //Set the prevInput equal to current in preparation of next iteration.
        prevInput = input;

        //If higher, say "Was too large" or "too small" if lower.
        if(input > secretNumber) {
            System.out.println("Your guess was too large");
            checkNumber(); //reiterate.
        }
        else if(input < secretNumber){
            System.out.println("Your guess was too small");
            checkNumber();//reiterate.
        }

        return;
    }
}

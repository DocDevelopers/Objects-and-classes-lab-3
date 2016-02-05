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
    private int prevInput = -1;
    private int secretNumber;

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
        System.out.println("The number of tries it took you to find the secret number was "+tries);
    }


    public void checkNumber(){
        System.out.println("Enter the secret number:");

        //Validate input.
        while(!scanner.hasNextInt()){
            System.out.println("That's not a number!");
            scanner.next(); // this is important!
        }

        input = scanner.nextInt();

        //If they entered something different... Add one try
        if(input != prevInput)
            tries++;

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
    }
}

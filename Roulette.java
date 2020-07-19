package roulette;
import java.util.Scanner;

public class Roulette {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        //Introduction
        System.out.println("Hello hi welcome.\nYou will start with 1000 monies.\nYou can bet on black, red, green or blue.");
        System.out.println("Black: 50% chance to win. Multiplies betting amount with 2");
        System.out.println("Red: 40%, multiplies with 3\nGreen: 7%, multiplies with 5\nBlue: 3%, multiplies with 10");
        System.out.println("Good luck!");

        int bal = 1000; //start balance
        System.out.println("\nYou have " + bal + " monies");

        //loop to continue playing until user exits or loses all money
        while (true) {
            System.out.print("How much monies do you want to bet?: ");
            int bet = sc.nextInt();

            while (bet > bal) { //prevents inputting a number higher than current balance
                System.out.print("You don't have enough monies!!! Enter a number again: ");
                bet = sc.nextInt();
            }

            bal -= bet; //deducts bet amount from balance

            sc.nextLine();
            System.out.print("\nPick a color: ");
            String choice = sc.nextLine();

            double rnd = Math.random() * 100;
            String pocket = null;

            System.out.println("\nRolling...");
            Thread.sleep(1000);

            if (rnd <= 50) { // this is where a random pocket is chosen using Math.random()
                pocket = "black";
            } else if (rnd <= 90) {
                pocket = "red";
            } else if (rnd <= 97) {
                pocket = "green";
            } else {
                pocket = "blue";
            }

            System.out.println(pocket); //prints winning pocket

            if (choice.equalsIgnoreCase(pocket)) { //checks if choice is equal to the winning pocket
                if (pocket.equalsIgnoreCase("black")) bal += bet * 2; //if it is then it checks which one and adds monies to balance
                if (pocket.equalsIgnoreCase("red")) bal += bet * 3;
                if (pocket.equalsIgnoreCase("green")) bal += bet * 5;
                if (pocket.equalsIgnoreCase("blue")) bal += bet * 10;
                System.out.println("\nYou win!");
            } else {
                System.out.println("\nYou lose D:"); //this will be executed if choice didn't equal the randomly chosen pocket
            }

            if (bal <= 0) { //exits program if user doesn't have any monies remaining
                System.out.println("You lost all your monies. kbye.");
                System.exit(0);
            }

            System.out.println("\nYou have " + bal + " monies");

            System.out.println("Do you want to exit the program? y for yes, anything else for no");
            String c = sc.nextLine();
            if (c.equalsIgnoreCase("y")) System.exit(0); //user can choose to exit program after every round
        }

    }

}
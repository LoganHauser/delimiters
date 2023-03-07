import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //Create a Scanner to read input from the user
        Scanner inputScanner = new Scanner(System.in);
        //Create a BufferedWriter to write to a file
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("user_data.txt"));
        //Create a BufferedReader to read from the file
        BufferedReader fileReader = new BufferedReader(new FileReader("user_data.txt"));

        //Repeat 5 times
        for (int i = 0; i < 5; i++) {
            //Ask the user to input a name
            System.out.println("Enter User " + (i + 1) + "'s Name:");
            //Write the inputted value to the file
            fileWriter.write(inputScanner.nextLine() + "*");
            //Start a while loop
            while (true) {
                //Ask the user to input an age
                System.out.println("Enter User " + (i + 1) + "'s Age:");
                //If the inputted value is an int
                if (inputScanner.hasNextInt()) {
                    //Write the inputted value to the file
                    fileWriter.write(inputScanner.nextInt() + "*");
                    //Skip to the next line
                    inputScanner.nextLine();
                    //Break from the loop
                    break;
                //If the inputted value is not an int
                } else {
                    //Skip to the next line
                    inputScanner.nextLine();
                    //Ask the user to input an int value and loop again
                    System.out.println("Please enter an integer value.");
                }
            }
            //Ask the user to input a phone number
            System.out.println("Enter User " + (i + 1) + "'s Phone Number:");
            //Write the inputted value to the file
            fileWriter.write(inputScanner.nextLine() + "*");
            //Ask the user to input an address
            System.out.println("Enter User " + (i + 1) + "'s Address:");
            //Write the inputted value to the file
            fileWriter.write(inputScanner.nextLine() + "*");
            //Start a while loop
            while (true) {
                //Ask the user to input a zip code
                System.out.println("Enter User " + (i + 1) + "'s Zip Code:");
                //If the inputted value is an int
                if (inputScanner.hasNextInt()) {
                    //Write the inputted value to the file
                    fileWriter.write(inputScanner.nextInt() + "\n");
                    //Skip to the next line
                    inputScanner.nextLine();
                    //Break from the loop
                    break;
                //If the inputted value is not an int
                } else {
                    //Skip to the next line
                    inputScanner.nextLine();
                    //Ask the user to input an int value and loop again
                    System.out.println("Please enter an integer value.");
                }
            }
        }

        //Close the input scanner
        inputScanner.close();
        //Close the file writer
        fileWriter.close();

        //Create an int variable to store the total of each age
        int ageTotal = 0;
        //Loop 5 times
        for (int i = 0; i < 5; i++) {
            try {
                //Create a StringTokenizer for the a line in the file
                StringTokenizer stringTokenizer = new StringTokenizer(fileReader.readLine(), "*");
                //Print the current user
                System.out.println("User " + (i + 1) + ":");
                //Print the user's name
                System.out.println("\tName: " + stringTokenizer.nextToken());
                //Store the user's age
                int age = Integer.parseInt(stringTokenizer.nextToken());
                //Add the age to the ageTotal variable
                ageTotal += age;
                //Print the user's age
                System.out.println("\tAge: " + age);
                //Print the user's phone number
                System.out.println("\tPhone Number: " + stringTokenizer.nextToken());
                //Print the user's address
                System.out.println("\tAddress: " + stringTokenizer.nextToken());
                //Print the user's zip code
                System.out.println("\tZip Code: " + stringTokenizer.nextToken());
            } catch (NoSuchElementException e) {
                //Print if there was an error reading from the file
                System.out.println("Error reading data from user_data.txt");
            }
        }
        //Print the average age
        System.out.println("Average Age: " + ageTotal / 5);

        //Close the file reader
        fileReader.close();
    }
}

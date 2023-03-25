//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1867636
//Date: 20/04/2022

package com.keerthana;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ArraySolution {

    //global variables
    static String customersName;
    static int cabinNum = 0;
    static String[] shipCabins = {"empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String option;
        boolean exit = false;
        do {
            // menu options
            System.out.println("\n\n          _Welcome To Cruise Ship Boarding_");
            System.out.println("----------------------MENU OPTIONS-----------------------");
            System.out.println("    A  :  Add Customer For Cabin");
            System.out.println("    V  :  View All Cabins");
            System.out.println("    E  :  Display Empty Cabins");
            System.out.println("    D  :  Delete Customer From Cabin");
            System.out.println("    F  :  Find Cabin From Customer Name ");
            System.out.println("    O  :  View Passengers Ordered Alphabetically By Name");
            System.out.println("    S  :  Store Program Data Into File");
            System.out.println("    L  :  Load Program Data From File");
            System.out.println("    Q  :  Quit The Program");
            System.out.println("---------------------------------------------------------");
            System.out.print("Enter an option from the above menu : ");

            option = input.nextLine().toUpperCase();

            //This Switch statement to check users choice and call the correct method
            switch (option) {
                case "V" -> viewAllCabins();
                case "E" -> displayEmptyCabins();
                case "A" -> addCustomer();
                case "D" -> deleteCustomer();
                case "F" -> findCabins();
                case "S" -> storeDataIntoFile();
                case "L" -> loadDataFromFile();
                case "O" -> sortInAlphabeticalOrder();
                case "Q" -> {
                    System.out.println("================ Thank you For Using Cruise Ship ! ==============");
                    exit = true;
                }
                default -> System.out.println("         INVALID INPUT");
            }
        } while (!exit);
    }

    //methods for procedures
    //this method goes through the 'shipCabins' array's elements and prints each out with the customers name
    private static void viewAllCabins() {
        System.out.println("\n========= Ship Cabins =========\n");
        for (int i = 0; i < shipCabins.length; i++) {
            System.out.println("    Cabin Number " + i + " = " + shipCabins[i]);
        }
        System.out.println("\n================================");
    }

    //this method goes through the mentioned array and checks whether it's indexes are equal to empty and prints the empty ones out
    private static void displayEmptyCabins() {
        System.out.println("\n========= Empty Cabins =========\n");
        for (int i = 0; i < shipCabins.length; i++) {
            if (shipCabins[i].equals("empty")) {
                System.out.println("     Cabin " + i + " is empty.");
            }
        }
        System.out.println("\n================================");
    }

    //this method prompts user to enter a Cabin number and then prompts for a name, and it adds the name to particular cabin arrays
    private static void addCustomer() {
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.print("Enter Cabin Number(0-11) to stop :");
                String cabinNum = input.nextLine();

                if (!Objects.equals(ArraySolution.shipCabins[Integer.parseInt(cabinNum)], "empty")) {
                    System.out.println("Already this Cabin has Occupied by Someone.Try Another Cabin!!!!!\n");
                    continue;
                }
                if (cabinNum.equals("0") || cabinNum.equals("1") || cabinNum.equals("2") || cabinNum.equals("3") || cabinNum.equals("4") ||
                        cabinNum.equals("5") || cabinNum.equals("6") || cabinNum.equals("7") || cabinNum.equals("8") || cabinNum.equals("9") ||
                        cabinNum.equals("10") || cabinNum.equals("11")) {
                    System.out.print("Enter Customer's Name for cabin number " + cabinNum + " :");
                    customersName = new Scanner(System.in).nextLine();
                    ArraySolution.shipCabins[Integer.parseInt(cabinNum)] = customersName;
                    System.out.print("" + customersName + " Has Occupied The Cabin " + cabinNum);
                    break;
                }

            } catch (Exception e) {
                System.out.println("        INVALID INPUT\n");
            }
        } while (true);
    }

    //this method prompts user for a number and delete the customer in that cabin(number) of the array
    private static void deleteCustomer() {
            try {
                System.out.print("In Which Cabin Do You Want To Remove Passengers : ");
                cabinNum = new Scanner(System.in).nextInt();
                shipCabins[cabinNum] = "empty";
                System.out.print("Successfully Passenger Removed from Cabin Number " + cabinNum + " .");
            } catch (Exception e) {
                System.out.println("        INVALID INPUT");
            }
    }

    //this method prompts user for the name before entered and display the cabin number that name included
    private static void findCabins() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter The Passenger Name To Find The Cabin:");
        String passengerName = input.next();
        passengerName = passengerName.toLowerCase();
        boolean userInput=false;
        for (int i = 0; i < shipCabins.length; i++) {

            if(shipCabins[i].equals(passengerName)){
                System.out.println("Passenger "+ passengerName +" is in  Cabin Number : "+i);
                userInput = true;
            }
        }
        if (!userInput){
            System.out.println("There is no passenger with the Name "+passengerName+". ");
        }
    }

    //this method prints all the customers in alphabetical order
    private static void sortInAlphabeticalOrder() {
        String[] newArr = new String[12];
        System.arraycopy(shipCabins, 0, newArr, 0, shipCabins.length);

        for (int j = 0; j < shipCabins.length- 1; j++) {
            for (int i = j + 1; i < newArr.length; i++) {
                if (newArr[j].compareToIgnoreCase(shipCabins[i]) > 0) {
                    String temp = newArr[j];
                    newArr[j] = newArr[i];
                    newArr[i] = temp;
                }
            }
        }
        for (String s : newArr) {
            if (s.equals("empty")) {
                continue;
            }
            System.out.println(s);
        }
    }

    //this method created a text file and stores the mentioned data into it
    private static void storeDataIntoFile () {
        try {
            FileWriter enterData = new FileWriter("cruiseShipCabinData.txt");
            enterData.write("=============== The Stored Data ==============\n");
            for (int i = 0; i < shipCabins.length; i++) {
                enterData.write("       Cabin " + (i) + " : " + shipCabins[i] + "\n");
            }
            enterData.close();
            System.out.println("Program Data Successfully Stored into file ");
        }
        catch (IOException e){
            System.out.println("AN ERROR OCCURRED.");
            e.printStackTrace();
        }
    }

    //this method load the data into the program from the mentioned text file
    private static void loadDataFromFile ()  {
        System.out.println("\n=============== Load Data From File ==============");
        try {
            File loadData = new File("cruiseShipCabinData.txt");
            Scanner displayData = new Scanner(loadData);
            while (displayData .hasNextLine()) {
                String data = displayData .nextLine();
                System.out.println(data);
            }
            displayData .close();
        } catch (FileNotFoundException e) {
            System.out.println("AN ERROR OCCURRED.");
            e.printStackTrace();
        }
        System.out.println("\n________Successfully Data Loaded From The File._______ ");
        System.out.println("==================================================");
    }

}






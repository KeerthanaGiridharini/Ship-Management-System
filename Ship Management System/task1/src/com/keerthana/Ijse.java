package com.keerthana;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ijse {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
            // menu options
            System.out.println("\t\t\t\t\t*****************");
            System.out.println("\t\t\t\t\t UNIT CALCULATOR");
            System.out.println("\t\t\t\t\t*****************");
            System.out.println("----------------------MENU OPTIONS-----------------------");
            System.out.println("  1 : Convert Meter to Centimeter");
            System.out.println("  2 : Convert Liter to Milliliter");
            System.out.println("  3 : Convert Feet to Inches");
            System.out.println("  4 : Convert Gigabyte to Megabyte");
            System.out.println("---------------------------------------------------------");
            System.out.print("Enter an option from the above menu : ");

            String option = input.nextLine();

            //This Switch statement to check users choice and call the correct method
            switch (option) {
                case "1" -> centimeterToMeter();
                case "2" -> literToMilliliter();
                case "3" -> feetToInches();
                case "4" -> gigabytesToMega();
                default -> {
                    System.out.println("         INVALID INPUT");
                    mainMenu();
                }
            }

    }
    public static void cmdFlush(){     // Clear console
        try {
            final String os = System.getProperty("os.name"); if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) { e.printStackTrace(); // Handle any exceptions.
        }
    }

    public static void centimeterToMeter(){   // Converts Centimiters to Meters
        boolean exit = false;
        cmdFlush(); // Flush console before getting user input
        do{
            try {
                System.out.println();
                System.out.print("Enter value in meter : ");
                double meters = input.nextDouble();
                double centimeters = meters * 100;
                System.out.println("Answer is : " + centimeters + " cm");
                System.out.println(" **** Enter 0 to Return to main menu OR Any Key to Exit : ");
                String menu = input.next();
                if (menu.equals("0")) {
                    cmdFlush();
                    mainMenu();
                } else {
                    System.out.println("\n ***** Thank You For Using Unit Calculator!!! *****");
                    exit= true;
                }
                }catch(InputMismatchException e){
                    System.err.println("Please enter valid input");
                    input.nextLine();
                }
            }while (!exit);
    }
    private static void literToMilliliter() {
        cmdFlush();
    }
    private static void feetToInches() {
        cmdFlush();
    }
    private static void gigabytesToMega() {
        cmdFlush();
    }
}

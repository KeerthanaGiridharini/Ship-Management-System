//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1867636
//Date: 20/04/2022

package com.keerthana;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WaitingList {
  static Queue<String> waitingCabinList = new LinkedList<>();

    public static void main(String[] args) {
        Cabin[] shipCabins = new Cabin[12];
        for (int i = 0; i < shipCabins.length; i++) {
            shipCabins[i] = new Cabin();
        }
        try (Scanner input = new Scanner(System.in)) {
            initialize(shipCabins);
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
                System.out.println("    T  :  Total Expenses of Passengers");
                System.out.println("    S  :  Store Program Data Into File");
                System.out.println("    L  :  Load Program Data From File");
                System.out.println("    Q  :  Quit The Program");
                System.out.println("---------------------------------------------------------");
                System.out.print("Enter an option from the above menu : ");

                option = input.nextLine().toUpperCase();

                switch (option) {
                    case "V" -> viewAllCabins(shipCabins);
                    case "E" -> displayEmptyCabins(shipCabins);
                    case "A" -> addCustomer(shipCabins);
                    case "D" -> deleteCustomer(shipCabins);
                    case "F" -> findCabins(shipCabins);
                    case "O" -> sortInAlphabeticalOrder(shipCabins);
                    case "T" -> totalExpenses(shipCabins);
                    case "S" -> storeDataIntoFile(shipCabins);
                    case "L" -> loadDataFromFile();
                    case "Q" -> {
                        System.out.println("\n ================ Thank you For Using Cruise Ship ! ==============\n");
                        exit = true;
                    }
                    default -> System.out.println("\n         INVALID INPUT");
                }
            } while (!exit);
        }
    }


    //methods for procedures
    public static void initialize(Cabin[] cabins) {
        for (Cabin cabin : cabins) {
            cabin.setShipCabinName("empty");
        }
    }


    //this method goes through the 'shipCabins' array's elements and prints each out with the customers name
    public static void viewAllCabins(Cabin[] cabins) {
        System.out.println("\n=========== Ship Cabins ===========");
        for (int i = 0; i < cabins.length; i++) {
            System.out.println("\n    ======= Cabin "+i+" ===== " +cabins[i].getShipCabinName());
        }
        System.out.println("\n===================================");
    }


    //this method goes through the mentioned array and checks whether it's indexes are equal to empty and prints the empty ones out
    public static void displayEmptyCabins(Cabin[] arr) {
        System.out.println("\n====== Empty Cabins ======\n");
        for (int i = 0; i < arr.length; i++) {
            String name = arr[i].getShipCabinName();
            if(name.equals("empty")){
                System.out.println("Cabin " + i +" is Empty");
            }
        }
        System.out.println("\n================================");
    }


    //this method prompts user to enter a Cabin number and then prompts up to 3 passengers, and it adds the name to particular cabin arrays & expenses
    // In here if all the cabins full the passengers can stay in the waiting list
    public static void addCustomer(Cabin[] shipCabins) {
        Scanner input = new Scanner(System.in);
        do{
        try {
            System.out.print("Enter Cabin Number(0-11) to stop: ");
                int cabinNum = input.nextInt();
                if ((!shipCabins[0].getShipCabinName().equals("empty")) && (!shipCabins[1].getShipCabinName().equals("empty")) && (!shipCabins[2].getShipCabinName().equals("empty")) && (!shipCabins[3].getShipCabinName().equals("empty")) && (!shipCabins[4].getShipCabinName().equals("empty")) && (!shipCabins[5].getShipCabinName().equals("empty")) && (!shipCabins[6].getShipCabinName().equals("empty")) && (!shipCabins[7].getShipCabinName().equals("empty")) && (!shipCabins[8].getShipCabinName().equals("empty")) &&(!shipCabins[9].getShipCabinName().equals("empty")) && (!shipCabins[10].getShipCabinName().equals("empty")) && (!shipCabins[11].getShipCabinName().equals("empty")) ) {
                    System.out.println("\n SORRY ALL THE CABINS ARE OCCUPIED BY SOMEONE.\n CRUISE SHIP IS FULL !!!!. PLEASE WAIT IN THE WAITING LIST.");
                    System.out.println("\n             ============== WAITING LIST ==============");
                    System.out.println("\n========================== Passenger Types =========================");
                    System.out.print("ENTER THE NUMBER OF PASSENGERS YOU WANT TO BOARD (UP TO 3 PASSENGERS) :  ");
                    int request = input.nextInt();

                    switch (request) {
                        case 1:
                            System.out.println("\n------ Passenger 1 -----");
                            System.out.print("Enter Your first Name : ");
                            String firstName = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName);
                            System.out.print("Enter Your Last Name  : ");
                            String surName = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName);
                            System.out.print("Enter Your Expenses   :$");
                            double expenses = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses);
                            shipCabins[cabinNum].setPassenger1Ex(expenses);

                            System.out.println("\n*********************************************");
                            waitingCabinList.add("\n        (*) Passenger 1 : " + firstName + " " + surName);

                            break;

                        case 2:

                            System.out.println("\n------ Passenger 1 -----");
                            System.out.print("Enter Your first Name : ");
                            firstName = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName);
                            System.out.print("Enter Your Last Name  : ");
                            surName = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName);
                            System.out.print("Enter Your Expenses   : $");
                            expenses = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses);
                            shipCabins[cabinNum].setPassenger1Ex(expenses);

                            System.out.println("\n------ Passenger 2 -----");
                            System.out.print("Enter Your first Name : ");
                            String firstName2 = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName2);
                            System.out.print("Enter Your Last Name  : ");
                            String surName2 = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName2);
                            System.out.print("Enter Your Expenses   : $");
                            double expenses2 = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses2);
                            shipCabins[cabinNum].setPassenger2Ex(expenses2);

                            System.out.println("\n*********************************************");
                            waitingCabinList.add("\n        (*) Passenger 1 : " + firstName + " " + surName + "\n        (*) Passenger 2 : " + firstName2 + " " + surName2);

                            break;


                        case 3:
                            System.out.println("\n-------- Passenger 1 -------");
                            System.out.print("Enter Your first Name : ");
                            firstName = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName);
                            System.out.print("Enter Your Last Name  : ");
                            surName = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName);
                            System.out.print("Enter Your Expenses   : $");
                            expenses = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses);
                            shipCabins[cabinNum].setPassenger1Ex(expenses);

                            System.out.println("\n------ Passenger 2 -----");
                            System.out.print("Enter Your first Name : ");
                            firstName2 = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName2);
                            System.out.print("Enter Your Last Name  : ");
                            surName2 = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName2);
                            System.out.print("Enter Your Expenses   : $");
                            expenses2 = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses2);
                            shipCabins[cabinNum].setPassenger2Ex(expenses2);

                            System.out.println("\n------ Passenger 3 -----");
                            System.out.print("Enter Your first Name : ");
                            String firstName3 = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName3);
                            System.out.print("Enter Your Last Name  : ");
                            String surName3 = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName3);
                            System.out.print("Enter Your Expenses   : $");
                            double expenses3 = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses3);
                            shipCabins[cabinNum].setPassenger3Ex(expenses3);

                            System.out.println("\n*********************************************");
                            waitingCabinList.add("\n        (*) Passenger 1 : " + firstName + " " + surName + "\n        (*) Passenger 2 : " + firstName2 + " " + surName2 + "\n        (*) Passenger 3 : " + firstName3 + " " + surName3);
                            break;

                        default:
                            System.out.println("__ONLY YOU CAN ADD PASSENGER UP TO (1-3)__ ....\nPlease enter correct number of Passengers");
                            break;
                    }
                    break;
            }
                if (shipCabins[cabinNum].getShipCabinName().equals("empty")) {
                    shipCabins[cabinNum].setEnterCabinNumber(cabinNum);
                    System.out.println("\n          =========== WELCOME TO CABIN " + cabinNum + " ===========");
                    System.out.println("\n========================== Passenger Types =========================");
                    System.out.print("ENTER THE NUMBER OF PASSENGERS YOU WANT TO BOARD (UP TO 3 PASSENGERS) :  ");
                    int request = input.nextInt();

                    switch (request) {
                        case 1:
                            System.out.println("\n------ Passenger 1 -----");
                            System.out.print("Enter Your first Name : ");
                            String firstName = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName);
                            System.out.print("Enter Your Last Name  : ");
                            String surName = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName);
                            System.out.print("Enter Your Expenses   :$");
                            double expenses = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses);
                            shipCabins[cabinNum].setPassenger1Ex(expenses);

                            System.out.println("\n*********************************************");
                            shipCabins[cabinNum].setShipCabinName("\n        (*) Passenger 1 : " + firstName + " " + surName);

                            break;

                        case 2:

                            System.out.println("\n------ Passenger 1 -----");
                            System.out.print("Enter Your first Name : ");
                            firstName = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName);
                            System.out.print("Enter Your Last Name  : ");
                            surName = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName);
                            System.out.print("Enter Your Expenses   : $");
                            expenses = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses);
                            shipCabins[cabinNum].setPassenger1Ex(expenses);

                            System.out.println("\n------ Passenger 2 -----");
                            System.out.print("Enter Your first Name : ");
                            String firstName2 = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName2);
                            System.out.print("Enter Your Last Name  : ");
                            String surName2 = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName2);
                            System.out.print("Enter Your Expenses   : $");
                            double expenses2 = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses2);
                            shipCabins[cabinNum].setPassenger2Ex(expenses2);

                            System.out.println("\n*********************************************");
                            shipCabins[cabinNum].setShipCabinName("\n        (*) Passenger 1 : " + firstName + " " + surName + "\n        (*) Passenger 2 : " + firstName2 + " " + surName2);

                            break;


                        case 3:
                            System.out.println("\n-------- Passenger 1 -------");
                            System.out.print("Enter Your first Name : ");
                            firstName = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName);
                            System.out.print("Enter Your Last Name  : ");
                            surName = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName);
                            System.out.print("Enter Your Expenses   : $");
                            expenses = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses);
                            shipCabins[cabinNum].setPassenger1Ex(expenses);

                            System.out.println("\n------ Passenger 2 -----");
                            System.out.print("Enter Your first Name : ");
                            firstName2 = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName2);
                            System.out.print("Enter Your Last Name  : ");
                            surName2 = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName2);
                            System.out.print("Enter Your Expenses   : $");
                            expenses2 = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses2);
                            shipCabins[cabinNum].setPassenger2Ex(expenses2);

                            System.out.println("\n------ Passenger 3 -----");
                            System.out.print("Enter Your first Name : ");
                            String firstName3 = input.next();
                            shipCabins[cabinNum].setPassengerFirstName(firstName3);
                            System.out.print("Enter Your Last Name  : ");
                            String surName3 = input.next();
                            shipCabins[cabinNum].setPassengerSurName(surName3);
                            System.out.print("Enter Your Expenses   : $");
                            double expenses3 = input.nextInt();
                            shipCabins[cabinNum].setExpenses(expenses3);
                            shipCabins[cabinNum].setPassenger3Ex(expenses3);

                            System.out.println("\n*********************************************");
                            shipCabins[cabinNum].setShipCabinName("\n        (*) Passenger 1 : " + firstName + " " + surName + "\n        (*) Passenger 2 : " + firstName2 + " " + surName2 + "\n        (*) Passenger 3 : " + firstName3 + " " + surName3);
                            break;

                        default:
                            System.out.println("__ONLY YOU CAN ADD PASSENGER UP TO (1-3)__ ....\nPlease enter correct number of Passengers");
                            break;

                    }
                    System.out.println("Cabin number " + shipCabins[cabinNum].getEnterCabinNumber() + " is occupied by " + shipCabins[cabinNum].getShipCabinName());
                        break;
                } else {
                    System.out.println("SORRY!!  ALREADY CABIN " + cabinNum + " IS OCCUPIED BY SOMEONE.TRY ANOTHER CABIN. \n");
                }
            }catch(Exception e){
                System.out.println("        INVALID INPUT ");
                break;
            }
        }while (true);
    }


    //this method prompts user for a number and delete the customer in that cabin(number) of the array & modified to add passenger from waiting list to the passenger removed cabin
    public static void deleteCustomer(Cabin[] arr) {
        System.out.println("\n====== Remove Customers From Cabins ======\n");
        Scanner input = new Scanner(System.in);
        int cabin_Num = 0;
        try {
            System.out.print("In Which Cabin Do You Want To Remove Passengers : ");
            cabin_Num = input.nextInt();
            if (waitingCabinList.isEmpty()){
            arr[cabin_Num].setShipCabinName("empty");
            }else {
                arr[cabin_Num].setShipCabinName(waitingCabinList.remove());
            }

        } catch (Exception e) {
            System.out.println("        INVALID INPUT");
        }

        System.out.println("\n Successfully Passengers Removed From Cabin " + cabin_Num + ".");
    }


    //this method prompts user for the name before entered and display the cabin number that name included
    public static void findCabins(Cabin[] arr) {
        boolean userInput=false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter The Passenger Name To Find The Cabin: ");
        String passengerName = input.nextLine();
        passengerName = passengerName.toLowerCase();
        for (int i = 0; i < arr.length; i++) {
            String cabinName = arr[i].getShipCabinName();
            cabinName = cabinName.toLowerCase();
            if(cabinName.contains(passengerName)){
                System.out.println("Passenger "+ passengerName + " Cabin Number : "+i);
                userInput = true;
            }
        }
        if (!userInput){
            System.out.println("There is no passenger with the Name "+passengerName+". ");
        }
    }


    //this method prints all the customers in alphabetical order
    public static void sortInAlphabeticalOrder(Cabin[] arr) {
        Cabin[] newArr = new Cabin[12];
        System.arraycopy(arr, 0, newArr, 0, arr.length);

        for (int j = 0; j < arr.length- 1; j++) {
            for (int i = j + 1; i < newArr.length; i++) {
                if (newArr[j].getShipCabinName().compareToIgnoreCase(arr[i].getShipCabinName()) > 0) {
                    Cabin temp = newArr[j];
                    newArr[j] = newArr[i];
                    newArr[i] = temp;
                }
            }
        }
        for (Cabin cabin : newArr) {
            if (cabin.getShipCabinName().equals("empty")) {
                continue; }
            System.out.println(cabin.getShipCabinName());
        }
    }

    //this method will print the passnegers expenses & total expenses in the entire cabin
    public static void totalExpenses(Cabin[] arr) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter A Cabin Number (0-11) to Check Expenses: ");
            int cabinNo = input.nextInt();

            System.out.println(arr[cabinNo].getShipCabinName());
            System.out.print("    ============= Expenses =========== ");
            System.out.println("\n        Passenger 1 expense: $"+ arr[cabinNo].getPassenger1Ex());
            System.out.println("        Passenger 2 expense: $"+arr[cabinNo].getPassenger2Ex());
            System.out.println("        Passenger 3 expense: $"+arr[cabinNo].getPassenger3Ex());
            System.out.println("        Total Expenses Of Cabin "+cabinNo+": $" + (arr[cabinNo].getPassenger1Ex() + arr[cabinNo].getPassenger2Ex() + arr[cabinNo].getPassenger3Ex()));
            System.out.print("    =================================== ");
        }catch (Exception e){
            System.out.println("        INVALID INPUT");
        }
    }


    //this method created a text file and stores the mentioned data into it
    public static void storeDataIntoFile(Cabin[] arr) {
        try {
            FileWriter enterData = new FileWriter("cruiseShipCabinData.txt");
            enterData.write("=============== The Stored Data ==============\n");
            for (int i = 0; i < arr.length; i++) {
                enterData.write("\n       ===== Cabin " + (i) + " ==== " + arr[i].getShipCabinName()+ "\n");
            }
            enterData.write("   \n\n____________ WAITING LIST____________");
            for (String i : waitingCabinList) {
                enterData.write(i+"\n");
                enterData.write("\n=====================================");
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
    public static void loadDataFromFile() {
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


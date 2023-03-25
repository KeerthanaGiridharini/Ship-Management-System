package com.keerthana;

import java.util.Objects;
import java.util.Scanner;


public class K {
    public static void main(String[] args) {
        iniARR();
        Mainmenu();

    }

    public static void iniARR() {
        for (int i = 0; i < pump1.length; i++) {
            pump1[i] = "Empty";
            pump2[i] = "Empty";
            pump3[i] = "Empty";
        }
    }

    public static String[] pump1 = new String[6];
    public static String[] pump2 = new String[6];
    public static String[] pump3 = new String[6];
    public static int totalfuel = 6600;
    //public static int nopumps=3;
    final static int warning=500;
    //public static int fuellimit=10;
    static Scanner input = new Scanner(System.in);
    static String choice;


    public static void Mainmenu() {
        boolean exit = false;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Welcome to the Aradhana Fuel Center");
        System.out.println("--------------------------------------------------------------------");


        System.out.println
                ("""
                        [100 or VFQ]:  View all Fuel Queue                   [101 or VEQ] : View all empty Queues.  \s
                        [102 or ACQ]: Add customer to a Queue                [103 or RCQ] : Remove a customer form a Queue
                        [104 or PCQ]: Remove a served customer               [105 or VCS] : View Customers Sorted in alphabetical order\s
                        [106 or SPD]: Store Program Data into file.          [107 or LPD] : Load Program Data from file\s
                        [108 or STK]: View Remaining Fuel Stock.             [109 or AFS] :Add Fuel Stock.
                         [999 or EXT]:Exit""");
        do {
            System.out.print("Enter and option to continue > ");
            choice = input.next();
            switch (choice) {
                case "100", "VFQ" -> ViewAllQueue();
                case "101", "VEQ" -> ViewEmpQueue();
                case "102", "ACQ" -> AddCustomer();
                case "103", "RCQ" -> RemoveCustomer();
                case "104", "PCQ" -> RemoveSerCustomer();

                //case "105", "VCS":
                //ViewCustomer();
                //  break;
                //case "106", "SPD":
                //StoreProgram();
                //  break;
                //case "107", "LPD":
                //LoadProgram();
                //  break;
                case "108", "STK" -> RemainFuel();

                //case "109", "AFS":
                //AddFuel();
                //  break;
                case "999", "EXT"-> exit = true;

                //default -> System.err.println("Invalid input");

            }
        } while (!exit);

    }

    private static void RemainFuel() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                            Remain Fuel                             |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(" Remaining Fuel = "+totalfuel);
        if (totalfuel==warning){
            System.out.println("You Dont have enough Fuel!!!!!");
        }
    }


    public static void ViewAllQueue() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                            View All Queue                          |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();
        System.out.println("PUMP 01");
        for (int i = 0; i < pump1.length; i++) {
            System.out.println("    Customer" + (i + 1) + " : " + pump1[i]);
        }

        System.out.println("\nPUMP 02");
        for (int j = 0; j < pump1.length; j++) {
            System.out.println("    Customer" + (j + 1) + " : " + pump2[j]);
        }

        System.out.println("\nPUMP 03");
        for (int k = 0; k < pump1.length; k++) {
            System.out.println("    Customer" + (k + 1) + " : " + pump3[k]);
        }


    }

    public static void ViewEmpQueue() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                            View Empty Queue                          |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();
        System.out.println("PUMP 01");
        for (int i = 0; i < pump1.length; i++) {
            if (pump1[i].equals("Empty")) {
                System.out.println("    Customer" + (i + 1) + " : " + pump1[i]);
            }
        }

        System.out.println("\nPUMP 02");
        for (int j = 0; j < pump1.length; j++) {
            if (pump2[j].equals("Empty")) {
                System.out.println("    Customer" + (j + 1) + " : " + pump2[j]);
            }
        }

        System.out.println("\nPUMP 03");
        for (int k = 0; k < pump1.length; k++) {
            if (pump3[k].equals("Empty")) {
                System.out.println("    Customer" + (k + 1) + " : " + pump3[k]);
            }
        }

    }

    public static void AddCustomer() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|                         Add Customr to a Queue                         |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();

        System.out.println("Select a pump(1/2/3):");

        int num = input.nextInt();
        if(num==1|| num==2 || num==3) {
            if (num == 1) {

                for (int i = 0; i < 6; i++) {
                    if (pump1[i].equals("Empty")) {
                        System.out.println("Enter customer's Name:");
                        String name = input.next();
                        pump1[i] = name;
                        break;
                    }

                }

            } else if (num == 2) {
                for (int j = 0; j < 6; j++) {
                    if (pump2[j].equals("Empty")) {
                        System.out.println("Enter customer's name:");
                        String name2 = input.next();
                        pump2[j] = name2;
                        break;

                    }
                }

            } else {
                for (int k = 0; k < 6; k++) {
                    if (pump3[k].equals("Empty")) {
                        System.out.println("Enter customer's name:");
                        String name3 = input.next();
                        pump3[k] = name3;
                        break;

                    }
                }
            }
        }else{
            System.out.println("Please enter valid pump number");}
    }


    public static void RemoveCustomer() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Remove  customer");
        System.out.println("------------------------------------------------------");

        System.out.println("Enter pump number:");
        int pum = input.nextInt();
        if (pum < 0 || pum > 3) {
            System.out.println("Plz enter valid  pump number( 1-3)");
        } else {
            System.out.println("Enter the index you want to remove:");
            int ind = input.nextInt();
            if (pum == 1) {
                if (pump1 == null || ind < 0 || ind >= pump1.length) {
                    System.out.println("Cant Remove this customer . try again");
                }
                int i ;
                for (i = ind - 1; i < pump1.length - 1; i++) {
                    if (pump1[i + 1].equals( "Empty"))
                    pump1[i] = pump1[i + 1];

                }
                pump1[i] = "Empty";
                for (String m : pump1) {
                    System.out.println(m);
                }

            }
            if (pum == 2) {
                if (pump2 == null || ind < 0 || ind >= pump2.length) {
                    System.out.println("Cant Remove this customer . try again");

                }
                int j ;
                for (j = ind - 1; j < pump2.length - 1; j++) {
                    if (Objects.equals(pump2[j + 1], "Empty")) break;
                    pump2[j] = pump2[j + 1];
                }
                pump2[j] = "Empty";
                for (String x : pump2) {
                    System.out.println(x);
                }
            }
            if (pum == 3) {
                if (pump3 == null || ind < 0 || ind >= pump3.length) {
                    System.out.println("Cant remove this customer.Try again.");
                }
                int k ;
                for (k = ind - 1; k < pump3.length - 1; k++) {
                    if (Objects.equals(pump3[k + 1], "Empty")) break;
                    pump3[k] = pump3[k + 1];
                }
                pump3[k] = "Empty";
                for (String y : pump3) {
                    System.out.println(y);
                }
            }


        }
    }

    public static void RemoveSerCustomer() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Remove served customer");
        System.out.println("------------------------------------------------------");
        System.out.println("Enter pump number:");
        int pum = input.nextInt();
        if (pum == 1) {
            int i;
            for (i = 0; i < pump1.length - 1; i++) {

                if (Objects.equals(pump1[i + 1], "Empty")) break;
                pump1[i] = pump1[i + 1];
            }

            if(!Objects.equals(pump1[i], "Empty"))
            totalfuel -= 10;

            pump1[i] = "Empty";
            for (String m : pump1) {
                System.out.println(m);
            }
            System.out.println(totalfuel);

        }


        else if (pum == 2) {
            int j;
            for (j = 0; j < pump2.length - 1; j++) {

                if (Objects.equals(pump2[j + 1], "Empty")) break;
                pump2[j] = pump2[j + 1];
            }

            if(!Objects.equals(pump2[j], "Empty"))
            totalfuel -= 10;


            pump2[j] = "Empty";
            for (String x : pump2) {
                System.out.println(x);
            }
        }
        else if (pum == 3) {
            int k;
            for (k = 0; k < pump3.length - 1; k++) {
                if (Objects.equals(pump3[k + 1], "Empty")) break;
                pump3[k] = pump3[k + 1];
            }
            if(!Objects.equals(pump3[k], "Empty"))
            totalfuel -= 10;

            pump3[k] = "Empty";
            for (String y : pump3) {
                System.out.println(y);
            }


        }


    }
}
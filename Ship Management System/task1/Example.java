package com.keerthana;

import java.util.*;

public class Example {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        int option;
        boolean exit = false;

        do {
            System.out.println("	****************");
            System.out.println("	 UNIT CALCULATOR	");
            System.out.println("	****************");
            System.out.println("\n----------- Menu Options ----------");  // menu options
            System.out.println("  1 : Convert Meter to Centimeter");
            System.out.println("  2 : Convert Liter to Mililiter");
            System.out.println("  3 : Convert Feet to Inches");
            System.out.println("  4 : Convert Gigabyte to Megabyte");
            System.out.println("  0 : Exit ");
            System.out.println("------------------------------------");
            System.out.print("\n Enter an option from the above menu : ");

            option = input.nextInt();
            //This if statement to check users choice
            switch(option){
                case 1:
                    System.out.println("\n===== Converting Meter to Centimeter =====");
                    try{
                        System.out.print(" Enter Value in Meter : ");
                        int m = input.nextInt();
                        System.out.print(" The Value in Centemeter is : "+ m*100 +"cm\n");
                    }catch(Exception e) {
                        System.out.println("        INVALID INPUT\n");
                    }
                    System.out.println("==========================================\n\n");

                    break;
                case 2:
                    System.out.println("\n===== Converting Liter to Milileter =====");
                    try{
                        System.out.print(" Enter Value in Liter : ");
                        int l = input.nextInt();
                        System.out.print(" The Value in Mililiter is : "+ l*1000 +" ml\n");
                    }catch(Exception e) {
                        System.out.println("        INVALID INPUT\n");
                    }
                    System.out.println("==========================================\n\n");

                    break;
                case 3:
                    System.out.println("\n===== Converting Feet to Inches =====");
                    try{
                        System.out.print(" Enter Value in Feet : ");
                        int f = input.nextInt();
                        System.out.print(" The Value in Inches is : "+ f*12 +"\n");
                    }catch(Exception e) {
                        System.out.println("        INVALID INPUT\n");
                    }
                    System.out.println("==========================================\n\n");

                    break;
                case 4:
                    System.out.println("\n===== Converting Gigabyte to Megabyte =====");
                    try{
                        System.out.print(" Enter Value in Gigabytes : ");
                        int g = input.nextInt();
                        System.out.print(" The Value in Megabyte is : "+ g*1000 +" MB\n");
                    }catch(Exception e) {
                        System.out.println("        INVALID INPUT\n");
                    }
                    System.out.println("==========================================\n\n");

                    break;
                case 0:
                    System.out.println("Thank You For Using Unit Calculator!!!");
                    exit = true;

                    break;

                default:
                    System.out.println("         INVALID INPUT");
            }

        } while (!exit);

    }
}



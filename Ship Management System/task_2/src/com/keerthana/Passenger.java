//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1867636
//Date: 20/04/2022

package com.keerthana;

public class Passenger {
    //instant variables

    String passengerFirstName;
    String passengerSurName;
    double expenses;
    double passenger1Ex;
    double passenger2Ex;
    double passenger3Ex;

    //getters & setters
    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public void setPassengerSurName(String passengerSurName) {
        this.passengerSurName = passengerSurName;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
    public void setPassenger1Ex(double expenses) {
        this.passenger1Ex = expenses;
    }
    public void setPassenger2Ex(double expenses) {
        this.passenger2Ex = expenses;
    }
    public void setPassenger3Ex(double expenses) {
        this.passenger3Ex = expenses;
    }
    public double getPassenger1Ex() {
        return passenger1Ex ;
    }
    public double  getPassenger2Ex() {
        return passenger2Ex  ;
    }
    public double getPassenger3Ex() {
        return passenger3Ex ;
    }

}

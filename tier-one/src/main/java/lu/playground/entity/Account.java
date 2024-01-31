package lu.playground.entity;

import javax.validation.constraints.NotBlank;

/**
 * A simple representation of a bank account
 */
public class Account {
    //Account Owner Info
    private final String firstName;
    private final String lastName;

    //Account Details
    private double balance; //The balance is automatically assigned for you

    /**
     * Constructs a new Account using the name info
     * @param firstName
     * @param lastName
     */
    public Account(
        @NotBlank String firstName,
        @NotBlank String lastName){

        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = Math.random() * 100.00;
    }

    /**
     * Sets the account balance, provided that it is greater than zero
     */
    public void setBalance(double newBalance){
        
    }
}

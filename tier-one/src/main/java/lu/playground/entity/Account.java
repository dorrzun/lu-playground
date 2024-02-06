package lu.playground.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * A simple representation of a bank account
 */
@Data
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
     * @apiNote @Min doesn't actually work here due to some third party constraints, but this is just demonstrate :)
     */
    public void setBalance(@Min(0) double newBalance){
        
    }

    /**
     * Determines if this customer is "favorable" in our (the bank's) eyes
     * @apiNote To be considered favorable, the account must have a balance exceeding $1000 and whose owner's name isn't "Austin"
     * @return
     */
    public boolean isFavorable(){
        return !firstName.equalsIgnoreCase("Austin") && balance > 1000;
    }
}

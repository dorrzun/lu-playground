package lu.playground.service;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;
import lu.playground.entity.Account;
import lu.playground.service.contracts.AccountServiceContract;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Facilitates all business operations regarding bank accounts
 * @apiNote Do not reference this class directly. You must use {@link AccountServiceContract}
 */
@Slf4j
public class AccountService implements AccountServiceContract {

    // init a temp hashmap for local saves for now...
    private Map<String, Account> accountDatabase = new HashMap<>();
    
    public AccountService(){
        log.info("Initializing the Account Service...");
    }

    @Override
    public String createAccount(@NotBlank String firstName, @NotBlank String lastName) {
        // TODO Auto-generated method stub

        try{
            // attempt to find if account exists
                // if it doesn't, create it
                // if it does, return its account id
        }

        catch ( Exception e ) {
            //print error message
        }
        //throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }

    @Override
    public Optional<Account> getAccount(@NotBlank String accountId) {
        // TODO Auto-generated method stub
        try{
            // attempt to lookup account and return it
        }

        catch ( Exception e ){
            //print error message
        }
        //throw new UnsupportedOperationException("Unimplemented method 'getAccount'");
    }

    @Override
    public void updateAccount(@NotNull Account updatedAccount) {
        // TODO Auto-generated method stub
        try {
            // update account?
        }

        catch( Exception e ){
            //print error message
        }
        //throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

    @Override
    public void deleteAccount(@NotBlank String accountId) {
        // TODO Auto-generated method stub
        try {
            // attempt to remove account from database
        }

        catch( Exception e ){
            //print error message
        }
        //throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }
}

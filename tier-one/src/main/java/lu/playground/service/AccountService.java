package lu.playground.service;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.extern.slf4j.Slf4j;
import lu.playground.entity.Account;
import lu.playground.exception.DatabaseException;
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
    public String createAccount(@NotBlank String firstName, @NotBlank String lastName) throws DatabaseException {
        // TODO Auto-generated method stub

        try {
            String key = generateKey( firstName, lastName);
            if( accountDatabase.containsKey(key) ){
                return key;
            }

            else {
                Account newAccount = new Account(firstName, lastName);
                accountDatabase.put(key, newAccount);
                return key;
            }
        } catch (Exception e) {
            throw new DatabaseException("Failed to create account", e);
        }
        //throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }

    @Override
    public Optional<Account> getAccount(@NotBlank String accountId) throws DatabaseException {
        // TODO Auto-generated method stub

        try{
            // attempt to lookup account and return it
            Account account = accountDatabase.get( accountId );
            return Optional.ofNullable( account );
        }

        catch ( Exception e ){
            throw new DatabaseException("Failed to get account", e);
        }
        //throw new UnsupportedOperationException("Unimplemented method 'getAccount'");
    }

    @Override
    public void updateAccount(@NotNull Account updatedAccount) throws DatabaseException {
        // TODO Auto-generated method stub
        try {
            accountDatabase.put( updatedAccount.getFirstName() + updatedAccount.getLastName(), updatedAccount );
        }

        catch( Exception e ){
            throw new DatabaseException("Failed to update account", e);
        }
        //throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

    @Override
    public void deleteAccount(@NotBlank String accountId) throws DatabaseException {
        // TODO Auto-generated method stub
        try {
            accountDatabase.remove( accountId );
        }

        catch( Exception e ){
            throw new DatabaseException("Failed to delete account", e);
        }
        //throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }

    public String generateKey( @NotBlank String firstName, @NotBlank String lastName ) {
        String firsthalf = firstName.substring(0, Math.min(firstName.length(), 3)).toUpperCase();
        String lasthalf = lastName.substring(0, Math.min(lastName.length(), 3)).toUpperCase();

        String rv = lasthalf + firsthalf;

        while (rv.length() < 6) {
            rv += "0";
        }

        return rv;
    }
}

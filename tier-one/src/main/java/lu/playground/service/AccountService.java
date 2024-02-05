package lu.playground.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;
import lu.playground.entity.Account;
import lu.playground.exception.DatabaseException;
import lu.playground.service.contracts.AccountServiceContract;

/**
 * Facilitates all business operations regarding bank accounts
 * @apiNote Do not reference this class directly. You must use {@link AccountServiceContract}
 */
@Slf4j
public class AccountService implements AccountServiceContract {
    
    private Map<String, Account> accountDatabase = new HashMap<>();
    
    public AccountService(){
        log.info("Initializing the Account Service...");
    }

    @Override
    public String createAccount(@NotBlank String firstName, @NotBlank String lastName) {
        try{
            String accountID = firstName +lastName;

            if(accountDatabase.containsKey(accountID)){
                log.info("Account already exists. Account ID: {}", accountID);
                return accountID;
            }

            Account newAccount = new Account(firstName, lastName);
            accountDatabase.put(accountID, newAccount);

            log.info("Account created. Account ID: {}", accountID);
            return accountID;
        } catch (Exception e){
            log.error("Could not create account", e);
            throw new DatabaseException("Could not create account", e);
        }
        //    throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }
        
    @Override
    public Optional<Account> getAccount(@NotBlank String accountId) {
        try{
            Account newAccount = accountDatabase.get(accountId);
            return Optional.ofNullable(newAccount);
        } catch (Exception e) {
            log.error("Problem getting account",e);
            throw new DatabaseException("Problem getting account", e);
        }
        //throw new UnsupportedOperationException("Unimplemented method 'getAccount'");
    }

    @Override
    public void updateAccount(@NotNull Account updatedAccount) {
        //String accountID;
        try {
            //accountDatabase.put(updatedAccount.accountID, updatedAccount);
            //log.info("Account updated successfully. Account ID: {}", updatedAccount.accountId);
        } catch (Exception e) {
            log.error("Error updating account", e);
            throw new DatabaseException("Error updating account", e);
        }
      //  throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

    @Override
    public void deleteAccount(@NotBlank String accountId) {
        try {
            Account deletedAccount = accountDatabase.remove(accountId);

            if (deletedAccount != null) {
                log.info("Account deleted successfully. Account ID: {}", accountId);
            } else {
                log.warn("Account with ID {} not found for deletion.", accountId);
            }
        } catch (Exception e) {
            log.error("Error deleting account", e);
            throw new DatabaseException("Error deleting account", e);
        }
       // throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }
}

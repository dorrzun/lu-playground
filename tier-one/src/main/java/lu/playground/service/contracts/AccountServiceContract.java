package lu.playground.service.contracts;

import java.util.Optional;

import lu.playground.entity.Account;
import lu.playground.exception.DatabaseException;

/**
 * Represents the working data contract offered to any consumers of the account
 * service.
 * The service guarantees basic CRUD (Create, Read, Update and Delete) of
 * {@link Account} objects in a controlled manner
 * 
 * @apiNote Consume/reference this interface when you need to work directly with
 *          bank accounts in some capacity
 */
public interface AccountServiceContract {
    /**
     * Attempts to create a new bank account using the provided first and last name.
     * 
     * @apiNote If an account already exists with the given name values, the
     *          existing account's ID is returned
     * @param firstName The first name of the account owner
     * @param lastName  The last name of the account owner
     * @return A six character string representing the account ID
     * @throw DatabaseException If the account database was unavailable
     */
    public String createAccount(String firstName, String lastName);

    /**
     * Retrieve an account from the account database
     * 
     * @implNote Although it would be considered more consistent, the verb for
     *           "read" often appears as "get" or "fetch"
     * @param accountId A 6 character string containing only non-whitespace chars
     * @return The account having the given ID
     * @throw DatabaseException If the account database was unavailable
     */
    public Optional<Account> getAccount(String accountId);

    /**
     * Overwrites the old account info in the account database
     * 
     * @apiNote You must aim to ensure that {@link Account} objects cannot be
     *          maliciously created and passed in here.
     * @implNote This action will succeed even if the account has no prior entry in
     *           the database
     * @param updatedAccount An account object to write to the database
     * @throw DatabaseException If the account database was unavailable
     */
    public void updateAccount(Account updatedAccount);

    /**
     * Deletes the account with the given ID from the database
     * 
     * @param accountId
     * @throw DatabaseException If the account database was unavailable
     */
    public void deleteAccount(String accountId);
}

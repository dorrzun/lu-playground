/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lu.playground;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lu.playground.entity.Account;
import lu.playground.service.AccountService;
import lu.playground.service.contracts.AccountServiceContract;

/**
 * Verifies that the Account Service satisfies its service contract
 */
class AccountServiceTest {
    private AccountServiceContract accountService = new AccountService();

    /**
     * Verifies that all 4 CRUD operations behave as expected for the Account Service
     */
    @ParameterizedTest
    @ValueSource(strings = {"John Smith", "Jane Doe", "Chuck Norris"})
    void testAllFourCrudOperations(String name) {
        //Parse the first and last name
        final String[] nameParts = name.split(StringUtils.SPACE);

        //Ask the service to create the account
        String accountId = accountService.createAccount(nameParts[0],nameParts[1]);

        //Ask the service to retrieve the account (known to exist)
        Account account = accountService.getAccount(accountId).get();

        //Ask the service to overwrite the entry in the database with our updated account info
        account.setBalance(9001.00);
        accountService.updateAccount(account);

        //Ask the service to delete the entry in the database
        accountService.deleteAccount(accountId);
    }
}

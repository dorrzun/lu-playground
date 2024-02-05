package lu.playground;

//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;

//import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;
import lu.playground.service.AccountService;
import lu.playground.service.contracts.AccountServiceContract;

/**
 * This is the main workflow for Tier 1
 * @apiNote This app will attempt to perform the following actions:
 * <ol>
 * <li>Create a few bank accounts using the Account Service</li>
 * <li>Modify the balances on the accounts</li>
 */
@Slf4j
public class App {
    //Creates the Account Service
    //Note how we are limiting ourselves to the interface, rather than the implementation of it
    private static AccountServiceContract accountService = new AccountService();
    
    public static void main(String[] args) {
        log.info("Starting Tier 1 Application!");
    }
}

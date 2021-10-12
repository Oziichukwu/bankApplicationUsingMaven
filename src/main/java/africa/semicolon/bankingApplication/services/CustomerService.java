package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.Customer;

public interface CustomerService {
    Account createAccount(String firstName, String lastName);

    Account createAccount(String firstName, String lastName, String bvn);

}

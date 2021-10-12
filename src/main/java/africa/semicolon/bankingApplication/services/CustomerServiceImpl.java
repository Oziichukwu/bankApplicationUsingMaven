package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.repositories.CustomerRepository;
import africa.semicolon.bankingApplication.data.repositories.CustomerReposotoryImpl;

public class CustomerServiceImpl implements  CustomerService{

    private CustomerRepository customerRepository = new CustomerReposotoryImpl();

    @Override
    public Account createAccount(String firstName, String lastName) {
        return null;
    }

    @Override
    public Account createAccount(String firstName, String lastName, String bvn) {
        return null;
    }
}

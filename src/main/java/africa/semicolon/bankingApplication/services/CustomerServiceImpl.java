package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.dtos.Response.CustomerResponse;
import africa.semicolon.bankingApplication.data.models.Customer;
import africa.semicolon.bankingApplication.data.repositories.CustomerRepository;
import africa.semicolon.bankingApplication.data.repositories.CustomerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements  CustomerService{

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public String createAccount(String firstName, String lastName) {
        return null;
    }

    @Override
    public String createAccount(String firstName, String lastName, String bvn) {
        return null;
    }

    @Override
    public List<CustomerResponse> findAll() {
        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> ourRealCustomers = customerRepository.findAll();
        for (Customer customer : ourRealCustomers) responses.add(new CustomerResponse(customer));
        ourRealCustomers.forEach(customer -> responses.add(new CustomerResponse(customer)));
        return responses;
    }
}

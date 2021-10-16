package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.dtos.Response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    String createAccount(String firstName, String lastName);
    String createAccount(String firstName, String lastName, String bvn);

    List<CustomerResponse> findAll();
}

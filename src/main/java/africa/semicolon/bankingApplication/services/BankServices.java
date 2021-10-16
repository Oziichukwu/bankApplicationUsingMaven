package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.dtos.Request.CreateAccountRequest;
import africa.semicolon.bankingApplication.data.models.Bank;

import java.util.List;

public interface BankServices {

    public String createBank(String bankName);

    public List<Bank> findAllBanks();

    String createAccount(CreateAccountRequest createAccountRequest);
}

package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.dtos.Request.CreateAccountRequest;
import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.data.models.Customer;
import africa.semicolon.bankingApplication.data.repositories.BankRepository;
import africa.semicolon.bankingApplication.data.repositories.BankRepositoryImpl;

import java.util.List;

public class BankServicesImpl implements BankServices{
    private BankRepository bankRepository = new BankRepositoryImpl();
    private static int lastAccountNumber = 0;
    @Override
    public String createBank(String bankName) {
        Bank bank = generateBankId();
        bank.setName(bankName);
        Bank savedBank = bankRepository.save(bank);
        return savedBank.getId();
    }

    @Override
    public List<Bank> findAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public String createAccount(CreateAccountRequest createAccountRequest) {

        String bankId = createAccountRequest.getBankId();
        String accountNumber = generateSuffixFor(bankId);
        Customer customer = new Customer();
        Account account = new Account();
        account.setNumber(bankId + accountNumber);
        account.setType(createAccountRequest.getAccountType());

        customer.setFirstName(createAccountRequest.getFirstName());
        customer.setLastName(createAccountRequest.getLastName());
        customer.getAccounts().add(account);
        //customerService.addNew(customer);

        Bank bank = bankRepository.findByBankId(bankId);
        bank.getAccounts().add(account);
        bankRepository.save(bank);
        System.out.println(bankRepository.findAll());
        return account.getNumber();
    }

    private String generateSuffixFor(String bankId) {
        Bank bank = bankRepository.findByBankId(bankId);
        int lastNumber = bank.getAccounts().size();
        return String.format("%08d", ++lastNumber);
    }

    private Bank generateBankId() {
        int lastBankIdCreated = findAllBanks().size();
        Bank bank = new Bank();
        bank.setId(String.format("%02d", ++lastBankIdCreated));
        return bank;

    }
}

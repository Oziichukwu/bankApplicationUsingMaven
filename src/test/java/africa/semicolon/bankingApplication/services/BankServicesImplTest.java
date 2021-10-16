package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.dtos.Request.CreateAccountRequest;
import africa.semicolon.bankingApplication.data.models.AccountType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServicesImplTest {
    BankServices bankServices;
    @BeforeEach
    void setUp() {
        bankServices = new BankServicesImpl();
    }

    @AfterEach
    void tearDown() {
        bankServices = null;
    }

    @Test
    void createBank() {
        String bankId= bankServices.createBank("GTCO");
        assertEquals("01", bankId);
    }

    @Test
    void createTwoBanks_secondBank_willBe02(){

        String gtCOID = bankServices.createBank("GTCO");
        String firstBank = bankServices.createBank("FIRSTBANK");

        assertEquals("01", gtCOID);
        assertEquals("02", firstBank);
    }

    @Test
    void createTwoBanks_repositoryShouldNowHaveTwoBanks(){

        String gtCOID = bankServices.createBank("GTCO");
        String firstBank = bankServices.createBank("FIRSTBANK");

        assertEquals("01", gtCOID);
        assertEquals("02", firstBank);
        assertEquals(2, bankServices.findAllBanks().size());
        System.out.println(bankServices.findAllBanks());
    }
    @Test
    void bankCanCreateAccountForCustomers(){
        String gtCOID = bankServices.createBank("GTCO");
        // when
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setAccountType(AccountType.CURRENT);
        createAccountRequest.setBankId("01");
        createAccountRequest.setFirstName("Goodnews");
        createAccountRequest.setLastName("Uchechukwu");
        String accountNumber = bankServices.createAccount(createAccountRequest);
        assertEquals("0100000001", accountNumber);
    }
    @Test
    void createTwoAccountsInBank1_accountNumberShouldBe02(){
        String gtCOID = bankServices.createBank("GTCO");
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setAccountType(AccountType.CURRENT);
        createAccountRequest.setBankId("01");
        createAccountRequest.setFirstName("Lawal");
        createAccountRequest.setLastName("Uchechukwu");
        String yusufAccountNumber = bankServices.createAccount(createAccountRequest);
        CreateAccountRequest sholasForm = new CreateAccountRequest();
        sholasForm.setAccountType(AccountType.CURRENT);
        sholasForm.setBankId("01");
        sholasForm.setFirstName("Goodnews"); // A builder can be used to reduce this code
        sholasForm.setLastName("Uchechukwu");
        String mikeAccountNumber = bankServices.createAccount(sholasForm);
        assertEquals("0100000001", yusufAccountNumber);
        assertEquals("0100000002", mikeAccountNumber);
    }
    @Test
    void createAccountsInTheTwoBanks_accountNumberShouldBeDifferentWithdifferentBank(){
        String gtCOID = bankServices.createBank("GTCO");
        String firstBank = bankServices.createBank("FIRSTBANK");
        String goodboyzBank = bankServices.createBank("GODDYBANK");

        CreateAccountRequest sholasForm = new CreateAccountRequest();
        sholasForm.setAccountType(AccountType.CURRENT);
        sholasForm.setBankId("01");
        sholasForm.setFirstName("Goodnews");
        sholasForm.setLastName("Uchechukwu");
        String mikeAccountNumber = bankServices.createAccount(sholasForm);

        CreateAccountRequest olasForm = new CreateAccountRequest();
        olasForm.setAccountType(AccountType.CURRENT);
        olasForm.setBankId("02");
        olasForm.setFirstName("ola");
        olasForm.setLastName("chukwu");
        String bikeAccountNumber = bankServices.createAccount(olasForm);

        CreateAccountRequest holasForm = new CreateAccountRequest();
        holasForm.setAccountType(AccountType.CURRENT);
        holasForm.setBankId("03");
        holasForm.setFirstName("holas");
        holasForm.setLastName("Uche");
        String yemiAccountNumber = bankServices.createAccount(holasForm);

        assertEquals("0100000001", mikeAccountNumber);
        assertEquals("0200000001", bikeAccountNumber);
        assertEquals("0300000001", yemiAccountNumber);
    }

    @Test
    void whenAccountIsCreated_customerIsCreated(){
        String gtCOID = bankServices.createBank("GTCO");

        CreateAccountRequest sholasForm = new CreateAccountRequest();
        sholasForm.setAccountType(AccountType.CURRENT);
        sholasForm.setBankId("01");
        sholasForm.setFirstName("Goodnews");
        sholasForm.setLastName("Uchechukwu");
        String mikeAccountNumber = bankServices.createAccount(sholasForm);

        CustomerService customerService = new CustomerServiceImpl();

        assertEquals(1, customerService.findAll().size());

    }

}
package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.AccountType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
    AccountRepository accountRepository;
    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Account account = new Account();
        account.setNumber("217300854");
        account.setCustomerId("38878906");
        account.setType(AccountType.SAVINGS);
        Account savedAccount = accountRepository.save(account);
        assertEquals(account, savedAccount);
    }

    @Test
    void findByAccountid() {
        Account account = new Account();
        account.setNumber("217300854");
        account.setCustomerId("38878906");
        account.setType(AccountType.SAVINGS);
        Account savedAccount = accountRepository.save(account);
        Account foundAccount = accountRepository.findByAccountid("38878906");
        assertEquals(savedAccount, foundAccount);
    }

    @Test
    void delete() {
        Account account = new Account();
        account.setNumber("217300854");
        account.setCustomerId("38878906");
        account.setType(AccountType.SAVINGS);
        accountRepository.save(account);
        assertNotNull(accountRepository.findByAccountid("38878906"));
        accountRepository.delete(account);
        assertNull(accountRepository.findByAccountid("38878906"));
    }

    @Test
    void testDelete() {
        Account account = new Account();
        account.setNumber("217300854");
        account.setCustomerId("38878906");
        account.setType(AccountType.SAVINGS);
        accountRepository.save(account);
        assertNotNull(accountRepository.findByAccountid("38878906"));
        accountRepository.delete("38878906");
        assertNull(accountRepository.findByAccountid("38878906"));
    }

    @Test
    void findAll() {
        Account account = new Account();
        account.setNumber("217300854");
        account.setCustomerId("38878906");
        account.setType(AccountType.SAVINGS);
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);
        assertEquals(4, accountRepository.findAll().size());
    }
}
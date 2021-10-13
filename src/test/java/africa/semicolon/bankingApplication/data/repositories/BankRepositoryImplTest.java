package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankRepositoryImplTest {
    BankRepository bankRepository;
    @BeforeEach
    void setUp() {
        bankRepository = new BankRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Bank bank = new Bank();
        bank.setId("32567892");
        bank.setName("Bank Goodnews");
        assertEquals(bank, bankRepository.save(bank));
    }

    @Test
    void findByBankId() {
        Bank bank = new Bank();
        bank.setId("32567892");
        bank.setName("Bank Goodnews");
        Bank foundBank = bankRepository.save(bank);
        assertEquals(foundBank, bankRepository.findByBankId("32567892"));
    }

    @Test
    void delete() {
        Bank bank = new Bank();
        bank.setId("32567892");
        bank.setName("Bank Goodnews");
        bankRepository.save(bank);
        assertNotNull(bankRepository.findByBankId("32567892"));
        bankRepository.delete(bank);
        assertNull(bankRepository.findByBankId("32567892"));
    }

    @Test
    void testDelete() {
        Bank bank = new Bank();
        bank.setId("32567892");
        bank.setName("Bank Goodnews");
        bankRepository.save(bank);
        assertNotNull(bankRepository.findByBankId("32567892"));
        bankRepository.delete("32567892");
        assertNull(bankRepository.findByBankId("32567892"));
    }

    @Test
    void findAll() {
        Bank bank = new Bank();
        bank.setId("32567892");
        bank.setName("Bank Goodnews");
        bankRepository.save(bank);
        bankRepository.save(bank);
        bankRepository.save(bank);
        bankRepository.save(bank);
        assertEquals(4, bankRepository.findAll().size());
    }
}
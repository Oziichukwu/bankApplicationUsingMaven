package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvnRepositoryImplTest {
    BvnRepository bvnRepository;
    @BeforeEach
    void setUp() {

        bvnRepository = new BvnRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("32456785", customer);
        Bvn savedBvn = bvnRepository.save(bvn);
        assertEquals(bvn, savedBvn);
    }

    @Test
    void findByCustomerId() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("32456785", customer);
        Bvn savedBvn = bvnRepository.save(bvn);
        Bvn foundBvn = bvnRepository.findByCustomerId("32456785");
        assertEquals(savedBvn,foundBvn);
    }

    @Test
    void delete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("32456785", customer);
        Bvn savedBvn = bvnRepository.save(bvn);
        assertNotNull(bvnRepository.findByCustomerId("32456785"));
        bvnRepository.delete(bvn);
        assertNull(bvnRepository.findByCustomerId("32456785"));
    }

    @Test
    void testDelete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("32456785", customer);
        bvnRepository.save(bvn);
        assertNotNull(bvnRepository.findByCustomerId("32456785"));
        bvnRepository.delete("32456785");
        assertNull(bvnRepository.findByCustomerId("32456785"));
    }

    @Test
    void findAll() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("32456785", customer);
        bvnRepository.save(bvn);
        bvnRepository.save(bvn);
        bvnRepository.save(bvn);
        bvnRepository.save(bvn);
        bvnRepository.save(bvn);
        assertEquals(5, bvnRepository.findAll().size());
    }
}
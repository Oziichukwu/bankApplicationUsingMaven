package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerReposotoryImplTest {
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository = new CustomerReposotoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("388403245",customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("paul");
        customer.setLastName("phliip");
        Customer savedCustomer = customerRepository.save(customer);
        assertEquals(customer, savedCustomer);
    }

    @Test
    void findByCustomerId() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("388403245",customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("paul");
        customer.setLastName("phliip");
        Customer savedCustomer = customerRepository.save(customer);
        //customerRepository.findByCustomerId("388403245");
        Customer foundCustomer = customerRepository.findByCustomerId("388403245");
        assertEquals(savedCustomer, foundCustomer);
    }

    @Test
    void delete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("388403245",customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("paul");
        customer.setLastName("phliip");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findByCustomerId("388403245"));
        customerRepository.delete(customer);
        assertNull(customerRepository.findByCustomerId("388403245"));
    }

    @Test
    void testDelete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("388403245",customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("paul");
        customer.setLastName("phliip");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findByCustomerId("388403245"));
        customerRepository.delete("388403245");
        assertNull(customerRepository.findByCustomerId("388403245"));

    }

    @Test
    void findAll() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("388403245",customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("paul");
        customer.setLastName("phliip");
        customerRepository.save(customer);
        customerRepository.save(customer);
        customerRepository.save(customer);
        assertEquals(3,customerRepository.findAll().size());
    }
}
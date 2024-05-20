package x.mart.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import x.mart.Models.Customer;
import x.mart.Repositories.CustomerRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomerByQrCode(String qrCode) {
        return customerRepository.findById(qrCode).orElse(null);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        customer.setQrCode(UUID.randomUUID().toString());
        return customerRepository.save(customer);
    }

    public ResponseEntity<?> updateCustomer(String qrCode, Customer customer) {
        Customer existingCustomer = customerRepository.findById(qrCode).orElse(null);
        if (existingCustomer == null) {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
        existingCustomer.setName(customer.getName());
        existingCustomer.setWallet(customer.getWallet());
        return new ResponseEntity<>(customerRepository.save(existingCustomer), HttpStatus.OK);
    }

    public void deleteCustomer(String qrCode) {
        customerRepository.deleteById(qrCode);
    }
}

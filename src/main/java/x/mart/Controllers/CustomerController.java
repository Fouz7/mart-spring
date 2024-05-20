package x.mart.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import x.mart.Models.Customer;
import x.mart.Services.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/customers/{qrCode}")
    public ResponseEntity<?> getCustomerByQrCode(String qrCode) {
        return ResponseEntity.ok(customerService.findCustomerByQrCode(qrCode));
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/customers/{qrCode}")
    public ResponseEntity<?> updateCustomer(String qrCode, Customer customer) {
        return customerService.updateCustomer(qrCode, customer);
    }

    @DeleteMapping("/customers/{qrCode}")
    public ResponseEntity<?> deleteCustomer(String qrCode) {
        customerService.deleteCustomer(qrCode);
        return ResponseEntity.ok("Customer deleted");
    }

}

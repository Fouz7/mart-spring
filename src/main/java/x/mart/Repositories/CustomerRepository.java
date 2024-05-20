package x.mart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import x.mart.Models.Customer;

public interface CustomerRepository  extends  JpaRepository<Customer, String>{
}

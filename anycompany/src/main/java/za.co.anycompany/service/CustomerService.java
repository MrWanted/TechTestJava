package za.co.anycompany.service;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.anycompany.entity.Customer;

import java.util.Collection;

public interface CustomerService extends JpaRepository<Customer, Long> {
    Collection<Customer> findByNameAndSurname(String firstName, String lastName);

}

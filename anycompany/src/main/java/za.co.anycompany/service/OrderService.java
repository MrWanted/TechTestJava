package za.co.anycompany.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.anycompany.entity.Customer;
import za.co.anycompany.entity.CustomerOrder;

import java.util.Collection;

@Repository
public interface OrderService extends JpaRepository<CustomerOrder, Long> {
    CustomerOrder findByCustomer(Customer customer);

    Collection<CustomerOrder> findAllByCustomer(Customer customer);
}

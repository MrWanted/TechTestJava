
package za.co.anycompany.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.anycompany.entity.CustomerOrder;
import za.co.anycompany.service.CustomerService;
import za.co.anycompany.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/order/v1")
@Data
@Slf4j
public class OrderController {
    //Spring will automatically autowire final objects
    private final OrderService orderService;
    private final CustomerService customerService;

    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerOrder>> findAllOrders(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @PutMapping("/{customerId}")
    CustomerOrder update(@RequestBody CustomerOrder order, @PathVariable Long customerId){
       order.setCustomer(customerService.findById(customerId).orElse(null));
       log.info("this is my order, {}" , order);
        //TODO: set vat

        return orderService.save(order);
    }

    @GetMapping("/customer/orders/{customerId}")
    Iterable<CustomerOrder> findOrderByCustomerID(@PathVariable Long customerId){
        return orderService.findAllByCustomer(customerService.findById(customerId).orElse(null));
    }
}


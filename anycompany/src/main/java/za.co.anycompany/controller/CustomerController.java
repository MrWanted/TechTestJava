package za.co.anycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.anycompany.entity.Customer;
import za.co.anycompany.model.CustomerDTO;
import za.co.anycompany.model.CustomerOrderDTO;
import za.co.anycompany.service.CustomerService;
import za.co.anycompany.service.OrderService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/ping")
    public String greeting() {
        return "pong";
    }

    @PostMapping("/customer")
    Customer create(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/customer")
    Iterable<Customer> read() {
        return customerService.findAll();
    }

    @PutMapping("/customer")
    Customer update(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    void delete(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/customer/{id}")
    ResponseEntity findByid(@PathVariable Long id) {

        return new ResponseEntity(customerService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/customer/search")
    Iterable<Customer> findAll(@RequestParam(value = "first", required = false) String firstName,
                               @RequestParam(value = "first", required = false) String lastName) {
        if (firstName != null && lastName != null)
            return customerService.findByNameAndSurname(firstName, lastName);
        //TODO: to add other conditions

        return customerService.findAll();
    }

    @GetMapping("/findAllCustomersOrders")
    Collection<CustomerDTO> findAllCustomer() {

        return customerService.findAll().stream().map(
                customer ->
                        CustomerDTO.builder()
                                .name(customer.getName())
                                .surname(customer.getSurname())
                                .orders(orderService.findAllByCustomer(customer).stream()
                                        .map(customerOrder -> CustomerOrderDTO.builder()
                                                .amount(customerOrder.getAmount())
                                                .VAT(customerOrder.getVAT())
                                                .build()
                                        ).collect(Collectors.toList()))
                                .build()
       ).collect(Collectors.toList());
    }
}
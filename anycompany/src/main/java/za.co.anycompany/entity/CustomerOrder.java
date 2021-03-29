package za.co.anycompany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long orderId;
    private long amount;
    private long VAT;
    private String country;


    @ManyToOne
    private Customer customer;

    public CustomerOrder(long amount, long VAT){
        this.amount = amount;
        this.VAT = VAT;
    }
}

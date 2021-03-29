package za.co.anycompany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long customerId;
    private String name;
    private String surname;
    private String country;
    private Date dateOfBirth;

    public Customer(String firstName, String lastName) {
        this.name = firstName;
        this.surname = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', surname='%s']",
                customerId, name, surname);
    }
}

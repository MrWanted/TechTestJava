package za.co.anycompany.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class CustomerDTO {
    private String name, surname;
    private Collection<CustomerOrderDTO> orders;
}

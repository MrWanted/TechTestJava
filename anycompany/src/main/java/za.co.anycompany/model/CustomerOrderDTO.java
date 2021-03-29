package za.co.anycompany.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerOrderDTO {
    private long amount;
    private long VAT;
}

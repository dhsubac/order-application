package orderapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import orderapplication.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Integer menuId;
    private Integer price;
    private Integer qty;
    private Integer customerId;
}

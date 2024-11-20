package orderapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import orderapplication.domain.*;
import orderapplication.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryDecreased extends AbstractEvent {

    private Long id;
    private String menuId;
    private Integer qty;

    public InventoryDecreased(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryDecreased() {
        super();
    }
}
//>>> DDD / Domain Event

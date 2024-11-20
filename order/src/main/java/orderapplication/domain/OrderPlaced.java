package orderapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import orderapplication.domain.*;
import orderapplication.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private Integer menuId;
    private Integer price;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event

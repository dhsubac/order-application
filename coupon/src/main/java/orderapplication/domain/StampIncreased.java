package orderapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import orderapplication.domain.*;
import orderapplication.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StampIncreased extends AbstractEvent {

    private Long id;
    private String customerName;
    private Integer customerId;
    private Integer qty;

    public StampIncreased(Coupon aggregate) {
        super(aggregate);
    }

    public StampIncreased() {
        super();
    }
}
//>>> DDD / Domain Event

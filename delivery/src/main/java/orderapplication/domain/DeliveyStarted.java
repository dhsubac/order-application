package orderapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import orderapplication.domain.*;
import orderapplication.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveyStarted extends AbstractEvent {

    private Long id;
    private Integer tableId;

    public DeliveyStarted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveyStarted() {
        super();
    }
}
//>>> DDD / Domain Event

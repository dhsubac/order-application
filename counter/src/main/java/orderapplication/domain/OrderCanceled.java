package orderapplication.domain;

import java.util.*;
import lombok.*;
import orderapplication.domain.*;
import orderapplication.infra.AbstractEvent;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private Integer customerId;
    private Integer menuId;
    private Integer price;
    private Integer qty;
}

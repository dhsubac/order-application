package orderapplication.domain;

import java.util.*;
import lombok.*;
import orderapplication.domain.*;
import orderapplication.infra.AbstractEvent;

@Data
@ToString
public class InventoryDecreased extends AbstractEvent {

    private Long id;
    private String menuId;
    private Integer qty;
}

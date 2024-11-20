package orderapplication.domain;

import java.util.*;
import lombok.*;
import orderapplication.domain.*;
import orderapplication.infra.AbstractEvent;

@Data
@ToString
public class DeliveyStarted extends AbstractEvent {

    private Long id;
    private Integer tableId;
}

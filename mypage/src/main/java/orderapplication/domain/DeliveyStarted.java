package orderapplication.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import orderapplication.infra.AbstractEvent;

@Data
public class DeliveyStarted extends AbstractEvent {

    private Long id;
    private Integer tableId;
}

package orderapplication.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import orderapplication.config.kafka.KafkaProcessor;
import orderapplication.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InventoryDecreased'"
    )
    public void wheneverInventoryDecreased_PrepareDelivery(
        @Payload InventoryDecreased inventoryDecreased
    ) {
        InventoryDecreased event = inventoryDecreased;
        System.out.println(
            "\n\n##### listener PrepareDelivery : " +
            inventoryDecreased +
            "\n\n"
        );

        // Sample Logic //
        Delivery.prepareDelivery(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

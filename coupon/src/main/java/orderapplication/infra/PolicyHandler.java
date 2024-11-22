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
    CouponRepository couponRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveyStarted'"
    )
    public void wheneverDeliveyStarted_Stamp(
        @Payload DeliveyStarted deliveyStarted
    ) {
        DeliveyStarted event = deliveyStarted;
        System.out.println(
            "\n\n##### listener Stamp : " + deliveyStarted + "\n\n"
        );

        // Sample Logic //
        Coupon.stamp(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

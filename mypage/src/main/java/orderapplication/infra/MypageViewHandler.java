package orderapplication.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import orderapplication.config.kafka.KafkaProcessor;
import orderapplication.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MypageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setCustomerId(orderPlaced.getCustomerId());
            mypage.setId(orderPlaced.getId());
            mypage.setOrderStatus("주문됨");
            mypage.setStampqty(mypage.getStampqty() + 1);
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveyStarted_then_UPDATE_1(
        @Payload DeliveyStarted deliveyStarted
    ) {
        try {
            if (!deliveyStarted.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findById(
                deliveyStarted.getId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setOrderStatus("전달중");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}

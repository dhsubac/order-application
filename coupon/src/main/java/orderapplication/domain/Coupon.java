package orderapplication.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import orderapplication.CouponApplication;
import orderapplication.domain.StampIncreased;

@Entity
@Table(name = "Coupon_table")
@Data
//<<< DDD / Aggregate Root
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerName;

    private Integer customerId;

    private Integer stanpqty;

    @PostPersist
    public void onPostPersist() {
        StampIncreased stampIncreased = new StampIncreased(this);
        stampIncreased.publishAfterCommit();
    }

    public static CouponRepository repository() {
        CouponRepository couponRepository = CouponApplication.applicationContext.getBean(
            CouponRepository.class
        );
        return couponRepository;
    }

    //<<< Clean Arch / Port Method
    public static void stamp(DeliveyStarted deliveyStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Coupon coupon = new Coupon();
        repository().save(coupon);

        StampIncreased stampIncreased = new StampIncreased(coupon);
        stampIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveyStarted.get???()).ifPresent(coupon->{
            
            coupon // do something
            repository().save(coupon);

            StampIncreased stampIncreased = new StampIncreased(coupon);
            stampIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

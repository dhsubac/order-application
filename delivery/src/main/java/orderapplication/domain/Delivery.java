package orderapplication.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import orderapplication.DeliveryApplication;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer tableId;

    private String customerName;

    private Integer customerId;

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void prepareDelivery(InventoryDecreased inventoryDecreased) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveyStarted deliveyStarted = new DeliveyStarted(delivery);
        deliveyStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(inventoryDecreased.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveyStarted deliveyStarted = new DeliveyStarted(delivery);
            deliveyStarted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

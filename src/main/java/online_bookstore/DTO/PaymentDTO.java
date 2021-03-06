package online_bookstore.DTO;

import lombok.Data;
import online_bookstore.Entity.Member;
import online_bookstore.Entity.Orders;
import online_bookstore.Entity.Payment;

import javax.persistence.*;
import java.sql.Date;
@Data
public class PaymentDTO {

    private Long id;

    private Member member;

    private Orders orders;

    private String payment_status;

    private Date payment_time;

    private String payment_type;

    private long total_price;

    private long discount_price;

    private String book_name;

    public PaymentDTO(Payment payment) {
        this.id = payment.getId();
        this.member = payment.getMember();
        this.orders = payment.getOrders();
        this.payment_status = payment.getPayment_status();
        this.payment_time = payment.getPayment_time();
        this.payment_type = payment.getPayment_type();
        this.total_price = payment.getTotal_price();
        this.discount_price = payment.getDiscount_price();
    }

    public PaymentDTO() {

    }
}

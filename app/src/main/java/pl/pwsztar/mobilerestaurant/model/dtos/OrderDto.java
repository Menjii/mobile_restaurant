package pl.pwsztar.mobilerestaurant.model.dtos;

public class OrderDto {
    private Integer id;
    private OrderRateDto rate;
    private PaymentDto paymentData;
    private User client;
    private String realisationStatus;
    private String comments;

    public OrderDto(Integer id, User client, OrderRateDto rate, PaymentDto paymentData, String realisationStatus, String comments) {
        this.id = id;
        this.rate = rate;
        this.client = client;
        this.paymentData = paymentData;
        this.realisationStatus = realisationStatus;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public OrderRateDto getRate() {
        return rate;
    }

    public PaymentDto getPaymentData() {
        return paymentData;
    }

    public String getRealisationStatus() {
        return realisationStatus;
    }

    public String getComments() {
        return comments;
    }

    public User getClient() {
        return client;
    }
}

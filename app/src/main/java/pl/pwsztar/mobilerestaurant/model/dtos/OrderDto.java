package pl.pwsztar.mobilerestaurant.model.dtos;

public class OrderDto {
    private Integer id;
    private OrderRateDto rate;
    private PaymentDto paymentData;
    private User client;
    private WorkerDto worker = new WorkerDto(1);
    private String realizationStatus;
    private String comments;

    public OrderDto(Integer id, User client, OrderRateDto rate, PaymentDto paymentData, String realizationStatus, String comments) {
        this.id = id;
        this.rate = rate;
        this.client = client;
        this.paymentData = paymentData;
        this.realizationStatus = realizationStatus;
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

    public String getRealizationStatus() {
        return realizationStatus;
    }

    public String getComments() {
        return comments;
    }

    public User getClient() {
        return client;
    }
}

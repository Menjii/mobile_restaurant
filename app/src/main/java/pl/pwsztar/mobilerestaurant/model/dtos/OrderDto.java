package pl.pwsztar.mobilerestaurant.model.dtos;

public class OrderDto {
    private int id;
    private RateDto rate;
    private PaymentDto paymentData;
    private String realisationStatus;
    private String comments;

    public OrderDto(int id, RateDto rate, PaymentDto paymentData, String realisationStatus, String comments) {
        this.id = id;
        this.rate = rate;
        this.paymentData = paymentData;
        this.realisationStatus = realisationStatus;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public RateDto getRate() {
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
}

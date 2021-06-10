package pl.pwsztar.mobilerestaurant.model.dtos;

public class PaymentDto {
    private Integer id;
    private int amount;
    private String method;
    private String startData;
    private String paymentData;

    public PaymentDto(Integer id, int amount, String method, String startData, String paymentData) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.startData = startData;
        this.paymentData = paymentData;
    }

    public Integer getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStartData() {
        return startData;
    }

    public String getPaymentData() {
        return paymentData;
    }
}

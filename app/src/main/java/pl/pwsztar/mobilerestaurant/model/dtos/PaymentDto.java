package pl.pwsztar.mobilerestaurant.model.dtos;

public class PaymentDto {
    private int id;
    private int amount;
    private String method;
    private String startData;
    private String paymentData;

    public PaymentDto(int id, int amount, String method, String startData, String paymentData) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.startData = startData;
        this.paymentData = paymentData;
    }

    public int getId() {
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

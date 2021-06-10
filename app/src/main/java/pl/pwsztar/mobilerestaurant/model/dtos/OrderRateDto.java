package pl.pwsztar.mobilerestaurant.model.dtos;

public class OrderRateDto {
    private Integer id;
    private int points;
    private String comments;

    public OrderRateDto(Integer id, int points, String comments) {
        this.id = id;
        this.points = points;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

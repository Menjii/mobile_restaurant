package pl.pwsztar.mobilerestaurant.model.dtos;

public class WorkerDto {
    private int id;

    public WorkerDto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

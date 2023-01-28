package pl.camp.micro.car.rent.model;

public class Car {
    private String brand;
    private String model;
    private double price;
    private String plate;
    private int year;

    public Car(String brand, String model, double price, String plate, int year) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.plate = plate;
        this.year = year;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(brand)
                .append(" ")
                .append(model)
                .append(" ")
                .append("Cena: ")
                .append(price)
                .append(" zl ")
                .append("nr rejestracyjny: ")
                .append(plate)
                .append(" rok produkcji: ")
                .append(year)
                .toString();
    }
}

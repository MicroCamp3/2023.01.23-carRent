package pl.camp.micro.car.rent.database;

import pl.camp.micro.car.rent.model.Car;

import java.util.*;

public class CarRepository implements ICarRepository {
    private final List<Car> cars = new ArrayList<>();
    private final Set<String> rent = new HashSet<>();
    private static final CarRepository instance = new CarRepository();

    private CarRepository() {
        this.cars.add(new Car("Audi", "A5", 300.00, "KR11", 2005));
        this.cars.add(new Car("BMW", "3", 200.00, "KR22", 2009));
        this.cars.add(new Car("Toyota", "Corolla", 210.00, "KR33", 2018));
        this.cars.add(new Car("Kia", "Ceed", 180.00, "KR44", 2015));
    }

    @Override
    public List<Car> getCars() {
        return this.cars;
    }

    @Override
    public Set<String> getRent() {
        return this.rent;
    }

    @Override
    public boolean rentCar(String plate) {
        for(Car car : this.cars) {
            if(car.getPlate().equals(plate) && !this.rent.contains(plate)) {
                this.rent.add(plate);
                return true;
            }
        }

        return false;
    }

    public static CarRepository getInstance() {
        return instance;
    }
}

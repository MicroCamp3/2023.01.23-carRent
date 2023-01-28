package pl.camp.micro.car.rent.database;

import pl.camp.micro.car.rent.model.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarRepository2 implements ICarRepository {
    private final List<Car> cars = new ArrayList<>();
    private final Set<String> rent = new HashSet<>();
    private static final CarRepository2 instance = new CarRepository2();

    private CarRepository2() {
        this.cars.add(new Car("Audi", "A5", 300.00, "KR111", 2005));
        this.cars.add(new Car("BMW", "3", 200.00, "KR222", 2009));
        this.cars.add(new Car("Toyota", "Corolla", 210.00, "KR333", 2018));
        this.cars.add(new Car("Kia", "Ceed", 180.00, "KR444", 2015));
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

    public static CarRepository2 getInstance() {
        return instance;
    }
}

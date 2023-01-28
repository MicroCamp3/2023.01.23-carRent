package pl.camp.micro.car.rent.database;

import pl.camp.micro.car.rent.model.Car;

import java.util.List;
import java.util.Set;

public interface ICarRepository {
    List<Car> getCars();
    Set<String> getRent();
    boolean rentCar(String plate);
}

package pl.camp.micro.car.rent.database;

import pl.camp.micro.car.rent.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> getUserByLogin(String login);
}

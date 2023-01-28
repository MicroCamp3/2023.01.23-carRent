package pl.camp.micro.car.rent.database;

import pl.camp.micro.car.rent.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {

    private final List<User> users = new ArrayList<>();
    private static final UserRepository instance = new UserRepository();
    private UserRepository() {
        this.users.add(new User("admin", "150d9f58797c01aa0b50bbd539871335"));
        this.users.add(new User("janusz", "ebdcfabe8c3efb56e9cf31da0584e563"));
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    public static UserRepository getInstance() {
        return instance;
    }
}

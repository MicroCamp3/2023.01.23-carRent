package pl.camp.micro.car.rent.authentication;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.micro.car.rent.database.IUserRepository;
import pl.camp.micro.car.rent.database.UserRepository;
import pl.camp.micro.car.rent.model.User;

import java.util.Optional;

public class Authenticator implements IAuthenticator {

    private static final Authenticator instance = new Authenticator();
    private final IUserRepository userRepository = UserRepository.getInstance();
    public static final String seed = "m5yIJls3buFmtK1*nNB@MzM7e1h9q&";

    private Authenticator() {
    }

    public static Authenticator getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) {
        Optional<User> userFromDbBox = this.userRepository.getUserByLogin(login);
        return userFromDbBox.isPresent() &&
                userFromDbBox.get().getPassword()
                        .equals(DigestUtils.md5Hex(password+seed));
    }
}

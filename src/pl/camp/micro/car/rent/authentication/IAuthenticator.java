package pl.camp.micro.car.rent.authentication;

public interface IAuthenticator {
    boolean authenticate(String login, String password);
}

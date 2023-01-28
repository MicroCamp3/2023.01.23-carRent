package pl.camp.micro.car.rent;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.micro.car.rent.authentication.Authenticator;

public class Test {
    public static void main(String[] args) {
        String pass = "janusz" + Authenticator.seed;
        String hash = DigestUtils.md5Hex(pass);
        System.out.println(hash);
    }
}

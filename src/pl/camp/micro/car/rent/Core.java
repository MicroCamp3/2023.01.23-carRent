package pl.camp.micro.car.rent;

import pl.camp.micro.car.rent.authentication.Authenticator;
import pl.camp.micro.car.rent.authentication.IAuthenticator;
import pl.camp.micro.car.rent.database.*;
import pl.camp.micro.car.rent.gui.GUI;
import pl.camp.micro.car.rent.gui.IGUI;
import pl.camp.micro.car.rent.model.User;

import java.util.Optional;

public class Core {
    private final IGUI gui = GUI.getInstance();
    private final ICarRepository carRepository = CarRepository.getInstance();
    private final IAuthenticator authenticator = Authenticator.getInstance();
    private static final Core instance = new Core();

    private Core() {
    }

    public void start() {
        int loginCounter = 0;
        boolean run = false;
        while(!run && loginCounter < 3) {
            User user = gui.getLoginAndPassword();
            run = this.authenticator.authenticate(user.getLogin(), user.getPassword());
            loginCounter++;
        }

        while(run) {
            String choose = gui.showMenu();
            switch(choose) {
                case "1":
                    gui.listCars();
                    break;
                case "2":
                    gui.showRentResult(carRepository.rentCar(gui.getPlate()));
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    System.out.println("Incorrect choose !!");
                    break;
            }
        }
    }

    public static Core getInstance() {
        return instance;
    }
}

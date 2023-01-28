package pl.camp.micro.car.rent.gui;

import pl.camp.micro.car.rent.model.User;

public interface IGUI {
    String showMenu();
    void listCars();
    String getPlate();
    void showRentResult(boolean rentResult);
    User getLoginAndPassword();
}

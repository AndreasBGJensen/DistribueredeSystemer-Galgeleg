package Controller.UserController;

import brugerautorisation.Persistance.IValidate;
import brugerautorisation.BrugerOperations;

public class UserController {

    IValidate validation;

    public UserController(){
        validation = (IValidate) new BrugerOperations();
    }

    public boolean validate(String username, String password) {
        return validation.validate(username, password);
    }
}

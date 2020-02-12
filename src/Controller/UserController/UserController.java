package Controller.UserController;

import Persistance.IValidate;
import brugerautorisation.BrugerOperations;
import brugerautorisation.data.Bruger;

public class UserController {

IValidate validation;


public UserController(){
    validation = (IValidate) new BrugerOperations();
}


public boolean validate(String username, String password){

    Bruger bruger = validation.validate(username,password);

    if(bruger!=null){
        return true;
    }

    return false;


}

}

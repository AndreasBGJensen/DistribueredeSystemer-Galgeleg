package Persistance;

import brugerautorisation.data.Bruger;

public interface IValidate {


    public Bruger validate(String brugernavn, String kodeord);
}

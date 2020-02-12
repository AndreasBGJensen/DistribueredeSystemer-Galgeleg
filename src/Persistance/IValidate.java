package Persistance;

import brugerautorisation.data.Bruger;

public interface IValidate {
    boolean validate(String brugernavn, String kodeord);
}

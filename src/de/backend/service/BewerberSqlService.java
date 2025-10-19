package de.backend.service;

import de.backend.bewerber.CharakterBewerberpool;
import de.backend.datenbank.DatenBankSqlZugriff;

import java.util.List;

//Datenbank anbindung

public class BewerberSqlService {
    private DatenBankSqlZugriff datenbankInBewerberService;
    private List<CharakterBewerberpool> allesBewerber;



public BewerberSqlService(){
    datenbankInBewerberService= new DatenBankSqlZugriff();
    allesBewerber=datenbankInBewerberService.lesserDerBewerber();

}




    public List<CharakterBewerberpool> getAllesBewerber() {
        return allesBewerber;
    }
}

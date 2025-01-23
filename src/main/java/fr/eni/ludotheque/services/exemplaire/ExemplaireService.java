package fr.eni.ludotheque.services.exemplaire;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.services.ICrudService;
import java.util.List;

public interface ExemplaireService extends ICrudService<Exemplaire> {
    List<Exemplaire> getExemplairesById(int id);
}

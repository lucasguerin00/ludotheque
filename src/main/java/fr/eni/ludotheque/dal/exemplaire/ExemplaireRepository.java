package fr.eni.ludotheque.dal.exemplaire;

import java.util.List;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.dal.ICrudRepository;

public interface ExemplaireRepository extends ICrudRepository<Exemplaire> {
    List<Exemplaire> findByJeuId(int jeuId); // Récupérer les exemplaires d'un jeu spécifique
}

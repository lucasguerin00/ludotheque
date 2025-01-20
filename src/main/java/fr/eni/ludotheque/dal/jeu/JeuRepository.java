package fr.eni.ludotheque.dal.jeu;

import java.util.List;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.ICrudRepository;

public interface JeuRepository extends ICrudRepository<Jeu>  {
	List<Genre> getGenresByNoJeu(Integer noJeu);
}

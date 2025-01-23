package fr.eni.ludotheque.dal.security;



import java.util.Optional;

import fr.eni.ludotheque.bo.Utilisateur;

public interface UtilisateurRepository  {

	public Optional<Utilisateur> findUtilisateurByEmail(String email);
	
}

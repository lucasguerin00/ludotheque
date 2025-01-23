package fr.eni.ludotheque.services.security;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.dal.security.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

	@Override
	public Optional<Utilisateur> findUtilisateurByEmail(String email) {
		
		return utilisateurRepository.findUtilisateurByEmail(email);
	}

    
}

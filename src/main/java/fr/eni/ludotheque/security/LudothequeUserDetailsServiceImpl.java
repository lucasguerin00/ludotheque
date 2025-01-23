package fr.eni.ludotheque.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.services.security.UtilisateurService;

@Service
public class LudothequeUserDetailsServiceImpl implements UserDetailsService {

	private UtilisateurService utilisateurService;

	public LudothequeUserDetailsServiceImpl(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	/*
	 * Est appelée à chaque connexion utilisateur username : login saisi par
	 * l'utilisateur
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Utilisateur> utilOpt = utilisateurService.findUtilisateurByEmail(username);

		UserDetails user = null;

		if (utilOpt.isPresent()) {
			Utilisateur utilisateur = utilOpt.get();
			user = User.builder()
					.username(username)
					.password(utilisateur.getMotDePasse()) 
					.roles(utilisateur.getRole()).build();
			return user;
		}
		throw new UsernameNotFoundException(username + " not found.");
	}

}

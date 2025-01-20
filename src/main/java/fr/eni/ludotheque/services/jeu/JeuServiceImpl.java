package fr.eni.ludotheque.services.jeu;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.jeu.JeuRepository;
import fr.eni.ludotheque.exceptions.JeuNotFoundException;

@Service
public class JeuServiceImpl implements JeuService {

	private final JeuRepository jeuRepo;

	public JeuServiceImpl(JeuRepository jeuRepo) {
		super();
		this.jeuRepo = jeuRepo;
	}

	@Override
	public void add(Jeu jeu) {
		jeuRepo.add(jeu);
	}

	@Override
	public List<Jeu> getAll() {
		return jeuRepo.getAll();
	}

	@Override
	public Optional<Jeu> getById(int id) {
		return jeuRepo.getById(id);
	}

	@Override
	public void update(Jeu jeuToUpdate) {
		Optional<Jeu> jeuOpt = getById(jeuToUpdate.getId());
		if(jeuOpt.isPresent()) {
			jeuRepo.update(jeuToUpdate);
		}else {
			throw new JeuNotFoundException();
		}
	}

	@Override
	public void save(Jeu jeu) {
		if(jeu.getId()==null) {
			this.add(jeu);
			return;
		}
		this.update(jeu);
	}

	@Override
	public void delete(int id) {
		jeuRepo.delete(id);
	}
	
	
}

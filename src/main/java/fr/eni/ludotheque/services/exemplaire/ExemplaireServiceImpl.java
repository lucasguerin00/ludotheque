package fr.eni.ludotheque.services.exemplaire;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.dal.exemplaire.ExemplaireRepository;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {
    private final ExemplaireRepository exemplaireRepo;

    public ExemplaireServiceImpl(ExemplaireRepository exemplaireRepo) {
        this.exemplaireRepo = exemplaireRepo;
    }

    @Override
    public void add(Exemplaire exemplaire) {
        exemplaireRepo.add(exemplaire);
    }

    @Override
    public List<Exemplaire> getAll() {
        return exemplaireRepo.getAll();
    }

    @Override
    public Optional<Exemplaire> getById(int id) {
        return exemplaireRepo.getById(id);
    }

    @Override
    public void update(Exemplaire exemplaire) {
        exemplaireRepo.update(exemplaire);
    }

    @Override
    public void delete(int id) {
        exemplaireRepo.delete(id);
    }

    @Override
    public List<Exemplaire> getExemplairesById(int id) {
        return exemplaireRepo.findByJeuId(id);
    }
    
    @Override
	public void save(Exemplaire exemplaire) {
		if(exemplaire.getId()==null) {
			this.add(exemplaire);
			return;
		}
		this.update(exemplaire);
	}
}

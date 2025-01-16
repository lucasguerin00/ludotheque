package fr.eni.ludotheque.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.ludotheque.bo.Jeu;

@Repository
@Primary
public class JeuRepositoryJbcdImpl implements JeuRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	public JeuRepositoryJbcdImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void add(Jeu newJeu) {
		
		String sql = "insert into jeux (titre, reference, description, tarif_journee, agemin, duree)"
				+ "values (:titre, :reference, :description, :tarif, :ageMin, :duree)";
		namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(newJeu));
	}

	@Override
	public List<Jeu> getAll() {
		String sql = "select no_jeu, titre, reference, description, tarif_journee, agemin, duree"
				+ "from jeux";
		List<Jeu> jeux = namedParameterJdbcTemplate.query(sql,
				new BeanPropertyRowMapper<>(Jeu.class));
		
		return jeux;
	}

	@Override
	public Optional<Jeu> getById(int id) {
		String sql = "select no_jeu, titre, reference, description, tarif_journee, agemin, duree"
				+ " from jeux where no_jeu = ?";
		Jeu jeu = jdbcTemplate.queryForObject(sql,
				new BeanPropertyRowMapper<>(Jeu.class), id);
				
		return Optional.ofNullable(jeu);
	}

	@Override
	public void update(Jeu jeuToUpdate) {
		String sql = "update jeux set titre=:titre, reference=:reference, description=:description, tarif_journee=:tarif"
				+ "agemin=:ageMin, duree where no_jeu = :id";
		int nbRows = namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(jeuToUpdate));
		if(nbRows != 1) {
			throw new RuntimeException("La modification du jeu a échouée : " + jeuToUpdate);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from jeux  where no_jeu = ? ";
		int nbRows = jdbcTemplate.update(sql, id);
		if(nbRows != 1) {
			throw new RuntimeException("La suppression du jeu a échouée : id= " +id );
		}
		
	}
	
	
}

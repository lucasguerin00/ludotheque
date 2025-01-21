package fr.eni.ludotheque.dal.exemplaire;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import fr.eni.ludotheque.bo.Exemplaire;

@Repository
public class ExemplaireRepositoryJdbcImpl implements ExemplaireRepository {
    Logger logger = LoggerFactory.getLogger(ExemplaireRepositoryJdbcImpl.class);
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public ExemplaireRepositoryJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
    }

    @Override
    public void add(Exemplaire newExemplaire) {
        String sql = "INSERT INTO exemplaires (code_barre, louable, no_jeu) " +
                     "VALUES (:codeBarre, :louable, :jeu.id)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(newExemplaire), keyHolder);
    }

    @Override
    public List<Exemplaire> getAll() {
        String sql = "SELECT id, code_barre, louable, no_jeu AS jeu FROM exemplaires";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Exemplaire.class));
    }

    @Override
    public Optional<Exemplaire> getById(int id) {
        String sql = "SELECT id, code_barre, louable, no_jeu AS jeu FROM exemplaires WHERE id = ?";
        Exemplaire exemplaire = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Exemplaire.class), id);
        return Optional.ofNullable(exemplaire);
    }

    @Override
    public void update(Exemplaire exemplaire) {
        String sql = "UPDATE exemplaires SET code_barre = :codeBarre, louable = :louable, no_jeu = :jeu.id WHERE id = :id";
        int rows = namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(exemplaire));
        if (rows != 1) {
            throw new RuntimeException("Échec de la mise à jour de l'exemplaire : " + exemplaire);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM exemplaires WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Exemplaire> findByJeuId(int jeuId) {
        String sql = "SELECT id, code_barre, louable, no_jeu AS jeu FROM exemplaires WHERE no_jeu = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Exemplaire.class), jeuId);
    }
}

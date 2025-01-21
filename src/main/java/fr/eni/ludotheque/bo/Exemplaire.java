package fr.eni.ludotheque.bo;

import java.util.Objects;

public class Exemplaire {

    private Integer id; // Identifiant unique pour l'exemplaire
    private String codeBarre; // Code-barres de l'exemplaire
    private boolean louable; // Statut de louabilité
    private Jeu jeu; // Jeu associé à cet exemplaire

    public Exemplaire() {
    }

    public Exemplaire(Integer id, String codeBarre, boolean louable, Jeu jeu) {
        this.id = id;
        this.codeBarre = codeBarre;
        this.louable = louable;
        this.jeu = jeu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public boolean isLouable() {
        return louable;
    }

    public void setLouable(boolean louable) {
        this.louable = louable;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    @Override
    public String toString() {
        return "Exemplaire [id=" + id + ", codeBarre=" + codeBarre + ", louable=" + louable + ", jeu=" + jeu + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeBarre, louable, jeu);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exemplaire other = (Exemplaire) obj;
        return Objects.equals(id, other.id) &&
               Objects.equals(codeBarre, other.codeBarre) &&
               louable == other.louable &&
               Objects.equals(jeu, other.jeu);
    }
}

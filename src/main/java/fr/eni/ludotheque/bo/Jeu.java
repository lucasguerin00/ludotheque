package fr.eni.ludotheque.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class Jeu {
	
	private Integer id;
	
	@NotBlank
	private String titre;
	
	@NotBlank
	private String reference;
	
	private String decription;
	
	private int tarif;
	
	private int ageMin;
	
	private float duree;

	private List<Genre> genres;
	
	public Jeu() {
		genres = new ArrayList<>();
	}

	public Jeu(Integer id,String titre, String reference, String decription,
			int tarif, int ageMin, float duree, Genre... genres	) {
		super();
		this.id = id;
		this.titre = titre;
		this.reference = reference;
		this.decription = decription;
		this.tarif = tarif;
		this.ageMin = ageMin;
		this.duree = duree;
		for(Genre genre :genres) {
			this.genres.add(genre);
		}
	}

	public Jeu (String titre, String reference, String decription, int tarif, float duree) {
		super();
		this.titre = titre;
		this.reference = reference;
		this.decription = decription;
		this.tarif = tarif;
		this.duree = duree;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}

	public float getDuree() {
		return duree;
	}

	public void setDuree(float duree) {
		this.duree = duree;
	}

	public List<Genre> getGenres() {
		return genres;
	}
	
	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Jeu [id=" + id + ", titre=" + titre + ", reference=" + reference + ", decription=" + decription
				+ ", tarif=" + tarif + ", ageMin=" + ageMin + ", duree=" + duree + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ageMin, decription, duree, id, reference, tarif, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jeu other = (Jeu) obj;
		return ageMin == other.ageMin && Objects.equals(decription, other.decription)
				&& Float.floatToIntBits(duree) == Float.floatToIntBits(other.duree) && Objects.equals(id, other.id)
				&& reference == other.reference && tarif == other.tarif && Objects.equals(titre, other.titre);
	}
	
}

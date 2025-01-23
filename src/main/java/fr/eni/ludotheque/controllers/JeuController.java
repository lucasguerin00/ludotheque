package fr.eni.ludotheque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.services.exemplaire.ExemplaireService;
import fr.eni.ludotheque.services.jeu.JeuService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/jeux")
public class JeuController {

	private JeuService jeuService;
	private ExemplaireService exemplaireService;

    public JeuController(JeuService jeuService) {
        this.jeuService = jeuService;
    }

    /*
     * Afficher la liste des jeux 
     */
    @GetMapping
    public String afficherJeux(Model model) {
        List<Jeu> jeux = jeuService.getAll();
        model.addAttribute("jeux", jeux);
        model.addAttribute("body", "pages/jeux/jeux");
        return "index";
    }
    
    @GetMapping("/{id}")
    public String getJeuDetails(@PathVariable int id, Model model) {
        Jeu jeu = jeuService.getById(id).orElseThrow(() -> new RuntimeException("Jeu introuvable"));
        List<Exemplaire> exemplaires = exemplaireService.getExemplairesById(id);
        jeu.setExemplaires(exemplaires); // Ajoutez une liste d'exemplaires dans votre objet Jeu
        model.addAttribute("jeu", jeu);
        return "jeu";
    }


    @GetMapping("/{id}/afficher")
    public String pageAjouterJeu(@PathVariable("id") Integer id, Model model) {
    	
    	if (id == null) {
	        throw new RuntimeException("L'ID est manquant ou invalide.");
	    }
    	
    	Optional<Jeu> optJeu = jeuService.getById(id);
    	
    	if(optJeu.isEmpty()) {
    		throw new RuntimeException("Le jeu " + id +" n'a pas été trouvé. ");
    	}
        model.addAttribute("jeu", optJeu.get());
        model.addAttribute("body", "pages/jeux/jeu");
        return "index";
    }

    @GetMapping("/ajouter")
    public String pageAjouterJeu(Model model) {
        model.addAttribute("jeu", new Jeu());
        model.addAttribute("body", "pages/jeux/formulaire-jeu");
        return "index";
    }

    @PostMapping("/enregistrer")
    public String ajouterJeu(Model model, @Valid Jeu jeu,  BindingResult bindingResult ) {
    	model.addAttribute("body", "pages/jeux/formulaire-jeu");
    	if(bindingResult.hasErrors()) {
    		return "index";
    	}
        jeuService.save(jeu);
        return "redirect:/jeux";
    }

    @GetMapping("/modifier")
    public String getModifierJeu(Model model, @RequestParam("id") int id) {
        Optional<Jeu> jeuOpt = jeuService.getById(id);
        if (jeuOpt.isPresent()) {
            model.addAttribute("jeu", jeuOpt.get());
            model.addAttribute("body", "pages/jeux/formulaire-jeu");

        } else {
        	//TODO : gestion erreur
            model.addAttribute("body", "pages/jeux/jeux");
        }
        return "index";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerJeu(Model model, @PathVariable("id") int id) {
        jeuService.delete(id);
        model.addAttribute("body", "pages/jeux/formulaire-jeu");
        return "redirect:/jeux";
    }
}

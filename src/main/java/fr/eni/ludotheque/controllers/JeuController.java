package fr.eni.ludotheque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.services.jeu.JeuService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/jeux")
public class JeuController {

    private final JeuService jeuService;

    public JeuController(JeuService jeuService) {
        this.jeuService = jeuService;
    }

    /**
     * Afficher la liste des jeux
     */
    @GetMapping()
    public String jeux(Model model) {
        List<Jeu> jeux = jeuService.getAll();
        model.addAttribute("jeux", jeux);
        model.addAttribute("body", "pages/jeux/jeux");
        return "index";
    }

    @GetMapping("/ajouter")
    public String pageAjouterJeu(Model model) {
        model.addAttribute("jeu", new Jeu());
        model.addAttribute("body", "pages/jeux/formulaire-jeu");
        return "index";
    }

    @PostMapping("/enregistrer")
    public String ajouterJeu(Model model, 
            @Valid @ModelAttribute("jeu") Jeu jeu,
            BindingResult resultatValidation) {
        if (resultatValidation.hasErrors()) {
            model.addAttribute("body", "pages/jeux/formulaire-jeu");
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
            // TODO : gestion erreur
            model.addAttribute("body", "pages/jeux/jeux");
        }
        return "index";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerJeu(Model model, @PathVariable("id") int id) {
        jeuService.delete(id);
        return "redirect:/jeux";
    }
}

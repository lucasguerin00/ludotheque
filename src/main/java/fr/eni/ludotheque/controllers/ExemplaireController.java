package fr.eni.ludotheque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.services.exemplaire.ExemplaireService;

import java.util.List;

@Controller
@RequestMapping("/exemplaires")
public class ExemplaireController {

    private final ExemplaireService exemplaireService;

    public ExemplaireController(ExemplaireService exemplaireService) {
        this.exemplaireService = exemplaireService;
    }

    @GetMapping("/{jeuId}")
    public String listExemplaires(@PathVariable int id, Model model) {
        List<Exemplaire> exemplaires = exemplaireService.getExemplairesById(id);
        model.addAttribute("exemplaires", exemplaires);
        model.addAttribute("id", id);
        return "exemplaires/list";
    }

    @GetMapping("/add/{jeuId}")
    public String addForm(@PathVariable int id, Model model) {
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setId(id);
        model.addAttribute("exemplaire", exemplaire);
        return "exemplaires/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Exemplaire exemplaire) {
        exemplaireService.add(exemplaire);
        return "redirect:/jeux/" + exemplaire.getId();
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Exemplaire exemplaire = exemplaireService.getById(id).orElseThrow(() -> new RuntimeException("Exemplaire introuvable"));
        model.addAttribute("exemplaire", exemplaire);
        return "exemplaires/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Exemplaire exemplaire) {
        exemplaireService.update(exemplaire);
        return "redirect:/jeux/" + exemplaire.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Exemplaire exemplaire = exemplaireService.getById(id).orElseThrow(() -> new RuntimeException("Exemplaire introuvable"));
        id = exemplaire.getId();
        exemplaireService.delete(id);
        return "redirect:/jeux/" + id;
    }
}

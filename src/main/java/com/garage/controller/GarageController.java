package com.garage.controller;

import com.garage.entity.Voiture;
import com.garage.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GarageController {

    @Autowired
    private GarageService garageService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("voitures", garageService.getAllVoitures());
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalVoitures", garageService.getTotalVoitures());
        model.addAttribute("totalValeur", garageService.getTotalValeur());
        model.addAttribute("moyennePuissance", String.format("%.0f", garageService.getMoyennePuissance()));

        // Pass data for charts
        model.addAttribute("marquesStats", garageService.getPuissanceMoyenneParMarque());
        model.addAttribute("anneeStats", garageService.getValeurParAnnee());

        return "dashboard";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("voiture", new Voiture());
        return "add";
    }

    @PostMapping("/add")
    public String saveVoiture(@ModelAttribute Voiture voiture) {
        garageService.saveVoiture(voiture);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Voiture voiture = garageService.getVoitureById(id);
        if (voiture != null) {
            model.addAttribute("voiture", voiture);
            return "add"; // Reuse the add form
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteVoiture(@PathVariable Long id) {
        garageService.deleteVoiture(id);
        return "redirect:/";
    }
}

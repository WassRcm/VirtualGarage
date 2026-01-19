package com.garage.service;

import com.garage.entity.Voiture;
import com.garage.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GarageService {

    @Autowired
    private VoitureRepository voitureRepository;

    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    public Voiture getVoitureById(Long id) {
        return voitureRepository.findById(id).orElse(null);
    }

    public void saveVoiture(Voiture voiture) {
        voitureRepository.save(voiture);
    }

    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }

    public long getTotalVoitures() {
        return voitureRepository.count();
    }

    public long getTotalValeur() {
        return voitureRepository.findAll().stream()
                .mapToLong(Voiture::getPrixAchat)
                .sum();
    }

    public double getMoyennePuissance() {
        return voitureRepository.findAll().stream()
                .mapToInt(Voiture::getPuissance)
                .average()
                .orElse(0.0);
    }

    // Pour le graphique par marque
    public Map<String, Double> getPuissanceMoyenneParMarque() {
        return voitureRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Voiture::getMarque,
                        Collectors.averagingInt(Voiture::getPuissance)));
    }

    // Pour le graphique évolution prix (par année du modèle)
    public Map<Integer, Long> getValeurParAnnee() {
        return voitureRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Voiture::getAnnee,
                        Collectors.summingLong(Voiture::getPrixAchat)));
    }
}

# GarageVirtuel 🚗

Application Spring Boot de démonstration pour gérer une collection de voitures.
URL : https://virtualgarage.onrender.com/ (Pas toujours disponible)
Portfolio Project.

## 🛠 Stack Technique

- **Java 17**
- **Spring Boot 3.x** (Web, Data JPA, Thymeleaf)
- **H2 Database** (In-Memory)
- **Bootstrap 5** (UI)
- **Chart.js** (Dashboard Visualization)
- **Maven**

## 🚀 Démarrage Rapide

### Pré-requis
- Java 17 installé / Maven

### Lancer l'application
```bash
mvn spring-boot:run
```

Accédez à : `http://localhost:8080`

## 📱 Fonctionnalités

1. **Accueil** : Liste des voitures sous forme de cartes.
2. **Ajouter** : Formulaire pour enrichir votre collection.
3. **Dashboard** : Statistiques en temps réel et graphiques visuels.
   - Puissance moyenne par marque
   - Valeur de la collection par année modèle
4. **Suppression** : Retrait rapide d'un véhicule.

## 🐳 Docker

Construire l'image :
```bash
mvn clean package
docker build -t garage-virtuel .
```

Lancer le conteneur :
```bash
docker run -p 8080:8080 garage-virtuel
```

## 📸 Screenshots
Dans le futur...

# 🌍 Guide de Déploiement Gratuit (Spring Boot)

Pour déployer **GarageVirtuel** gratuitement sur internet, la meilleure option actuelle est **Render** (ou Koyeb), car ils supportent Docker nativement.

## Pré-requis
1. Votre projet doit être sur GitHub (C'est fait ✅).
2. Votre `Dockerfile` doit être capable de construire le projet (Je viens de le mettre à jour pour ça ✅).

## Option Recommandée : Render.com

**Render** offre un plan gratuit pour les services Web (Docker).
*Note : Le serveur se met en veille après 15min d'inactivité (démarrage lent au prochain accès).*

### Étapes :
1. Créez un compte sur [dashboard.render.com](https://dashboard.render.com/).
2. Cliquez sur **New +** -> **Web Service**.
3. Choisissez **Build and deploy from a Git repository**.
4. Connectez votre compte GitHub et sélectionnez `VirtualGarage`.
5. Configuration :
   - **Name** : `garage-virtuel-demo` (ou ce que vous voulez)
   - **Region** : Frankfurt (plus proche)
   - **Branch** : `main`
   - **Runtime** : **Docker** (Très important !)
   - **Instance Type** : **Free**
6. Cliquez sur **Create Web Service**.

Render va lire le `Dockerfile`, télécharger Maven, compiler le projet et lancer l'application. Cela prendra environ 3-5 minutes la première fois.

## Autres Options

- **Koyeb** : Similaire à Render, souvent plus rapide, pas de mise en veille sur le plan gratuit (selon disponibilités).
- **Fly.io** : Nécessite d'installer une ligne de commande (`flyctl`). Plus technique.

## ⚠️ Important (Base de données)
Actuellement, votre projet utilise **H2 (In-Memory)**.
- Cela signifie que **à chaque redémarrage** (ou déploiement), **toutes les voitures créées seront effacées**.
- Pour une vraie persistance, il faudrait connecter une base de données externe (PostgreSQL), disponible gratuitement sur Render (90 jours) ou Supabase.

Pour une démo portfolio, H2 est généralement suffisant !

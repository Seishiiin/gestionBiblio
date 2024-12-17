# Documentation du Projet Bibliothèque

## 1. **Arborescence du Projet**

```
ProjetBibliotheque/
|-- src/
|   |-- Adherents.java
|   |-- Livres.java
|   |-- Emprunts.java
|   |-- Bibliotheque.java
|   |-- Main.java
|   |-- JeuEssai.java
|-- README.md
|-- ProjetBibliotheque.iml
|-- .idea/
|-- out/ (dossier de compilation)
```

### **Détails des Fichiers**
1. **Adherents.java** : Classe représentant les adhérents.
2. **Livres.java** : Classe représentant les livres.
3. **Emprunts.java** : Classe représentant les emprunts.
4. **Bibliotheque.java** : Classe principale qui gère les livres, adhérents et emprunts.
5. **Main.java** : Point d'entrée du programme avec le menu interactif.
6. **JeuEssai.java** : Fournit des données initiales pour tester le programme.

---

## 2. **Description des Classes**

### **Adherents.java**
- **Attributs** :
    - `String nom` : Nom de l'adhérent.
    - `String prenom` : Prénom de l'adhérent.
    - `String adresse` : Adresse de l'adhérent.
    - `String telephone` : Numéro de téléphone.
    - `String email` : Email de l'adhérent.
- **Méthodes** :
    - Constructeur : Initialise tous les attributs.
    - Getters/Setters : Permettent l'accès et la modification des attributs.
    - `toString()` : Affiche les informations de l'adhérent.

---

### **Livres.java**
- **Attributs** :
    - `String titre` : Titre du livre.
    - `String auteur` : Auteur du livre.
    - `String isbn` : ISBN unique du livre.
    - `int annee` : Année de publication.
    - `boolean emprunte` : Statut d'emprunt (vrai si emprunté).
- **Méthodes** :
    - Constructeur : Initialise les attributs.
    - Getters : Accès aux attributs.
    - `setEmprunte(boolean)` : Change le statut d'emprunt.
    - `toString()` : Affiche les informations du livre.

---

### **Emprunts.java**
- **Attributs** :
    - `String dateEmprunt` : Date à laquelle le livre est emprunté.
    - `String dateRetour` : Date de retour prévue.
    - `Livres livre` : Référence au livre emprunté.
    - `Adherents adherent` : Référence à l'adhérent qui emprunte le livre.
- **Méthodes** :
    - Constructeur : Initialise les attributs.
    - Getters/Setters : Accès et modification des attributs.
    - `isEnCours()` : Retourne `true` si la dateRetour est vide (emprunt en cours).
    - `toString()` : Affiche les informations de l'emprunt.

---

### **Bibliotheque.java**
- **Attributs** :
    - `ArrayList<Livres> listeLivres` : Liste des livres.
    - `ArrayList<Adherents> listeAdherents` : Liste des adhérents.
    - `ArrayList<Emprunts> listeEmprunts` : Liste des emprunts.
- **Méthodes** :
    - `ajouterLivre(Livres livre)` : Ajoute un livre à la bibliothèque.
    - `ajouterAdherent(Adherents adherent)` : Ajoute un adhérent.
    - `ajouterEmprunt(Emprunts emprunt)` : Ajoute un emprunt.
    - `searchLivreByIsbn(String isbn)` : Recherche un livre par son ISBN.
    - `searchAdherentByNom(String nom)` : Recherche un adhérent par son nom.
    - `getLivres()` : Affiche la liste des livres.
    - `getAdherents()` : Affiche la liste des adhérents.
    - `getEmprunts()` : Affiche la liste des emprunts.

---

### **Main.java**
- **Fonction principale `main()`** :
    - Initialise la bibliothèque.
    - Affiche un menu interactif pour gérer les actions :
        - Ajouter un livre.
        - Ajouter un adhérent.
        - Afficher les livres.
        - Afficher les adhérents.
        - Afficher les emprunts.
        - Ajouter un emprunt.
    - Utilise la classe `Scanner` pour capturer les entrées utilisateur.
- **Fonctions spécifiques** :
    - `ajouterLivre(Bibliotheque b, Scanner sc)` : Ajoute un livre via la console.
    - `ajouterAdherent(Bibliotheque b, Scanner sc)` : Ajoute un adhérent via la console.
    - `ajouterEmprunt(Bibliotheque b, Scanner sc)` : Gère l'ajout d'un emprunt en validant les données.

---

### **JeuEssai.java**
- **Objectif** : Charger un jeu d'essai avec des données réalistes pour tester le programme.
- **Méthode principale** :
    - `chargerJeuEssai(Bibliotheque bibliotheque)` :
        - Ajoute des livres célèbres.
        - Ajoute des adhérents réalistes.
        - Crée quelques emprunts avec des validations sur les livres disponibles.

---

## 3. **Fonctionnement Général**
1. **Initialisation** :
    - `Bibliotheque` est initialisée.
    - Le jeu d'essai peut être chargé via `JeuEssai.chargerJeuEssai(bibliotheque)`.
2. **Menu Principal** :
    - L'utilisateur peut effectuer des actions telles que l'ajout de livres, adhérents ou emprunts.
    - Les actions sont interactives et capturées via la console.
3. **Gestion des Emprunts** :
    - Un livre est marqué comme emprunté (`emprunte = true`) lorsqu'il est ajouté dans un emprunt.
    - Les emprunts en cours sont identifiés via la méthode `isEnCours()`.

---

## 4. **Exemple de Test Console**

```
|---------- MENU ----------|
| 1. Ajouter un livre      |
| 2. Ajouter un adherent   |
| 3. Afficher livres       |
| 4. Afficher adherents    |
| 5. Afficher emprunts     |
| 6. Ajouter un emprunt    |
| 8. Quitter               |
|--------------------------|
| Votre choix : 3

Livres{titre='Harry Potter à l'école des sorciers', auteur='J.K. Rowling', isbn='978-2070643028', annee=1997, emprunte=true}
Livres{titre='Le Seigneur des anneaux', auteur='J.R.R. Tolkien', isbn='978-2266182690', annee=1954, emprunte=false}
Livres{titre='1984', auteur='George Orwell', isbn='978-0451524935', annee=1949, emprunte=true}
Livres{titre='Fahrenheit 451', auteur='Ray Bradbury', isbn='978-2070368227', annee=1953, emprunte=false}
Livres{titre='Le Petit Prince', auteur='Antoine de Saint-Exupéry', isbn='978-0156012195', annee=1943, emprunte=false}
Livres{titre='Les Misérables', auteur='Victor Hugo', isbn='978-2070406709', annee=1862, emprunte=false}
...
```

---

## 5. **Résumé des Variables Importantes**
| **Classe**     | **Variable**     | **Type**               | **Description**      |
|----------------|------------------|------------------------|----------------------|
| `Adherents`    | `nom`            | `String`               | Nom de l'adhérent    |
| `Adherents`    | `prenom`         | `String`               | Prénom de l'adhérent |
| `Livres`       | `titre`          | `String`               | Titre du livre       |
| `Livres`       | `isbn`           | `String`               | ISBN unique du livre |
| `Emprunts`     | `dateEmprunt`    | `String`               | Date d'emprunt       |
| `Bibliotheque` | `listeLivres`    | `ArrayList<Livres>`    | Liste des livres     |
| `Bibliotheque` | `listeAdherents` | `ArrayList<Adherents>` | Liste des adhérents  |
| `Bibliotheque` | `listeEmprunts`  | `ArrayList<Emprunts>`  | Liste des emprunts   |

---

## 6. **Conclusion**
Ce projet est une implémentation simple d'un système de gestion de bibliothèque en Java, avec des fonctionnalités basiques, mais extensibles. Il est structuré de manière modulaire pour faciliter la maintenance et l'ajout de nouvelles fonctionnalités dans le futur.

---

## 7. **Évolutions Possibles**
- Gestion des dates avec une bibliothèque comme `java.time`.
- Enregistrement et chargement des données depuis un fichier.
- Interface graphique avec JavaFX.
- Gestion des emprunts en retard.

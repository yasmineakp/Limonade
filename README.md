# Limonade 🍋

Petite application Android faite avec **Kotlin** et **Jetpack Compose** dans Android Studio.
C'est un exercice pour apprendre à associer un comportement à un clic.

## Description

Pour faire de la limonade, il faut suivre 4 étapes. On appuie sur l'image pour passer à l'étape suivante :

| Étape | Image | Texte affiché |
|---|---|---|
| 1 | Citronnier | Tap the lemon tree to select a lemon |
| 2 | Citron | Keep tapping the lemon to squeeze it |
| 3 | Verre de limonade | Tap the lemonade to drink it |
| 4 | Verre vide | Tap the empty glass to start again |

## Fonctionnement

- Au lancement, on voit le citronnier.
- Quand on appuie sur le citronnier, un nombre est tiré au hasard entre **2 et 4**. C'est le nombre de fois qu'il faut presser le citron.
- On appuie sur le citron autant de fois que ce nombre, puis la limonade apparaît.
- On appuie sur la limonade pour la boire, ça affiche le verre vide.
- On appuie sur le verre vide et on revient au début.

## Ce que j'ai utilisé

- Kotlin
- Jetpack Compose
- `remember` et `mutableStateOf` pour retenir l'étape en cours
- `when` pour choisir l'image et le texte selon l'étape
- `Modifier.clickable` pour rendre l'image cliquable
- `(2..4).random()` pour le nombre de pressions aléatoire

## Lancer le projet

1. Cloner le dépôt : `git clone https://github.com/yasmineakp/limonade.git`
2. Ouvrir le dossier dans Android Studio.
3. Attendre la fin du Gradle Sync.
4. Choisir un émulateur ou un téléphone, puis cliquer sur **Run** (triangle vert).

## Structure

- `app/src/main/java/com/example/limonade/MainActivity.kt` : tout le code de l'application
- `app/src/main/res/drawable/` : les 4 images
- `app/src/main/res/values/strings.xml` : les textes

## Auteur

Yasmine (GitHub : yasmineakp), étudiante en informatique.

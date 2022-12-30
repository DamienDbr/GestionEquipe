package evenements;

import acteurs.Joueur;
import acteurs.Gardien;
import acteurs.Equipe;

public class Matchs {

	public static void main(String[] args) {
		Joueur robin = new Joueur("Robin",0,0,0,"milieu",91,90,89,73,70,71);
		Joueur thiago = new Joueur("Thiago",0,0,0,"attaquant",89,80,87,90,75,75);
		Gardien marceau = new Gardien("Marceau",0,0,0,"gardien",50,55,64,70,68,69,85,86,78);
		Gardien azdine = new Gardien("Azdine",0,0,0,"gardien",50,55,64,70,68,69,85,80,80);
		Gardien victor = new Gardien("Victor",0,0,0,"gardien",50,55,64,70,68,69,80,81,65);
		Joueur alexis = new Joueur("Alexis",0,0,0,"attaquant",91,70,82,80,83,65);
		Joueur theoB = new Joueur("TheoB",0,0,0,"attaquant",93,70,89,85,80,63);
		Joueur theoM = new Joueur("TheoM",0,0,0,"milieu",80,70,81,92,88,84);
		Joueur camilo = new Joueur("Camilo",0,0,0,"defenseur",60,75,55,60,93,95);
		Joueur martin = new Joueur("Martin",0,0,0,"defenseur",60,70,60,75,83,85);
		Joueur lucas = new Joueur("Lucas",0,0,0,"defenseur",58,73,75,85,87,90);
		Joueur ismael = new Joueur("Ismael",0,0,0,"defenseur",80,83,80,87,86,95);
		Joueur mathis = new Joueur("Mathis",0,0,0,"defenseur",60,70,70,71,69,70);
		Joueur damien = new Joueur("Damien",0,0,0,"milieu",82,90,84,91,83,80);
		Joueur aron = new Joueur("Aron",0,0,0,"milieu",75,85,82,78,79,84);
		Joueur ilyas = new Joueur("Ilyas",0,0,0,"milieu",96,85,78,65,80,60);
		
		
		
		
		
		Equipe selecao = new Equipe("Selecao");
		selecao.ajouterJoueurDansListeJoueur(robin);
		selecao.ajouterJoueurDansListeJoueur(thiago);
		selecao.ajouterGardienDansListeGardien(victor);
		selecao.ajouterGardienDansListeGardien(marceau);
		selecao.ajouterGardienDansListeGardien(azdine);
		selecao.ajouterJoueurDansListeJoueur(theoM);
		selecao.ajouterJoueurDansListeJoueur(theoB);
		selecao.ajouterJoueurDansListeJoueur(alexis);
		selecao.ajouterJoueurDansListeJoueur(camilo);
		selecao.ajouterJoueurDansListeJoueur(martin);
		selecao.ajouterJoueurDansListeJoueur(lucas);
		selecao.ajouterJoueurDansListeJoueur(ismael);
		selecao.ajouterJoueurDansListeJoueur(mathis);
		selecao.ajouterJoueurDansListeJoueur(damien);
		selecao.ajouterJoueurDansListeJoueur(aron);
		selecao.ajouterJoueurDansListeJoueur(ilyas);
		
		selecao.assertDeTousLesJoueurs();
		selecao.assertDeTousLesGardiens();
		
		
		selecao.creerEquipeTitulaire();
		selecao.afficherEquipeTitulaire();
		
		
		
		
		
		
	}

}

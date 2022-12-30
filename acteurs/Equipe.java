package acteurs;


public class Equipe {
	
	private String nomEquipe;
	
	//Liste de joueurs (def + milieu + attaquant)
	private int nbJoueursDansLaListeJoueur = 0;
	private int nbJoueursMaxDansLaListeJoueur = 50;
	public Joueur[] listeJoueur = new Joueur[nbJoueursMaxDansLaListeJoueur];
	
	//Liste de Gardiens
	private int nbGardiensDansLaListeGardien = 0;
	private int nbGardiensMaxDansLaListeGardien = 50;
	public Gardien[] listeGardien = new Gardien[nbGardiensMaxDansLaListeGardien];
	
	//Equipe Titulaire : liste de noms de joueur
	//Formation : 1-3-3-1 (foot à 8)
	//Indice 0 : gardien
	//Indice 1,2,3 : defenseurs
	//Indice 4,5,6 : milieu
	//Indice 5,6,7 : attaquants
	public int nombreJoueurFootA8 = 8;
	public String[] equipeTitulaire = new String[nombreJoueurFootA8];
	
	//Choisir le gardien
	public int statsGardienTitu;
	public String nomGardienTitu;
	
	//Choisir les defenseurs
	public int statsDef1;
	public int statsDef2;
	public int statsDef3;
	public int statsDefPotentiel;
	public String nomDef1;
	public String nomDef2;
	public String nomDef3;
	public String nomDefPotentiel;
	
	//Choisir les milieux
	public int statsMil1;
	public int statsMil2;
	public int statsMil3;
	public int statsMilPotentiel;
	public String nomMil1;
	public String nomMil2;
	public String nomMil3;
	public String nomMilPotentiel;
	
	
	//Choisir l'attaquant
	public int statsAttaquantTitu;
	public String nomAttaquantTitu;
	
	
	
	//Constructeur
	public Equipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	
	public void ajouterJoueurDansListeJoueur(Joueur joueur) {
		if(joueur.getPoste()=="gardien") {
			System.out.println("Un gardien ne peut se trouver dans la liste des joueurs.");
		}
		else {
			if(nbJoueursDansLaListeJoueur<nbJoueursMaxDansLaListeJoueur) {
				listeJoueur[nbJoueursDansLaListeJoueur] = joueur;
				nbJoueursDansLaListeJoueur+=1;
			}
		}
	}
	
	public void afficherListeJoueur() {
		System.out.println("Voici tous les joueurs dans la liste de l'équipe : ");
		for(int i=0;i<nbJoueursDansLaListeJoueur;i++) {
			System.out.println(listeJoueur[i].getNom());
		}
	}
	
	public void ajouterGardienDansListeGardien(Gardien gardien) {
		if(nbGardiensDansLaListeGardien<nbGardiensMaxDansLaListeGardien) {
			listeGardien[nbGardiensDansLaListeGardien] = gardien;
			nbGardiensDansLaListeGardien+=1;
		}
	}
	
	public void afficherListeGardien() {
		System.out.println("Voici tous les gardiens dans la liste de Gardien de l'équipe : ");
		for(int i=0;i<nbGardiensDansLaListeGardien;i++) {
			System.out.println(listeGardien[i].getNom());
		}
	}
	public void remplirDeRemplacant() {
		for(int i=0;i<8;i++) {
			equipeTitulaire[i] = "remplacant";
		}
	}
	
	public void gardienEquipeTitulaire() {
		for(int i=0;i<nbGardiensDansLaListeGardien;i++) {
			if(equipeTitulaire[0]=="remplacant") {
				nomGardienTitu = listeGardien[i].getNom();
				equipeTitulaire[0]=nomGardienTitu;
				statsGardienTitu = listeGardien[i].getStatArret()+listeGardien[i].getStatPlongeon()+listeGardien[i].getStatReflexe();
			}
			else {
				int statsGardienTituPotentiel = listeGardien[i].getStatArret()+listeGardien[i].getStatPlongeon()+listeGardien[i].getStatReflexe();
				if(statsGardienTitu<statsGardienTituPotentiel) {
					statsGardienTitu = statsGardienTituPotentiel;
					nomGardienTitu = listeGardien[i].getNom();
					equipeTitulaire[0] = nomGardienTitu;
					
				}
			}
		}
		
	}
	public void attaquantEquipeTitulaire() {
		for(int i=0;i<nbJoueursDansLaListeJoueur;i++) {
			if(listeJoueur[i].getPoste() == "attaquant") {
				if(equipeTitulaire[7]=="remplacant") {
					nomAttaquantTitu = listeJoueur[i].getNom();
					equipeTitulaire[7]=nomAttaquantTitu;
					statsAttaquantTitu = listeJoueur[i].getStatTir() + listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatDrible() + (listeJoueur[i].getStatPhysique()/2)+(listeJoueur[i].getStatPasse()/2)+(listeJoueur[i].getStatDefense()/3);
				}
				else {
					int statsAttaquantTituPotentiel = listeJoueur[i].getStatTir() + listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatDrible() + (listeJoueur[i].getStatPhysique()/2)+(listeJoueur[i].getStatPasse()/2)+(listeJoueur[i].getStatDefense()/3);
					if(statsAttaquantTitu<statsAttaquantTituPotentiel) {
						statsAttaquantTitu = statsAttaquantTituPotentiel;
						nomAttaquantTitu = listeJoueur[i].getNom();
						equipeTitulaire[7] = nomAttaquantTitu;
						
					}
				}
			}
		}
		
	}
	public void defenseursEquiepeTitulaire() {
		for(int i=0;i<nbJoueursDansLaListeJoueur;i++) {
			if(listeJoueur[i].getPoste()=="defenseur") {
				if((equipeTitulaire[1]=="remplacant") &&(equipeTitulaire[2]=="remplacant")&&(equipeTitulaire[1]=="remplacant")) {
					nomDef1 = listeJoueur[i].getNom();
					statsDef1 = (listeJoueur[i].getStatTir()/3)+listeJoueur[i].getStatPasse()+(listeJoueur[i].getStatDrible()/3) +listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatPhysique()+listeJoueur[i].getStatDefense();
					equipeTitulaire[1] = nomDef1;
				}
				else if((equipeTitulaire[1]!="remplacant") &&(equipeTitulaire[2]=="remplacant")&&(equipeTitulaire[1]=="remplacant")){
					nomDef2 = listeJoueur[i].getNom();
					statsDef2 = (listeJoueur[i].getStatTir()/3)+listeJoueur[i].getStatPasse()+(listeJoueur[i].getStatDrible()/3) +listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatPhysique()+listeJoueur[i].getStatDefense();
					if(statsDef2>statsDef1) {
						String nomTemp = nomDef1;
						int statsTemp = statsDef1;
						nomDef1 = nomDef2;
						statsDef1 = statsDef2;
						nomDef2 = nomTemp;
						statsDef2 = statsTemp;
						equipeTitulaire[1]=nomDef1;
						equipeTitulaire[2]=nomDef2;
					}
					else {
						equipeTitulaire[2]=nomDef2;
					}
				}
				else if((equipeTitulaire[1]!="remplacant") &&(equipeTitulaire[2]!="remplacant")&&(equipeTitulaire[1]=="remplacant")) {
					nomDef3 = listeJoueur[i].getNom();
					statsDef3 = (listeJoueur[i].getStatTir()/3)+listeJoueur[i].getStatPasse()+(listeJoueur[i].getStatDrible()/3) +listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatPhysique()+listeJoueur[i].getStatDefense();
					if(statsDef3>statsDef1) {
						String nomTemp1 = nomDef1;
						int statsTemp1 = statsDef1;
						nomDef1 = nomDef3;
						statsDef1 = statsDef3;
						String nomTemp2 = nomDef2;
						int statsTemp2 = statsDef2;
						nomDef2 = nomTemp1;
						statsDef2 = statsTemp1;
						nomDef3 = nomTemp2;
						statsDef3 = statsTemp2;
						equipeTitulaire[1]=nomDef1;
						equipeTitulaire[2]=nomDef2;
						equipeTitulaire[3]=nomDef3;
					}
					else if(statsDef3>statsDef2) {
						String nomTemp = nomDef2;
						int statsTemp = statsDef2;
						nomDef2 = nomDef3;
						statsDef2 = statsDef3;
						nomDef3 = nomTemp;
						statsDef3 = statsTemp;
						equipeTitulaire[2]=nomDef2;
						equipeTitulaire[3]=nomDef3;
					}
					else {
						equipeTitulaire[3]=nomDef3;
						
					}
					
				}
				else {
					nomDefPotentiel = listeJoueur[i].getNom();
					statsDefPotentiel = (listeJoueur[i].getStatTir()/3)+listeJoueur[i].getStatPasse()+(listeJoueur[i].getStatDrible()/3) +listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatPhysique()+listeJoueur[i].getStatDefense();
					if(statsDefPotentiel>statsDef1) {
						String nomTemp1 = nomDef1;
						int statsTemp1 = statsDef1;
						nomDef1 = nomDefPotentiel;
						statsDef1 = statsDefPotentiel;
						String nomTemp2 = nomDef2;
						int statsTemp2 = statsDef2;
						nomDef2 = nomTemp1;
						statsDef2 = statsTemp1;
						nomDef3 = nomTemp2;
						statsDef3 = statsTemp2;
						equipeTitulaire[1]=nomDef1;
						equipeTitulaire[2]=nomDef2;
						equipeTitulaire[3]=nomDef3;
						
					}
					else if(statsDefPotentiel>statsDef2) {
						String nomTemp = nomDef2;
						int statsTemp = statsDef2;
						nomDef2 = nomDefPotentiel;
						statsDef2 = statsDefPotentiel;
						nomDef3 = nomTemp;
						statsDef3 = statsTemp;
						equipeTitulaire[2]=nomDef2;
						equipeTitulaire[3]=nomDef3;
					}
					else if(statsDefPotentiel>statsDef3) {
						nomDef3 = nomDefPotentiel;
						statsDef3 = statsDefPotentiel;
						equipeTitulaire[3]=nomDefPotentiel;
						
					}
						
				}
			}
		}
	}
	public void milieuxEquiepeTitulaire() {
		for(int i=0;i<nbJoueursDansLaListeJoueur;i++) {
			if(listeJoueur[i].getPoste()=="milieu") {
				if((equipeTitulaire[4]=="remplacant") &&(equipeTitulaire[5]=="remplacant")&&(equipeTitulaire[6]=="remplacant")) {
					nomMil1 = listeJoueur[i].getNom();
					statsMil1 = listeJoueur[i].getStatTir()+listeJoueur[i].getStatPasse()+listeJoueur[i].getStatDrible() +listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatPhysique()+listeJoueur[i].getStatDefense();
					equipeTitulaire[4] = nomMil1;
				}
				else if((equipeTitulaire[4]!="remplacant") &&(equipeTitulaire[5]=="remplacant")&&(equipeTitulaire[6]=="remplacant")){
					nomMil2 = listeJoueur[i].getNom();
					statsMil2 = listeJoueur[i].getStatTir()+listeJoueur[i].getStatPasse()+listeJoueur[i].getStatDrible() +listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatPhysique()+listeJoueur[i].getStatDefense();
					if(statsMil2>statsMil1) {
						String nomTemp = nomMil1;
						int statsTemp = statsMil1;
						nomMil1 = nomMil2;
						statsMil1 = statsMil2;
						nomMil2 = nomTemp;
						statsMil2 = statsTemp;
						equipeTitulaire[4]=nomMil1;
						equipeTitulaire[5]=nomMil2;
					}
					else {
						equipeTitulaire[5]=nomMil2;
					}
				}
				else if((equipeTitulaire[4]!="remplacant") &&(equipeTitulaire[5]!="remplacant")&&(equipeTitulaire[6]=="remplacant")) {
					nomMil3 = listeJoueur[i].getNom();
					statsMil3 = listeJoueur[i].getStatTir()+listeJoueur[i].getStatPasse()+listeJoueur[i].getStatDrible() +listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatPhysique()+listeJoueur[i].getStatDefense();
					if(statsMil3>statsMil1) {
						String nomTemp1 = nomMil1;
						int statsTemp1 = statsMil1;
						nomMil1 = nomMil3;
						statsMil1 = statsMil3;
						String nomTemp2 = nomMil2;
						int statsTemp2 = statsMil2;
						nomMil2 = nomTemp1;
						statsMil2 = statsTemp1;
						nomMil3 = nomTemp2;
						statsMil3 = statsTemp2;
						equipeTitulaire[4]=nomMil1;
						equipeTitulaire[5]=nomMil2;
						equipeTitulaire[6]=nomMil3;
					}
					else if(statsMil3>statsMil2) {
						String nomTemp = nomMil2;
						int statsTemp = statsMil2;
						nomMil2 = nomMil3;
						statsMil2 = statsMil3;
						nomMil3 = nomTemp;
						statsMil3 = statsTemp;
						equipeTitulaire[5]=nomMil2;
						equipeTitulaire[6]=nomMil3;
					}
					else {
						equipeTitulaire[6]=nomMil3;
						
					}
					
				}
				else {
					nomMilPotentiel = listeJoueur[i].getNom();
					statsMilPotentiel = listeJoueur[i].getStatTir()+listeJoueur[i].getStatPasse()+listeJoueur[i].getStatDrible() +listeJoueur[i].getStatVitesse() +listeJoueur[i].getStatPhysique()+listeJoueur[i].getStatDefense();
					if(statsMilPotentiel>statsMil1) {
						String nomTemp1 = nomMil1;
						int statsTemp1 = statsMil1;
						nomMil1 = nomMilPotentiel;
						statsMil1 = statsMilPotentiel;
						String nomTemp2 = nomMil2;
						int statsTemp2 = statsMil2;
						nomMil2 = nomTemp1;
						statsMil2 = statsTemp1;
						nomMil3 = nomTemp2;
						statsMil3 = statsTemp2;
						equipeTitulaire[4]=nomMil1;
						equipeTitulaire[5]=nomMil2;
						equipeTitulaire[6]=nomMil3;
						
					}
					else if(statsMilPotentiel>statsMil2) {
						String nomTemp = nomMil2;
						int statsTemp = statsMil2;
						nomMil2 = nomMilPotentiel;
						statsMil2 = statsMilPotentiel;
						nomMil3 = nomTemp;
						statsMil3 = statsTemp;
						equipeTitulaire[5]=nomMil2;
						equipeTitulaire[6]=nomMil3;
					}
					else if(statsMilPotentiel>statsMil3) {
						nomMil3 = nomMilPotentiel;
						statsMil3 = statsMilPotentiel;
						equipeTitulaire[6]=nomMilPotentiel;
						
					}
						
				}
			}
		}
	}
	public void creerEquipeTitulaire() {
		remplirDeRemplacant();
		gardienEquipeTitulaire();
		defenseursEquiepeTitulaire();
		milieuxEquiepeTitulaire();
		attaquantEquipeTitulaire();
		
	}
	public void afficherEquipeTitulaire() {
		System.out.println("Voici la composition de l'équipe titulaire : ");
		System.out.println();
		System.out.println("        "+equipeTitulaire[0]+"        ");
		System.out.println();
		System.out.println(equipeTitulaire[2]+" - "+equipeTitulaire[1]+" - "+equipeTitulaire[3]);
		System.out.println();
		System.out.println(equipeTitulaire[5]+" - "+equipeTitulaire[4]+" - "+equipeTitulaire[6]);
		System.out.println();
		System.out.println("        "+equipeTitulaire[7]+"        ");
		
	}
	
	public void methodeAsserts(Joueur joueur) {
		assert joueur.testValiditeStats(): "Une des stats de "+joueur.getNom()+" est supérieure à 99";
		assert joueur.testValiditeStats2():"Une des stats de "+joueur.getNom()+" est inférieure à 0";
		assert joueur.testValiditePoste():"Le poste de "+joueur.getNom()+" est incorrect : Essayez gardien/defenseur/milieu/attaquant";
	}
	public void assertDeTousLesJoueurs() {
		for(int i=0;i<nbJoueursDansLaListeJoueur;i++) {
			methodeAsserts(listeJoueur[i]);
		}
	}
	public void assertDeTousLesGardiens() {
		for(int i=0;i<nbGardiensDansLaListeGardien;i++) {
			methodeAsserts(listeGardien[i]);
		}
	}
	
}

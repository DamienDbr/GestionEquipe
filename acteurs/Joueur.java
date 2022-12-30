package acteurs;

public class Joueur {
	private String nom;
	private int nombreMatchs = 0;
	private int nombreButs = 0;
	private int nombrePasseDes = 0;
	private String poste;
	private int statTir;
	private int statPasse;
	private int statDrible;
	private int statVitesse;
	private int statPhysique;
	private int statDefense;
	
	
	
	
	public Joueur(String nom, int nombreMatchs,int nombreButs, int nombrePasseDes, String poste, int statTir, int statPasse, int statDrible, int statVitesse, int statPhysique, int statDefense) {
		this.nom = nom;
		this.nombreMatchs = nombreMatchs;
		this.nombreButs = nombreButs;
		this.nombrePasseDes = nombrePasseDes;
		this.poste = poste;
		this.statTir = statTir;
		this.statPasse = statPasse;
		this.statDrible = statDrible;
		this.statVitesse = statVitesse;
		this.statPhysique = statPhysique;
		this.statDefense = statDefense;
		
				
	}
	public String getNom() {
		return nom;
	}
	
	public int getNombreMatchs() {
		return nombreMatchs;
	}
	public int getNombreButs() {
		return nombreButs;
	}
	public int getNombrePasseDes() {
		return nombrePasseDes;
	}
	public String getPoste() {
		return poste;
	}
	public int getStatTir() {
		return statTir;
	}
	public int getStatPasse() {
		return statPasse;
	}
	public int getStatDrible() {
		return statDrible;
	}
	public int getStatVitesse() {
		return statVitesse;
	}
	public int getStatPhysique() {
		return statPhysique;
	}
	public int getStatDefense() {
		return statDefense;
	}
	public boolean testValiditeStats() {
		if((statTir<100)&&(statVitesse<100)&&(statDrible<100)&&(statPhysique<100)&&(statDefense<100)&&statPasse<100) {
			return true;
		}
		else {
			return false;
		}
					
	}
	public boolean testValiditeStats2() {
		if((statTir>=0)&&(statVitesse>=0)&&(statDrible>=0)&&(statPhysique>=0)&&(statDefense>=0)&&(statPasse>=0)&&(nombrePasseDes>=0)&&(nombreButs>=0)&&(nombreMatchs>=0)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean testValiditePoste() {
		if((poste=="attaquant")||(poste=="milieu")||(poste=="defenseur")||(poste=="gardien")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int noteGlobaleJoueur() {
		int somme = statTir +statPasse +statDrible +statPhysique +statVitesse+ statDefense;
		return somme/6;
		
	}
	public void marquerUnBut() {
		nombreButs += 1;
		if(statTir<99) {
			statTir +=1;
		}
	}
	public void faireUnePasseDes() {
		nombrePasseDes += 1;
		if(statPasse<99) {
			statPasse+=1;
		}
	}
	
	

}

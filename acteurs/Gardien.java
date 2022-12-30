package acteurs;

public class Gardien extends Joueur{
	private int statReflexe;
	private int statPlongeon;
	private int statArret;
	public Gardien(String nom, int nombreMatchs,int nombreButs, int nombrePasseDes, String poste, int statTir, int statPasse, int statDrible, int statVitesse, int statPhysique, int statDefense,int statReflexe,int statPlongeon, int statArret) {
		super(nom,nombreMatchs,nombreButs,nombrePasseDes,poste,statTir,statPasse,statDrible,statVitesse,statPhysique,statDefense);
		this.statReflexe = statReflexe;
		this.statPlongeon = statPlongeon;
		this.statArret = statArret;
	}
	public int getStatArret() {
		return statArret;
	}
	public int getStatReflexe() {
		return statReflexe;
	}
	public int getStatPlongeon() {
		return statPlongeon;
	}

}

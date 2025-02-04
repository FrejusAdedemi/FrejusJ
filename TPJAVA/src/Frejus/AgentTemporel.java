package Frejus;

public abstract class AgentTemporel {
	protected String nom;
	private int niveauExperience;
	private int anneeRecrutement;
	
	public AgentTemporel(String nom,int niveauExperience,int anneeRecrutement) {
		this.nom=nom;
		this.niveauExperience=niveauExperience;
		this.anneeRecrutement=anneeRecrutement;
	}
	
	
	void executerMission(Anomalie anomalie) {}
	
	@Override
    public String toString() {
        return nom + " (Exp: " + niveauExperience + ", Recruté en " + anneeRecrutement + ")";
    }
}

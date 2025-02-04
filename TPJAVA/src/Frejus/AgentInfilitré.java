package Frejus;

public class AgentInfilitré extends AgentTemporel implements ExpertEnDiscretion {

	public AgentInfilitré(String nom, int niveauExperience, int anneeRecrutement) {
		super(nom, niveauExperience, anneeRecrutement);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void executerMission(Anomalie anomalie) {
        System.out.println(nom + " infiltre l'époque et agit discrètement.");
        anomalie.changerStatut("En cours de résolution");
    }

    @Override
    public void seFondreDansLeDécor() {
        System.out.println(nom + " se fond dans le passé sans être détecté.");
    }

}

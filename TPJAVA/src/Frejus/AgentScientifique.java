package Frejus;

public class AgentScientifique extends AgentTemporel {
	
	public AgentScientifique(String nom, int niveauExperience, int anneeRecrutement) {
		super(nom, niveauExperience, anneeRecrutement);
	}

	@Override
    public void executerMission(Anomalie anomalie) {
        System.out.println(nom + " analyse l'anomalie et réduit son impact.");
        anomalie.changerStatut("En cours de résolution");
    }
}

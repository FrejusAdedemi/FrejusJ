package Frejus;

public class AgentTechnologique extends AgentTemporel implements HackeurTemporel{

	public AgentTechnologique(String nom, int niveauExperience, int anneeRecrutement) {
		super(nom, niveauExperience, anneeRecrutement);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void executerMission(Anomalie anomalie) {
		System.out.println(nom + " utilise la technologie pour corriger l'anomalie.");
        anomalie.changerStatut("Résolue");
		
	}
	@Override
	public void piraterSysteme(String cible) {
		System.out.println(nom + " pirate le système temporel de " + cible + ".");
	}

}

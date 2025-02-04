package Frejus;

public class Main {

	public static void main(String[] args) {
		AgentScientifique agent1=new AgentScientifique("Dr. Fred", 10, 2015);
		AgentInfilitré agent2=new AgentInfilitré("Tony", 8, 2017);
		AgentTechnologique agent3=new AgentTechnologique("Dr. Frejus", 12, 2013);
		
		Anomalie anomalie1 = new Anomalie("Un roi médiéval a un smartphone", 1200, "Élevé");
        Anomalie anomalie2 = new Anomalie("Un astronaute romain a été aperçu", 50, "Moyen");

        Mission mission1 = new Mission("Corriger l'anomalie du Moyen Âge", anomalie1, agent1);
        Mission mission2 = new Mission("Éliminer l'astronaute romain", anomalie2, agent2);
        
        mission1.lancer();
        mission2.lancer();
        
        agent2.seFondreDansLeDécor();
        agent3.piraterSysteme("google-server");
	}
}

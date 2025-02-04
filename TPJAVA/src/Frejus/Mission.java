package Frejus;

public class Mission {
	private String titre;
	private Anomalie anomalie;
	private AgentTemporel agent;
	
	public Mission(String titre,Anomalie anomalie,AgentTemporel agent) {
		this.titre=titre;
		this.anomalie=anomalie;
		this.agent=agent;
	}
	
	public void lancer() {
		System.out.println("Mission: " + titre + " assignée à " + agent);
        agent.executerMission(anomalie);
	}
}

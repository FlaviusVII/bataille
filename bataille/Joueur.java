package bataille;

import java.util.ArrayList;

public class Joueur {
	private ArrayList<Carte> main = new ArrayList<Carte>();
	private int points;
	private String prenom;
	
	public Joueur(String prenom){
		this.prenom = prenom;
		this.points = 0;
	}
	public void addNewCard(Carte carte){
		this.main.add(carte);
		}
	public Carte playCard(int index){
		Carte carte = this.main.get(index);
		this.main.remove(index);
		return carte;
	}
	public void addPoint(){
		this.points++;
	}
	public int getPoint(){
		return this.points;
	}
	public ArrayList<Carte> getMain(){
		return this.main;
	}
	public String getPrenom(){
		return this.prenom;
	}
}

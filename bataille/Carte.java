package bataille;

public class Carte {
	private String couleur;
	private int valeur;
	
	public Carte(String couleur, int valeur){
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	public boolean isSuperiorTo(Carte carte){
		boolean response = false;
		if(this.valeur < carte.valeur)
			response = false;
		if(this.valeur > carte.valeur)
			response = true;
		
		return response;
	}
	public int getValeur(){
		return this.valeur;
	}
	public String getCouleur(){
		return this.couleur;
	}
}

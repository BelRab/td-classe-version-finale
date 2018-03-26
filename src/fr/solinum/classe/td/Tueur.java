package fr.solinum.classe.td;
import java.lang.Comparable;

public class Tueur {

	private String nom;
	private int age;
	private Tueur contrat;
	
	//constructeur
	
	public Tueur(String nom,int age){
		this.nom=nom;
		this.age=age;
	}
	public void setContrat(Tueur contrat) {
		this.contrat=contrat;
	}
	public Tueur getContrat() {
		return this.contrat;
	}
	public String getNom() {
		return this.nom;
	}
	public int getAge() {
		return this.age;
	}
	public void afficheContrat(Tueur tueur) {
		
		//si le tueur n'existe pas
		// si il existe une seule tueur
		//else
		Tueur tueurContrat = tueur;
		
		while(tueurContrat.contrat!=tueur) {
			System.out.println("Le contrat de tueur "+tueurContrat.nom+" est "+tueurContrat.contrat.nom);
			tueurContrat=tueurContrat.contrat;
		}
		System.out.println("Le contrat de tueur "+tueurContrat.nom+" est "+tueurContrat.contrat.nom);
	}
	public String afficher(){
		return "Le nom de tueur est :"+this.nom+" son age est :"+this.age+" son contrat est :"+this.contrat.nom;
	}
	public boolean comaparable(Tueur tueur1,Tueur tueur2) {
		if(tueur1.nom.equals(tueur2.nom)&&tueur1.age==tueur2.age) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

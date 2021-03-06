package fr.iutvalence.java.tp2014.g2c.binome5.labyrinthe.metier;
import java.util.Scanner;

import fr.iutvalence.java.tp2014.g2c.binome5.labyrinthe.console.Application;
import fr.iutvalence.java.tp2014.g2c.binome5.labyrinthe.typecase.Case;
import fr.iutvalence.java.tp2014.g2c.binome5.labyrinthe.typecase.CaseMur;
import fr.iutvalence.java.tp2014.g2c.binome5.labyrinthe.typecase.CaseNulleException;

/**
*
* OLIVIER Etienne - BERTRAND Hugo
* version 2.0
*/
public class Jeu {

    /** variable contenant l'instance du plateau d'un tour de jeu */
    public static Plateau plateau;
    /** variable contenant les coordonn�es du jeoueur */
    public final Coordonnees joueur;
    /** variable contenant le sens de d�placement du tour en cours*/
    public SensDeplacement[] deplacement;
    
    /**
     *  1. 
     *  cr�e un nouveau plateau de dimension par d�faut
     *  place le joueur sur la premi�re case */
    public Jeu(int dimension) {
        plateau = new Plateau(dimension);
        joueur = plateau.depart();
    }
    
    /** demande le mouvement au clavier au joueur*/
	 private SensDeplacement demanderMouvement() {
	    	System.out.println("Saisissez un mouvement :");
	    	Scanner sc = new Scanner(System.in);
	    	String str = sc.nextLine();
	    	return Mouvement.mouvementEnCoordonnees(str);
	 }

    /** affiche le plateau et demande un d�placement au joueur */
    public void jouer() {
    		this.plateau.afficher();
    		while ((this.plateau.arrivee().i!=this.plateau.posJoueur().i)||(this.plateau.arrivee().j!=this.plateau.posJoueur().j)) {
    			/* Demander le mouvement. */
    			/* Appliquer le mouvement. */
    			try {
    					this.appliquerMouvement(demanderMouvement());
    				} 
    			catch (CaseNulleException e)
    				{
    					System.out.println("Attention tu sors");
    				}
    			/* Afficher Plateau. */
    			this.plateau.afficher();
    		}
    		System.out.println("Bravo, Essaye �a maintenant");
    	
	}
   
    /** 0
	 * 	Initialise la dimension � la valeur par d�faut, soit 10
	 */
	public void initialiserDimension(){
		plateau.dimension=Application.DEFAULT_SIZE;
	}
	
	/** 3
	 * 	Incr�mente la dimension du plateau d'une valeur pass�e en param�tre
	 */
	public void incrementerDimension(int augmentation){
		plateau.dimension=plateau.dimension+augmentation;
	}
	/** applique aux coordonn�es du joueur les coordonn�es du d�placements saisi
	 * 	teste la sortie de tablau et le d�placement sur case mur*/
	public static void appliquerMouvement(SensDeplacement deplacement2) throws CaseNulleException {
		Coordonnees coordonneeCiblee = new Coordonnees(deplacement2.x()+Jeu.plateau.posJoueur().i,deplacement2.y()+Jeu.plateau.posJoueur().j);
		if(((coordonneeCiblee.i<0)||(coordonneeCiblee.j<0))||((coordonneeCiblee.i>=Jeu.plateau.dimension)||(coordonneeCiblee.j>=Jeu.plateau.dimension)))
			throw new CaseNulleException();
		Case caseCiblee = Jeu.plateau.recupererCase(coordonneeCiblee);
		if(!(caseCiblee instanceof CaseMur)) 
		Jeu.plateau.rafraichirPlateau(coordonneeCiblee);	
		else System.out.println("non");
	}	
}


package fr.iutvalence.java.tp2014.g2c.binome5.labyrinthe.typecase;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
*
* OLIVIER Etienne - BERTRAND Hugo
* version 2.0
*/
public class CaseMur implements Case {
	
	public JButton BoutonMur;
	
	public JButton afficherBouton(){
	    BoutonMur = new JButton(new ImageIcon("fr.iutvalence.java.tp2014.g2c.binome5.labyrinthe.images/mur.png"));
	    return BoutonMur;
	}
	
	@Override
	public String afficher() {
		return "#";
	}
	
    @Override
    public String toString() {
    	return afficher();
    }
}

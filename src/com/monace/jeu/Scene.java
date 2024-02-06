package com.monace.jeu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.monace.objets.Tuyau;

public class Scene extends JPanel{
//Création des variables
	private ImageIcon iconBandeFond;
	private Image imgBandeFond;
	
	//Les instances pour le tuyau
	public Tuyau tuyauHauteur1;
	public Tuyau tuyauBas1;
	public Tuyau tuyauHauteur2;
	public Tuyau tuyauBas2;
	public Tuyau tuyauHauteur3;
	public Tuyau tuyauBas3;
	
	
	private final int LARGEUR_BANDE_FOND = 140;
	private final int DISTANCE_TUYAUX = 250;
	private final int ECART_TUYAUX = 120;
	
	public int xFond;
	private int dxTuyaux;// le deplacement des tuyaux
	private int xTuyaux; // gère la position des tuyaux sur l'écran
	
	//Constructeur, le constructeur porte toujours le nom de la classe
	public Scene() {
		super();
		
		this.iconBandeFond = new ImageIcon (getClass().getResource("/images/bandeFondEcran.png"));
		this.imgBandeFond = this.iconBandeFond.getImage();
		this.xFond = 0;
		this.xTuyaux = 100;
		this.dxTuyaux = 0;
		
		this.tuyauHauteur1 = new Tuyau(this.xTuyaux, -150, "/images/tuyauHaut.png");
		this.tuyauBas1 = new Tuyau(this.xTuyaux, 250, "/images/tuyauBas.png");
		
		
		this.tuyauHauteur2 = new Tuyau(this.xTuyaux + this.tuyauBas1.getLargeur() + this.ECART_TUYAUX, -150, "/images/tuyauHaut.png");
		this.tuyauBas2 = new Tuyau(this.xTuyaux + this.tuyauHauteur1.getLargeur() + this.ECART_TUYAUX, 250, "/images/tuyauBas.png");
		
		this.tuyauHauteur3 = new Tuyau(this.xTuyaux + (this.tuyauBas1.getLargeur() + this.ECART_TUYAUX *2), -150, "/images/tuyauHaut.png");
		this.tuyauBas3 = new Tuyau(this.xTuyaux + (this.tuyauBas1.getLargeur() + this.ECART_TUYAUX *2), 250, "/images/tuyauBas.png");
		
		
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();//Nous permet de demarer le jeu.
	}
	
	
	public void deplacementFond(Graphics g) {
		if(this.xFond == -this.LARGEUR_BANDE_FOND) {this.xFond = 0;}
		g.drawImage(this.imgBandeFond, this.xFond, 0, null);
		g.drawImage(this.imgBandeFond, this.xFond + this.LARGEUR_BANDE_FOND, 0, null);
		g.drawImage(this.imgBandeFond, this.xFond + this.LARGEUR_BANDE_FOND * 2, 0, null);
		g.drawImage(this.imgBandeFond, this.xFond + this.LARGEUR_BANDE_FOND * 3, 0, null);
		
		
	}
	
	//Ajout des composant pour dessiner à l'écran
	public void paintComponent(Graphics g) {
		this.deplacementFond(g);
}
	
	
}

package com.monace.jeu;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

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
	private Random hasard;//pour que la position des tuyaux apparaissent de façon aléatoires 
	
	
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
		this.tuyauHauteur2 = new Tuyau(this.xTuyaux  + this.DISTANCE_TUYAUX, -100, "/images/tuyauHaut.png");
		this.tuyauBas2 = new Tuyau(this.xTuyaux  + this.DISTANCE_TUYAUX, 300, "/images/tuyauBas.png");
		this.tuyauHauteur3 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX *2, -120, "/images/tuyauHaut.png");
		this.tuyauBas3 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX *2, 280, "/images/tuyauBas.png");
		
		hasard = new Random();
		
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
	
	
	private void deplacementTuyaux(Graphics g){
		//Tuyau 1
	    this.tuyauHauteur1.setX(this.tuyauHauteur1.getX() - 1);
		this.tuyauBas1.setX(this.tuyauHauteur1.getX());
		
		if(this.tuyauHauteur1.getX() == -100){
	    	this.tuyauHauteur1.setX(this.tuyauHauteur3.getX() + this.DISTANCE_TUYAUX);
	    	this.tuyauHauteur1.setY(-100 - 10 * this.hasard.nextInt(18));
	    	this.tuyauBas1.setY(this.tuyauHauteur1.getY() + this.tuyauHauteur1.getHauteur() + this.ECART_TUYAUX);
	    }		
		g.drawImage(this.tuyauHauteur1.getImgTuyau(), this.tuyauHauteur1.getX(), this.tuyauHauteur1.getY(), null);
		g.drawImage(this.tuyauBas1.getImgTuyau(), this.tuyauBas1.getX(), this.tuyauBas1.getY(), null);
		
		
		//Tuyau 2
		this.tuyauHauteur2.setX(this.tuyauHauteur2.getX() - 1);
		this.tuyauBas2.setX(this.tuyauHauteur2.getX());
		
		if(this.tuyauHauteur2.getX() == -100) {
			this.tuyauHauteur2.setX(this.tuyauHauteur1.getX() + this.DISTANCE_TUYAUX);
			this.tuyauHauteur2.setY(-100 - 10 * this.hasard.nextInt(18));
			this.tuyauBas2.setY(this.tuyauHauteur2.getY() + this.tuyauHauteur2.getHauteur() + this.ECART_TUYAUX);
		}
		
		g.drawImage(this.tuyauHauteur2.getImgTuyau(), this.tuyauHauteur2.getX(), this.tuyauHauteur2.getY(), null);
		g.drawImage(this.tuyauBas2.getImgTuyau(), this.tuyauBas2.getX(), this.tuyauBas2.getY(), null);
		
	
		//Tuyau 3
		this.tuyauHauteur3.setX(this.tuyauHauteur3.getX() - 1);
		this.tuyauBas3.setX(this.tuyauHauteur3.getX());
		
		if(this.tuyauHauteur3.getX() == -100) {
			this.tuyauHauteur3.setX(this.tuyauHauteur2.getX() + this.DISTANCE_TUYAUX);
			this.tuyauHauteur3.setY(-100 - 10 * this.hasard.nextInt(18));
			this.tuyauBas3.setY(this.tuyauHauteur3.getY() + this.tuyauHauteur3.getHauteur() + this.ECART_TUYAUX);
		}
		
		g.drawImage(this.tuyauHauteur3.getImgTuyau(), this.tuyauHauteur3.getX(), this.tuyauHauteur3.getY(), null);
		g.drawImage(this.tuyauBas3.getImgTuyau(), this.tuyauBas3.getX(), this.tuyauBas3.getY(), null);
		

	}
	
	//Ajout des composant pour le deffilement de l'écran
	public void paintComponent(Graphics g) {
		this.deplacementFond(g);
		this.deplacementTuyaux(g);
}
	
	
}

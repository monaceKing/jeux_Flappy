package com.monace.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tuyau {
	//Varaibles
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private String strImage; //Permet didentifier si on à un tuyau haut ou bas
	private ImageIcon iconTuyau;
	private Image imgTuyau;
	
	
	//Constructeur
	
	public Tuyau(int x, int y, String strImage) {
		this.hauteur = 50;
		this.hauteur = 300;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		
		this.iconTuyau = new ImageIcon(getClass().getResource(strImage));
		this.imgTuyau = this.iconTuyau.getImage();
	}

	//Implementation des Getter et Setter

	public int getX() {return x;}

	public int getY() {return y;}


	public int getLargeur() {return largeur;}


	public int getHauteur() {return hauteur;}


	public Image getImgTuyau() {return imgTuyau;}

	
	public void setX(int x) {this.x = x;}
	
	public void setY(int y) {this.y = y;}
	
	
}

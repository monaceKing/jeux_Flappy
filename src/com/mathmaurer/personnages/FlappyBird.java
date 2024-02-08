package com.mathmaurer.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FlappyBird {

	// Variable
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private int dy;
	private String strImage;
	private ImageIcon icoOiseau;
	private Image imgOiseau;

	// Constructeur

	public FlappyBird(int x, int y, String srtImage) {
		this.largeur = 34;
		this.hauteur = 24;
		this.x = x;
		this.y = y;
		this.strImage = srtImage;
		this.icoOiseau = new ImageIcon(getClass().getResource(this.strImage));
		this.imgOiseau = this.icoOiseau.getImage();
	}

	// Geutters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public Image getImgOiseau() {
		return imgOiseau;
	}

	// Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	// Methodes
	public void monte() {
		this.dy = 50;
		this.y = this.y - this.dy;

	}

}

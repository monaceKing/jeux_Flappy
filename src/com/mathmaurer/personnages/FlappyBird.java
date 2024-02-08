package com.mathmaurer.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FlappyBird implements Runnable {

	// Variable
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private int dy;
	private String strImage;
	private ImageIcon icoOiseau;
	private Image imgOiseau;

	private final int PAUSE = 10;

	// Constructeur

	public FlappyBird(int x, int y, String srtImage) {
		this.largeur = 34;
		this.hauteur = 24;
		this.x = x;
		this.y = y;
		this.strImage = srtImage;
		this.icoOiseau = new ImageIcon(getClass().getResource(this.strImage));
		this.imgOiseau = this.icoOiseau.getImage();
		Thread chronoAilles = new Thread(this);
		chronoAilles.start();
		
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
	public void monte() {this.dy = 50;}
	
	
	private void batDesAilles(int dy) {
		if(dy > 10) {
		this.icoOiseau = new ImageIcon(getClass().getResource("/images/oiseau2.png"));
		this.imgOiseau = this.icoOiseau.getImage();
		this.y = this.y - 3;
		}else if(dy > 5) {
			this.y = this.y - 2;
		}else if(dy > 1) {
			this.y = this.y - 1;
		} else if(dy == 1) {
			this.icoOiseau = new ImageIcon(getClass().getResource("/images/oiseau1.png"));
			this.imgOiseau = this.icoOiseau.getImage();
		}
	}

	@Override
	public void run() {
		while (true) {
			this.batDesAilles(dy);
			this.dy--;
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}

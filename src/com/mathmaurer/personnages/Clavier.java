package com.mathmaurer.personnages;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.monace.jeu.Main;

public class Clavier implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			//System.out.println("Touche espace pressée.");
			Main.scene.flappyBird.monte();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	
}

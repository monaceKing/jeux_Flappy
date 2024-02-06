package com.monace.jeu;

public class Chrono implements Runnable{

	private final int PAUSE = 10;
	
	//Cette methode va être appellée pendant tpout le programme pour faire defilier l'écran
	@Override
	public void run() {
		while(true) {
			Main.scene.xFond--;
			Main.scene.repaint();//Appel de la methode paintComonent()
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {}
		}
		
	}
	
}

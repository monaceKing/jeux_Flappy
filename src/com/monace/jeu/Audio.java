package com.monace.jeu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

	// Variable
	private Clip clip;

	// CONSTRUCTEUR
	public Audio(String son) {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
			clip = AudioSystem.getClip();
			clip.open(audio);

		} catch (Exception e) {
		}
	}

	// Guetters
	public Clip getClip() {
		return clip;
	}

	// Methodes
	public void play() {
		clip.start();
	}

	public void stop() {
		clip.start();
	}

	public static void playsSound(String son) {
		Audio s = new Audio(son);
		s.play();
	}
}

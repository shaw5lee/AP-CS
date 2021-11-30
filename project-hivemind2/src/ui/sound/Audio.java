package ui.sound;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

import core.Game;
import core.Utility;
import core.Values;

public class Audio 
{
	// Attacks
	private static SFX[] laser;
	private static SFX[] mg;
	private static SFX blast;
	private static SFX heal;
	private static SFX[] boom;
	
	// Abilities
	private static SFX aegis;
	private static SFX emp;

	private static ArrayList<Song> songs;
	private static ArrayList<Song> special;
	private static Song gameMusic;
	
	public static void playBlast(Point location)
	{
		Audio.blast.play(location, Utility.random(.9f, 1.1f), 1);
	}
	
	public static void playHeal(Point location)
	{
		Audio.heal.play(location);	
	}
	
	public static void playBoom(Point location, float pitch, float volume)
	{
		Audio.boom[Utility.random(0, 2)].play(location, pitch, volume);
	}
	
	public static void playAegis(Point location)
	{
		Audio.aegis.play(location);	
	}
	
	public static void playEMP(Point Location)
	{
		emp.play(Location);
	}
	
	public static void playMG(Point location)
	{
		final float PITCH = 1.6f;
		final float VOLUME = 1.3f;
		
		if(!Audio.mg[0].playing())
		{
			Audio.mg[0].play(location, PITCH, VOLUME);
		}
		else if(!Audio.mg[1].playing())
		{
			Audio.mg[1].play(location, PITCH, VOLUME);
		}
		else if(!Audio.mg[2].playing())
		{
			Audio.mg[2].play(location, PITCH, VOLUME);
		}
		else if(!Audio.mg[3].playing())
		{
			Audio.mg[3].play(location, PITCH, VOLUME);
		}
		else if(!Audio.mg[4].playing())
		{
			Audio.mg[4].play(location, PITCH, VOLUME);
		}
	}
	
	public static void playLaser(Point location)
	{
		laser[Utility.random(0, 2)].play(location, 1.5f, .6f);	
	}
	
	private static void loadSongList() throws SlickException
	{
		String path = "res/music/core/";
		
		songs = new ArrayList<Song>();
		songs.add(new Song("Lindsey Stirling", "The Arena", path + "the_arena.ogg"));
		songs.add(new Song("Lindsey Stirling", "Heist", path + "heist.ogg"));
		songs.add(new Song("Mythos", "Icarus", path + "icarus.ogg"));
		songs.add(new Song("District 78", "Shyboy", path + "shyboy.ogg"));
		songs.add(new Song("Bear McCreary", "Prelude to War", path + "prelude_to_war.ogg"));
		songs.add(new Song("Explosions in the Sky", "Glittering Blackness", path + "glittering_blackness.ogg"));
		songs.add(new Song("Escala", "Clubbed To Death", path + "clubbed_to_death.ogg"));
		songs.add(new Song("The Glitch Mob", "Fortune Days", path + "fortune_days.ogg"));
		songs.add(new Song("Lights and Motion", "Drift", path + "drift.ogg"));
		songs.add(new Song("Lindsey Stirling", "The Pheonix", path + "pheonix.ogg"));
		songs.add(new Song("Lindsey Stirling", "First Light", path + "first_light.ogg"));
		songs.add(new Song("The XX", "Intro", path + "intro.ogg"));
		songs.add(new Song("Blackmill", "The Drift", path + "blackmill.ogg"));


		special = new ArrayList<Song>();
		
		path = "res/music/special/";

		special.add(new Song("Smooth McGroove", "Duck Tales - Moon Theme (Acapella)", path + "duck_tales_moon.ogg", true));
		special.add(new Song("Sabaton", "Winged Hussars", path + "winged_hussars.ogg", true));
		special.add(new Song("John Williams", "Duel of the Fates", path + "duel_of_the_fates.ogg", true));
		special.add(new Song("Blue Suede", "Hooked on a Feeling", path + "hooked_on_a_feeling.ogg", true));
		special.add(new Song("Haddaway", "What Is Love?", path + "what_is_love.ogg", true));
		special.add(new Song("Men Without Hats", "Safety Dance", path + "safety_dance.ogg", true));
		special.add(new Song("Europe", "The Final Countdown", path + "final_countdown.ogg", true));
		special.add(new Song("Starcraft 2", "Terran Theme", path + "terran.ogg", true));
		special.add(new Song("Rick Astley", "Never Gonna Give You Up", path + "never_gonna_give_you_up.ogg", true));
		special.add(new Song("The Bee Gees", "Stayin' Alive", path + "stayin_alive.ogg", true));
		special.add(new Song("Darude", "Sandstorm", path + "sandstorm.ogg", true));
		special.add(new Song("Trans-Siberian Orchestra", "Christmas Eve", path + "chirstmas_eve.ogg", true));
		
		setRandomGameMusic();
	}

	public static void setRandomGameMusic() throws SlickException
	{

		if(Math.random() < Values.MUSIC_SECRET_CHANCE)
		{
			gameMusic = Audio.special.get(Utility.random(0, Audio.special.size()-1));
		}
		else
		{
			gameMusic = Audio.songs.get(Utility.random(0, Audio.songs.size()-1));
		}
	
	}
	
	public static Song getGameMusic()
	{
		return gameMusic;
	}
	
	public static void loadGameMusicFile() throws SlickException
	{
		gameMusic.loadMusic();
	}
	
	public static void playGameMusic() throws SlickException
	{
		if(getGameMusic() == null)
		{
			setRandomGameMusic();
		}
		
		if(getGameMusic().getMusic() == null)
		{
			loadGameMusicFile();
				
		}
		
		if(Game.musicOn)
		{
			getGameMusic().getMusic().loop();
		}
	}
	
	public static void loadAudio() throws SlickException 
	{
		// Music
		loadSongList();
		loadGameMusicFile();

		// Attacks
		laser = new SFX[3];
		laser[0] = new SFX("res/sfx/laser1.ogg");
		laser[1] = new SFX("res/sfx/laser2.ogg");
		laser[2] = new SFX("res/sfx/laser3.ogg");
		
		mg = new SFX[5];
		mg[0] = new SFX("res/sfx/mg.ogg");
		mg[1] = new SFX("res/sfx/mg.ogg");
		mg[2] = new SFX("res/sfx/mg.ogg");
		mg[3] = new SFX("res/sfx/mg.ogg");
		mg[4] = new SFX("res/sfx/mg.ogg");

		blast = new SFX("res/sfx/blast.ogg");
		heal = new SFX("res/sfx/heal.ogg");

		// Abilities
		aegis = new SFX("res/sfx/aegis.ogg");
		emp = new SFX("res/sfx/emp.ogg");
		
		// Other
		boom = new SFX[3];
		boom[0] = new SFX("res/sfx/boom1.ogg");
		boom[1] = new SFX("res/sfx/boom2.ogg");
		boom[2] = new SFX("res/sfx/boom3.ogg");

	}
}

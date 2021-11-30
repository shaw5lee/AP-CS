package teams.s2.basic;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import core.Game;
import core.Utility;
import objects.base.Player;
import objects.units.Assault;
import objects.units.Miner;
import objects.units.Raider;
import objects.units.Specialist;
import objects.units.Support;
import objects.units.Unit;
import objects.units.Unit.Order;
import objects.upgrades.AssaultAegis;
import objects.upgrades.AssaultExplosive;
import objects.upgrades.AssaultShield;
import objects.upgrades.MinerHull;
import objects.upgrades.MinerLaser;
import objects.upgrades.RaiderEngine;
import objects.upgrades.RaiderMissile;
import objects.upgrades.RaiderPierce;
import objects.upgrades.SpecialistKinetic;
import objects.upgrades.SpecialistReactor;
import objects.upgrades.SpecialistRift;
import objects.upgrades.SupportEnergy;
import objects.upgrades.SupportFix;

public class Vortex extends Player {
	/**************** Constructor ****************/

	public Vortex(int team, Game g) throws SlickException {
		super(team, g);
		setName("MyTeamName");
		loadImageSet("classic");
	}

	/**************** Action Method ****************/

	public void action() throws SlickException {

		if (countMyMiners() < 4) {
			addMinerToQueue();
		} else {
			addRaiderToQueue();
		}

		if (countMyAssaults() < countMyRaiders() * 2) {
			addAssaultToQueue();
		}

		if (this.countEnemyRaiders() > 3) {
			addAssaultToQueue();
		}
		if (this.countEnemyMiners() > 3 || this.countEnemySpecialists() > 2) {
			addRaiderToQueue();
		} else if (countMyMiners() < countMyRaiders() * 2) {
			addMinerToQueue();
		}

	}

	/**************** Draw Method ****************/

	public void draw(Graphics g) {

		// This method allows you to draw things on the screen. It's only visible if you
		// enable
		// that player's drawings. Press 'q' to enable drawings for BLUE and 'e' for
		// RED.
	}

	/*****************
	 * Build Methods ***************\
	 * 
	 * These methods determine what kind of unit is created when you build a unit.
	 * At the start, don't modify them. Later on, you can use them to situationally
	 * create alternate versions of each unit type with different behaviors.
	 * 
	 * \
	 ***********************************************/

	public Raider buildRaider() throws SlickException {
		return new VortexRaider(this);
	}

	public Miner buildMiner() throws SlickException {
		return new VortexMiner(this);
	}

	public Assault buildAssault() throws SlickException {
		return new VortexAssault(this);
	}

	public Specialist buildSpecialist() throws SlickException {
		return new VortexSpecialist(this);
	}

	public Support buildSupport() throws SlickException {
		return new VortexSupport(this);
	}

}

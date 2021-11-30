package teams.s2.basic;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import core.Utility;
import objects.units.Assault;
import objects.units.Raider;
import objects.units.Specialist;
import objects.units.Unit;

public class VortexRaider extends Raider {
	Vortex p;

	public VortexRaider(Vortex p) throws SlickException {
		super(p);
		this.p = p;
	}

	/***************** Action Method ***************/

	public void action() {

		float noChance = 0;
		Unit a = nearestEnemy();

		if (a instanceof Specialist) {
			if (this.nearestAlly(Raider.class) != null
					&& this.nearestAlly(Raider.class).nearestEnemy(Assault.class) != null
					&& this.nearestAlly(Raider.class)
							.getDistance(this.nearestEnemy(Assault.class)) > RAIDER_ATTACK_RANGE) {
				noChance += 1;
			}
		}

		if (noChance >= 1) {
			moveTo(this.getHomeBase());
		}
		moveTo(a);
		shoot(a);

	}

	/***************** Order Methods ***************/

	protected void attack() {
		// This method is called every frame while the unit's order is set to ATTACK
	}

	protected void defend() {
		// This method is called every frame while the unit's order is set to DEFEND
	}

	protected void guard() {
		// This method is called every frame while the unit's order is set to GUARD
	}

	protected void rally() {
		// This method is called every frame while the unit's order is set to RALLY
	}

	protected void skirmish() {
		// This method is called every frame while the unit's order is set to SKIRMISH
	}

	protected void special() {
		// This method is called every frame while the unit's order is set to SPECIAL
	}

	protected void run() {
		// This method is called every frame while the unit's order is set to RUN
	}

	/***************** DRAW Methods ***************/

	public void draw(Graphics g) {

		// This method allows you to draw things on the screen. It's only visible if you
		// enable
		// that player's drawings. Press 'q' to enable drawings for BLUE and 'e' for
		// RED.
	}
}

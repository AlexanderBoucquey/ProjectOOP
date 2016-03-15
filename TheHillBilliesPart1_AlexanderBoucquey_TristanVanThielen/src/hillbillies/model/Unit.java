/**
 * Alexander Boucquey and Tristan Van Thielen
 * Bachelor Burgerlijk Ingenieur CWSELT
 * https://github.com/tristanvanthielen/ProjectOOP
 */

package hillbillies.model;

import java.util.Arrays;
import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;

/**
 * A class of units
 * 
 * @invar 	... 
 * 			| isValidAttribute(this.getStrength())
 * @invar 	... 
 * 			| isValidAttribute(this.getAgility())
 * @invar 	... 
 * 			| isValidAttribute(this.getWeigth())
 * @invar 	... 
 * 			| isValidAttribute(this.getToughness())
 * @invar 	... 
 * 			| isValidName(this.getName())
 * @invar 	... 
 * 			| isValidPoints(this.getHitpoints())
 * @invar 	... 
 * 			| isValidPoints(this.getStaminapoints())
 * @invar	...
 * 			| isValidPosition(this.getPosition())
 * @invar	...
 * 			| isValidOrientation(this.getOrientation())
 * @author Alexander Boucquey & Tristan Van Thielen
 * @version 1.12
 * 
 */

public class Unit {

	/**
	 * @param 	name
	 * 			The name to give to the unit.
	 * @param 	strength
	 * 			The number to set the unit's strength on.
	 * @param 	agility
	 * 			The number to set the unit's agility on.
	 * @param 	toughness
	 * 			The number to set the unit's toughness on.
	 * @param 	weight
	 * 			The number to set the unit's weight on.
	 * @effect 	... 
	 * 			Sets the name of this unit to the given name.
	 * 			| setName(name)
	 * @effect 	... 
	 * 			Sets the strength of this unit to the given strength.
	 * 			| setStrength(strength, 25, 100)
	 * @effect 	... 
	 * 			Sets the toughness of this unit to the given toughness.
	 * 			| setToughness(toughness,25,100)
	 * @effect 	... 
	 * 			Sets the agility of this unit to the given agility.
	 * 			| setAgility(agility, 25, 100)
	 * @effect 	... 
	 * 			Sets the weight of this unit to the given weight.
	 * 			| setWeight(weight, 100)
	 * @effect 	... 
	 * 			Sets the hitpoints of this unit to the given hitpoints.
	 * 			| setHitpoints(maxPoints)
	 * @effect 	... 
	 * 			Sets the staminapoints of this unit to the given staminapoints.
	 * 			| setStaminapoints(maxPoints)
	 * @effect 	... 
	 * 			Sets the movementspeed of this unit to the given movementspeed.
	 * 			| setBaseMovespeed()
	 * @effect 	... 
	 * 			Sets the position of this unit to the given position.
	 * 			| setPosition(initialPosition)
	 * @effect 	... 
	 * 			Sets the orientation of this unit to the given orientation.
	 * 			| setOrientation(Math.PI/2.0)
	 */

	public Unit(String name, int[] initialPosition, int weight, int agility, int strength, int toughness)
			throws IllegalArgumentException {
		this.setName(name);
		this.setStrength(strength, 25, 100);
		this.setToughness(toughness, 25, 100);
		this.setAgility(agility, 25, 100);
		this.setWeight(weight, 100);
		this.setHitpoints(this.getMaxPoints());
		this.setStaminapoints(this.getMaxPoints());
		this.setBaseMovespeed();
		double position[] = { (double) initialPosition[0]+0.5, (double) initialPosition[1]+0.5, (double) initialPosition[2]+0.5};
		this.setPosition(position);
		this.setOrientation(Math.PI / 2.0);
	}

	private int hitpoints;
	private int staminapoints;
	
	/**
	 * Return the maximum number of hit-/ staminapoints.
	 * @return	...
	 * 			The result is the maximum number of hitpoints for a given unit.
	 * 			| result == (int) Math.ceil(200.0 * this.getWeight() / 100 * this.getToughness() / 100)
	 */
	public int getMaxPoints() {
		return (int) Math.ceil(200.0 * this.getWeight() / 100 * this.getToughness() / 100);
	}

	/**
	 * Return the name of the unit.
	 * @return	...
	 * 			Returns this unit's name.
	 * 			| result == this.name;
	 */
	@Basic
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of this unit to name.
	 * 
	 * @param 	name
	 * 			The name to give to this unit.
	 * @pre ...
	 * 		The name of this unit must be valid.
	 * 		| isValidName(name)
	 * @post 	... 
	 * 			The name of the unit is now the given name.
	 * 		 	| new.getName() == name
	 * @throws	IllegalArgumentException
	 * 			Throws an exception if the given name is not valid.
	 * 			| (!isValidName(name)
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (isValidName(name))
			this.name = name;
		else
			throw new IllegalArgumentException();
	}

	private String name;

	/**
	 * Checks whether the given name is a valid name.
	 * 
	 * @param 	name
	 * 			The name to check.
	 * @return ... 
	 * 			Returns true if the name's first letter is uppercase, the name's length
	 * 			is equal or lager than two and the name only contains valid characters.
	 * 			| if (!Character.isUpperCase(name.charAt(0))) || (name.length() < 2))
	 *         	| 	then result == false 
	 *         	| if (for each char in name) 
	 *         	| 	(LegalCharacters.contains(Character.toString(c)))
	 *         	| 	then result == true
	 */
	public static boolean isValidName(String name) {

		if (name.length() < 2) {
			System.out.println("Name too short!");
			return false;
		}

		if (!Character.isUpperCase(name.charAt(0))) {
			System.out.println("First letter is not uppercase!");
			return false;
		}

		for (char c : name.toCharArray())
			if (!legalcharacters.contains(Character.toString(c))) {
				System.out.println("Name contains illegal character!");
				return false;
			}
		return true;

	}

	private final static String legalcharacters = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ'\"";

	/**
	 * Return the strength of this unit.
	 * @return	...
	 * 			Returns this unit's strength.
	 * 			| result == this.strength;
	 */
	@Basic
	public int getStrength() {
		return this.strength;
	}

	/**
	 * Set the strength of the unit to the given strength.
	 * 
	 * @param 	strength
	 * 			The number to set the unit's strength on.
	 * @param 	min
	 * 			The minimal amount of strength for this unit.
	 * @param 	max
	 * 			The maximal amount of strength for this unit.
	 * @post 	... 
	 * 			If the given strength is an allowed value, then the
	 * 			unit's new strength equals the given strength.
	 * 		 	| new.strength == setAttribute(strength, min, max)
	 */
	public void setStrength(int strength, int min, int max) {
		this.strength = setAttribute(strength, min, max);
		this.setWeight(this.getWeight(), max);

	}

	private int strength;

	/**
	 * Return the toughness of this unit.
	 * @return	...
	 * 			Returns this unit's toughness.
	 * 			| result == this.tougness;
	 */
	@Basic
	public int getToughness() {
		return this.toughness;
	}

	/**
	 * Set the toughness of the unit to the given toughness.
	 * 
	 * @param	toughness
	 * 			The number to set the unit's toughness on.
	 * @param 	min
	 * 			The minimal amount of toughness for this unit.
	 * @param 	max
	 * 			The maximal amount of toughness for this unit.
	 * @post 	... 
	 * 			If the given toughness is an allowed value, then the
	 * 			unit's new toughness equals the given toughness.
	 * 		 	| new.toughness == setAttribute(toughness, min, max)
	 */
	public void setToughness(int toughness, int min, int max) {
		this.toughness = setAttribute(toughness, min, max);
	}

	private int toughness;

	/**
	 * Return the agility of this unit.
	 * @return	...
	 * 			Returns this unit's agility.
	 * 			| result == this.agility;
	 */
	@Basic
	public int getAgility() {
		return this.agility;
	}

	/**
	 * 
	 * Set the agility of the unit to the given agility.
	 * 
	 * @param	agility
	 * 			The number to set the unit's agility on.
	 * @param 	min
	 * 			The minimal amount of agility for this unit.
	 * @param 	max
	 * 			The maximal amount of agility for this unit.
	 * @post 	... 
	 * 			If the given agility is an allowed value, then the
	 * 			unit's new agility equals the given agility.
	 * 		 	|new.agility == setAttribute(agility, min, max)
	 */
	public void setAgility(int agility, int min, int max) {
		this.agility = setAttribute(agility, min, max);
		this.setWeight(this.getWeight(), max);
	}

	private int agility;

	/**
	 * Return the weight of this unit.
	 * @return	...
	 * 			Returns this unit's weight.
	 * 			| result == this.weight;
	 */
	@Basic
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Set the weight of the unit to the given weight.
	 * 
	 * @param 	weight
	 * 			The number to set the unit's weight on.
	 * @param 	max
	 * 			The maximal amount of weight for this unit.
	 * @post 	... 
	 * 			If the given weight is an allowed value, then the
	 * 			unit's new weight equals the given weight.
	 * 		 	|new.weight == setAttribute(weight, (this.strength + this.agility)/2, max)
	 */
	public void setWeight(int weight, int max) {
		this.weight = this.setAttribute(weight, (this.strength + this.agility) / 2, max);
		this.setBaseMovespeed();
	}

	private int weight;

	/**
	 * Return the correct number for the given attribute.
	 * 
	 * @param 	attribute
	 * 			The number to try to give to an attribute.
	 * @param 	min
	 * 			The minimal value for this attribute.
	 * @param 	max
	 * 			The maximal value for this attribute.
	 * @return  ... 
	 * 			If the given value is smaller than the smallest allowed value
	 * 			then the result is that smallest value. If the given value is
	 * 			larger than the largest allowed value, then the result is that
	 * 			largest value. If the given value is within the boundries then
	 * 			the result is that given value.
	 * 			| if (isValidAttribute(attribute,min, max)) 
	 * 			| 	then result ==attribute 
	 * 			| else if (attribute < min) 
	 * 			| 	then result == min 
	 * 			| else
	 *         	| 	then result == max;
	 */
	private int setAttribute(int attribute, int min, int max) {
		if (isValidAttribute(attribute, min, max))
			return attribute;
		else if (attribute < min) {
			return min;
		} else
			return max;
	}

	/**
	 * Check if attribute is an allowed value.
	 * 
	 * @param 	attribute
	 * 			The number to check.
	 * @param 	min
	 * 			The minimal value for the attribute.
	 * @param	max
	 * 			The maximal value for the attribute.
	 * @return  ... 
	 * 			If the given values lies between the given maximum
	 * 			and minimum, then the result is true. If this is not
	 * 			case then the result is false.
	 * 			| if ((attribute >= min) && (attribute <=max)) 
	 * 			| 	then result == true 
	 * 			| else 
	 * 			|	then result == false
	 */
	public static boolean isValidAttribute(int attribute, int min, int max) {
		if ((attribute >= min) && (attribute <= max))
			return true;
		return false;
	}

	/**
	 * Return the current hitpoints of this unit.
	 * @return	...
	 * 			Returns this unit's hitpoints.
	 * 			| result == this.hitpoints;
	 */
	@Basic
	public int getHitpoints() {
		return this.hitpoints;
	}

	/**
	 * Set the hitpoints of this unit the given number of hitpoints.
	 * 
	 * @param 	hitpoints
	 * 			The number to set this unit's hitpoints on.
	 * @pre ...
	 * 		The given value must a valid number of points. 
	 * 		| isValidPoints(hitpoints) 
	 * @post...
	 * 		The unit's hipoints are now equal to the given
	 * 		number of hitpoints. 
	 * 		| new.getHitpoints() == hitpoints
	 */
	private void setHitpoints(int hitpoints) {
		assert (isValidPoints(hitpoints));
		this.hitpoints = hitpoints;
	}

	/**
	 * Add the given amount to this unit's current hitpoints.
	 * 
	 * @param 	amount
	 * 			The number of hitpoints to give to this unit.
	 * @effect 	... 
	 * 			The amount of hitpoints is added to the unit's current hitpoints.
	 * 			| setHitpoints(this.getHitpoints() + amount)
	 */
	private void addHitpoints(int amount) {
		this.setHitpoints(this.getHitpoints() + amount);
	}

	/**
	 * Substract the given amount from this unit's current hitpoints.
	 * 
	 * @param 	amount
	 * 			The number of hitpoints to substract from this unit.
	 * @effect 	... 
	 * 			The amount of hitpoints is substracted from the unit's current hitpoints.
	 * 			| setHitpoints(this.getHitpoints() - amount)
	 */
	private void substractHitpoints(int amount) {
		this.setHitpoints(this.getHitpoints() - amount);
	}

	/**
	 * Return the current number of staminapoints of this unit.
	 * @return	...
	 * 			Returns this unit's staminapoints.
	 * 			| result == this.staminapoints;
	 */
	@Basic
	public int getStaminapoints() {
		return this.staminapoints;
	}

	/**
	 * Set the stamina of this unit the given number of stamina.
	 * 
	 * @param 	staminapoints
	 * 			The number to set this unit's staminapoints on.
	 * @pre ... 
	 * 		The given number of points must be a valid
	 * 		number of points.
	 * 		| isValidPoints(staminapoints) 
	 * @post... 
	 * 		The unit's staminapoints now equal the given number
	 * 		of staminapoints.
	 * 		| new.getStaminapoints() == staminapoints
	 */
	private void setStaminapoints(int staminapoints) {
		assert (isValidPoints(staminapoints));
		this.staminapoints = staminapoints;
	}

	/**
	 * Add the given amount to this unit's current staminapoints.
	 * 
	 * @param 	amount
	 * 			The number of staminapoints to give to this unit.
	 * @effect 	... 
	 * 			The given amount of staminapoints is added to the unit's
	 * 			current staminapoints.
	 * 			| setStaminapoints(this.staminapoints + amount)
	 */
	private void addStaminapoints(int amount) {
		this.setStaminapoints(this.staminapoints + amount);
	}

	/**
	 * Substract the given amount from this unit's current staminapoints.
	 * 
	 * @param 	amount
	 * 			The number of staminapoints to substract from this unit.
	 * @effect 	... 
	 * 			The given amount of staminapoints is substracted from the unit's
	 * 			current staminapoints.
	 * 			| setStaminapoints(this.staminapoints - amount)
	 */
	private void substractStaminapoints(int amount) {
		this.setStaminapoints(this.staminapoints - amount);
	}

	/**
	 * Check whether the given points are a valid amount.
	 * 
	 * @param 	points
	 * 			The number to check.
	 * @return 	... 
	 * 			If the given value lies within the allowed boundries
	 * 			then the result is true. If this is not the case
	 * 			then the result is false.
	 * 			| if ((points <= maxPoints) && (points >= 0)) 
	 * 			| 	then result == true 
	 * 			| else 
	 * 			|	then result == false
	 */
	public boolean isValidPoints(int points) {
		return ((points <= this.getMaxPoints()) && (points >= 0));
	}

	/**
	 * Calculate the base movementspeed from the unit based on the other attributes.
	 * @post ...
	 * 		 The unit's basemovementspeed is now set based on other values.
	 * 		 | new.BaseMovespeed == setAttribute(1.5 * (this.getStrength() + 
	 *	 	 | 				this.getAgility()) / (200 * this.getWeight() / 100)
	 */
	private void setBaseMovespeed() {
		this.basemovespeed = 1.5 * (this.getStrength() + this.getAgility()) / ((200 * this.getWeight() / 100));
	}

	private double basemovespeed;

	/**
	 * Return the base movementspeed of this unit.
	 * 
	 * @return	...
	 * 			The result is the unit's current base movementspeed.
	 * 			| result == this.basemovespeed
	 */
	@Basic
	private double getBaseMovespeed() {
		return this.basemovespeed;
	}

	/**
	 * Set the unit's position on the given position.
	 * 
	 * @param 	position
	 * 			The position to put this unit on.
	 * @post...
	 * 		If the given position was valid, then the unit's
	 * 		position is set to that position.
	 * 		| if isValidPosition(position) 
	 * 		| 	then new.position == position
	 */
	private void setPosition(double[] position) {
		if (isValidPosition(position))
			this.position = position;
	}

	/**
	 * Return the current position	of this unit.
	 * 
	 * @return	...
	 * 			The result is this unit's current position
	 * 			| result == this.position
	 */
	@Basic
	public double[] getPosition() {
		return this.position;
	}

	private double[] position;
	
	/**
	 * Set the unit's orientation on the given orientation.
	 * 
	 * @param 	radian
	 * 			The orientation to give to this unit.
	 * @post...
	 * 		The new orientation is now the given orientation,
	 * 		but modulo 2*PI to keep it within boundaries.
	 *	 	| new.orientation == radian % (2*PI)
	 * 
	 */
	private void setOrientation(double radian) {
		this.orientation = radian % (2 * Math.PI);
	}
	

	/**
	 * Return the current orientation of this unit.
	 * 
	 * @return	...
	 * 			The result is the unit's current orientation.
	 * 			| result == this.orientation
	 */
	@Basic
	public double getOrientation() {
		return this.orientation;
	}

	private double orientation;
	
	/**
	 * Start the unit's sprinting.
	 * 
	 * @post... 
	 * 		The unit's sprinting state is now true.
	 * 	 	| new.sprinting == true
	 */
	public void startSprinting() {
		this.sprinting = true;
	}
	
	/**
	 * Stop the unit's sprinting.
	 * 
	 * @post... 
	 * 		The unit's sprinting state is now false.
	 * 	 	| new.sprinting == false
	 */
	public void stopSprinting() {
		this.sprinting = false;
	}
	
	/**
	 * Check whether the unit is sprinting.
	 * 
	 * @return 	... 
	 * 			The result is a boolean that is true of the unit
	 * 			is sprinting and false if it is not.
	 *	   		| result == this.sprinting
	 */
	public boolean isSprinting() {
		return this.sprinting;

	}

	private boolean sprinting;
	
	/**
	 * Check whether the unit is moving.
	 * 
	 * @return 	... 
	 * 			The result is a boolean that is true of the unit
	 * 			is moving and false if it is not.
	 *	   		| result == this.moving
	 */
	public boolean isMoving() {
		return this.moving;
	}

	private boolean moving;
	
	/**
	 * Move the unit to an adjacent cube.
	 * 
	 * @param 	dx
	 * 			The direction to move via the x-axis.
	 * @param 	dy
	 * 			The direction to move via the y-axis.
	 * @param 	dz
	 * 			The direction to move via the z-axis.
	 * @effect  ...
	 * 			If the unit can stop resting, then it's targetposition is
	 * 			set to the center of the given cube.
	 * 			| if (this.canStopResting())
	 * 			|	then (setTargetPosition(new double[] { this.getCubeCoordinate()[0] + dx + 0.5
	 * 			|							, this.getCubeCoordinate()[1] + dy + 0.5
	 * 			|							, this.getCubeCoordinate()[2] + dz + 0.5}))
	 * @effect	...
	 * 			If the unit can stop resting, then it's orientation is 
	 * 			set to respresent where the unit is moving to.
	 *			| if ((this.canStopResting())
	 * 			|	then (setOrientation(atan(getTartgetPosition(targetPosition)[1] - this.getPosition[1] * this.getBaseMovespeed / d1
	 *			|				, getTartgetPosition(targetPosition)[0] - this.getPosition[0] * this.getBaseMovespeed / d1)))
	 * @effect 	... 
	 * 			Set the speedvector of this unit based on whether or not it is moving
	 * 			up or down and the three dimensional direction.
	 * 			If it is moving down then the speed is the unit's speed times 1.8.
	 * 			If it is moving up then the speed is the unit's speed times 0.5.
	 * 			Else it is just the unit's base movementspeed.
	 *			| if ((this.canStopResting()) && (dz == -1))
	 *			|	then setSpeedVector(getTartgetPosition(targetPosition)[0] - this.getPosition[0] * this.getBaseMovespeed / d1
	 *			|						, getTartgetPosition(targetPosition)[1] - this.getPosition[1] * this.getBaseMovespeed / d1
	 *			|						, getTartgetPosition(targetPosition)[2] - this.getPosition[2] * this.getBaseMovespeed / d1 * 1.2)
	 *			| else if ((this.canStopResting()) && (dz == 1))
	 *			|	then setSpeedVector(getTartgetPosition(targetPosition)[0] - this.getPosition[0] * this.getBaseMovespeed / d1
	 *			|						, getTartgetPosition(targetPosition)[1] - this.getPosition[1] * this.getBaseMovespeed / d1
	 *			|						, getTartgetPosition(targetPosition)[2] - this.getPosition[2] * this.getBaseMovespeed / d1 * 0.5)
	 *			| else if ((this.canStopResting()) && (dz == 0))
	 *			| 	then setSpeedVector(getTartgetPosition(targetPosition)[0] - this.getPosition[0] * this.getBaseMovespeed / d1
	 *			|						, getTartgetPosition(targetPosition)[1] - this.getPosition[1] * this.getBaseMovespeed / d1
	 *			|						, getTartgetPosition(targetPosition)[2] - this.getPosition[2] * this.getBaseMovespeed / d1)
	 *			| where d1 = sqrt((this.getTargetPosition[0] - this.getPosition[0])^2
	 *			|			+ (getTargetPosition[1] - this.getPosition[1])^2
	 *			|			+ (getTargetPosition[2] - this.getPosition[2])^2)
	 * @effect  ...
	 * 			If the unit is sprinting then the speed is the unit's speed times 2.
	 * 			| if (this.isSprinting())
	 *			|	then this.setCurrentSPeed(this.getBaseMovespeed()*2.0);
	 *			| else if (!this.isSprinting())
	 *			|	then this.setCurrentSPeed(this.getBaseMovespeed());
	 *	
	 * @post...
	 * 		The unit is no longer resting and it is now moving.
	 *	  	| new.resting == false;
	 *	  	| new.moving == true;
	 * 
	 * */
	public void moveToAdjacent(int dx, int dy, int dz) throws IllegalArgumentException {
		if ((Math.abs(dx) > 1) || (Math.abs(dy) > 1) || (Math.abs(dz) > 1))
			throw new IllegalArgumentException();
		this.stopBehavior();
		if (canStopResting()) {
			int[] myCube = this.getCubeCoordinate();
			int[] targetCube = new int[] { myCube[0] + dx, myCube[1] + dy, myCube[2] + dz };
			double[] targetPosition = new double[] { targetCube[0] + 0.5, targetCube[1] + 0.5, targetCube[2] + 0.5 };
			this.setTargetPosition(targetPosition);
			this.resting = false;
			this.moving = true;
			double v = 0.0, d1, vx, vy, vz;
			v = this.getBaseMovespeed();
			if (dz == -1)
				v = v * 1.2;
			if (dz == 1)
				v = v * 0.5;
			if (this.isSprinting())
				this.setCurrentSPeed(v*2.0);
			if (!this.isSprinting())
				this.setCurrentSPeed(v);
			d1 = Math.sqrt(Math.pow((this.getTargetPosition()[0] - this.getPosition()[0]), 2)
					+ Math.pow((this.getTargetPosition()[1] - this.getPosition()[1]), 2)
					+ Math.pow((this.getTargetPosition()[2] - this.getPosition()[2]), 2));

			vx = (this.getTargetPosition()[0] - this.getPosition()[0]) * v / d1;
			vy = (this.getTargetPosition()[1] - this.getPosition()[1]) * v / d1;
			vz = (this.getTargetPosition()[2] - this.getPosition()[2]) * v / d1;
			this.setOrientation(Math.atan2(vy, vx));

			this.setSpeedVector(vx, vy, vz);
		}
	}
	
	/**
	 * Set the Unit's speedvector on the given speed.
	 * 
	 * @param 	vx
	 * 			The speed to set along the x-axis.
	 * @param 	vy
	 * 			The speed to set along the y-axis.
	 * @param 	vz
	 * 			The speed to set along the z-axis.
	 * @post... 
	 * 		This unit's speedvector is tow set to the given
	 * 		values vx, vy and vz.
	 * 	 	| new.speedvector == {vx, vy, vz}
	 * 
	 */
	private void setSpeedVector(double vx, double vy, double vz) {
		this.speedvector = new double[] { vx, vy, vz };
	}
	
	/**
	 * Return the current speedvector of this unit.
	 * 
	 * @return	...
	 * 			The result is this unit's speedvector.
	 * 			| result == this.speedvector
	 */
	@Basic
	private double[] getSpeedVector() {
		return this.speedvector;
	}

	private double[] speedvector;
	
	/**
	 * Return the current cube coordinate of this unit.
	 * 
	 * @return	... 
	 * 			The result is a list of coordinates of the cube in which this unit is standing.
	 * 			| result == ({ Math.floor(this.getPosition[0]), Math.floor(this.getPosition[1]),Math.floor(this.getPosition[2])})
	 * 
	 */
	@Basic
	public int[] getCubeCoordinate() {
		return new int[] { (int) this.getPosition()[0], (int) this.getPosition()[1], (int) this.getPosition()[2] };

	}
	
	/**
	 * Set the Unit's target position on the given position.
	 * 
	 * @param 	target position
	 * 			The position to move to.
	 * @pre ... 
	 * 		The given position must be a valid position.
	 * 		| isValidPosition(targetPosition)
	 * @post...
	 * 		The unit's targetposition is set to the given position.
	 * 		| new.targetposition == targetPosition
	 * 
	 */
	private void setTargetPosition(double[] targetPosition) throws IllegalArgumentException {
		if (isValidPosition(targetPosition))
			this.targetposition = targetPosition;
		else
			throw new IllegalArgumentException();

	}
	
	/**
	 * Return the target position of the unit.
	 * 
	 * @return	...
	 * 			The result is this unit's targetposition.
	 * 			| result == this.targetposition
	 */
	@Basic
	private double[] getTargetPosition() {
		return this.targetposition;
	}

	private double[] targetposition;
	
	/**
	 * Move the unit to a target cube.
	 * @param 	targetCube
	 * 			The coordinates of the cube to move to.
	 * @effect	...
	 * 			Calls moveToAdjacent based on the direction the unit
	 * 			needs to move in along the x-, y- and z-axis.
	 * 			| dx = 0, dy = 0, dz = 0
	 * 			| if (this.getCubeCoordinate()[0] < targetCube[0])
	 *			|	then dx = 1;
	 *			| if (this.getCubeCoordinate()[0] > targetCube[0])
	 *			|	then dx = -1;
	 *			| if (this.getCubeCoordinate()[1] < targetCube[1])
	 *			|	then dy = 1;
	 *			| if (this.getCubeCoordinate()[1] > targetCube[1])
	 *			|	then dy = -1;
	 *			| if (this.getCubeCoordinate()[2] < targetCube[2])
	 *			|	then dz = 1;
	 *			| if (this.getCubeCoordinate()[2] > targetCube[2])
	 *			|	then dz = -1;
	 *			| moveToAdjacent(dx, dy, dz)
	 * @throws 	IllegalArgumentException
	 * 			Throws an exception if the given cube is invalid.
	 */
	public void moveTo(int[] targetCube) throws IllegalArgumentException {
		this.stopBehavior();
		int[] myCube = this.getCubeCoordinate();
		this.setGlobalTarget(new double[] { targetCube[0] + 0.5, targetCube[1] + 0.5, targetCube[2] + 0.5 });
		int dx = 0, dy = 0, dz = 0;
		int myX = myCube[0];
		int targetX = targetCube[0];
		int myY = myCube[1];
		int targetY = targetCube[1];
		int myZ = myCube[2];
		int targetZ = targetCube[2];

		if (myX < targetX)
			dx = 1;
		if (myX > targetX)
			dx = -1;

		if (myY < targetY)
			dy = 1;
		if (myY > targetY)
			dy = -1;

		if (myZ < targetZ)
			dz = 1;
		if (myZ > targetZ)
			dz = -1;
		this.moveToAdjacent(dx, dy, dz);

	}
	
	/**
	 * Set the Unit's global target on target 
	 * 
	 * @post...
	 * 		The given target is now the unit's global target. 
	 * 		| new.globalTarget == target
	 * 
	 */
	void setGlobalTarget(double[] target) {
		this.globalTarget = target;
	}
	 
	/**
	 * Return the global target position of the unit.
	 *
	 * @return	...
	 * 			The result is the unit's current target.
	 * 			| result == this.globalTarget
	 */
	@Basic
	private double[] getGlobalTarget() {
		return this.globalTarget;
	}

	private double[] globalTarget;

	/**
	 * Check if the given position is a valid position.
	 * 
	 * @param 	position
	 * 			The position to check.
	 * @return 	... 
	 * 			If the given position lies within the boundaries of the game world
	 * 			then the result is true. If this is not the case, then the result is false.
	 * 			| if (position[0]>=0) && (position[0] < xMax) &&
	 *         	|	(position[1]>=0) && (position[1] < yMax) && | (position[2]>=0) &&
	 *         	|	(position[2] < zMax) 
	 *         	| 	then result == true 
	 *         	| else 
	 *         	|	then result == false
	 */
	private boolean isValidPosition(double[] position) {
		return (( (position != null) && position[0] >= 0) && (position[0] < xMax) && (position[1] >= 0) && (position[1] < yMax)
				&& (position[2] >= 0) && (position[2] < zMax));
	}

	private final int xMax = 50;
	private final int yMax = 50;
	private final int zMax = 50;

	public void advanceTime(double deltaT) throws IllegalArgumentException {
		gametime += deltaT;
		if (gametime >= 180) {
			this.hasToRest = true;
			this.hasRestedHitpoint = false;
			gametime -= 180;
		}
		if (this.isAttacking()) {
			this.combatTime += deltaT;
			if (this.combatTime >= 1) {
				this.attacking = false;
				this.combatTime = 0.0;
			}

		} else if ((this.hasToRest) || this.isResting()) {
			this.rest();
			this.timeResting += deltaT;
			this.totalRestTime += deltaT;
			double timeForOneHP = 0.2 * 200 / this.getToughness();
			double timeForOneSP = 0.2 * 100 / this.getToughness();
			if (this.totalRestTime >= timeForOneHP) {
				this.hasToRest = false;
				this.hasRestedHitpoint = true;
				this.totalRestTime = 0.0;
			}
			if (this.timeResting >= timeForOneSP) {
				if ((this.staminapoints < this.getMaxPoints()) && (this.getHitpoints() >= this.getMaxPoints())) {
					this.addStaminapoints(1);
					this.timeResting -= timeForOneSP;
				} else if ((this.timeResting >= timeForOneHP) && (this.getHitpoints() < this.getMaxPoints())) {
					this.addHitpoints(1);
					this.timeResting -= timeForOneHP;
				}
			}
		} else if (this.isMoving()) {
			double d1, d2, factor = 1.0;
			if (this.getStaminapoints() <= 0)
				this.stopSprinting();
			if ((this.isSprinting() == true) && (this.getStaminapoints() > 0)){
				factor = 2.0;
			}
			double[] speedVector = this.getSpeedVector();
			double[] targetPosition = this.getTargetPosition();
			double[] myPosition = this.getPosition();
			double newPosition[] = { myPosition[0] + factor * speedVector[0] * deltaT,
					myPosition[1] + factor * speedVector[1] * deltaT,
					myPosition[2] + factor * speedVector[2] * deltaT };
			d1 = Math.sqrt(Math.pow((targetPosition[0] - myPosition[0]), 2) + Math.pow((targetPosition[1] - myPosition[1]), 2)
							+ Math.pow((targetPosition[2] - myPosition[2]), 2));
			d2 = Math.sqrt(Math.pow((newPosition[0] - this.getPosition()[0]), 2)
					+ Math.pow((newPosition[1] - this.getPosition()[1]), 2)
					+ Math.pow((newPosition[2] - this.getPosition()[2]), 2));
			if (d1 > d2) {
				this.setPosition(newPosition);
				if (this.isSprinting())
					this.sprintDuration = this.sprintDuration + deltaT;
				if (this.sprintDuration >= 0.1) {
					this.substractStaminapoints(1);
					this.sprintDuration = this.sprintDuration - 0.1;
				}
			}
			if (d1 <= d2) {
				this.setPosition(targetPosition);
				if (Arrays.equals(targetPosition, this.getGlobalTarget()) || (this.getGlobalTarget() == null)) {
					this.moving = false;
					this.setCurrentSPeed(0.0);
					this.stopSprinting();
					this.setGlobalTarget(null);
				} else
					moveTo(new int[] { (int) this.getGlobalTarget()[0], (int) this.getGlobalTarget()[1],
							(int) this.getGlobalTarget()[2] });

			}
		} else if (this.isWorking()) {
			this.workTime += deltaT;
			if (this.workTime > 500 / this.getStrength()) {
				this.working = false;
				this.workTime = 0.0;
				System.out.println("Work completed!");
			}

		}

	}
	
	private double totalRestTime = 0.0;
	private boolean hasRestedHitpoint = true;
	private boolean hasToRest;
	private double gametime;
	private double timeResting = 0.0;
	private double combatTime = 0.0;
	private double sprintDuration = 0.0;
	private double workTime = 0.0;
	
	/**
	 * Check whether the unit has rested as long as it takes to recover an hitpoint.
	 * 
	 * @return 	... 
	 * 			The result is true if the unit has rested long enough
	 * 			to restore one hitpoint.
	 * 			| result == this.hasRestedHitpoint
	 */
	private boolean canStopResting() {
		return this.hasRestedHitpoint;
	}
	
	/**
	 * Set the unit's current speed to the given speed.
	 * 
	 * @param 	speed
	 * 			The speed at which this unit is moving.
	 * @post...
	 * 		The unit's current speed is now the given speed.
	 * 		| new.currentSpeed = speed
	 */
	private void setCurrentSPeed(double speed){
		this.currentSpeed = speed;
	}
	
	/**
	 * Returns the unit's current speed.
	 * 
	 * @return	...
	 * 			The result is the current speed of this unit.
	 * 			| result == this.currentSpeed
	 */
	@Basic
	public double getCurrentSpeed() {
		return this.currentSpeed;
	}
	
	private double currentSpeed = 0.0;
	
	/**
	 * Attack the defender.
	 * 
	 * @param 	defender
	 * 			The unit to attack.
	 * @pre 	... 
	 * 			| this.canStopResting()
	 * 			| ((Math.abs(this.getCubeCoordinate[0] - defender.getCubeCoordinate[0]) <= 1) 
	 * 			|	&& (Math.abs(this.getCubeCoordinate[1] - defender.getCubeCoordinate[1]) <= 1)
				|	&& (Math.abs(this.getCubeCoordinate[2] - defender.getCubeCoordinate[2]) <= 1))
	 * 			| this != defender
	 * @effect	...
	 * 	 		| defender.setOrientation(Math.atan2(this.getPosition()[1] - defender.getPosition()[1],
	 *			|			this.getPosition()[0] - defender.getPosition()[0]))
	 *			| setOrientation (atan2(defender.getPosition()[1] - this.getPosition()[1],
	 *			|			defender.getPosition()[0] - this.getPosition()[0]))
	 * 		
	 * @post	...
	 * 			| new this.attacking == true
	 *			| defender.defending == true;
	 *			| defender.attacker == this;
	 * 
	 */
	public void attack(Unit defender) {
		if ((this != defender) && (canStopResting()) && (!this.isAttacking())){
				int[] myCube = this.getCubeCoordinate();
				int[] defCube = defender.getCubeCoordinate();
				if ((Math.abs(myCube[0] - defCube[0]) <= 1) && (Math.abs(myCube[1] - defCube[1]) <= 1)
						&& (Math.abs(myCube[2] - defCube[2]) <= 1)) {
					this.stopBehavior();
					defender.stopBehavior();
					this.attacking = true;
					this.setOrientation(Math.atan2(defender.getPosition()[1] - this.getPosition()[1],
							defender.getPosition()[0] - this.getPosition()[0]));
					defender.setOrientation(Math.atan2(this.getPosition()[1] - defender.getPosition()[1],
							this.getPosition()[0] - defender.getPosition()[0]));
					defender.defend(this);
				}
			}
	}
	
	
	/**
	 * Check whether the unit is attacking.
	 * 
	 */
	public boolean isAttacking() {
		return this.attacking;
	}

	private boolean attacking = false;
	
	/**
	 * Make the unit defend against it's attacker.
	 * 
	 * @effect	...
	 * 			| if ((!attemptDodge(this.attacker)) && (!attemptBlock(this.attacker)))
	 * 			| 	then this.substractHitpoints(this.attacker.getStrength() / 10)
	 * @post 	... 
	 * 		 	| new.attacker.attacking == false
	 *		 	| new.defending == false
	 *		 	| new.attacker == null
	 *			| new.moving = true
	 * 
	 */
	private void defend(Unit attacker) {
		if ((!attemptDodge(attacker)) && (!attemptBlock(attacker)))
			this.substractHitpoints(attacker.getStrength() / 10);
		this.defending = false;
		if (this.globalTarget != null)
			this.moveTo(new int[] {(int) this.globalTarget[0], (int) this.globalTarget[1], (int) this.globalTarget[2]});

	}
	
	/**
	 * Check whether the unit is defending.
	 * 
	 */
	public boolean isDefending() {
		return this.defending;
	}

	private boolean defending = false;
	
	/**
	 * Check whether the unit succeeds in dodging.
	 * 
	 * @param	attacker
	 * 			The unit against which a dodge is attempted.
	 * @effect	...
	 * 			| randNumber = rand.nextInt(99) + 1
	 * 			| double randNumber1 = random.nextInt(200) - 100.0;
				| double randNumber2 = random.nextInt(200) - 100.0;
	 *			| if (0.2 * this.getAgility() / attacker.getAgility()*100 >= randNumber)
	 * 			| 	then setPosition({ this.getPosition()[0] + randNumber1 / 100,
	 *			|		this.getPosition()[1] + randNumber2 / 100, this.getPosition()[2]})

	 * @return 	... 
	 * 			| if (0.2 * this.getAgility() / attacker.getAgility()*100 >= randNumber)
	 * 			| 	then result == true
	 * 			| else 
	 * 			|	then result == false
	 */
	private boolean attemptDodge(Unit attacker) {
		Random rand = new Random();
		int randNumber = rand.nextInt(99) + 1;
		double dodgeChance = 0.2 * this.getAgility() / attacker.getAgility();
		if (dodgeChance * 100 >= randNumber) {
			double[] newPos = null;
			while ((newPos == null)||(!isValidPosition(newPos))) {
				Random random = new Random();
				double randNumber1 = random.nextInt(200) - 100.0;
				double randNumber2 = random.nextInt(200) - 100.0;
				newPos = new double[] { this.getPosition()[0] + randNumber1 / 100.0,
						this.getPosition()[1] + randNumber2 / 100.0, this.getPosition()[2] };
				System.out.println(newPos[0]);
				System.out.println(newPos[1]);
				System.out.println(newPos[2]);
			}
			this.setPosition(newPos);
			return true;
		} else
			return false;
	}
	
	/**
	 * Check whether the unit succeeds in blocking.
	 * 
	 * @param	attacker
	 * 			The unit against which a block is attempted.
	 * @return 	...
	 * 			| randNumber = rand.nextInt(99) + 1
	 * 			| if (0.25 * (this.getAgility() + this.getStrength()) / (attacker.getAgility() + attacker.getStrength())*100 >= randNumber)
	 * 			| 	then result == true
	 * 			| else 
	 * 			|	result == false
	 */
	private boolean attemptBlock(Unit attacker) {
		Random rand = new Random();
		int randNumber = rand.nextInt(99) + 1;
		double blockChance = 0.25 * (this.getAgility() + this.getStrength())
				/ (attacker.getAgility() + attacker.getStrength());
		if (blockChance * 100 >= randNumber)
			return true;
		else
			return false;
	}
	
	/**
	 * Set the unit's activity on resting.
	 * 
	 * @effect 	...
	 * 			The unit stops whatever it is doing right now
	 * 			| stopBehavior()
	 * @post 	... 
	 * 			The unit has started resting.
	 * 		 	| new.resting == true
	 */
	public void rest() {
		this.stopBehavior();
		this.resting = true;
	}
	
	/**
	 * Check whether the unit is resting or not.
	 * 
	 * @return	...
	 * 			The result is true if the unit is resting.
	 * 			It is false otherwise.
	 * 			| result == this.resting
	 */
	@Basic
	public boolean isResting() {
		return this.resting;
	}

	private boolean resting = false;
	
	/**
	 * Set the unit's activity on working.
	 * 
	 * @pre		...
	 * 			The unit must be able to stop resting.
	 * 			| this.canStopResting()
	 * @effect 	...
	 * 			The unit stops whatever it is doing right now.
	 * 			| stopBehavior()
	 * @post 	... 
	 * 			The unit is now working.
	 * 		 	| new.working == true
	 * 
	 */
	public void work() {
		this.stopBehavior();
		if (canStopResting())
			this.working = true;
	}
	
	/**
	 * Check whether the unit is working or not.
	 * 
	 * @return	...
	 * 			The result is true if the unit is resting,
	 * 			it is false otherwise.
	 */
	public boolean isWorking() {
		return this.working;
	}

	private boolean working = false;
	
	/**
	 * Set the unit's activity on defaultBehavior.
	 * 
	 * @param	value
	 * 			The value that indicates whether or not to acivate default behavior.
	 * @effect 	...
	 * 			If the given value is true, then the unit starts its default
	 * 			behavior. If it is false, then it stops it's default behavior.
	 * 			| if (value)
	 * 			| 	then startDefaultBehavior()
	 * 			| else 
	 * 			|	then stopBehavior()
	 */
	public void setDefaultBehavior(boolean value) {
		this.defaultBehavior = value;
		if (value) {
			this.startDefaultBehavior();
		}
		if (!value)
			this.stopBehavior();
	}
	
	/**
	 * Set the unit's activity on a random activity.
	 * 
	 * @effect	...
	 * 			The unit either starts working, moving to a random position
	 * 			or resting.
	 * 			| cap = 2
	 * 			| if ((this.getHitpoints() == this.getMaxPoints()) && (this.getStaminapoints() == this.getMaxPoints()))
	 * 			|	then cap = 1
	 * 			| Random rand = new Random()
	 * 			| randNumber = rand.nextInt(cap)
	 * 			| if (randNumber == 0) {
	 *			|	then Random randx = new Random();
	 *			|	int randNumberx = randx.nextInt(xMax - 1);
	 *			|	Random randy = new Random();
	 *			|	int randNumbery = randy.nextInt(yMax - 1);
	 *			|	Random randz = new Random();
	 *			|	int randNumberz = randz.nextInt(zMax - 1);
	 *			|	moveTo(new int[] { randNumberx, randNumbery, randNumberz });
	 *			| if (randNumber == 1)
	 *			| 	then work();
	 *			| if (randNumber == 2) {
	 *			| 	then rest();
	 */
	private void startDefaultBehavior() {
		int cap = 2;
		if ((this.getHitpoints() == this.getMaxPoints()) && (this.getStaminapoints() == this.getMaxPoints())) {
			cap = 1;
		}
		Random rand = new Random();
		int randNumber = rand.nextInt(cap);
		if (randNumber == 0) {
			Random randx = new Random();
			int randNumberx = randx.nextInt(xMax - 1);
			Random randy = new Random();
			int randNumbery = randy.nextInt(yMax - 1);
			Random randz = new Random();
			int randNumberz = randz.nextInt(zMax - 1);
			this.moveTo(new int[] { randNumberx, randNumbery, randNumberz });
		}

		if (randNumber == 1)
			this.work();

		if (randNumber == 2) {
			this.rest();
		}

	}
	
	/**
	 * Stop the units Behavior.
	 * 
	 * @post 	...
	 * 			The unit has stopped whatever it was doing.
	 * 			| new.moving == false
	 * 			| new.working == false
	 * 			| if (this.hasRestedHitpoint)
	 * 			| 	then new.resting == false
	 * 
	 */
	private void stopBehavior() {
		this.moving = false;
		this.working = false;
		if (this.hasRestedHitpoint)
			this.resting = false;
	}
	
	/**
	 * Check whether the unit has defaultBehaviorEnabled().
	 * 
	 * @return	...
	 * 			If the unit's default behavior is enabled, the
	 * 			result is true. If it is not the case then it
	 * 			is false.
	 * 			| result == this.defaultBehavior
	 */
	@Basic
	public boolean isDefaultBehaviorEnabled() {
		return this.defaultBehavior;
	}

	private boolean defaultBehavior = false;

}

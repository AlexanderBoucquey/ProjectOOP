package hillbillies.part1.facade;

import hillbillies.model.Unit;
import hillbillies.part1.facade.IFacade;
import ogp.framework.util.ModelException;

public class Facade implements IFacade {

	@Override
	public Unit createUnit(String name, int[] initialPosition, int weight, int agility, int strength, int toughness,
			boolean enableDefaultBehavior) throws ModelException {
		try{
			Unit newUnit = new Unit(name, initialPosition, weight, agility, strength, toughness);
			return newUnit;}
		catch (IllegalArgumentException e){
			throw new ModelException();
		}
	}

	@Override
	public double[] getPosition(Unit unit) throws ModelException {
		return unit.getPosition();
		
	}

	@Override
	public int[] getCubeCoordinate(Unit unit) throws ModelException {
		return null;
	}

	@Override
	public String getName(Unit unit){
		return unit.getName();
	}

	@Override
	public void setName(Unit unit, String newName) throws ModelException {
		try{
		unit.setName(newName);}
		catch (IllegalArgumentException e){
			throw new ModelException();
		}
		
	}

	@Override
	public int getWeight(Unit unit){
		return unit.getWeight();
	}

	@Override
	public void setWeight(Unit unit, int newValue){
		unit.setWeight(newValue, 200);
		
	}

	@Override
	public int getStrength(Unit unit){
		return unit.getStrength();
	}

	@Override
	public void setStrength(Unit unit, int newValue){
		unit.setStrength(newValue, 1, 200);
		
	}

	@Override
	public int getAgility(Unit unit){
		return unit.getAgility();
	}

	@Override
	public void setAgility(Unit unit, int newValue){
		unit.setAgility(newValue, 1, 200);
		
	}

	@Override
	public int getToughness(Unit unit){
		return unit.getToughness();
	}

	@Override
	public void setToughness(Unit unit, int newValue){
		unit.setToughness(newValue, 1, 200);
		
	}

	@Override
	public int getMaxHitPoints(Unit unit){
		return unit.getMaxPoints();
	}

	@Override
	public int getCurrentHitPoints(Unit unit){
		return unit.getHitpoints();
	}

	@Override
	public int getMaxStaminaPoints(Unit unit){
		return unit.getMaxPoints();
	}

	@Override
	public int getCurrentStaminaPoints(Unit unit){
		return unit.getStaminapoints();
	}

	@Override
	public void advanceTime(Unit unit, double dt) throws ModelException {
		try{
		unit.advanceTime(dt);}
		catch (IllegalArgumentException e){
			throw new ModelException();
		}
		
	}

	@Override
	public void moveToAdjacent(Unit unit, int dx, int dy, int dz) throws ModelException {
		try{
		unit.moveToAdjacent(dx, dy, dz);}
		catch (IllegalArgumentException e){
			throw new ModelException();
		}
	}

	@Override
	public double getCurrentSpeed(Unit unit){
		return unit.getCurrentSpeed();
	}

	@Override
	public boolean isMoving(Unit unit){
		return unit.isMoving();
	}

	@Override
	public void startSprinting(Unit unit){
		unit.startSprinting();
		
	}

	@Override
	public void stopSprinting(Unit unit){
		unit.stopSprinting();
		
	}

	@Override
	public boolean isSprinting(Unit unit){
		return unit.isSprinting();
	}

	@Override
	public double getOrientation(Unit unit){
		return unit.getOrientation();
	}

	@Override
	public void moveTo(Unit unit, int[] cube) throws ModelException {
		try{
		unit.moveTo(cube);}
		catch (IllegalArgumentException e){
			throw new ModelException();
		}
	}

	@Override
	public void work(Unit unit){
		unit.work();
	}

	@Override
	public boolean isWorking(Unit unit){
		return unit.isWorking();
	}

	@Override
	public void fight(Unit attacker, Unit defender){
		attacker.attack(defender);
		
	}

	@Override
	public boolean isAttacking(Unit unit){
		return unit.isAttacking();
	}

	@Override
	public void rest(Unit unit){
		unit.rest();
		
	}

	@Override
	public boolean isResting(Unit unit){
		return unit.isResting();
	}

	@Override
	public void setDefaultBehaviorEnabled(Unit unit, boolean value){
		unit.setDefaultBehavior(value);
		
	}

	@Override
	public boolean isDefaultBehaviorEnabled(Unit unit){
		return unit.isDefaultBehaviorEnabled();
	} 

}

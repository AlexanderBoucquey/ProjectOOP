package hillbillies.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ogp.framework.util.Util;

public class UnitTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
	}

	private Unit testunit;

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isValidName_DoubleQuote() {
		assertTrue(Unit.isValidName("James O\"Hara"));
	}

	@Test
	public void isValidName_SingleQuote() {
		assertTrue(Unit.isValidName("James O'Hara"));
	}

	@Test
	public void isValidName_FirstLetterNotUppercase() {
		assertFalse(Unit.isValidName("james O'Hara"));
	}

	@Test
	public void isValidName_NameTooShort() {
		assertFalse(Unit.isValidName("J"));
	}

	@Test
	public void isValidName_EmptyName() {
		assertFalse(Unit.isValidName(""));
	}

	@Test
	public void isValidName_IllegalCharacter() {
		assertFalse(Unit.isValidName("James!"));
	}

	@Test
	public void isValidAttribute_StatTooLow() {
		assertFalse(Unit.isValidAttribute(1, 25, 100));
	}

	@Test
	public void isValidAttribute_StatInRange() {
		assertTrue(Unit.isValidAttribute(50, 25, 100));
	}

	@Test
	public void isValidAttribute_StatLowerBorder() {
		assertTrue(Unit.isValidAttribute(25, 25, 100));
	}

	@Test
	public void isValidAttribute_StatUpperBorder() {
		assertTrue(Unit.isValidAttribute(100, 25, 100));
	}

	@Test
	public void isValidattribute_StatTooHigh() {
		assertFalse(Unit.isValidAttribute(200, 25, 100));
	}

	@Test
	public void setStrength_StatTooHigh() {
		testunit.setStrength(200, 25, 100);
		assertEquals(100, testunit.getStrength());
	}

	@Test
	public void setStrength_StatTooLow() {
		testunit.setStrength(1, 25, 100);
		assertEquals(25, testunit.getStrength());
	}

	@Test
	public void setStrength_StatInRange() {
		testunit.setStrength(75, 25, 100);
		assertEquals(75, testunit.getStrength());
	}

	@Test
	public void setStrength_StatLowerBorder() {
		testunit.setStrength(25, 25, 100);
		assertEquals(25, testunit.getStrength());
	}

	@Test
	public void setStrength_StatUpperBorder() {
		testunit.setStrength(100, 25, 100);
		assertEquals(100, testunit.getStrength());
	}

	@Test
	public void setAgility_StatTooHigh() {
		testunit.setAgility(200, 25, 100);
		assertEquals(100, testunit.getAgility());
	}

	@Test
	public void setAgility_StatTooLow() {
		testunit.setAgility(1, 25, 100);
		assertEquals(25, testunit.getAgility());
	}

	@Test
	public void setAgility_StatInRange() {
		testunit.setAgility(75, 25, 100);
		assertEquals(75, testunit.getAgility());
	}

	@Test
	public void setAgility_StatLowerBorder() {
		testunit.setAgility(25, 25, 100);
		assertEquals(25, testunit.getAgility());
	}

	@Test
	public void setAgility_StatUpperBorder() {
		testunit.setAgility(100, 25, 100);
		assertEquals(100, testunit.getAgility());
	}

	@Test
	public void setToughness_StatTooHigh() {
		testunit.setToughness(200, 25, 100);
		assertEquals(100, testunit.getToughness());
	}

	@Test
	public void setToughness_StatTooLow() {
		testunit.setToughness(1, 25, 100);
		assertEquals(25, testunit.getToughness());
	}

	@Test
	public void setToughness_StatInRange() {
		testunit.setToughness(75, 25, 100);
		assertEquals(75, testunit.getToughness());
	}

	@Test
	public void setToughness_StatLowerBorder() {
		testunit.setToughness(25, 25, 100);
		assertEquals(25, testunit.getToughness());
	}

	@Test
	public void setToughness_StatUpperBorder() {
		testunit.setToughness(100, 25, 100);
		assertEquals(100, testunit.getToughness());
	}

	@Test
	public void setWeight_StatTooHigh() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.setWeight(200, 100);
		assertEquals(100, testunit.getWeight());
	}

	@Test
	public void setWeight_StatTooLow() {
		testunit.setWeight(1, 100);
		assertEquals(50, testunit.getWeight());
	}

	@Test
	public void setWeight_StatInRange() {
		testunit.setWeight(75, 100);
		assertEquals(75, testunit.getWeight());
	}

	@Test
	public void setWeight_StatLowerBorder() {
		testunit.setWeight(50, 100);
		assertEquals(50, testunit.getWeight());
	}

	@Test
	public void setWeight_StatUpperBorder() {
		testunit.setWeight(100, 100);
		assertEquals(100, testunit.getWeight());
	}

	@Test
	public void getMaxPoints() {
		assertEquals(50, testunit.getMaxPoints());
	}

	@Test
	public void getHitpoints() {
		assertEquals(50, testunit.getHitpoints());
	}

	@Test
	public void getStaminaPoints() {
		assertEquals(50, testunit.getStaminapoints());
	}

	@Test
	public void isValidPoints_MaxPoints() {
		assertTrue(testunit.isValidPoints(50));
	}

	@Test
	public void isValidPoints_MinPoints() {
		assertTrue(testunit.isValidPoints(0));
	}

	@Test
	public void isValidPoints_NormalPoints() {
		assertTrue(testunit.isValidPoints(25));
	}
	
	@Test
	public void isValidPoints_NegativePoints() {
		assertFalse(testunit.isValidPoints(-25));
	}
	
	@Test
	public void isValidPoints_TooHigh() {
		assertFalse(testunit.isValidPoints(75));
	}

	@Test
	public void getCubeCoordinate_Corner() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		assertEquals(0, testunit.getCubeCoordinate()[0]);
		assertEquals(0, testunit.getCubeCoordinate()[1]);
		assertEquals(0, testunit.getCubeCoordinate()[2]);
	}

	@Test
	public void getCubeCoordinate_NormalPos() {
		testunit = new Unit("James O'Hara", new int[] { 25, 26, 27 }, 50, 50, 50, 50);
		assertEquals(25, testunit.getCubeCoordinate()[0]);
		assertEquals(26, testunit.getCubeCoordinate()[1]);
		assertEquals(27, testunit.getCubeCoordinate()[2]);
	}

	@Test
	public void moveToAdjacent_NonValidPos() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		try {
			testunit.moveToAdjacent(-1, -1, -1);
			assertFalse(true);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void moveToAdjacent_ValidPos() {
		testunit.moveToAdjacent(1, 1, 1);
		testunit.advanceTime(2);
		assertEquals(1, testunit.getCubeCoordinate()[0]);
		assertEquals(1, testunit.getCubeCoordinate()[1]);
		assertEquals(1, testunit.getCubeCoordinate()[2]);
	}

	@Test
	public void moveToAdjacent_NonValidArgument() {
		try {
			testunit.moveToAdjacent(2, 2, 2);
			assertFalse(true);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void getCurrentSpeed_NotMoving() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		assertTrue(testunit.getCurrentSpeed() == 0.0);
	}

	@Test
	public void getCurrentSpeed_MovingNonVertical() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.moveToAdjacent(1, 1, 0);
		assertTrue(testunit.getCurrentSpeed() == 1.5);
	}

	@Test
	public void getCurrentSpeed_MovingUp() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.moveToAdjacent(1, 1, 1);
		assertTrue(testunit.getCurrentSpeed() == 0.75);
	}

	@Test
	public void getCurrentSpeed_MovingDown() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 10 }, 50, 50, 50, 50);
		testunit.moveToAdjacent(1, 1, -1);
		assertTrue(Util.fuzzyEquals(testunit.getCurrentSpeed(), 1.8));
	}

	@Test
	public void getCurrentSpeed_Sprinting() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.startSprinting();
		testunit.moveToAdjacent(1, 1, 0);
		assertTrue(testunit.getCurrentSpeed() == 3.0);
	}

	@Test
	public void isMoving_NotMoving() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		assertFalse(testunit.isMoving());

	}

	@Test
	public void isMoving_Moving() {
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.moveToAdjacent(1, 1, 1);
		assertTrue(testunit.isMoving());

	}
	
	@Test
	public void startSprinting_isSprintingTrue(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.startSprinting();
		assertTrue(testunit.isSprinting());
	}
	
	@Test
	public void stopSprinting_isSprintingFalse(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.startSprinting();
		testunit.stopSprinting();
		assertFalse(testunit.isSprinting());
	}
	
	@Test
	public void getOrientation_DefaultOrientation(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		assertTrue(testunit.getOrientation() == Math.PI/2.0);

	}
	
	@Test
	public void getOrientation_MovingOrientation(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.moveToAdjacent(1, 1, 0);
		assertTrue(testunit.getOrientation() == Math.PI/4);

	}
	
	@Test
	public void moveTo_NotMove(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.moveTo(testunit.getCubeCoordinate());
		testunit.advanceTime(2.0);
		assertTrue(testunit.getCubeCoordinate()[0] == 0);
		assertTrue(testunit.getCubeCoordinate()[1] == 0);
		assertTrue(testunit.getCubeCoordinate()[1] == 0);
	}
	
	@Test
	public void moveTo_Move(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.moveTo(new int[] {5, 2, 1});
		for(int i=0; i < 20; i++){
			testunit.advanceTime(1.0);}
		assertEquals(testunit.getCubeCoordinate()[0], 5);
		assertEquals(testunit.getCubeCoordinate()[1], 2);
		assertEquals(testunit.getCubeCoordinate()[2], 1);
	}
	
	@Test
	public void moveTo_IllegalPos(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		try{
			testunit.moveTo(new int[] {-1,-1,-1});
			assertFalse(true);
		}
		catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void work_NotYetWorking_isWorking(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		assertFalse(testunit.isWorking());
		testunit.work();
		assertTrue(testunit.isWorking());
	}
	
	@Test
	public void work_YetWorking_isWorking(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.work();
		assertTrue(testunit.isWorking());
		testunit.work();
		assertTrue(testunit.isWorking());
	}
	
	@Test
	public void attack_DefenderInRange_isAttacking(){
		testunit1 = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit2 = new Unit("John Smith", new int[] { 1, 1, 1 }, 50, 50, 50, 50);
		testunit1.attack(testunit2);
		assertTrue(testunit1.isAttacking());

	}
	
	private Unit testunit1;
	private Unit testunit2;
	
	@Test
	public void attack_DefenderOutOfRange_isAttacking(){
		testunit1 = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit2 = new Unit("John Smith", new int[] { 2, 15, 4 }, 50, 50, 50, 50);
		testunit1.attack(testunit2);
		assertFalse(testunit1.isAttacking());

	}
	
	@Test
	public void rest_NotYetResting_isResting(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		assertFalse(testunit.isResting());
		testunit.rest();
		assertTrue(testunit.isResting());
	}
	
	@Test
	public void work_YetResting_isResting(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.rest();
		assertTrue(testunit.isResting());
		testunit.rest();
		assertTrue(testunit.isResting());
	}
	
	@Test
	public void setDefaultBehaviour_True_isDefaultBehaviorEnabled(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.setDefaultBehavior(true);
		assertTrue(testunit.isDefaultBehaviorEnabled());

	}
	
	@Test
	public void setDefaultBehaviour_False_isDefaultBehaviorEnabled(){
		testunit = new Unit("James O'Hara", new int[] { 0, 0, 0 }, 50, 50, 50, 50);
		testunit.setDefaultBehavior(false);
		assertFalse(testunit.isDefaultBehaviorEnabled());

	}
	
	
}

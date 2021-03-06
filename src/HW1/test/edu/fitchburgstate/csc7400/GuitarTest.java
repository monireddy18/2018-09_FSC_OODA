/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 1 
 * Date			: 2018-09-15
 * Students		: Mounika Pailla (@01393337)
 */
package HW1.test.edu.fitchburgstate.csc7400;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HW1.edu.fitchburgstate.csc7400.Guitar;
/**
 * GuitarTest contains test methods to test all the methods present in Guitar class.
 * This class creates mock data and calls the test methods using this data.
 * 
 * @author Mounika Pailla
 * @version 1.0 
 */
class GuitarTest {
	
	Guitar testGuitar;

	/**
	   * 
	   * Sets up the mock guitar object with data
	   * 
	   */
	@BeforeEach
	void setUp() throws Exception {
		this.testGuitar = new Guitar(
				"AB123", // serial number
				203.35, // store price
				"Gibson", // Manufacturer
				"EasyLearn", // Manufacturer model
				"electric", // Type of Guitar
				"Maple", // Back wood
				"Adirondack" // Face wood
				);
	}

	/**
	   * 
	   * Tests getSerialNumber() method in Guitar class
	   * Test fails if the serial number returned doesn't match with the mock object's serial number
	   * 
	   */
	@Test
	void testGetSerialNumber() {
		String expected = "AB123";
		String returned = this.testGuitar.getSerialNumber();
		assertEquals(expected, returned, String.format("Serial number %s != %s", expected, returned));
	}

	/**
	   * 
	   * Tests getPrice() method in Guitar class
	   * Test fails if the price of the guitar returned doesn't match with the mock guitar's price
	   * 
	   */
	@Test
	void testGetPrice() {
		double expected = 203.35;
		double returned = this.testGuitar.getPrice();
		assertEquals(expected, returned, 0.01, String.format("Price %f != %f", expected, returned));
	}

	/**
	   * 
	   * Tests setPrice() method in Guitar class
	   * Test fails if the price returned doesn't match with the price that is set using setPrice()
	   * 
	   */
	@Test
	void testSetPrice() {
		double expected = 225.10;
		this.testGuitar.setPrice(expected);
		double returned = this.testGuitar.getPrice();
		assertEquals(expected, returned, String.format("Price %f != %f", expected, returned));
	}

	/**
	   * 
	   * Tests getManufacturer() method in Guitar class
	   * Test fails if the guitar's manufacturer returned doesn't match with the mock guitar's manufacturer
	   * 
	   */
	@Test
	void testGetManufacturer() {
		String expected = "Gibson";
		String returned = this.testGuitar.getManufacturer();
		assertEquals(expected, returned, String.format("Manufacturer %s != %s", expected, returned));
	}

	/**
	   * 
	   * Tests getModel() method in Guitar class
	   * Test fails if the guitar's model returned doesn't match with the mock guitar's model
	   * 
	   */
	@Test
	void testGetModel() {
		String expected = "EasyLearn";
		String returned = this.testGuitar.getModel();
		assertEquals(expected, returned, String.format("Model %s != %s", expected, returned));
	}

	/**
	   * 
	   * Tests getType() method in Guitar class
	   * Test fails if the guitar's type returned doesn't match with the mock guitar's type
	   * 
	   */
	@Test
	void testGetType() {
		String expected = "electric";
		String returned = this.testGuitar.getType();
		assertEquals(expected, returned, String.format("Type %s != %s", expected, returned));
	}

	/**
	   * 
	   * Tests getBackWood() method in Guitar class
	   * Test fails if the guitar's backwood returned doesn't match with the mock guitar's backwood
	   * 
	   */
	@Test
	void testGetBackWood() {
		String expected = "Maple";
		String returned = this.testGuitar.getBackWood();
		assertEquals(expected, returned, String.format("Back wood %s != %s", expected, returned));
	}

	/**
	   * 
	   * Tests getTopWood() method in Guitar class	   *
	   * Test fails if the guitar's topwood returned doesn't match with the mock guitar's topwood
	   *  
	   */
	@Test
	void testGetTopWood() {
		String expected = "Adirondack";
		String returned = this.testGuitar.getTopWood();
		assertEquals(expected, returned, String.format("Top wood %s != %s", expected, returned));
	}
}

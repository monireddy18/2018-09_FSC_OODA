/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2 
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */
package HW1.test.edu.fitchburgstate.csc7400;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HW1.edu.fitchburgstate.csc7400.Guitar;
import HW1.edu.fitchburgstate.csc7400.GuitarSpec;
import HW1.edu.fitchburgstate.csc7400.Manufacturer;
import HW1.edu.fitchburgstate.csc7400.Type;
import HW1.edu.fitchburgstate.csc7400.Wood;
/**
 * GuitarTest contains test methods to test all the methods present in Guitar class.
 * This class creates mock data and calls the test methods using this data.
 * 
 * @author Mounika Pailla
 * @version 1.1
 */
class GuitarTest {
	
	Guitar testGuitar;

	/**
	   * 
	   * Sets up the mock guitar object with data
	   * 
	   * @param nothing
	   * @return void
	   */
	@BeforeEach
	void setUp() throws Exception {
		this.testGuitar = new Guitar(
				"AB123", // serial number
				203.35, // store price
				Manufacturer.Gibson, // Manufacturer
				"EasyLearn", // Manufacturer model
				Type.Electric, // Type of Guitar
				Wood.Maple, // Back wood
				Wood.Adirondack // Face wood
				);
	}

	/**
	   * 
	   * Tests getSerialNumber() method in Guitar class
	   * 
	   * @param nothing
	   * @return void
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
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testGetPrice() {
		double expected = 203.35;
		double returned = this.testGuitar.getPrice();
		assertEquals(expected, returned, 0.01, String.format("Price %f != %f", expected, returned));
	}

	/**
	   * 
	   * Tests getSetPrice() method in Guitar class
	   * 
	   * @param nothing
	   * @return void
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
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testGetManufacturer() {
		Manufacturer expected = Manufacturer.Gibson;
		Manufacturer returned = this.testGuitar.getSpec().getManufacturer();
		assertEquals(expected, returned, String.format("Manufacturer %s != %s", 
				expected.toString(), returned.toString()));
	}

	/**
	   * 
	   * Tests getModel() method in Guitar class
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testGetModel() {
		String expected = "EasyLearn";
		String returned = this.testGuitar.getSpec().getModel();
		assertEquals(expected, returned, String.format("Model %s != %s", expected, returned));
	}

	/**
	   * 
	   * Tests getType() method in Guitar class
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testGetType() {
		Type expected = Type.Electric;
		Type returned = this.testGuitar.getSpec().getType();
		assertEquals(expected, returned, String.format("Type %s != %s", 
				expected.toString(), returned.toString()));
	}

	/**
	   * 
	   * Tests getBackWood() method in Guitar class
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testGetBackWood() {
		Wood expected = Wood.Maple;
		Wood returned = this.testGuitar.getSpec().getBackWood();
		assertEquals(expected, returned, String.format("Back wood %s != %s", 
				expected.toString(), returned.toString()));
	}

	/**
	   * 
	   * Tests getTopWood() method in Guitar class
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testGetTopWood() {
		Wood expected = Wood.Adirondack;
		Wood returned = this.testGuitar.getSpec().getTopWood();
		assertEquals(expected, returned, String.format("Top wood %s != %s", 
				expected.toString(), returned.toString()));
	}
	
	/**
	   * 
	   * Tests getSpec() method in Guitar class
	   */
	@Test
	void testGetSpec() {
		GuitarSpec returned = this.testGuitar.getSpec();
		assertEquals(returned.getManufacturer(),Manufacturer.Gibson);
		assertEquals(returned.getBackWood(),Wood.Maple);
		assertEquals(returned.getModel(),"EasyLearn");
		assertEquals(returned.getTopWood(),Wood.Adirondack);
		assertEquals(returned.getType(),Type.Electric);
	}
}

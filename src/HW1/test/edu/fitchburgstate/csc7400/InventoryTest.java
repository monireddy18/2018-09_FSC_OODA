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
import HW1.edu.fitchburgstate.csc7400.Inventory;

/**
 * InventoryTest contains test methods to test all the methods present in Inventory class.
 * This class creates mock data and calls the test methods using this data.
 * 
 * @author Mounika Pailla
 * @version 1.0 
 */

class InventoryTest {

	Inventory testInventory;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.testInventory = new Inventory();
		testInventory.addGuitar("11277", 3999.95, "Collings", "CJ", "acoustic",
                "Indian Rosewood", "Sitka");
		testInventory.addGuitar("V95693", 1499.95, "Fender", "Stratocastor", "electric",
                "Alder", "Alder");		
	}

	/**
	   * 
	   * Tests addGuitar() method in Inventory class
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testAddGuitar() {
		String serialNumber = "AB123"; 
		double price=	203.35; 
		String builder = "Gibson"; 
		String model=	"EasyLearn"; 
		String type =	"electric"; 
		String backWood = "Maple"; 
		String topWood = "Adirondack" ;
		
		try {
		this.testInventory.addGuitar(serialNumber, price, builder, model, type, backWood, topWood);
		assertTrue(true);
		}
		catch(Exception e)
		{
			fail("Object not added");
		}
		 
	}

	/**
	   * 
	   * Tests getGuitar() method in Inventory class
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testGetGuitar() {
		String serialNumber = "11277";
		Guitar expected = new Guitar("11277", 3999.95, "Collings", "CJ", "acoustic",
                "Indian Rosewood", "Sitka");
		Guitar returned = this.testInventory.getGuitar(serialNumber);
		assertEquals(expected.getSerialNumber(), returned.getSerialNumber());
		assertEquals(expected.getBackWood(), returned.getBackWood());
		assertEquals(expected.getManufacturer(), returned.getManufacturer());
		assertEquals(expected.getModel(), returned.getModel());
		assertEquals(expected.getPrice(), returned.getPrice());
		assertEquals(expected.getTopWood(), returned.getTopWood());
		
		
	}

	/**
	   * 
	   * Tests addGuitar() method in Inventory class
	   * 
	   * @param nothing
	   * @return void
	   */
	@Test
	void testSearch() {
		Guitar searchGuitar = new Guitar("V95693", 1499.95, "Fender", "Stratocastor", "electric",
                "Alder", "Alder");
		Guitar expected = new Guitar("V95693", 1499.95, "Fender", "Stratocastor", "electric",
                "Alder", "Alder");
		Guitar returned = this.testInventory.search(searchGuitar);
		assertEquals(expected.getSerialNumber(), returned.getSerialNumber());
		assertEquals(expected.getBackWood(), returned.getBackWood());
		assertEquals(expected.getManufacturer(), returned.getManufacturer());
		assertEquals(expected.getModel(), returned.getModel());
		assertEquals(expected.getPrice(), returned.getPrice());
		assertEquals(expected.getTopWood(), returned.getTopWood());
		}
	
	

}

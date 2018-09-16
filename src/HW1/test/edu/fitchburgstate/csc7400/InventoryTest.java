/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 1 
 * Date			: 2018-09-15
 * Students		: Mounika Pailla (@01393337)
 */

package HW1.test.edu.fitchburgstate.csc7400;

import static org.junit.jupiter.api.Assertions.*;
import HW1.edu.fitchburgstate.csc7400.Guitar;
import HW1.edu.fitchburgstate.csc7400.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * InventoryTest contains test methods to test all the methods present in Inventory class.
 * InventoryTest has test objects of inventory and guitar classes.
 * Contains tests to test methods of Inventory class.
 * 
 * @author Mounika Pailla
 * @version 1.0 
 * 
 */
public class InventoryTest {
    Inventory testInventory;
    Guitar testGuitar;

    /**
     * Test data setup. Add guitar data to inventory
     */
    @BeforeEach
    public void setup() {
        // instantiate inventory class
        testInventory = new Inventory();

        testGuitar = new Guitar("0001", 1009.99, "Manufacturer1", "Model1", "type1",
                "backwood1", "topwood1");

        testInventory.addGuitar(testGuitar.getSerialNumber(), testGuitar.getPrice(), testGuitar.getManufacturer(),
                testGuitar.getModel(), testGuitar.getType(), testGuitar.getBackWood(), testGuitar.getTopWood());
        
    }

    /**
     * Tests getGuitar() method by passing serial number as parameter
     */
    @Test
    void test_GetGuitar_SerialNumber() {
        Guitar actual = testInventory.getGuitar(testGuitar.getSerialNumber());
        Guitar expected = testGuitar;
        assertEquals(actual.getSerialNumber(), expected.getSerialNumber());
        assertEquals(actual.getManufacturer(), expected.getManufacturer());
        assertEquals(actual.getModel(), expected.getModel());
        assertEquals(actual.getPrice(), expected.getPrice());
        assertEquals(actual.getType(), expected.getType());
        assertEquals(actual.getTopWood(), expected.getTopWood());
        assertEquals(actual.getBackWood(), expected.getBackWood());
    }

    

    /**
     * Tests if a Guitar is returned when backwood parameter is passed to search.
     */
    @Test
    void test_SearchGuitar_Backwood() {
        Guitar expected = new Guitar("", 0, "", null, null, "backwood1","");

        Guitar actual = testInventory.search(expected);
        assertEquals(actual.getBackWood(), expected.getBackWood());
    }

    /**
     * Tests if a Guitar is returned when topwood parameter is passed to search 
     */
    @Test
    void test_SearchGuitar_Topwood() {
        Guitar expected = new Guitar("", 0, "", null, null, "","topwood1");

        Guitar actual = testInventory.search(expected);
        assertEquals(actual.getTopWood(), expected.getTopWood());
    }

    /**
     * Tests if a Guitar is returned when model parameter is passed to search
     */
    @Test
    void test_SearchGuitar_Model() {
        Guitar expected = new Guitar("", 0, "", "Model1", null,
                "", "");

        Guitar actual = testInventory.search(expected);
        assertEquals(actual.getModel(), expected.getModel());
    }

    /**
     * Tests if a Guitar is returned when type parameter is passed to search
     */
    @Test
    void test_SearchGuitar_Type() {
        Guitar expected = new Guitar("", 0, "", null, "type1",
                "", "");

        Guitar actual = testInventory.search(expected);
        assertEquals(actual.getType(), expected.getType());
    }

    /**
     * Tests if a Guitar is returned when manufacturer name is passed to search
     */
    @Test
    void test_SearchGuitar_Manufacturer() {
        Guitar expected = new Guitar("", 0, "Manufacturer1", "", null,
                "", "");

        Guitar actual = testInventory.search(expected);
        assertEquals(actual.getManufacturer(), expected.getManufacturer());
    }

    /**
     * Tests search method by passing a manufacturer of a guitar that is not preset in the inventory
     */
    @Test
    void test_SearchGuitar_UnlistedManufacturer() {
        Guitar expected = new Guitar(null, 0, "MP", null, null, null, null);

        Guitar actual = testInventory.search(expected);
        assertEquals(null, actual);
    }

    /**
     * Tests search method by passing a model of a guitar that is not preset in the inventory
     */
    @Test
    void test_SearchGuitar_UnlistedModel() {
        Guitar expected = new Guitar(null, 0, null, "model2", null,
                null, null);

        Guitar actual = testInventory.search(expected);
        assertEquals(null, actual);
    }

    /**
     * Tests search method by passing a type of a guitar that is not preset in the inventory
     */
    @Test
    void test_SearchGuitar_UnlistedType() {
        Guitar expected = new Guitar(null, 0, null, null, "type2",
                null, null);

        Guitar actual = testInventory.search(expected);
        assertEquals(null, actual);
    }

    /**
     * Tests search method by passing a backwood of a guitar that is not preset in the inventory
     */
    @Test
    void test_SearchGuitar_UnlistedBackwood() {
        Guitar expected = new Guitar(null, 0, null, null, null,
                "backwood2", null);

        Guitar actual = testInventory.search(expected);
        assertEquals(null, actual);
    }

    /**
     * Tests search method by passing a topwood of a guitar that is not preset in the inventory
     */
    @Test
    void test_SearchGuitar_UnlistedTopwood() {
        Guitar expected = new Guitar(null, 0, null, null, null,
                "", "topwood2");

        Guitar actual = testInventory.search(expected);
        assertEquals(null, actual);
    }   
    

        
    }



/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2 
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */

package HW1.test.edu.fitchburgstate.csc7400;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import HW1.edu.fitchburgstate.csc7400.Guitar;
import HW1.edu.fitchburgstate.csc7400.GuitarSpec;
import HW1.edu.fitchburgstate.csc7400.Inventory;
import HW1.edu.fitchburgstate.csc7400.Manufacturer;
import HW1.edu.fitchburgstate.csc7400.Type;
import HW1.edu.fitchburgstate.csc7400.Wood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * InventoryTest contains test methods to test all the methods present in Inventory class.
 * InventoryTest has test objects of Inventory, Guitar and GuitarSpec classes.
 * 
 * @author Mounika Pailla
 * @version 1.1 
 * 
 */
public class InventoryTest {
    Inventory testInventory;
    Guitar testGuitar;
    GuitarSpec testSpec;

    /**
     * Test data setup. Initialize Guitar's Inventory Object
     */
    @BeforeEach
    public void setup() {
        // instantiate inventory class
        testInventory = new Inventory();       
    }   
    
    /**
     * Tests addGuitar() method by passing serial number, price, manufacturer etc.
     */
    @Test
    void test_AddGuitar_CheckExistence() {    	
    	//test data is added to the inventory
        testInventory.addGuitar("SerialNo1",1000, Manufacturer.Martin, 
        		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo);  
        testInventory.addGuitar("SerialNo2",1200, Manufacturer.PRS, 
        		"Model2", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood);  
        Guitar actual1 = testInventory.getGuitar("SerialNo1");
        Guitar actual2 = testInventory.getGuitar("SerialNo2");
        
        //check if first object returned is the same as which we added
        CheckObjects(actual1, new Guitar("SerialNo1",1000, Manufacturer.Martin, 
        		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo));
        
        //check if the second object added in the inventory exists in the inventory
        CheckObjects(actual2, new Guitar("SerialNo2",1200, Manufacturer.PRS, 
        		"Model2", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood));
        
    }  
    
    /**
     * Tests getGuitar() method by passing serial number as parameter
     */
    @Test
    void test_GetGuitar_SerialNumber() {
    	//test data is added to the inventory        
    	 testGuitar = new Guitar("0001", 1009.99,Manufacturer.Collings, "Model1", Type.Accoustic,
                 Wood.Adirondack, Wood.Alder );
         testSpec = testGuitar.getSpec();
         testInventory.addGuitar(testGuitar.getSerialNumber(), testGuitar.getPrice(), testSpec.getManufacturer(),
         		testSpec.getModel(), testSpec.getType(), testSpec.getBackWood(), testSpec.getTopWood());
        Guitar actual = testInventory.getGuitar(testGuitar.getSerialNumber());       
        Guitar expected = testGuitar;
        CheckObjects(actual, expected);
    }    

    /**
     * Tests if a Guitar is returned when only manufacturer name Gibson is passed to search
     */
    @Test
    void test_SearchGuitar_ManufacturerGibson() {
    	//test data(2 guitars) to be added to the inventory of Manufacturer Gibson
    	testInventory.addGuitar("SerialNo3",100, Manufacturer.Gibson, 
        		"Model3", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood); 
    	testInventory.addGuitar("SerialNo4",100, Manufacturer.Gibson, 
        		"Model4", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood); 
    	//build guitar spec with Gibson in manufacturer and nothing else
    	GuitarSpec spec = new GuitarSpec(Manufacturer.Gibson, null, null, null,null);
        List<Guitar> actual = testInventory.search(spec);
        //test if the count of the list is 2 as two guitars are added with manufacturer name Gibson
        assertEquals(actual.size(), 2);        
        CheckObjects(actual.get(0), new Guitar("SerialNo3",100, Manufacturer.Gibson, 
        		"Model3", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood));
        CheckObjects(actual.get(1), new Guitar("SerialNo4",100, Manufacturer.Gibson, 
        		"Model4", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood));
    } 
    
    /**
     * Tests if a Guitar is returned when only manufacturer name Fender is passed to search
     */
    @Test
    void test_SearchGuitar_ManufacturerFender() {
    	//test data(2 guitars) to be added to the inventory of Manufacturer Fender
    	testInventory.addGuitar("SerialNo10",100, Manufacturer.Fender, 
        		"Model5", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood); 
    	testInventory.addGuitar("SerialNo11",100, Manufacturer.Fender, 
        		"Model6", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood); 
    	//build guitar spec with Fender in manufacturer and nothing else
    	GuitarSpec spec = new GuitarSpec(Manufacturer.Fender, null, null, null,null);
        List<Guitar> actual = testInventory.search(spec);
        //test if the count of the list is 2 as two guitars are added with manufacturer name Fender
        assertEquals(actual.size(), 2);        
        CheckObjects(actual.get(0), new Guitar("SerialNo10",100, Manufacturer.Fender, 
        		"Model5", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood));
        CheckObjects(actual.get(1), new Guitar("SerialNo11",100, Manufacturer.Fender, 
        	"Model6", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood));
    } 
    
    /**
     * Tests if a Guitar is returned when only type name Electric is passed to search
     */
    @Test
    void test_SearchGuitar_TypeElectric() {
    	//test data(2 guitars) to be added to the inventory - 1 electric and 1 accoustic
    	testInventory.addGuitar("SerialNo20",100, Manufacturer.Fender, 
        		"Model5", Type.Electric, Wood.Mahogany, Wood.Indian_Rosewood); 
    	testInventory.addGuitar("SerialNo21",100, Manufacturer.Fender, 
        		"Model6", Type.Accoustic, Wood.Mahogany, Wood.Indian_Rosewood); 
    	//build guitar spec with Electric in type and nothing else
    	GuitarSpec spec = new GuitarSpec(null, null, Type.Electric, null,null);
        List<Guitar> actual = testInventory.search(spec);
        //test if the count of the list is 1 as one guitar is added with type Electric
        assertEquals(actual.size(), 1);        
        CheckObjects(actual.get(0), new Guitar("SerialNo20",100, Manufacturer.Fender, 
        		"Model5", Type.Electric, Wood.Mahogany, Wood.Indian_Rosewood));
    } 
    
    /**
     * Tests if no Guitar is returned when multiple search criteria is passed with no matching guitar
     */
    @Test
    void test_SearchGuitar_MultipleSearchCriteriaWithNoResult() {    	
    	//test data is added to the inventory
    	testInventory.addGuitar("SerialNo20",100, Manufacturer.Fender, 
        		"Model5", Type.Electric, Wood.Mahogany, Wood.Indian_Rosewood); 
    	//build guitar spec with multiple parameters
    	GuitarSpec spec = new GuitarSpec(Manufacturer.Fender, "Stratocastor", Type.Electric, Wood.Alder,Wood.Alder);
        List<Guitar> actual = testInventory.search(spec);
        //test if the count of the list is 0 as no guitar with the required specs is in the inventory
        assertEquals(actual.size(), 0);      
    } 
    
    /**
     * Tests if a Guitar is returned when multiple search criteria is passed with a matching guitar
     */
    @Test
    void test_SearchGuitar_MultipleSearchCriteriaWithResult() {
    	//test data(1 guitars) to be added to the inventory 
    	testInventory.addGuitar("SerialNo100",100, Manufacturer.Fender, 
        		"Stratocastor", Type.Electric, Wood.Alder, Wood.Alder); 
    	//build guitar spec with multiple parameters
    	GuitarSpec spec = new GuitarSpec(Manufacturer.Fender, "Stratocastor", Type.Electric, Wood.Alder,Wood.Alder);
        List<Guitar> actual = testInventory.search(spec);
        //test if the count of the list is 1 as one guitar is added with the matching criteria
        assertEquals(actual.size(), 1);        
      //pass returned object with the inventory object which is added
        CheckObjects(actual.get(0), new Guitar("SerialNo100",100, Manufacturer.Fender, 
        		"Stratocastor", Type.Electric, Wood.Alder, Wood.Alder));
    } 
    
    /**
     * Tests if a Guitar is returned when backwood parameter is passed to search.
     */
    @Test
    void test_SearchGuitar_Backwood() {
    	//test data is added to the inventory    	
    	 testInventory.addGuitar("SerialNo1",1000, Manufacturer.Martin, 
         		"Model1", Type.Accoustic, Wood.Adirondack, Wood.Cocobolo);  
        GuitarSpec spec = new GuitarSpec(null, null, null, Wood.Adirondack,null);
        List<Guitar> actual = testInventory.search(spec);
      //pass returned object with the inventory object which is added
        CheckObjects(actual.get(0), new Guitar("SerialNo1",1000, Manufacturer.Martin, 
         		"Model1", Type.Accoustic, Wood.Adirondack, Wood.Cocobolo));
    }

    /**
     * Tests if a Guitar is returned when topwood parameter is passed to search 
     */
    @Test
    void test_SearchGuitar_Topwood() {
    	//test data is added to the inventory
    	 testInventory.addGuitar("SerialNo1",1000, Manufacturer.Martin, 
         		"Model1", Type.Accoustic, Wood.Cedar, Wood.Alder);  
    	GuitarSpec spec = new GuitarSpec(null, null, null, null,Wood.Alder);
        List<Guitar> actual = testInventory.search(spec);
        //pass returned object with the inventory object which is added
        CheckObjects(actual.get(0), new Guitar("SerialNo1",1000, Manufacturer.Martin, 
         		"Model1", Type.Accoustic, Wood.Cedar, Wood.Alder));
    }

    /**
     * Tests if a Guitar is returned when model parameter is passed to search
     */
    @Test
    void test_SearchGuitar_Model() {
    	//test data is added to the inventory    	
    	 testInventory.addGuitar("SerialNo1",1000, Manufacturer.Martin, 
         		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo);  
    	GuitarSpec spec = new GuitarSpec(null, "Model1", null, null,null);
        List<Guitar> actual = testInventory.search(spec);
      //pass returned object with the inventory object which is added
        CheckObjects(actual.get(0), new Guitar("SerialNo1",1000, Manufacturer.Martin, 
         		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo));
    }

    /**
     * Tests if a Guitar is returned when type parameter is passed to search
     */
    @Test
    void test_SearchGuitar_Type() {
    	//test data is added to the inventory    	
    	 testInventory.addGuitar("SerialNo1",1000, Manufacturer.Martin, 
         		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo);  
    	GuitarSpec spec = new GuitarSpec(null, null, Type.Accoustic, null,null);
        List<Guitar> actual = testInventory.search(spec);
        //pass returned object with the inventory object which is added
        CheckObjects(actual.get(0), new Guitar("SerialNo1",1000, Manufacturer.Martin, 
         		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo));
    }  
    
    /**
    * Tests if a Guitar is returned when price is passed to search
    */
   @Test
   void test_SearchGuitarByPrice_Price_Noresult() {
   	//test data is added to the inventory    	
   	 testInventory.addGuitar("SerialNo1",1000, Manufacturer.Martin, 
        		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo);  
   	   List<Guitar> actual = testInventory.searchGuitarsByPrice(1001);
       assertEquals(actual.size(),0);
   }  
   
   /**
    * Tests if a Guitar is returned when price is passed to search
    */
   @Test
   void test_SearchGuitarByPrice_WithResult() {
   	//test data is added to the inventory    	
   	 testInventory.addGuitar("SerialNo1",1000, Manufacturer.Martin, 
        		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo);  
   	   List<Guitar> actual = testInventory.searchGuitarsByPrice(1000);
       assertEquals(actual.size(),1);
     //pass returned object with the inventory object which is added
       CheckObjects(actual.get(0), new Guitar("SerialNo1",1000, Manufacturer.Martin, 
       		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo));
   }  
   
   /**
    * Tests if a Guitar is returned when price range is passed to search
    */
   @Test
   void test_SearchGuitarByPriceRange() {
   	//test data is added to the inventory    	
   	 testInventory.addGuitar("SerialNo1",1000, Manufacturer.Martin, 
        		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo); 
   	testInventory.addGuitar("SerialNo2",1001, Manufacturer.Martin, 
    		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo); 
   	testInventory.addGuitar("SerialNo3",2001, Manufacturer.Martin, 
    		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo); 
   	testInventory.addGuitar("SerialNo4",999, Manufacturer.Martin, 
    		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo); 
   	testInventory.addGuitar("SerialNo5",2000, Manufacturer.Martin, 
    		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo); 
   	   List<Guitar> actual = testInventory.searchGuitarsByPriceRange(1000, 2000);
   	   //3 guitars have price ranges from 1000 to 2000, so the count of the list returned should be 3
       assertEquals(actual.size(),3);
     //pass returned object with the inventory object which is added
       CheckObjects(actual.get(0), new Guitar("SerialNo1",1000, Manufacturer.Martin, 
       		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo));
       CheckObjects(actual.get(1), new Guitar("SerialNo2",1000, Manufacturer.Martin, 
          		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo));
       CheckObjects(actual.get(2), new Guitar("SerialNo5",1000, Manufacturer.Martin, 
          		"Model1", Type.Accoustic, Wood.Cedar, Wood.Cocobolo));
   }  
    
    /**
     * Checks if all the properties between two guitar objects are equal.
     * The method fails in case of inequality
     * 
     * @param guitar1, guitar2 Actual and expected guitar objects to be checked for equality for test cases
     */
    void CheckObjects(Guitar guitar1, Guitar guitar2)
    {
    	assertEquals(guitar1.getSerialNumber(), guitar2.getSerialNumber());
        assertEquals(guitar1.getPrice(), guitar1.getPrice());
        assertEquals(guitar1.getSpec().getManufacturer(), guitar1.getSpec().getManufacturer());
        assertEquals(guitar1.getSpec().getModel(), guitar1.getSpec().getModel());
        assertEquals(guitar1.getSpec().getType(), guitar1.getSpec().getType());
        assertEquals(guitar1.getSpec().getBackWood(), guitar1.getSpec().getBackWood());
        assertEquals(guitar1.getSpec().getTopWood(), guitar1.getSpec().getTopWood());
    }
}



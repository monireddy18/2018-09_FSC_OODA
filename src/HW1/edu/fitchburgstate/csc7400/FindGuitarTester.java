/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */
package HW1.edu.fitchburgstate.csc7400;

import java.util.List;

/**
 * FindGuitarTester has methods to call Guitar and Inventory classes' methods to provide
 * details of matching guitar according to customer requirements
 *
 * @author Mounika Pailla
 * @version 1.1
 */
public class FindGuitarTester {
	/**
	 * Drives the application.
	 * Populates inventory with the required data to test 
	 * Searches the inventory with specific parameters passed by the user 
	 * Returns list of guitars matching the specifications by the user
	 * Searches based on the price range, a list of guitars is returned within the specified range
	 * In case of no result returned by the search (both variations), sorry message is displayed
	 * 
	 * @param args Unused
	 * @return void
	 */
  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);
    
    GuitarSpec whatErinLikes = new GuitarSpec(Manufacturer.Fender, "Stratocastor",
                                      Type.Electric, Wood.Alder, Wood.Alder);
    //search inventory with the above mentioned criteria
    List<Guitar> guitars = inventory.search(whatErinLikes);
    if (!guitars.isEmpty()) {
    	for(Guitar guitar : guitars)
    	{
    		GuitarSpec guitarSpec = guitar.getSpec();	
    		System.out.println("Erin, you might like this " +
    				guitarSpec.getManufacturer() + " " + guitarSpec.getModel() +  " " +
    				guitarSpec.getType() + " guitar:\n   " +
    				guitarSpec.getBackWood() + " back and sides,\n   " +
    				guitarSpec.getTopWood() + " top.\nYou can have it for only $" +
    				guitar.getPrice() + "!");
    	}
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }   
    //search guitars with the price range from 1000 to 2000
    List<Guitar> guitarsWithPriceRange = inventory.searchGuitarsByPriceRange(1000, 2000);
    if (!guitarsWithPriceRange.isEmpty()) {
    	for(Guitar guitar : guitarsWithPriceRange)
    	{
    		GuitarSpec guitarSpec = guitar.getSpec();	
    		System.out.println("Guitar with " +
    				guitarSpec.getManufacturer() + " " + guitarSpec.getModel() +  " " +
    				guitarSpec.getType() + " guitar:\n   " +
    				guitarSpec.getBackWood() + " back and sides,\n   " +
    				guitarSpec.getTopWood() + " top.\nYou can have it for only $" +
    				guitar.getPrice() + "!");
    	}
    } else {
      System.out.println("Sorry, there is no guitar within the price range");
    }
    
  }

  	/**
	 * Initializes inventory data with multiple guitar details
	 *
	 * @param inventory Guitar's Inventory class object
	 */
  private static void initializeInventory(Inventory inventory) {
    inventory.addGuitar("11277", 3999.95, Manufacturer.Collings, "CJ", Type.Accoustic,
                        Wood.Indian_Rosewood, Wood.Sitka);
    inventory.addGuitar("V95693", 1499.95, Manufacturer.Fender, "Stratocastor", Type.Electric,
                        Wood.Alder, Wood.Alder);
    inventory.addGuitar("V9512", 1549.95, Manufacturer.Fender, "Stratocastor", Type.Electric,
    		Wood.Alder, Wood.Alder);
    inventory.addGuitar("122784", 5495.95, Manufacturer.Martin, "D-18", Type.Accoustic,
    		Wood.Mahogany, Wood.Adirondack);
    inventory.addGuitar("76531", 6295.95, Manufacturer.Martin, "OM-28", Type.Accoustic,
    		Wood.Brazilian_Rosewood, Wood.Adirondack);
    inventory.addGuitar("70108276", 2295.95, Manufacturer.Gibson, "Les Paul", Type.Electric,
    		Wood.Mahogany, Wood.Maple);
    inventory.addGuitar("82765501", 1890.95, Manufacturer.Gibson, "SG '61 Reissue",
                        Type.Electric, Wood.Mahogany, Wood.Mahogany);
    inventory.addGuitar("77023", 6275.95, Manufacturer.Martin, "D-28", Type.Accoustic,
    		Wood.Brazilian_Rosewood, Wood.Adirondack);
    inventory.addGuitar("1092", 12995.95, Manufacturer.Olson, "SJ", Type.Accoustic,
    		Wood.Indian_Rosewood, Wood.Cedar);
    inventory.addGuitar("566-62", 8999.95, Manufacturer.Ryan, "Cathedral", Type.Accoustic,
    		Wood.Cocobolo, Wood.Cedar);
    inventory.addGuitar("6 29584", 2100.95, Manufacturer.PRS, "Dave Navarro Signature",
                        Type.Electric, Wood.Mahogany, Wood.Maple);
  }
}

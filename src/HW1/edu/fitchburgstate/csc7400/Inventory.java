/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2 
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */
package HW1.edu.fitchburgstate.csc7400;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory keeps a searchable collection of Guitars. It implements methods
 * to find matching guitars for customers, add a guitar to the inventory 
 * and to get details about a specific guitar. 
 * 
 * @author Mounika Pailla
 * @version 1.1
 */
public class Inventory {
  private List<Guitar> guitars = new LinkedList<Guitar>();

  /**
   * Constructor to initialize guitars
   */
    public Inventory() 
    {
      guitars = new LinkedList<Guitar>();
    }
    
    /**
     * Adds a new guitar to the inventory
     * 
     * @param serialNumber Guitar Serial number
     * @param price Guitar Price
     * @param builder Guitar Builder
     * @param model Guitar model
     * @param type Guitar Type
     * @param backWood Guitar Backwood
     * @param topWood Guitar Topwood
     */
  public void addGuitar(String serialNumber, double price,
                        Manufacturer builder, String model,
                        Type type, Wood backWood, Wood topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
  
  /**
   * Searches inventory and returns guitar matching with given serial number
   * 
   * @param serialNumber Serial number of guitar
   * @return Guitar guitar that matches serial number, null if not found
   */
  public Guitar getGuitar(String serialNumber) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  
  /**
   * Searches inventory and returns guitar matching with given price
   * 
   * @param price price of guitar
   * @return List<Guitar> list of all guitars that match price, null if not found
   */
  public List<Guitar> searchGuitarsByPrice(double price) {
	  List<Guitar> priceMatchedGuitars = new LinkedList<Guitar>();
	  for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getPrice() == price) {
    	  priceMatchedGuitars.add(guitar);
      }
    }
    return priceMatchedGuitars;
  }
  
  /**
   * Searches inventory and returns guitar matching with given price
   * 
   * @param startPrice, endPrice the price range of the guitars to be returned
   * @return List<Guitar> list of all guitars that are in the price range which is passed,
   * 					 null if not found
   */
  public List<Guitar> searchGuitarsByPriceRange(double startPrice, double endPrice) {
	  List<Guitar> guitarsInPriceRange = new LinkedList<Guitar>();
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      int diff1 = Double.compare(startPrice, guitar.getPrice());
      int diff2 = Double.compare(endPrice, guitar.getPrice());
      if((diff1<=0)&&(diff2>=0)) 
      {
		 guitarsInPriceRange.add(guitar);
      }
    }
    return guitarsInPriceRange;
  }
  
  /**
   * 
   * Finds and returns the guitar that matches given guitar
   * 
   * @param searchGuitar Guitar object with given properties
   * @return Guitar Guitar object that matches given guitar, null if not found
   */
  public List<Guitar> search(GuitarSpec searchGuitar) {
	  List<Guitar> matchedList = new LinkedList<Guitar>();
	 for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      GuitarSpec guitarSpec = guitar.getSpec();
      if(searchGuitar.Match(guitarSpec))
    	  matchedList.add(guitar);
    }    
    return matchedList;
  }
}

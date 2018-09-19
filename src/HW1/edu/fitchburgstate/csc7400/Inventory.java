/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 1 
 * Date			: 2018-09-15
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
 * @version 1.0
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
                        String builder, String model,
                        String type, String backWood, String topWood) {
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
   * 
   * Finds and returns the guitar that matches given guitar
   * 
   * @param searchGuitar Guitar object with given properties
   * @return Guitar Guitar object that matches given guitar, null if not found
   */
  public Guitar search(Guitar searchGuitar) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.toLowerCase().equals(guitar.getManufacturer().toLowerCase())))
        continue;
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.toLowerCase().equals(guitar.getModel().toLowerCase())))
        continue;
      String type = searchGuitar.getType();
      if ((type != null) && (!type.equals("")) &&
          (!type.toLowerCase().equals(guitar.getType().toLowerCase())))
        continue;
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.toLowerCase().equals(guitar.getBackWood().toLowerCase())))
        continue;
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.toLowerCase().equals(guitar.getTopWood().toLowerCase())))
        continue;
      return guitar;
    }
    return null;
  }
}

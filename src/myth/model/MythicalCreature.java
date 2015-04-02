package myth.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * @author Charles "Narpas Sword" Brewster
 * @author Tyler "1upsoda" Parsons
 */
public interface MythicalCreature
{
	public String magic(String type);
	
	public String helpfulness();
	
	public int mischievousness();
	
	public ArrayList<String> spoils();
	
	public String talk(String say);
}

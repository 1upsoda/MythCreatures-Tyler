package myth.model;

import java.awt.Color;
import java.util.ArrayList;

public class Unicorn implements MythicalCreature
{
	private String colorType = "Light";

	@Override
	public String magic(String type)
	{	
		String Magic = "My magic is undefined for some reason...";
		if(type == "Light")
		{
			Magic = "My magic is light magic, neigh...";
		}
		else if(type == "Undead")
		{
			Magic = "I have been killed, and now I have undead magic!";
		}
		else if(type == "Entropy")
		{
			Magic = "I have entropy magic, it is very random, and therefore Mischievous";
		}
		return Magic;
	}

	@Override
	public String helpfulness()
	{
		
		setColorType("Light");
		return null;
	}

	@Override
	public int mischievousness()
	{
		
		setColorType("Entropy");
		return 0;
	}

	@Override
	public ArrayList<String> spoils()
	{
		ArrayList<String> drops = new ArrayList<String>();
		String oldColorType = colorType;
		if(oldColorType == "Undead")
		{
			drops.add("Rotten Flesh");
			drops.add("A Corrupted Unicorn Horn");
			drops.add("Unicorn Blood");
		}
		else if(oldColorType == "Light")
		{
			drops.add("Unicorn Horn");
			drops.add("Magical Meat");
			drops.add("Unicorn Pelt");
		}
		else if(oldColorType == "Entropy")
		{
			drops.add("A Lighter");
			drops.add("Some Lint");
			drops.add("''British Sponge Pudding''");
		}
		else
		{
			drops.add("nothing");
		}
		setColorType("Undead");
		return drops;
	}

	public String getColorType()
	{
		return colorType;
	}

	public void setColorType(String colorType)
	{
		this.colorType = colorType;
	}

	@Override
	public String talk(String say)
	{
		// TODO Auto-generated method stub
		return null;
	}

}

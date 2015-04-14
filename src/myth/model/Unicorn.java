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
		String helpSentence = "";
		if(colorType == "Light")
		{
			helpSentence = "I can help you with anything, in fact, I have already helped you with what you needed...";
		}
		else if(colorType == "Entropy")
		{
			int randomNess = (int) (Math.random()*4);
			switch(randomNess)
			{
				case 0:helpSentence = "Sure I can help you with anything.";break;
				case 1:helpSentence = "Eh, I don't really want to but I kinda do...";break;
				case 2:helpSentence = "Nope, you suck.";break;
				case 3:helpSentence = "Sausage.";break;
			}
		}
		else if(colorType == "Undead")
		{
			helpSentence = "No, you have killed me.";
		}
//		setColorType("Light");
		return helpSentence;
	}

	@Override
	public String mischievousness()
	{
		String misLevel = "";
		if(colorType == "Light")
		{
			misLevel = "I am not going to pull a prank, as I am an honorable Unicorn";
		}
		else if(colorType == "Undead")
		{
			misLevel = "I am too dead to pull any pranks at the moment";
		}
		else if(colorType == "Entropy")
		{
			misLevel = "Maybe I already have.... '-' ";
		}
//		setColorType("Entropy");
		return misLevel;
	}

	@Override
	public ArrayList<String> spoils()
	{
		ArrayList<String> drops = new ArrayList<String>();
		drops.clear();
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
			drops.add("\"British Sponge Pudding\"");
		}
		else
		{
			drops.add("nothing");
		}
//		setColorType("Undead");
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

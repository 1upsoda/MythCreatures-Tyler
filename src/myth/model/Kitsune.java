package myth.model;

import java.awt.Color;
import java.util.ArrayList;

public class Kitsune implements MythicalCreature
{
	private int annoyance = 0;
	private String last = "";

	@Override
	public String magic(String type)
	{
		// TODO Auto-generated method stub
		return "You tell the kitsune to show you some magic."
				+ " The kitsune wants to know what type of magic you want him to cast.";
	}

	@Override
	public String helpfulness()
	{
		// TODO Auto-generated method stub
		return  "The kitsune asks for you to pay him for his services."
				+ " How many coins do you give him?";
	}

	@Override
	public String mischievousness()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> spoils()
	{
		// TODO Auto-generated method stub
		ArrayList<String> drops = new ArrayList<String>();
		drops.clear();
		drops.add("Rotten Flesh");
		return drops;
	}

	@Override
	public String talk(String say)
	{
		String answer = "";
		if (last == "")
		{
			last = say;
			
			if (say == "magic")
			{
				answer = "You tell the kitsune to show you some magic."
						+ " The kitsune wants to know what type of magic you want him to cast.";
			}
			else if (say == "help")
			{
				answer = "The kitsune asks for you to pay him for his services."
						+ " How many coins do you give him?";
			}
			else if (say == "evil")
			{
				
			}
			else if (say == "kill")
			{
				
			}
			else
			{
				answer = "The kitsune wonders how you got here. Nobody's supposed to be here!";
			}
		}
		else if (last != say)
		{
			annoyance++;
			answer = "The kitsune is confused by your antics.";
			
			if (last == "magic")
			{
				answer += " It thought you had just asked it to do magic.";
			}
			else if (last == "help")
			{
				answer += " It thought you had just asked it for help";
			}
			else if (last == "evil")
			{
				
			}
			else if (last == "kill")
			{
				// Nobody should be here!
				answer += " It is dead, and yet you are still asking it things.";
			}
			else
			{
				answer = " The kitsune wonders how you got here. Nobody's supposed to be here!";
			}
			last = "";
		}
		else if (last == say)
		{
			if (say == "magic")
			{
				answer = "The ";
			}
			else if (say == "help")
			{
				answer = "The kitsune asks for you to pay him for his services."
						+ " How many coins do you give him?";
			}
			else if (say == "evil")
			{
				
			}
			else if (say == "kill")
			{
				
			}
			else
			{
				answer = "The kitsune wonders how you got here. Nobody's supposed to be here!";
			}
		}
		
		return answer;
	}

}

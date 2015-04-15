package myth.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import myth.controller.MythController;
import myth.model.Kitsune;
import myth.model.MythicalCreature;
import myth.model.Unicorn;

public class MythPanel extends JPanel
{
	private MythController baseController;
	private JButton magicButton;
	private JButton helpButton;
	private JButton evilButton;
	private JButton killButton;
	private JButton makeButton;
	private JTextArea text;
	private SpringLayout baseLayout;
	private MythicalCreature creature;
	private String[] creaturesList = {"Unicorn", "Kitsune"};
	private String currentCreature;

	public MythPanel(MythController baseController)
	{
		this.baseController = baseController;
		creature = new Unicorn();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	public void setupJPanel()
	{

		int n = JOptionPane.showOptionDialog(null,
		    "Which animal do you want to talk about?",
		    "Choose a creature",
		    JOptionPane.DEFAULT_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    creaturesList,
		    creaturesList[0]);
		if(creaturesList[n] == "Kitsune")
		{
			creature = new Kitsune();
			currentCreature = "Kitsune";
		}
		else if(creaturesList[n] == "Unicorn")
		{
			creature = new Unicorn();
		}
		text.setText("A " + creaturesList[n] + " slowly approaches you");
	}
	public void setupPanel()
	{
		baseLayout = new SpringLayout();
		this.setLayout(baseLayout);
		magicButton = new JButton("Cast Magic");
		helpButton = new JButton("I need help");
		baseLayout.putConstraint(SpringLayout.NORTH, helpButton, 0, SpringLayout.SOUTH, magicButton);
		evilButton = new JButton("Pull a prank");
		baseLayout.putConstraint(SpringLayout.NORTH, evilButton, 0, SpringLayout.SOUTH, helpButton);
		killButton = new JButton("KILL THE BEAST");
		baseLayout.putConstraint(SpringLayout.NORTH, killButton, 0, SpringLayout.SOUTH, evilButton);
		makeButton = new JButton("Instantiate a new beast");
		baseLayout.putConstraint(SpringLayout.NORTH, makeButton, 0, SpringLayout.SOUTH, killButton);
		text = new JTextArea("A beautiful Unicorn approaches...");
		baseLayout.putConstraint(SpringLayout.NORTH, magicButton, 0, SpringLayout.SOUTH, text);
		this.add(magicButton);
		this.add(helpButton);
		this.add(evilButton);
		this.add(killButton);
		this.add(makeButton);
		this.add(text);
		text.setEditable(false);
		currentCreature = "Unicorn";
	}

	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, magicButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, magicButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, helpButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, helpButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, evilButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, evilButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, killButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, killButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, makeButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, makeButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, text, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, text, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, text, 500, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, text, 0, SpringLayout.EAST, this);
	}

	public void setupListeners()
	{
		killButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				ArrayList<String> spoilsList = creature.spoils();
				int randomDrop = (int) (Math.random() * spoilsList.size());
				if(currentCreature != "Dead" )
				{
					displayToUser("You brutally murder the Creature (for some reason) and it drops " + spoilsList.get(randomDrop));
					if(((Unicorn) creature).getColorType() != "Undead")
					{
						displayToUser("Now that the Unicorn has been killed, it is using Undead Magics");
					}
					((Unicorn) creature).setColorType("Undead");
					displayToUser("The " +currentCreature+ " is dead now");
					
				}
				if(currentCreature == "Dead")
				{
					displayToUser("The Creature is dead...");
				}
				currentCreature = "Dead";
			}

		});
		helpButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				displayToUser(creature.helpfulness());
				if(currentCreature == "Unicorn")
				{
					if(((Unicorn) creature).getColorType() != "Light" && currentCreature == "Unicorn")
					{
						displayToUser("Now that the Unicorn has been helpful, Light Magics have returned to it");
					}
					
					((Unicorn) creature).setColorType("Light");
					currentCreature = "Unicorn";
				}
				
			}

		});
		magicButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				displayToUser(creature.magic(((Unicorn) creature).getColorType()));
			}

		});
		makeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				setupJPanel();
			}

		});
		evilButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				displayToUser(creature.mischievousness());
				if(((Unicorn) creature).getColorType() != "Entropy")
				{
					displayToUser("Now that the Unicorn has been a little mysterious, the Magics of Entropy have infused inside of it.");
				}
				((Unicorn) creature).setColorType("Entropy");
			}

		});
	}
	
	public void displayToUser(String output)
	{
		text.append("\n" + output);
	}
}

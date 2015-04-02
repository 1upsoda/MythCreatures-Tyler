package myth.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import myth.controller.MythController;
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
	private JTextField text;
	private SpringLayout baseLayout;
	private MythicalCreature creature;

	public MythPanel(MythController baseController)
	{
		this.baseController = baseController;
		creature = new Unicorn();
		setupPanel();
		setupLayout();
		setupListeners();
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
		text = new JTextField("COPYRIGHT LOLOLOL");
		baseLayout.putConstraint(SpringLayout.NORTH, magicButton, 0, SpringLayout.SOUTH, text);
		this.add(magicButton);
		this.add(helpButton);
		this.add(evilButton);
		this.add(killButton);
		this.add(makeButton);
		this.add(text);
		text.setEditable(false);
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
				int randomDrop = (int) (Math.random() * creature.spoils().size());
				text.setText(creature.spoils().get(randomDrop));

			}

		});
	}
}

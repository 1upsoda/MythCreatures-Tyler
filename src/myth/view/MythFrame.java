package myth.view;

import javax.swing.JFrame;

import myth.controller.MythController;

public class MythFrame extends JFrame
{
	private MythPanel basePanel;

	public MythFrame(MythController baseController)
	{
		basePanel = new MythPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
		this.setResizable(false);
		this.setVisible(true);
	}
}

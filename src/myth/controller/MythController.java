package myth.controller;

import myth.view.MythFrame;

public class MythController
{
	private MythFrame baseFrame;
	
	public void start()
	{
		baseFrame = new MythFrame(this);
	}
	
	public Object getThis()
	{
		return this.getThis();
	}
}

/*Abby KRishnan
 *Gallatin - 2nd
 *Fractals Lab
 *1/11/2017
 */
 

import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class Fractals extends Applet
{
	
	/**
	 * draw the original rectangle in the middle of the graphics window
	 */
	public void paint(Graphics g)
	{
		// if you cannot see the entire applet window on your monitor, you can change the
		// size of it in Fractals.html
		int a = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		int c = (int)(Math.random()*256);			
		g.setColor(new Color(a,b,c));
		
		drawRectangle(g,getWidth()/3,getHeight()/3);
	}
	
	/**
	 * draws the original rectangle, then calls the method/s that draw the
	 * four rectangles at the corners.
	 * NOT RECURSIVE
	 */
	public void drawRectangle(Graphics g, int x, int y)
	{
		
		Color color = randColor(x);
		
		g.drawRect(x, y, getWidth()/3, getHeight()/3);
		g.setColor(color);
		g.fillRect(x,y, getWidth()/3, getHeight()/3);
		
		topLeft(g, x - getWidth()/6, y - getHeight()/6, getWidth()/6, getHeight()/6, color);	
		topRight(g, x + getWidth()/3, y - getHeight()/6, getWidth()/6, getHeight() /6, color);
		bottomRight(g, x + getWidth()/3, y + getHeight()/3, getWidth()/6, getHeight() /6, color);
		bottomLeft(g, x - getWidth()/6, y + getHeight()/3, getWidth()/6, getHeight()/6, color);
		
		

	}
	
	public void topRight(Graphics g, int x, int y, int w, int h, Color c)
	{
		if(w > 1)
		{
			g.setColor(c);	
			g.fillRect(x,y,w,h); 			
			
			try
			{
				Thread.sleep(7);
			}
			
			catch(InterruptedException e){ }
			
			Color color = randColor(h); 
			topLeft(g, x - w/2, y - h/2, w/2, h/2, color);
			topRight(g, x + w, y - h/2, w/2, h/2, color);
			bottomRight(g, x + w, y + h, w/2, h/2, color);
			
		}
		
		
		
	}
	
	public void bottomRight (Graphics g, int x, int y, int w, int h, Color c)
	{
		if(w > 1)
		{
			g.setColor(c);
			g.fillRect(x,y,w,h); 			
				
			try
			{
				Thread.sleep(7);
			}
			
			catch(InterruptedException e){ }
			
			Color color = randColor(h); 
			topRight(g, x + w, y - h/2, w/2, h/2, color);
			bottomRight(g, x + w, y + h, w/2, h/2, color);
			bottomLeft(g, x - w/2, y + h, w/2, h/2, color);
		}
		

	}
	
	public void topLeft(Graphics g, int x, int y, int w, int h, Color c)
	{
		if(w > 1)
		{
			g.setColor(c);
			g.fillRect(x,y,w,h);
				
			try
			{
				Thread.sleep(7);
			}
			
			catch(InterruptedException e){ }
			
			Color color = randColor(h); 
			topLeft(g, x - w/2, y - h/2, w/2, h/2, color);
			topRight(g, x + w, y - h/2, w/2, h/2, color);
			bottomLeft(g, x - w/2, y + h, w/2, h/2, color);
			
			
			
			
		}
		

	}
	
	public void bottomLeft(Graphics g, int x, int y, int w, int h, Color c)
	{
		if(w > 1)
		{
			g.setColor(c);
			g.fillRect(x,y,w,h); 			
				

			try
			{
				Thread.sleep(7);
			}
			
			catch(InterruptedException e){ }
			
			Color color = randColor(h); 
			bottomRight(g, x + w, y + h, w/2, h/2, color);
			bottomLeft(g, x - w/2, y + h, w/2, h/2, color);
			topLeft(g, x - w/2, y - h/2, w/2, h/2, color);
		}

	}
	
	public Color randColor(int seed)
	{
		Random rand = new Random(seed);
		int a = (int)(rand.nextInt(256));
		int b = (int)(rand.nextInt(256));
		int c = (int)(rand.nextInt(256));	
					
		return new Color(a,b,c);
	}
}
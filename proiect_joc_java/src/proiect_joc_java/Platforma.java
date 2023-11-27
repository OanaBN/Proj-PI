package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Platforma extends Entitate{
	 public Platforma(int x, int y) {
	    	super(x,y);
	    }
	    
	    public void update() {
	    }
	    
	    public void draw(Graphics2D g2d) {
	    	g2d.drawImage(getPlatformaImg(),x,y,null);
	    	//g2d.draw(getBounds());
	    }

	    
	    public Image getPlatformaImg() {
	    	if(EcranJoc.nivel == 1) {
			ImageIcon ic = new ImageIcon("C:/Users/Legion/Desktop/Homework/Assets/iarba.png");
			return ic.getImage();}
	    	if(EcranJoc.nivel == 2) {
				ImageIcon ic = new ImageIcon("C:/Users/Legion/Desktop/Homework/Assets/piatra.png");
				return ic.getImage();}
	    	if(EcranJoc.nivel == 3) {
				ImageIcon ic = new ImageIcon("C:/Users/Legion/Desktop/Homework/Assets/coral.png");
				return ic.getImage();}
	    	if(EcranJoc.nivel == 4) {
				ImageIcon ic = new ImageIcon("C:/Users/Legion/Desktop/Homework/Assets/slime.png");
				return ic.getImage();}
	    	if(EcranJoc.nivel == 5) {
				ImageIcon ic = new ImageIcon("C:/Users/Legion/Desktop/Homework/Assets/lava.png");
				return ic.getImage();}
	    	else return null;
	    	
		}
	    public Rectangle getBounds() {
	     	return new Rectangle(x,y,getPlatformaImg().getWidth(null),getPlatformaImg().getHeight(null));
	}


		public int getY() {
			return y;
		}

		public int getX() {
			return x;
		}
}
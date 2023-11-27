package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.Timer;

public class MagieTipScut extends Entitate{

    public MagieTipScut(int x, int y) {
    	super(x,y);
    }
    
    public void update() {
    	x += 3;
    	
    	//checkEnemyCollisions();
    	
    	 if (x > 1200) {
             //EcranJoc.removeMagie(this);
         }
    }
    
    public void draw(Graphics2D g2d) {
    	g2d.drawImage(getShieldMagieImg(),x,y,null);
    }
    
    public static Image getShieldMagieImg() {
		ImageIcon ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\balon.png");
		return ic.getImage();
	}
    public Rectangle getBounds() {
     	return new Rectangle(x,y,getShieldMagieImg().getWidth(null),getShieldMagieImg().getHeight(null));
    }
     	

}

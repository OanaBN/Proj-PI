package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inamic extends Entitate {
	private Platforma currentPlatform;
	int velX = 0, velY = 0;
	int gravity = 1;
    private static int spared = 0;
	
	public Inamic(int x, int y) {
		super(x,y);
	}
	public void setPlatform(Platforma platform) {
        this.currentPlatform = platform;
    }
	
	public void update() {
		if (currentPlatform != null) {
            x -= 2;
            velY += gravity;
            y += velY;

            if (y >= currentPlatform.getY()) {
                y = currentPlatform.getY();
                velY = 0;
            }
        }
		x -= 2;
		velY += gravity;
        y += velY;
        
        if (y >= 600) {
            y = 600;
            velY = 0;
        }
		checkCollisions();
		 if (x < -100) {
	            // Remove the enemy from the list
	            EcranJoc.removeInamic(this);
	            spared++;
		 }
		//checkOffScreen();
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getInamicImg(),x,y,null);
		//g2d.draw(getBounds());
	}
	
	public Image getInamicImg() {
		ImageIcon ic = new ImageIcon("D:/Shimejii/shimejiee/img/Priest/shime1.png");
		return ic.getImage();
	}
	
	 public Rectangle getBounds() {
     	return new Rectangle(x,y,getInamicImg().getWidth(null),getInamicImg().getHeight(null));
}
	 
	 public void checkCollisions() {
		 for(int i = 0; i < EcranJoc.getMagieList().size(); i++) {
			 Magie m = EcranJoc.getMagieList().get(i);
			 
			 if(getBounds().intersects(m.getBounds())) {
				 EcranJoc.removeInamic(this);
				 EcranJoc.removeMagie(m);
			 }
		 }
	 }
	 //adaugare point sistem

	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static int getSpared() {
		return spared;
	}
	 
}

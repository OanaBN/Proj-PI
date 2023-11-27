package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Goal extends Entitate{
	public Goal(int x, int y) {
     super(x,y);
}

	public void update() {
		
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getGoalImg(), x, y, null);
		
	}
	
	public Image getGoalImg() {
		ImageIcon ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\red-flag.png");
		return ic.getImage();
	}
	
	public  Rectangle getBounds() {
        return new Rectangle(x, y, getGoalImg().getWidth(null), getGoalImg().getHeight(null));
    }
}

package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class InamicTip2 extends Entitate {
    private Platforma currentPlatform;
    private int hp = 2;
    int velX = 0, velY = 0;
    int gravity = 1;
    private static int spared = 0;

    public InamicTip2(int x, int y) {
        super(x, y);
    }

    public void setPlatform(Platforma platform) {
        this.currentPlatform = platform;
    }

    public void update() {
    	checkCollisions();
        if (x < -100) {
            EcranJoc.removeInamic(this);
            spared++;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getInamicImg(), x, y, null);
        // g2d.draw(getBounds());
    }

    public Image getInamicImg() {
		ImageIcon ic;
		switch (EcranJoc.nivel) {
        case 1:
            ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\imp1.png");
            break;
        case 2:
            ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\imp2.png");
            break;
        case 3:
            ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\imp3.png");
            break;
        case 4:
            ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\imp4.png");
            break;
        case 5:
            ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\imp5.png");
            break;
        default:
            ic = new ImageIcon("C:/Users/Legion/Desktop/Homework/Assets/imp.png");
    }
		return ic.getImage();
	}

    public Rectangle getBounds() {
        return new Rectangle(x, y, getInamicImg().getWidth(null), getInamicImg().getHeight(null));
    }

    public void checkCollisions() {
        for (int i = 0; i < EcranJoc.getMagieList().size(); i++) {
            Magie m = EcranJoc.getMagieList().get(i);

            if (getBounds().intersects(m.getBounds())) {
            	hp--;
            	if(hp <= 0) {
            		EcranJoc.removeInamic(this);
            		
            	}
            	EcranJoc.removeMagie(m);
            }
        }
    }

    public int getHeight() {
        return getInamicImg().getHeight(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getSpared() {
        return spared;
    }

    public void setX(int i) {
        this.x = x;
    }

    public void setY(int i) {
        this.y = y;
    }
}



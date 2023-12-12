package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class InamicBoss extends Entitate {
    int velX = 0, velY = 0;
    int gravity = 1;
    private int hp = 7;
    private int shootCooldown = 0;
    private static final int MAX_COOLDOWN = 35; // Adjust the cooldown value as needed

    private static int spared = 0;

    public InamicBoss(int x, int y) {
        super(x, y);
    }


    public void update() {
    	checkCollisions();
    	if (EcranJoc.checkGoalCollision() == 1) {
            EcranJoc.removeInamic(this);
            spared++;
	 }
    	shootCooldown--;
        if (shootCooldown <= 0) {
            shootProjectile();
            shootCooldown = MAX_COOLDOWN;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getInamicImg(), x, y, null);
        // g2d.draw(getBounds());
    }

    public Image getInamicImg() {
		ImageIcon ic;
		switch (EcranJoc.nivel) {
        case 4:
            ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\boss1.png");
            break;
        case 5:
            ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\boss2.png");
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
    private void shootProjectile() {
        //Proiectil projectile = new Proiectil(x, y + getHeight() / 2);
        EcranJoc.addProiectil(new Proiectil(x,EcranJoc.jucator.getY()));
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
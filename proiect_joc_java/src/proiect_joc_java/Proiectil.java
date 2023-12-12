package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Proiectil extends Entitate {
    private int speed = 5; // Adjust the speed of the projectile as needed

    public Proiectil(int x, int y) {
        super(x, y);
    }

    public void update() {
        x -= speed;

        // Check if the projectile is out of bounds
        if (x < 0) {
            EcranJoc.removeProiectil(this);
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(getProjectileImg(), x, y, null);
    }

    public Image getProjectileImg() {
        ImageIcon ic = new ImageIcon("C:/Users/Legion/Desktop/Homework/Assets/foc.png"); // Set the path to the projectile image file
        return ic.getImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getProjectileImg().getWidth(null)-15, getProjectileImg().getHeight(null)-15);
    }
}
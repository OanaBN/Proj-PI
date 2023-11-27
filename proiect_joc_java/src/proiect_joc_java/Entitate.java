package proiect_joc_java;

import java.awt.Graphics2D;

public class Entitate {
   protected int x;
   protected int y;
   private int HP;
   
   public Entitate() {
	   //HP = 0;
	   //nume = "unknown";
	   x = 0;
	   y = 0;
   }
   
   public Entitate(/*int HP, String nume,*/ int x, int y) {
	   //this.HP = HP;
	   //this.nume = nume;
	   this.x = x;
	   this.y = y;
   }
   public void update() {
	   
   }
   public void draw(Graphics2D g2d) {
	   
   }
   
}

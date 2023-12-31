package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Jucator extends Entitate {
	int velX = 0, velY = 0;
	int speed = 7;
	int gravity = 1;
	boolean isJumping = false;
	boolean isJumpKeyHeld = false;
	boolean onPlatform = true;
    int jumpStrength = 25;
    int jumpHeight = 0;
    int maxJumpHeight = 100;
    private boolean hasShield = false;
	public Jucator(int x, int y) {
		super(x, y);
	}
	public void update() {
		velY += gravity;
		y += velY;
		x += velX;
		
		 if (x < 0) {
		        x = 0;
		    }
		    if (y < 0) {
		        y = 0;
		    }
		    if (x > 1400) {
		        x = 1400;
		    }
		    if (y > 900) {
		        y = 900;
		    }
		
		 if (!hasShield) {
	            checkCollisions();
	        }
		 if (onPlatform == true) {
		 checkPlatformaCollisions();}
		
		if (y >= 600) {
            y = 600;
            isJumping = false;
            jumpHeight = 0;
            
            
            if (isJumpKeyHeld && isJumping && jumpHeight < maxJumpHeight) {
                velY = -jumpStrength;
                jumpHeight+=40;
                }
        }
	}
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(getJucatorImg(), x, y, null);
		 g2d.drawImage(getJucatorImg(), x, y, null);

	        // Draw the shield on top of the player when it is active
	        if (hasShield) {
	            g2d.drawImage(MagieTipScut.getShieldMagieImg(), x, y, null);
	        }
	}

	public Image getJucatorImg() {
		ImageIcon ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\Maylina.png");
		return ic.getImage();
	}
//Metode pentru miscarea caracterului
	//Apasare
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); 
		
		 if (key == KeyEvent.VK_W) {
	            jump();
		}else if (key == KeyEvent.VK_S) {
			onPlatform = false;
		}else if (key == KeyEvent.VK_A) {
			velX = -speed;
		}else if (key == KeyEvent.VK_D) {
			velX = speed;	
		}else if (key == KeyEvent.VK_Q) {
			EcranJoc.addMagie(new Magie(x,y));
		}else if (key == KeyEvent.VK_E) {
			activateShield();
		}
	}
	 //Lasare
	
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode(); 
        
        if (key == KeyEvent.VK_W) {
        	 isJumping = false;
             isJumpKeyHeld = false; 
             //jumpHeight = 0;
		}else if (key == KeyEvent.VK_S) {
			onPlatform = true;
		}else if (key == KeyEvent.VK_A) {
			velX = 0;
		}else if (key == KeyEvent.VK_D) {
			velX = 0;	
		}else if (key == KeyEvent.VK_E) {
			deactivateShield();
		}
        
        }
    
    public void checkCollisions() {
    	ArrayList<Inamic> inamici =EcranJoc.getInamicList();
    	ArrayList<InamicTip2> inamici2 =EcranJoc.getInamic2List();
    	ArrayList<InamicBoss> inamicB =EcranJoc.getInamicBossList();
    	ArrayList<Proiectil> proiectile = EcranJoc.getProiectilList();
    	
    	for( int i = 0; i < inamici.size(); i++) {
    	  Inamic tempInamic = inamici.get(i);
    		if(getBounds().intersects(inamici.get(i).getBounds()) && !hasShield) { 
    			JOptionPane.showMessageDialog(null, "Ai fost ucis :( " + "Nivelul--> " + EcranJoc.nivel);
    	        //EcranJoc.disparitieInamic(tempInamic);//daca jucatorul atinge inamicul, inamicul dispare 
    			System.exit(0);//daca jucatorul atinge inamicii, pierde o viata/moare
    			
    		}
    	}
    	for( int i = 0; i < inamici2.size(); i++) {
      	  InamicTip2 tempInamic = inamici2.get(i);
      		if(getBounds().intersects(inamici2.get(i).getBounds()) && !hasShield) { 
      			JOptionPane.showMessageDialog(null, "Ai fost ucis :( " + "Nivelul--> " + EcranJoc.nivel);
      	        //EcranJoc.disparitieInamic(tempInamic);//daca jucatorul atinge inamicul, inamicul dispare 
      			System.exit(0);//daca jucatorul atinge inamicii, pierde o viata/moare
      		}
    	}
    	for( int i = 0; i < inamicB.size(); i++) {
        	  InamicBoss tempInamic = inamicB.get(i);
        		if(getBounds().intersects(inamicB.get(i).getBounds()) && !hasShield) { 
        			JOptionPane.showMessageDialog(null, "Ai fost ucis :( " + "Nivelul--> " + EcranJoc.nivel);
        	        //EcranJoc.disparitieInamic(tempInamic);//daca jucatorul atinge inamicul, inamicul dispare 
        			System.exit(0);//daca jucatorul atinge inamicii, pierde o viata/moare
        		}
      	}
    	for( int i = 0; i < proiectile.size(); i++) {
      	  Proiectil tempPro = proiectile.get(i);
      		if(getBounds().intersects(proiectile.get(i).getBounds()) && !hasShield) { 
      			JOptionPane.showMessageDialog(null, "Ai fost ucis :( " + "Nivelul--> " + EcranJoc.nivel);
      	        //EcranJoc.disparitieInamic(tempInamic);//daca jucatorul atinge inamicul, inamicul dispare 
      			System.exit(0);//daca jucatorul atinge inamicii, pierde o viata/moare
      			
      		}
      	}
    }
    
    public void checkPlatformaCollisions() {
    	ArrayList<Platforma> platforme =EcranJoc.getPlatformaList();
    	
    	for( int i = 0; i < platforme.size(); i++) {
    	  Platforma tempPlat = platforme.get(i);
    		if(getBoundsFeet().intersects(platforme.get(i).getBounds())) { 
    			y = tempPlat.getY() - (getJucatorImg().getHeight(null));
                velY = 0;
                isJumping = false;
                jumpHeight = 0;
    		}
    	}
    }
    public Rectangle getBounds() {
    	return new Rectangle(x,y,getJucatorImg().getWidth(null),getJucatorImg().getHeight(null));
    }
    
    public Rectangle getBoundsFeet() {
    	return new Rectangle(x,y+getJucatorImg().getHeight(null)+1,getJucatorImg().getWidth(null),1);
    }
    
    
    public void jump() {
        if (!isJumping && !isJumpKeyHeld && jumpHeight < maxJumpHeight) {
            velY = -jumpStrength;
            isJumping = true;
            isJumpKeyHeld = true;
        }
    }
    
    public void activateShield() {
        hasShield = true;
    }
    
    public void deactivateShield() {
        hasShield = false;
    }
    
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public void setX(int i) {
		this.x = x;
		
	}
	public void setY(int i) {
		this.y = y;
		
	}
}

package proiect_joc_java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EcranJoc extends JPanel/*EcranJoc se afla in Jframe*/ implements ActionListener/*preia inputul jucatorului*/ {
	
	Timer mainTimer;
	static Jucator jucator;
	static Goal goal;
	private boolean paused = false;
    int nrInamici = 5;
    int nrInamici2;
    int nrPlat = 6;
    int boss = 1;
    public static int nivel = 1;
	
	static ArrayList<Inamic> inamici = new ArrayList<Inamic>();
	static ArrayList<InamicBoss> inamicB = new ArrayList<InamicBoss>();
	static ArrayList<InamicTip2> inamici2 = new ArrayList<InamicTip2>();
	static ArrayList<Magie> magii = new ArrayList<Magie>();
	static ArrayList<Proiectil> proi = new ArrayList<Proiectil>();
	static ArrayList<Platforma> platforme = new ArrayList<Platforma>();	
	static Random r = new Random();
	
	public EcranJoc() {
		setFocusable(true);
		jucator = new Jucator(100, 800);
		goal = new Goal(1350, 550);
		addKeyListener(new KeyAdapt(jucator));
		mainTimer = new Timer (10, this); /*odata ce timer ul se opreste, va apela actionPerformed*/
		mainTimer.start();
		addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    paused = !paused;
                    //drawPausedBar(g2d);
                }
            }
        });
		
		incepJoc();
	}
	
	public void paint(Graphics g){//functie pentru imaginea jocului
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g; {
		if(nivel == 1) {
		ImageIcon ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\backlvl1.png");
		g2d.drawImage(ic.getImage(),0,0,null);}
		
		if(nivel == 2) {
			ImageIcon ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\backlvl2.png");
			g2d.drawImage(ic.getImage(),0,0,null);}
		
		if(nivel == 3) {
			ImageIcon ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\backlvl3.png");
			g2d.drawImage(ic.getImage(),0,0,null);}
		
		if(nivel == 4) {
			ImageIcon ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\backlvl4.png");
			g2d.drawImage(ic.getImage(),0,0,null);}
		
		if(nivel == 5) {
			ImageIcon ic = new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\backlvl5.png");
			g2d.drawImage(ic.getImage(),0,0,null);}
		
		jucator.draw(g2d);
		goal.draw(g2d);
		
		for(int i = 0; i< inamici.size();i++) {
			Inamic tempInamic = inamici.get(i);
			tempInamic.draw(g2d);
		}
		
		for(int i = 0; i< inamici2.size();i++) {
			InamicTip2 tempInamic = inamici2.get(i);
			tempInamic.draw(g2d);
		}
		for(int i = 0; i< inamicB.size();i++) {
			InamicBoss tempInamic = inamicB.get(i);
			tempInamic.draw(g2d);
		}
		
		for (int i = 0; i < magii.size(); i++) {
			Magie m = magii.get(i);
			m.draw(g2d);
		}
		for (int i = 0; i < proi.size(); i++) {
			Proiectil p = proi.get(i);
			p.draw(g2d);
		}
		
		for (int i = 0; i < platforme.size(); i++) {
			Platforma p = platforme.get(i);
			p.draw(g2d);
		}
		drawKillsBar(g2d);
		drawSpareBar(g2d);
		drawPausedBar(g2d);
		drawInstructionsMagie(g2d);
		drawInstructionsMagieTipScut(g2d);
		}
	}
	
	private void drawPausedBar(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.drawString("Press P to Pause", 670, 20);
    }
	
	private void drawInstructionsMagie(Graphics2D g2d) {
        g2d.setColor(Color.ORANGE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.drawString("Press Q to throw a projectile", 20, 60);
    }
	
	private void drawInstructionsMagieTipScut(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.drawString("Press E to generate a shield", 20, 100);
    }

	private void drawKillsBar(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.drawString("Kills: " + Magie.getKills(), 20, 20);
    }
	
	private void drawSpareBar(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.drawString("Spared: " + Inamic.getSpared(), 1380, 20);
    }
	/*private int spared() {
		if (checkGoalCollision() == 1) {
			int nr = inamici.size() + inamici2.size() + inamicB.size();
		return nr;}
		return 0;
		
	}*/
	public void incepJoc()
	{   
		nrInamici= nivel * 3;
		nrInamici2= nivel * 2;
		jucator.x = 0;
		
		if (nivel == 4 || nivel == 5) {
	        // Spawn the boss enemy on the 4th and 5th levels
	        InamicBoss boss = new InamicBoss(1000,400);
	        inamicB.add(boss);
	    }
		
		for(int i = 0; i < nrInamici; i++) {
			addInamic(new Inamic(r.nextInt(1400,1500), r.nextInt(800)));
		}

		 //addInamicBoss(new InamicBoss(1000, 400)); // Adjust the coordinates accordingly
		 
		
		
		for(int j = 0; j < nrPlat; j++) {
			addPlatforma(new Platforma(r.nextInt(1400), r.nextInt(300,500)));
			addPlatforma(new Platforma(r.nextInt(1400), r.nextInt(100,200)));
			addInamic2(new InamicTip2(r.nextInt(1400), r.nextInt(100, 500)));
		}
	}
	
	public void terminJoc() {
		if (inamici.size()==0 && inamici2.size() == 0 && inamicB.size() == 0|| checkGoalCollision() == 1) {
			nivel ++;
			inamici.clear();
			inamici2.clear();
			magii.clear();
			platforme.clear();
			proi.clear();
			if (checkGoalCollision() == 1)
			JOptionPane.showMessageDialog(null,"Ai castigat nivelul" + (nivel - 1));
			if (nivel > 5) {
				JOptionPane.showMessageDialog(null, "Felicitari!! \n" + "Ai castigat jocul!");
				System.exit(0);
			}
			incepJoc();
		}
	}
	
	public static int checkGoalCollision() {
        if (jucator.getBounds().intersects(goal.getBounds())) {
        	//Inamic.getSpared();
        	return 1;
        }
        return 0;
    }
	private static void assignPlatform(InamicTip2 inamicTip2) {
        ArrayList<Platforma> availablePlatforms = new ArrayList<>(platforme);
        if (!availablePlatforms.isEmpty()) {
            Platforma randomPlatform = availablePlatforms.get(r.nextInt(availablePlatforms.size()));
            inamicTip2.setX(randomPlatform.getX() + randomPlatform.getPlatformaImg().getWidth(null) / 2);
            inamicTip2.setY(randomPlatform.getY() - inamicTip2.getInamicImg().getHeight(null));
            inamicTip2.setPlatform(randomPlatform);
        }
    }
	public void updateProjectiles() {
        for (int i = 0; i < proi.size(); i++) {
            Proiectil projectile = proi.get(i);
            projectile.update();
        }
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		jucator.update();
		updateProjectiles();
		
		 if (!paused) {
		        jucator.update();

		
		for(int i = 0; i < inamici.size(); i++) {//inamici se misca din dreapta spre stanga, a se schimba astfel incat inamici sa
			                                     //miste in dreapta/stanga pana dau de un perete
			Inamic tempInamic = inamici.get(i);
			tempInamic.update();
		}
		
		for(int i = 0; i < inamici2.size(); i++) {
      
            InamicTip2 tempInamic = inamici2.get(i);
            tempInamic.update();
        }
		
		for(int i = 0; i < inamicB.size(); i++) {
		      
            InamicBoss tempInamic = inamicB.get(i);
            tempInamic.update();
        }
		for (int i = 0; i < magii.size(); i++) {
			Magie m = magii.get(i);
			m.update();
		}
		
		for (int i = 0; i < platforme.size(); i++) {
			Platforma p = platforme.get(i);
			p.update();
		}
		checkGoalCollision();
		terminJoc();
		repaint();
		 }
	}
	
	
	public void setPaused(boolean paused) {
        this.paused = paused;
    }

	public static void addInamic(Inamic i) {
		inamici.add(i);
	}
	public static void addInamic2(InamicTip2 i) {
		inamici2.add(i);
	}
	public static void addInamicBoss(InamicBoss ib) {
		inamicB.add(ib);
	}
	
	public static void removeInamic(Inamic i) {
		inamici.remove(i);
	}
	public static void removeInamic(InamicTip2 i2) {
		inamici2.remove(i2);
		
	}
	public static void removeInamic(InamicBoss iB) {
		inamicB.remove(iB);
		
	}
	
	public static void addMagie(Magie m) {
		magii.add(m);
	}
	
	public static void removeMagie(Magie m) {
		magii.remove(m);
	}
	public static void addProiectil(Proiectil pro) {
		proi.add(pro);
	}
	public static void removeProiectil(Proiectil pro) {
		proi.remove(pro);
		
	}
	
	public static void addPlatforma(Platforma p) {
		platforme.add(p);
	}
	
	
	public static ArrayList<Magie> getMagieList() {
		return magii;
	}
	
	public static ArrayList<Inamic> getInamicList(){
		return inamici;
	}
	public static ArrayList<InamicTip2> getInamic2List(){
		return inamici2;
	}
	public static ArrayList<InamicBoss> getInamicBossList(){
		return inamicB;
	}
	public static ArrayList<Proiectil> getProiectilList(){
		return proi;
	}
	
	public static ArrayList<Platforma> getPlatformaList(){
		return platforme;
	}

	public void quitGame() { 
	  System.exit(0);
	}
}

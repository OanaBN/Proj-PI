package proiect_joc_java;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {
	private Image backgroundImage;
    public StartMenu() {
        setTitle("Starting Menu");
        setResizable(false);
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        
        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Legion\\Desktop\\Homework\\Assets\\start.png"));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);
        
        JButton startButton = new JButton("Start Game");
        //JButton optionsButton = new JButton("Options");
        JButton quitButton = new JButton("Quit");
        
        startButton.setBounds(225, 100, 100, 30);
        //optionsButton.setBounds(225, 200, 100, 30);
        quitButton.setBounds(225, 300, 100, 30);
       
        backgroundLabel.add(startButton);
        //backgroundLabel.add(optionsButton);
        backgroundLabel.add(quitButton);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the starting menu
                startGame(); // Start the game
            }
        });

        /*optionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement options functionality
                // For example: showOptions();
            }
        });*/

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Quit the application
            }
            
        });

        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
        
    }
    private void startGame() {
        JFrame frame = new JFrame("ProiectJoc");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new EcranJoc());
        frame.setVisible(true);
    }

}

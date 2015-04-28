package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

import main.Game;

public class RunButton extends JButton {

		public static Color buttonColor = Color.getHSBColor((float).58, (float)0.42, (float)0.9);
		private String button_text;
		private final int button_width = (int)(Game.APPLET_WIDTH/5);
		private final int button_height = (int)(Game.APPLET_HEIGHT/5 - 20);
		
		public RunButton(String text) {
			super(text);
			button_text = text;
			initGUI();
		}
		
		public void initGUI(){
			Dimension dim = new Dimension(button_width, button_height);
			setPreferredSize(dim);
			setMaximumSize(dim);
			setMinimumSize(dim);
			setContentAreaFilled(false);
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(buttonColor);
			g.fillRect(0, 0, button_width, button_height);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, button_width-1, button_height -1);
			g.setFont(new Font("Arial", Font.BOLD, 60));
			g.drawString(button_text, 25, 72);
		}

	}



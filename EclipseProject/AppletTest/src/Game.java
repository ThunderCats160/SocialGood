import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Game extends Applet implements ActionListener {
	
	Color redColor; 
	Color bgColor; 

	int stratCounter; 
	
	Level l; 
	
	Board b; 
	
	ArrayList<Move> moveList = new ArrayList<Move>(); 
	
	SelectPanel moveSelectionPanel; 
	StratPanel strategyPanel; 
	
	
	
	public void init()
	{
		stratCounter = 0; 
		

		setLayout(new BorderLayout()); 
		redColor =Color.red; 
		bgColor = Color.blue; 
		
		l = new Level(40); 
		
		b = new Board(l); 
		
		for(int i = 0; i < 8; i++)
		{
			moveList.add(new RightMove("Hello", b, null)); 
		}
		
		strategyPanel= new StratPanel();
		
		moveSelectionPanel = new SelectPanel(strategyPanel);
		//moveSelectionPanel.setLayout(new BoxLayout(moveSelectionPanel, BoxLayout.Y_AXIS));
		
		 
		
		moveSelectionPanel.setSelectOptions(l.getAvailableMoves()); 
		
		
		
		add(b, "Center"); 
		add(moveSelectionPanel, "West"); 
		//add(strategyPanel, "East"); 
		
		JButton butt =new JButton("DJFSDHFKJ"); 
		add(butt, "South"); 
		butt.addActionListener(this); 
		
		 
		//setBackground(bgColor); 
	}
	
	public void paint(Graphics g)
	{
		/*g.setColor(redColor); 
		g.drawRect(100, 100, 100, 100); 
		g.fillRect(110,  110,  80,  80);*/
		
		b.paint(g);
		moveSelectionPanel.paint(g); 
		//strategyPanel.paint(g); 
		//b.testStrategy(moveList);
/*
		if(b.runningStrat)
		{
			if(stratCounter >= 0)
			{
				b.incrementStrat();
				stratCounter = 0; 
			}
			else
			{
				stratCounter ++; 
			}
		}*/
		
		//System.out.println(b.player.getX()); 
		
		//System.out.println(stratCounter); 
		 
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		b.testStrategy(strategyPanel.getCurrentStrat()); 
		
	}

}

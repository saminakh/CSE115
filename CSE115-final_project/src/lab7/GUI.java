package lab7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI implements Runnable {
	
	private ArrayList<ArrayList<String>> _list;
	
	public void run() {
		
		//setting up frame
		JFrame frame = new JFrame("Connect Four");
		Container pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		//making player
		lab7.Player player = new lab7.Player();
		JLabel playerlabel = new JLabel();
		if(player.getPlayer()=="p1"){
			playerlabel.setText("Player 1's turn");
		} else{
			playerlabel.setText("Player 2's turn");
		}
		
		//add players to display
		JPanel ppane = new JPanel();
		ppane.setVisible(true);
		pane.add(ppane);
		ppane.add(playerlabel);
		
		//board layout
		JPanel board = new JPanel(new GridLayout(0,7));
		pane.add(board);
		board.setVisible(true);
		
		javax.swing.ImageIcon icon = new javax.swing.ImageIcon("images/blank.png"); 
		ArrayList<ArrayList<JLabel>> myList = new ArrayList<ArrayList<JLabel>>();
		
		//reset button
		JPanel rpane = new JPanel();
		rpane.setLayout(new BorderLayout());
		JButton rbutton = new JButton();
		rbutton.setText("Click to play again.");
		rpane.add(rbutton);	
		rpane.setVisible(false);
	
		//making game state
		lab7.GameState game = new lab7.GameState();
		_list = game.getList();
		
		//column buttons
		for(int z=0; z<7; z=z+1){
			JButton buttonz = new JButton();
			buttonz.setText("Col"+(z+1));
			board.add(buttonz);
			buttonz.addActionListener(new EventHandler(z, _list, myList, player, playerlabel, rpane, frame));			
		}
		
		
		
		//board squares
		for(int x=0; x<6;  x=x+1){
			ArrayList<JLabel> al = new ArrayList<JLabel>();
			
			for(int y=0; y<7; y=y+1){
				
				JLabel labelxy = new JLabel();
				labelxy.setIcon(icon);	
				board.add(labelxy);	
				al.add(labelxy);
			}
			
		myList.add(al);	
		}
		
		//add reset button to pane all the way at the bottom
		rbutton.addActionListener(new ResetHandler(_list, myList, player, playerlabel, rpane, frame));
		pane.add(rpane);		
		
		//frame stuff
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
	}

}

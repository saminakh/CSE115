package lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResetHandler implements ActionListener {
	
	private ArrayList<ArrayList<String>> _myListGame;
	private ArrayList<ArrayList<JLabel>> _myListGui;
	private lab7.Player _player;
	private JLabel _plabel;
	private JPanel _rpane;
	private JFrame _frame;
	
	public ResetHandler(ArrayList<ArrayList<String>> myListGame, ArrayList<ArrayList<JLabel>> myListGui, lab7.Player player, JLabel plabel, JPanel rpane, JFrame frame){
		_myListGame = myListGame;
		_myListGui = myListGui;		
		_player = player;
		_plabel = plabel;
		_rpane = rpane;
		_frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		javax.swing.ImageIcon icon = new javax.swing.ImageIcon("images/blank.png");
		for(int x=0; x<6; x=x+1){	
			for(int y=0; y<7; y=y+1){
				//set everything to empty
				_myListGame.get(x).set(y, "e");
				_myListGui.get(x).get(y).setIcon(icon);
				
			}
		}
		
		_player.setPlayer("p1");
		//make frame pretty again
		_rpane.setVisible(false);
		_frame.pack();
		_plabel.setText("Game reset! Player 1's turn");
	}
}

package lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventHandler implements ActionListener {
	
	private ArrayList<ArrayList<String>> _myListGame;
	private ArrayList<ArrayList<JLabel>> _myListGui;
	private int _col;
	private lab7.Player _player;
	private JLabel _plabel;
	private JPanel _rpane;
	private JFrame _frame;
	
	public EventHandler(int col, ArrayList<ArrayList<String>> myListGame, ArrayList<ArrayList<JLabel>> myListGui, lab7.Player player, JLabel playerlabel, JPanel rpane, JFrame frame){
		_col = col;
		_myListGame = myListGame;
		_myListGui = myListGui;	
		_player = player;
		_plabel = playerlabel;
		_rpane = rpane;
		_frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String pstring = null;
		ImageIcon icon = null;
		String pstring2 = null;
		
		//make stalemate counter
		int smCounter = 0;
		//icons
		ImageIcon rIcon = new javax.swing.ImageIcon("images/red.png");
		ImageIcon yIcon = new javax.swing.ImageIcon("images/yellow.png");
		
		//setting player
		if(_player.getPlayer() =="p1"){
			icon = rIcon;
			pstring = "p1";
			pstring2="Player 1";
		}
		if(_player.getPlayer() =="p2"){
			icon = yIcon;
			pstring = "p2";
			pstring2="Player 2";
		}
		//check to see if game was already ended, assign to arbitrary player 3 to end game
		if(_player.getPlayer() =="p3"){
			// do nothing cuz game is over
		} else{
		//check to see if there is space for another piece
		for(int x=5; x>=0; x=x-1){	
			int counter = 0;
			if(_myListGame.get(x).get(_col) == "e"){
				counter=0;
					
					//play piece
					_myListGame.get(x).set(_col, pstring);
					_myListGui.get(x).get(_col).setIcon(icon);
					
					
					//check column wins
					for(int a=5; a>=0; a=a-1){
						if(_myListGame.get(a).get(_col)==pstring){
							counter++;
						} else {
							counter=0;
						}
						if(counter==4){
							//declare winner
							_plabel.setText(pstring2+" wins!");
							//add reset button, repack frame
							_rpane.setVisible(true);
							_frame.pack();
							//set to arbitrary player 3 so no one can play until reset
							_player.setPlayer("p3");
							break;
						}
					}
					//check for wins to see if needs to end game and announce winner
					if(counter==4){
						break;
					}
					//check row wins
					for(int b=0; b<6; b=b+1){
						counter=0;
						for(int d=0; d<7; d=d+1){
							if(_myListGame.get(b).get(d)==pstring){
								counter++;
								if(counter==4){
									_plabel.setText(pstring2+" wins!");
									_rpane.setVisible(true);
									_frame.pack();
									_player.setPlayer("p3");
									break;
								}
							} else{
								counter=0;
							}
							
						}
						if(counter==4){
							break;
						}
					}
					//check for wins, see if it needs to end game
					if(counter==4){
						break;
					} else {counter =0;}
					
					//check for positive diagonal wins
					for(int a=5; a>2; a=a-1){
						for(int b=0; b<4; b=b+1){
							if(_myListGame.get(a).get(b)==pstring){
								if(_myListGame.get(a-1).get(b+1)==pstring){
									if(_myListGame.get(a-2).get(b+2)==pstring){
										if(_myListGame.get(a-3).get(b+3)==pstring){
											counter=4;
											_plabel.setText(pstring2+" wins!");
											_rpane.setVisible(true);
											_frame.pack();
											_player.setPlayer("p3");
											break;
										} 
									}
								}
							} 
						}
						if(counter==4){
							break;
						}
					}
					//check for wins, see if it needs to end game
					if(counter==4){
						break;
					}
					
					//check for negative diagonal wins
					for(int a=0; a<3; a=a+1){
						for(int b=0; b<4; b=b+1){
							if(_myListGame.get(a).get(b)==pstring){
								if(_myListGame.get(a+1).get(b+1)==pstring){
									if(_myListGame.get(a+2).get(b+2)==pstring){
										if(_myListGame.get(a+3).get(b+3)==pstring){
											counter=4;
											_plabel.setText(pstring2+" wins!");
											_rpane.setVisible(true);
											_frame.pack();
											_player.setPlayer("p3");
											break;
										}
									}
								}
							}
						}
						if(counter==4){
							break;
						}
					}
					
					//check for wins, see if it needs to end game
					if(counter==4){
						break;
					}
					for(int r=0; r<6; r=r+1){
						for(int c=0; c<7; c=c+1){
							if(_myListGame.get(r).get(c)=="e"){
								smCounter++;
								break;
							}
						}
						if(smCounter>0){
							break;
						}
						
					}
					if(smCounter>0){
					//no win, switching players
					if(_player.getPlayer()=="p1"){
					_player.setPlayer("p2");
					_plabel.setText("Player 2's turn");
					break;	
					} else{_player.setPlayer("p1");
					_plabel.setText("Player 1's turn");
					break;
					}
					} else {
						//declare stalemate
						_plabel.setText("Stalemate! GG scrub noobs.");
						//add reset button, repack frame
						_rpane.setVisible(true);
						_frame.pack();
						//set to arbitrary player 3 so no one can play until reset
						_player.setPlayer("p3");
					}
				} 
			}		
		}
	}
}

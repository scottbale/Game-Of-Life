import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
	Runs display of the board logic
*/
class MapComponent extends JComponent{
	private GameMap map;
	private int xCaret, yCaret;
	public MapComponent(Viewer v){
		xCaret = 0;
		yCaret = 0;
		this.setFocusable(true);
		/**
			keyListener handles the caret control
		*/
		this.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				switch(e.getKeyCode())
				{
					case KeyEvent.VK_LEFT:
						if(xCaret>0)
							xCaret--;
					break;
					case KeyEvent.VK_RIGHT:
						if(xCaret<map.getWidth()-1)
							xCaret++;
					break;
					case KeyEvent.VK_UP:
						if(yCaret>0)
							yCaret--;
					break;
					case KeyEvent.VK_DOWN:
						if(yCaret<map.getHeight()-1)
							yCaret++;
					break;
					case KeyEvent.VK_SPACE:
						map.toggle(xCaret,yCaret);	
					break;
					case KeyEvent.VK_ENTER:
						update();
					break;
				}
 				if((e.getModifiers() & ActionEvent.SHIFT_MASK) != 0)
				map.toggle(xCaret, yCaret); 
				repaint();
			}
			
			public void keyTyped(KeyEvent e){
				//To sastify the compiler
			}
			
			public void keyReleased(KeyEvent e){
				//To satisfy the compiler
			}
		});
		
		map = new GameMap(25,25);
		this.setVisible(true);
	}
	/**
		Takes the game map and colors appropriately, using blue or red to indicate the cursor
		Based off of previous work of mine
	*/
	public void paintComponent(Graphics g){
		boolean[][] draw = map.getMap();
		Graphics2D g2 = (Graphics2D) g;
		for(int i =0;i<draw.length;i++){
			for(int j =0;j<draw[i].length;j++){
				Color c = (draw[i][j])?Viewer.positive:Viewer.negative;
				if(i == xCaret && j == yCaret)
					c = (draw[i][j])?Color.RED:Color.BLUE;
				g2.setColor(c);
				Rectangle tile = new Rectangle((int)(i*Viewer.BOX_SIZE),(int)(j*Viewer.BOX_SIZE),Viewer.BOX_SIZE,Viewer.BOX_SIZE);
				g2.fill(tile);
			}
		}
	}
	public void update(){
		this.update(false);
	}
	public void update(boolean b){
		map.update(b);
	}
	public void resize(int x,int y){
		int n = JOptionPane.showConfirmDialog(null,"Would you like to refresh the grid\n(All data will be lost)", "Warning",JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION)
			map = new GameMap(x,y);
	}
	public GameMap getMap(){
		return map;        
	}
}

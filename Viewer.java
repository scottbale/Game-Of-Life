import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
	Handles the Window of the Game
*/
class Viewer extends JFrame{
	public static int BOX_SIZE = 10;
	public static Color positive = Color.GREEN, negative = Color.BLACK;
	private JButton jumpButton, stepButton;
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu;
	private JPanel mainPanel;
	private MapComponent grid;
	public Viewer(){
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(350,350);
		super.setResizable(false);
		setTitle("Game of Life");
		initializeMainPanel();
		initializeMenus();
		super.add(mainPanel);
		this.setVisible(true);
	}
	/**
		An extension of the constructor
		handles menus
	*/
	private void initializeMenus(){
		menuBar =  new JMenuBar();
		super.setJMenuBar(menuBar);
		fileMenu = new JMenu("File"); 
		editMenu = new JMenu("Edit"); 
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				System.exit(0);
			}
		});
		
		JMenuItem resize = new JMenuItem("Resize");
		resize.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
		editMenu.add(resize);
		resize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				int width = Integer.parseInt(JOptionPane.showInputDialog(new String("Enter New size:")));
				setResizable(true);
				grid.resize(width,width);
				setSize(new Dimension(width*BOX_SIZE+100,width*BOX_SIZE+100));
				setResizable(false);
			}		
		});

		JMenuItem rebox = new JMenuItem("Rebox");
		rebox.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
		editMenu.add(rebox);
		rebox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				BOX_SIZE = Integer.parseInt(JOptionPane.showInputDialog(new String("Enter New Box Size:")));
				setResizable(true);
				setSize(new Dimension(grid.getMap().getWidth()*BOX_SIZE+100,grid.getMap().getHeight()*BOX_SIZE+100));
				setResizable(false);
                
			}
		});
		JMenuItem refresh = new JMenuItem("Refresh");
		refresh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
 		editMenu.add(refresh);
		refresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				grid.resize(grid.getMap().getWidth(),grid.getMap().getHeight());
				grid.repaint();
			} 
		});
		
		
	}
	/**
		An extension of the constructor
		Makes and defines buttons and the grid
	*/
	private void initializeMainPanel(){
		//Constructors
		mainPanel = new JPanel();
		jumpButton = new JButton("Jump");
		jumpButton.setActionCommand("jumpGame");
		stepButton = new JButton("Step");
		stepButton.setActionCommand("stepGame");       
		grid = new MapComponent(this);
		

		//defines properties for the buttons
		jumpButton.addActionListener(new ButtonMole());
		stepButton.addActionListener(new ButtonMole());	
	      
	      	//Surrenders Control to the KeyBoard
	      	jumpButton.setFocusable(false);
	      	stepButton.setFocusable(false);
                
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.setBorder(BorderFactory.createEtchedBorder());
		
		//Prepares the buttons and grid for formatting        
		Dimension spacer = new Dimension(5, stepButton.getPreferredSize().height + 10);
        
		mainPanel.add(Box.createRigidArea(spacer));
		mainPanel.add(stepButton);
		mainPanel.add(Box.createRigidArea(spacer));
		mainPanel.add(jumpButton);
		mainPanel.add(Box.createRigidArea(spacer));
		mainPanel.add(grid);
		//Formatting code
		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.setHorizontalGroup(
			mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(mainPanelLayout.createSequentialGroup()
				.addContainerGap()
			.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(stepButton)
				.addComponent(jumpButton))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		//Formatting Code
		mainPanelLayout.setVerticalGroup(
			mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup()
					.addContainerGap()
				.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(mainPanelLayout.createSequentialGroup()
					.addComponent(stepButton)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jumpButton)))
					.addContainerGap())
		);
	}
}

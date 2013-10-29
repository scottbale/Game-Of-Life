/**
	Main Class, only offers tutorial and sends user on its way	
*/
public class GameOfLife_Kalb{
	public static void main(String[] args)
	{
		int n = JOptionPane.showConfirmDialog(null,"Do you need a tutorial?\n (Recommended for first time users)", "Notice",JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION)
			runTutorial();
		JFrame v = new Viewer();
	}
	/**
		Goes over the basics of how to operate it.
	*/
	private static void runTutorial(){
		int n = JOptionPane.showConfirmDialog(null,"Do you need the tutorial?", "Notice",JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.NO_OPTION)
			return;
		JOptionPane.showMessageDialog(null, "Hello. This is a Simulator for Conway's Game of Life.\nReferences can, as always, be found on the Internet.");
		JOptionPane.showMessageDialog(null, "Most of the simulator works in the panel, where you see two Buttons and the Game Board.");
		JOptionPane.showMessageDialog(null, "The buttons are labeled Step and Jump.\nStep runs one generation of the game.\nJump asks for the number of generations, and runs them all in a brief time.");
		JOptionPane.showMessageDialog(null, "The board runs solely off of keyboard command. The blue (or red) box indicates the cursor. Green boxes represent life, Black: death");
		JOptionPane.showMessageDialog(null, "The Arrow Keys move the cursor in the approriate direction.\nHit the SPACE bar to toggle the highlighted square betweeen life and death");
		JOptionPane.showMessageDialog(null, "To draw patterns faster, hold SHIFT down, and hit/hold the arrows in appropriate directions");
		JOptionPane.showMessageDialog(null, "Hit ENTER to bring about the next generation. Hold ENTER to run the generations in fast sequence.");
		JOptionPane.showMessageDialog(null, "In the EDIT menu, you have three MENUS, and corresponding hotkeys");
		JOptionPane.showMessageDialog(null, "Resize(Ctrl-Z) will expand the grids size.\nSo a 15x15 grid can become a 200x200 grid.\nThis will also clear the grid.\n(Warning: too big, this may cause a memory problems).");
		JOptionPane.showMessageDialog(null, "Rebox(Ctrl-B) will make the boxes of size n pixels, grid will not be cleared.\n(Warning: you may not be able to see the whold grid if you oversize it).");
		JOptionPane.showMessageDialog(null, "Refresh(Ctrl-R) clears the Grid.");
		JOptionPane.showMessageDialog(null, "Questions? Comments? Conerns? Considerations? Update ideas?\nEmail the publisher: art.kalb96@gmail.com");
	}
}

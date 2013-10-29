import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
	GameMap
		handles all the logic for the board game
		if map[i][j] == true, cell is present
	Code taken and modified from previous work with the Game of Life by Art Kalb
		
*/
class GameMap{
	private boolean[][] map;
	private int width, height;
	/**
		Constructs a blank map
	*/
	public GameMap(int row,int col){
		height = row;
		width = col;
		map = new boolean[row][col];
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				map[i][j] = false;
			}
		}
	}
	public void toggle(int x,int y){
		map[x][y] = !map[x][y];
	}
	/**
		Takes a look at the map, uses game rules to determine life or death
		@param toPrint if true-write to console
	*/
	public void update(boolean toPrint){
		boolean arr[][] = new boolean[width][height];
		for(int i = 0; i<arr.length;i++){
			for(int j =0;j<arr[i].length;j++){
				int count = countNeighbors(i,j);
				if(map[i][j])
					arr[i][j] = (count==2 || count==3);
				else
					arr[i][j] = (count==3);
			}
		}
		map = arr;
		if(toPrint)
			print(map);
	}
	//Console based proof of concept
	private static void print(boolean[][] arr){
		for(int i =0; i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print((arr[i][j])?"#":" ");
			}
			System.out.println();
		}
	}
	/**
		@return the humber of living neighbors of a particular cell
		@param x and y coordinates of the cell in question
		Makers note:
		123 this correlates to the commented line in the method
		4x5 
		678
	*/
	private int countNeighbors(int x,int y){
		int ret = 0;
		
		ret += (x>0 && y>0 && map[x-1][y-1])?1:0;//1
		ret += (x>0 && map[x-1][y])?1:0;//2
		ret += (x>0 && y<map[x-1].length-1 && map[x-1][y+1])?1:0;//3
		ret += (y>0 && map[x][y-1])?1:0;//4
		ret += (y<map[x].length-1 && map[x][y+1])?1:0;//5
		ret += (x<map.length-1 && y>0 && map[x+1][y-1])?1:0;//6
		ret += (x<map.length-1 && map[x+1][y])?1:0;//7
		ret += (x<map.length-1 && y<map[x+1].length-1 && map[x+1][y+1])?1:0;//8
		return ret;
	}
	/**
		Getter functions
	*/
	public boolean[][] getMap(){
		return map;
	}
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
}

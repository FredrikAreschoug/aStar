package aStar;

public class Map {

	private final int WIDTH, HEIGHT;
	public boolean[][] mapGrid;
	
	public Map(int width, int height){
		WIDTH = width;
		HEIGHT = height;
		
		mapGrid = new boolean[WIDTH][HEIGHT];
		
		for(int i = 0; i < mapGrid.length; i++){
			for(int j = 0; j < mapGrid[i].length; j++){
				mapGrid[i][j] = true;
//				System.out.println(i + "," + j);
			}
		}
		mapGrid[1][1] = false;
		mapGrid[2][1] = false;
		mapGrid[3][1] = false;
		mapGrid[3][2] = false;
		mapGrid[3][3] = false;
		mapGrid[3][4] = false;
		mapGrid[3][5] = false;
		mapGrid[1][5] = false;
		mapGrid[2][5] = false;
 	}
	
	//gets
	public int getWidth(){
		return WIDTH;
	}
	public int getHeight(){
		return HEIGHT;
	}
}

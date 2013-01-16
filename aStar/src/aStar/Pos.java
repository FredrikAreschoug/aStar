package aStar;

public class Pos {

	private int x,y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
//	public void move(int toX, int toY){
//		if(x < toX){
//			if(Main.map.mapGrid[x+1][y]){
//				x++;
//			}
//		}else if(x > toX){
//			if(Main.map.mapGrid[x-1][y]){
//				x--;
//			}
//		}else{
////			System.out.println("right width");
//		}
//		
//		if(y < toY){
//			if(Main.map.mapGrid[x][y+1]){
//				y++;
//			}
//		}else if(y > toY){
//			if(Main.map.mapGrid[x][y-1]){
//				y--;
//			}
//		}else{
////			System.out.println("right height");
//		}
//		
//	}
	
	//gets
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}

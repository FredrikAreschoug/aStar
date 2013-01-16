package aStar;

import java.util.ArrayList;

public class Movment {
	private int startX, startY, endX, endY, currentX, currentY;
	private Node node;
	
	private ArrayList<Node> openlist = new ArrayList<Node>();
	private ArrayList<Node> closedlist = new ArrayList<Node>();
	private ArrayList<Node> list = new ArrayList<Node>();
//	private int oldG = 0;
	
	
	Movment(int startX, int startY, int endX, int endY){
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	public void findPath() throws InterruptedException{
		
		currentX = startX;
		currentY = startY;
		node = new Node(currentX,currentY);
		closedlist.add(node);
		
		while(currentX != endX || currentY != endY){
			check(currentX,currentY);
			checkLowest();
//			Thread.sleep(1000);
		}

		backTrace();
		
		for(int i = list.size()-1; i >= 0; i--){
			System.out.println("X:"+list.get(i).x + " Y:" + list.get(i).y);
			System.out.println("G:" + list.get(i).g + " H:" + list.get(i).h + " F:" + (list.get(i).g+list.get(i).h));
		}
		System.out.println("win");
		
	}
	
	public void backTrace(){
		for(int i = closedlist.size()-1; i > 0 ;i--){
			switch(closedlist.get(i).from){
			case 1:
				if(closedlist.get(i).x == currentX && closedlist.get(i).y == currentY){
					currentX++;
					list.add(closedlist.get(i));
				}
				break;
			case 2:
				if(closedlist.get(i).x == currentX && closedlist.get(i).y == currentY){
					currentX++;
					currentY++;
					list.add(closedlist.get(i));
				}
				break;
			case 3:
				if(closedlist.get(i).x == currentX && closedlist.get(i).y == currentY){
					currentY++;
					list.add(closedlist.get(i));
				}
				break;
			case 4:
				if(closedlist.get(i).x == currentX && closedlist.get(i).y == currentY){
					currentX--;
					currentY++;
					list.add(closedlist.get(i));
				}
				break;
			case 5:
				if(closedlist.get(i).x == currentX && closedlist.get(i).y == currentY){
					currentX--;
					list.add(closedlist.get(i));
				}
				break;
			case 6:
				if(closedlist.get(i).x == currentX && closedlist.get(i).y == currentY){
					currentX--;
					currentY--;
					list.add(closedlist.get(i));
				}
				break;
			case 7:
				if(closedlist.get(i).x == currentX && closedlist.get(i).y == currentY){
					currentY--;
					list.add(closedlist.get(i));
				}
				break;
			case 8:
				if(closedlist.get(i).x == currentX && closedlist.get(i).y == currentY){
					currentX++;
					currentY--;
					list.add(closedlist.get(i));
				}
				break;
			
			}
		}
		node = new Node(currentX,currentY);
		list.add(node);
		
	}
	
	
	public void checkLowest(){
		int lowestF = -1;
		int lowestNode = 0;
		for(int i = 0; i < openlist.size(); i++){
			int f = openlist.get(i).g + openlist.get(i).h;
			if(f < lowestF || lowestF == -1){
				lowestF = f;
				lowestNode = i;
			}
		}
//		oldG += openlist.get(lowestNode).g;
//		System.out.println(openlist.get(lowestNode).x + ", " + openlist.get(lowestNode).y + ", " + openlist.get(lowestNode).h + ", " + oldG);
		currentX = openlist.get(lowestNode).x;
		currentY = openlist.get(lowestNode).y;
		closedlist.add(openlist.get(lowestNode));
//		list.add(openlist.get(lowestNode));
		openlist.remove(lowestNode);
	}
	
	public void check(int x,int y){
		if(!onList(x-1,y)){
			openOrClosed(x-1, y, false, 1);
		}
		
		if(!onList(x-1,y-1)){
			openOrClosed(x-1, y-1, true, 2);
		}
		
		if(!onList(x,y-1)){
			openOrClosed(x, y-1, false, 3);
		}
		
		if(!onList(x+1,y-1)){
			openOrClosed(x+1, y-1, true, 4);
		}
		
		if(!onList(x+1,y)){
			openOrClosed(x+1, y, false, 5);
		}
		
		if(!onList(x+1,y+1)){
			openOrClosed(x+1, y+1, true, 6);
		}
		
		if(!onList(x,y+1)){
			openOrClosed(x, y+1, false, 7);
		}
		
		if(!onList(x-1,y+1)){
			openOrClosed(x-1, y+1, true, 8);
		}
	}
	
	public void openOrClosed(int x, int y, boolean diagonal, int from){
		if(Main.map.mapGrid[x][y]){
			int g;
			if(diagonal){
				g = 14;
			}else{
				g = 10 ;
			}
			
			int h = getH(x,y);
			node = new Node(x,y,g,h,from);
			openlist.add(node);
		}else{
			node = new Node(x,y);
			closedlist.add(node);
		}
	}
	
	

	
	public boolean onList(int x, int y){
		if(x < 0 || y < 0 || x >= Main.map.getHeight() || y >= Main.map.getWidth()){
			return true;
		}
		for(int i = 0; i < openlist.size(); i++){
			if(openlist.get(i).x == x && openlist.get(i).y == y){
				return true;
			}
			
			
		}
		for(int i = 0; i < closedlist.size(); i++){
		
			if(closedlist.get(i).x == x && closedlist.get(i).y == y){
				return true;
			}
		}
		return false;
	}
	
	
	public int getH(int x,int y){
		int h = 0;
		if(x<endX){
			x = (endX - x)*10;
		}else if(x>endX){
			x = (x -endX)*10;
		}else{
			x=0;
		}
		if(y<endY){
			y = (endY - y)*10;
		}else if(y>endY){
			y = (y -endY)*10;
		}else{
			y=0;
		}
		
		h = x+y;
		return h;
	}
	
	
	//gets
	public int getStartX(){
		return startX;
	}
	public int getStartY(){
		return startY;
	}
	public int getEndX(){
		return endX;
	}
	public int getEndY(){
		return endY;
	}
	
}

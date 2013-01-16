package aStar;

public class Node {

	public int x,y,g,h, from;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	Node(int x, int y,int g, int h,int from){
		this.x = x;
		this.y = y;
		this.g = g;
		this.h = h;
		this.from = from;
	}
}

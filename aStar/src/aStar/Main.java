package aStar;

public class Main {
	
	// Till nästa gång kan du kolla på att göra så det inte går att snädda vid hörn
	//ränker mig om det är stängt åt ett håll så kan den inte se om det är öppet
	//brevid den punkten.
	//så först kolla nwes se kolla diagonaler.

	static Map map;
	public static void main(String[] args) throws InterruptedException{
		map = new Map(6,6);
		Pos player = new Pos(0,5);
		
		Movment move = new Movment(0,3,5,3);
		move.findPath();
		
//		while(true){
//			System.out.println(player.getX() + "," + player.getY());
//			if(player.getX() != toX || player.getY() != toY){
//				player.move(toX, toY);
//			}else{
//				System.out.println("Win");
//				break;
//			}
//			Thread.sleep(200);
//		}
	}
}

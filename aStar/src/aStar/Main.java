package aStar;

public class Main {
	
	// Till n�sta g�ng kan du kolla p� att g�ra s� det inte g�r att sn�dda vid h�rn
	//r�nker mig om det �r st�ngt �t ett h�ll s� kan den inte se om det �r �ppet
	//brevid den punkten.
	//s� f�rst kolla nwes se kolla diagonaler.

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

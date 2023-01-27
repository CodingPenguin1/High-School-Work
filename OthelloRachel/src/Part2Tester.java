
public class Part2Tester {
	public static void main(String[]args){
		HumanOthelloPlayer h = new HumanOthelloPlayer("bob");
		StupidComputerPlayer sc = new StupidComputerPlayer("ROBO1");
		Location hum = h.move();
		Location scc = sc.move();
		System.out.println("Row: "+hum.getRow()+" Col: "+hum.getCol());
		System.out.println("Row: "+scc.getRow()+" Col: "+scc.getCol());
		
	}

}

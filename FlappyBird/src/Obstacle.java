import java.util.ArrayList;

public class Obstacle{
	
	private int rand;
	private Top tP0 = new Top(650,-100 ,50,300); 
	private Top tP1 = new Top(900,-200 ,50,300); 
	private Top tP2 = new Top(1250,-250,50, 300); 
	private Top tP3 = new Top(1600,-190 ,50,300); 
	private Top tP4 = new Top(1950,-170 ,50,300); 
	private Bottom bP0 = new Bottom(650,300,50,300);
	private Bottom bP1 = new Bottom(900,200,50,300);
	private Bottom bP2 = new Bottom(1250,150,50,300);
	private Bottom bP3 = new Bottom(1600,210,50,300);
	private Bottom bP4 = new Bottom(1950,230,50,300);
	private ArrayList<Top> tPipe = new ArrayList<Top>();
	private ArrayList<Bottom> bPipe = new ArrayList<Bottom>();
	
	public Obstacle(){
		tPipe.add(tP0);
		tPipe.add(tP1);
		tPipe.add(tP2);
		tPipe.add(tP3);
		tPipe.add(tP4);
		bPipe.add(bP0);
		bPipe.add(bP1);
		bPipe.add(bP2);
		bPipe.add(bP3);
		bPipe.add(bP4);
	}// end constructor	
	
	public ArrayList<Top> getListTop(){
		return tPipe;
	} 
	public ArrayList<Bottom> getListBot(){
		return bPipe;
	}
	
	public int random(){
		rand = (int)( Math.random()*5);
		return rand;
	}//
	
	public Top getTop(int n){
		return tPipe.get(n);
	}//
	
	public Bottom getBot(int m){
		return bPipe.get(m);
	}
}

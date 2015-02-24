import java.awt.Rectangle;

public class Bottom extends GameObject{
	private Rectangle rBot;
	
	public Bottom(int x, int y, int w, int h){
		this.width = w;
		this.height = h;
		this.X = x;
		this.Y = y;
		rBot = new Rectangle(x,y,w,h);	
		}// end Bottom constructor
		
	//Makes the top move
	public int moveLeft(){
		this.X -= 17; 			//Updates bottom's X coordinate
		int left = this.X;				
		rBot.x = this.X;	    //Updates Rectangle's X to match with top's X
		return left;		
	}// end moveLeft method
	
	public Rectangle getRectBot(){
		return rBot;
	}// 
	
}// end class Obstacles

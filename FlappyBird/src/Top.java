import java.awt.Image;
import java.awt.Rectangle;

public class Top extends GameObject{
	private Rectangle rTop;
	
	public Top(int x, int y, int w, int h){
		this.width = w;
		this.height = h;
		this.X = x;
		this.Y = y;
		rTop = new Rectangle(x,y,w,h-5);	
		}// end Top constructor
		
	//Makes the top move
	public int moveLeft(){
		this.X -= 17; 			    //Updates top's X coordinate
		int left = this.X;				
		rTop.x = this.X - 3;	    //Updates Rectangle's X to match with top's X
		return left;		
	}// end moveLeft method
		
	public Rectangle getRectTop(){
		return rTop;
	}// 
	
}// end class Obstacles

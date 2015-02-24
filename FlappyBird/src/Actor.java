import java.awt.Rectangle;

public class Actor extends GameObject {
	private int gravity = 6; 
	private Bullet bullet;
	private Rectangle rectFlappy; 
	//Creates a flappy object at (X,Y) in pixels with desired height and width
	
	// (X,Y) then Width and Height in pixels
	public Actor(int X, int Y, final int w, final int h) 
	{
		this.X = X;
		this.Y = Y;
		this.height = h;
		this.width = w;
		rectFlappy = new Rectangle(X,Y,w-25,h);
	}// end Constructor
		
	//Makes flappy jump up
	public int jump(){
		this.Y -= 32; 			//Updates flappy's Y coordinate
		int jump = this.Y;				
		rectFlappy.y = this.Y;	//Updates Rectangle's Y to match with flappy's Y

		return jump;		
	}// end jump method
	
	//Makes flappy fall 
	public int fall(){			
		this.Y += gravity;		//Updates flappy's Y coordinate
		int downFall = this.Y;
		rectFlappy.y = this.Y;	//Updates Rectangle's Y coordinate to match with flappy's Y
		return downFall;
	}// end fall method	
	
	public Bullet shoot(){	
		bullet = new Bullet(this.getX(), this.getY(), 20, 20);
		bullet.setBulletY(this.getY());
		return bullet;
	}// end shoot method 

	public boolean death(int h){
		//checks out of bounds for flappy
		if( this.Y < -25 || this.Y > h + 20){
			return true;
		}
		return false;
	}// end death method
	
	/*
	 * 
	 * For the Rectangle
	 * 
	 */
	
	//Gets the Rectangle X coordinate for Flappy
	public Rectangle getRect(){
		return rectFlappy;
	}// 
	public int getRectXF(){
		return (int) rectFlappy.getX();
	}// end get Rectangle X coordinate for Flappy
	
	// Gets the Rectangle Y Coordinate for Flappy
	public int getRectYF(){
		return (int) rectFlappy.getY();
	}// end get Rectangle Y coordinate for Flappy
	
	// Gets the Rectangle Height for Flappy
	public int getRectHF(){
		return (int) rectFlappy.getHeight();
	}// end get Rectangle Height for Flappy
	
	// Gets the Rectangle Width for Flappy
	public int getRectWF(){
		return (int) rectFlappy.getWidth();
	}// end get Rectangle Width for Flappy
	
}// end Actor class 

import java.awt.Rectangle;

public class Bullet extends GameObject{	
	private Rectangle rectB;
	
	public Bullet(final int X, final int Y, final int height, final int width){
		this.Y = Y;
		this.X = X; 
		this.height = height;
		this.width = width;
		rectB = new Rectangle(X,Y,width,height);
	}// end constructor
			
	public void setBulletY(int Y){
		rectB.y = Y;
		this.Y = Y;
	}// end setBullet
	
	public int bulletYPos(){
		return this.Y;
	}// end bulletYPos
			
	public int velocity(int bulletSpeed){
		this.X += bulletSpeed;
		int temp = this.X;
		rectB.x = temp;
		return temp;
	}// end velocity
	
	public Rectangle getBRect(){
		return rectB;
	}//
}// end Ammo class

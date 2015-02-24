import java.awt.*; 
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Game {
	private Actor flappy = new Actor(32,150,35,35); // At (32,150) with 30 width and 30 height
	private Obstacle pipeSet = new Obstacle();
	Timer t;	
	public Game(Timer t) throws IOException {
		this.t = t;
	}

	/**
	 * Method called by the GUI main frame to update its internal graphics.
	 * 
	 * @param g
	 *            The canvas
	 * @param width
	 *            in pixels
	 * @param height
	 *            in pixels
	 * @param key
	 *            The numeric key pressed see class KeyEvent
	 */
	Image bg = ImageIO.read(new File("bg.png"));
	Image alive = ImageIO.read(new File("flappy.png"));
	Image go2 = ImageIO.read(new File("go2.png"));
	Image top = ImageIO.read(new File("top.png"));
	Image bottom = ImageIO.read(new File("bottom.png"));
	Image proj;	
	int rand;
	Random gen = new Random();
		
	CopyOnWriteArrayList<Bullet> ammo = new CopyOnWriteArrayList<Bullet>();

	public void updateGraphics(Graphics g, int width, int height, int key) {
		try {
			rand = gen.nextInt(500) + 1100;
			
			g.drawImage(bg, 
					0, // x pixel
					0, // y pixel
					width, // width of image.
					height,// height of image.
					null);
					// end Background drawing
			//Draws Set 1 of PipeSet
			g.drawImage(top, pipeSet.getTop(0).getX(),  // x pixel
					pipeSet.getTop(0).getY(), // y pixel
					pipeSet.getTop(0).getWidth(), // width of image.
					pipeSet.getTop(0).getHeight(), // height of image.
					null);
			pipeSet.getTop(0).moveLeft();
			g.drawImage(bottom, pipeSet.getBot(0).getX(),  // x pixel
					pipeSet.getBot(0).getY(), // y pixel
					pipeSet.getBot(0).getWidth(), // width of image.
					pipeSet.getBot(0).getHeight(), // height of image.
					null);
			pipeSet.getBot(0).moveLeft();		
			if(pipeSet.getBot(0).getX() < -400 && pipeSet.getTop(0).getX() < -400 )
			{
				pipeSet.getBot(0).setX(rand);
				pipeSet.getTop(0).setX(rand);
			}
			if(flappy.getRect().intersects(pipeSet.getTop(0).getRectTop())|| 
					   flappy.getRect().intersects(pipeSet.getBot(0).getRectBot())){
						int death = flappy.getY(); 
						g.drawImage(go2,0,0,width,height,null);
						g.drawImage(alive, flappy.getX(), death, 35, 35, null);
						t.stop();
			}
			rand = gen.nextInt(500) + 1000;
			//Draws Set 2 of PipeSet			
			g.drawImage(top, pipeSet.getTop(1).getX(),  // x pixel
					pipeSet.getTop(1).getY(), // y pixel
					pipeSet.getTop(1).getWidth(), // width of image.
					pipeSet.getTop(1).getHeight(), // height of image.
					null);
			pipeSet.getTop(1).moveLeft();			
			g.drawImage(bottom, pipeSet.getBot(1).getX(),  // x pixel
					pipeSet.getBot(1).getY(), // y pixel
					pipeSet.getBot(1).getWidth(), // width of image.
					pipeSet.getBot(1).getHeight(), // height of image.
					null);
			pipeSet.getBot(1).moveLeft();	
			if(pipeSet.getBot(1).getX() < -400 && pipeSet.getTop(1).getX() < -400 )
			{
				pipeSet.getBot(1).setX(rand);
				pipeSet.getTop(1).setX(rand);
			}
			if(flappy.getRect().intersects(pipeSet.getTop(1).getRectTop())|| 
					   flappy.getRect().intersects(pipeSet.getBot(1).getRectBot())){
						int death = flappy.getY(); 
						g.drawImage(go2,0,0,width,height,null);
						g.drawImage(alive, flappy.getX(), death, 35, 35, null);
						t.stop();
			}
			
			rand = gen.nextInt(500) + 1000;
			//Draws the 3rd set of PipeSet
			g.drawImage(top, pipeSet.getTop(2).getX(),  // x pixel
					pipeSet.getTop(2).getY(), // y pixel
					pipeSet.getTop(2).getWidth(), // width of image.
					pipeSet.getTop(2).getHeight(), // height of image.
					null);
			pipeSet.getTop(2).moveLeft();
			g.drawImage(bottom, pipeSet.getBot(2).getX(),  // x pixel
					pipeSet.getBot(2).getY(), // y pixel
					pipeSet.getBot(2).getWidth(), // width of image.
					pipeSet.getBot(2).getHeight(), // height of image.
					null);
			pipeSet.getBot(2).moveLeft();
		    
			//Handles putting the pipe back on
			if(pipeSet.getBot(2).getX() < -400 && pipeSet.getTop(2).getX() < -400 )
			{
				pipeSet.getBot(2).setX(rand);
				pipeSet.getTop(2).setX(rand);
			}
			//Randomly puts a pipe back
			
			//Collision Detection
			if(flappy.getRect().intersects(pipeSet.getTop(2).getRectTop())|| 
					   flappy.getRect().intersects(pipeSet.getBot(2).getRectBot())){
						int death = flappy.getY(); 
						g.drawImage(go2,0,0,width,height,null);
						g.drawImage(alive, flappy.getX(), death, 35, 35, null);
						t.stop();
			}// Collision Detection
						
			rand = gen.nextInt(500) + 1000;
			//Draws the 4th set of PipeSet
			g.drawImage(top, pipeSet.getTop(3).getX(),  // x pixel
					pipeSet.getTop(3).getY(), // y pixel
					pipeSet.getTop(3).getWidth(), // width of image.
					pipeSet.getTop(3).getHeight(), // height of image.
					null);
			pipeSet.getTop(3).moveLeft();
			g.drawImage(bottom, pipeSet.getBot(3).getX(),  // x pixel
					pipeSet.getBot(3).getY(), // y pixel
					pipeSet.getBot(3).getWidth(), // width of image.
					pipeSet.getBot(3).getHeight(), // height of image.
					null);
			pipeSet.getBot(3).moveLeft();
			
			// Handles putting pipes back on the screen
			if(pipeSet.getBot(3).getX() < -400 && pipeSet.getTop(3).getX() < -400 ) 
			{
				pipeSet.getBot(3).setX(rand);
				pipeSet.getTop(3).setX(rand);
			}
			// Once the pipe goes off-screen, it'll randomly place the pipe back onto the screen
			
			//Collision Detection
			if(flappy.getRect().intersects(pipeSet.getTop(3).getRectTop())|| 
					   flappy.getRect().intersects(pipeSet.getBot(3).getRectBot())){
						int death = flappy.getY(); 
						g.drawImage(go2,0,0,width,height,null);
						g.drawImage(alive, flappy.getX(), death, 35, 35, null);
						t.stop();
			}
			//Collision Detection
			
			rand = gen.nextInt(500) + 1000;
			//Draws the 5th set of PipeSet
			g.drawImage(top, pipeSet.getTop(4).getX(),  // x pixel
					pipeSet.getTop(4).getY(), // y pixel
					pipeSet.getTop(4).getWidth(), // width of image.
					pipeSet.getTop(4).getHeight(), // height of image.
					null);
			pipeSet.getTop(4).moveLeft();			
			g.drawImage(bottom, pipeSet.getBot(4).getX(),  // x pixel
					pipeSet.getBot(4).getY(), // y pixel
					pipeSet.getBot(4).getWidth(), // width of image.
					pipeSet.getBot(4).getHeight(), // height of image.
					null);
			pipeSet.getBot(4).moveLeft();
			if(pipeSet.getBot(4).getX() < -400 && pipeSet.getTop(4).getX() < -400 )
			{
				pipeSet.getBot(4).setX(rand);
				pipeSet.getTop(4).setX(rand);
			}
			if(flappy.getRect().intersects(pipeSet.getTop(4).getRectTop())|| 
					   flappy.getRect().intersects(pipeSet.getBot(4).getRectBot())){
						int death = flappy.getY(); 
						g.drawImage(go2,0,0,width,height,null);
						g.drawImage(alive, flappy.getX(), death, 35, 35, null);
						t.stop();
			}
								
					//Draws flappy to the screen
			g.drawImage(alive, 
					flappy.getX(), // x pixel
					flappy.getY(), // y pixel
					flappy.getWidth(), // width of image.
					flappy.getHeight(), // height of image.
					null);
					// Draws flappy to the screen
			
					// makes the fox fall
					flappy.fall();
					// makes the fox fall
		//	g.fillRect(flappy.getRectXF(), 
		//			   flappy.getRectYF(), 
		//   		   flappy.getRectWF(), 
		//	     	   flappy.getRectHF());
			
	
					// Makes the fox jump
					if( key == KeyEvent.VK_SPACE){
						flappy.jump(); 
						} 
					// Makes the fox jump
						 					
					// Makes the fox shoot a bullet
					if( key == KeyEvent.VK_CONTROL ){ // Uses the "Ctrl" key to shoot
						proj = ImageIO.read(new File("bullet.png"));
						ammo.add(flappy.shoot());					
						}
					// Makes the fox shoot a bullet
					
					for(Bullet bullet: ammo){
						bullet.velocity(32); // Sets the velocity 32
						if(bullet.getX()> width){  
							ammo.remove(bullet); // Removes the bullet when it reaches the end of the screen
						}						 // so that it does not take up unnecessary memory
						else if (bullet.getBRect().intersects(pipeSet.getTop(0).getRectTop())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getBot(0).getRectBot())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getTop(1).getRectTop())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getBot(1).getRectBot())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getTop(2).getRectTop())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getBot(2).getRectBot())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getTop(3).getRectTop())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getBot(3).getRectBot())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getTop(4).getRectTop())){
							ammo.remove(bullet);
						}
						else if (bullet.getBRect().intersects(pipeSet.getBot(4).getRectBot())){
							ammo.remove(bullet);
						}
						
						// Draws the bullet to the screen
						g.drawImage(proj, bullet.getX(), 
										  bullet.getY(), 
										  bullet.getHeight(), 
										  bullet.getWidth(), null); 
						// Draws the bullet to the screen
						
						//Draws a black box over the bullet for testing
					//	g.fillRect(bullet.getX(), 
					//			   bullet.getY(), 
					//			   bullet.getWidth(), 
					//			   bullet.getHeight());  
						// Draws a black box over the bullet for testing	
						
						}// for each loop to shoot multiple bullets

					// Draws the game over screen
					if(flappy.death(height)){ // Checks if it is out of bounds						
						int death = flappy.getY(); 
						g.drawImage(go2,0,0,width,height,null);
						g.drawImage(ImageIO.read(new File("fox_dead.png")), flappy.getX(), death, 40, 40, null);
						t.stop();
					}// Draws the game over screen
											
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch block
	}
}// end Game class
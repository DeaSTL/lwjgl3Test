package gameLoop;

import com.sudoplay.joise.noise.function.Function2DSimplex;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowCloseCallback;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL15.*;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.memAllocFloat;

import java.nio.FloatBuffer;

import javax.swing.text.GlyphView;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWWindowCloseCallback;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryStack;

import event.KeyboardHandler;
import event.WindowHandler;
import graphics.Cube;
import graphics.Display;
import graphics.Square;
import graphics.TerrainMesh;
import graphics.Triangle;
import player.Camera;

/**
 * @author deastl
 *
 */

public class GameThread implements Runnable {

	Thread runner;

	private Display display;
	private long window;
	private GLFWKeyCallback keyCallback;
	private GLFWWindowCloseCallback closeCallback;
	private boolean isRunning = true;
	private int counter = 0;
	
	
	/**
	 * Creates model objects
	 */
	public Triangle mod = new Triangle();
	public TerrainMesh mod1 = new TerrainMesh();
	public Camera player = new Camera(0,0,0);

	public GameThread(String threadName){
		runner = new Thread(this,threadName);
		runner.start();
	}

	public void init(){
		display = new Display(1280,720,"Title");
		window = display.getWindow();
		
	


		glfwSetKeyCallback(window, keyCallback = new KeyboardHandler());
		glfwSetWindowCloseCallback(window,closeCallback = new WindowHandler());




		createCapabilities();
		
		glMatrixMode(GL_MODELVIEW);
		glMatrixMode(GL_PROJECTION);
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	
		//glViewport(0, 0, display.getWidth(), display.getHeight());
		//glOrtho(0.001f, display.getWidth()/200, 0.001f, display.getHeight()/200, -0.001f, 0.001f);
		
		
		
		mod1.LoadModel();
		glScaled(0.1, 0.1, 0.1);
		glTranslatef(0.0f,0.0f,-1.0f);	
		

	}
	@Override
	public void run(){
		init();
		loop();
		clean();

	}
	public void clean(){
		display.dispose();
		glfwTerminate();
		//this.stop();
		//this.destroy();

	}
	public void loop(){
		while(isRunning){
			draw();

			pollevents();
			update();
			try {
				runner.sleep(1000/30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}
	public void draw(){
		glClear(GL_COLOR_BUFFER_BIT);
		
		glColor3f(1.0f, 0.0f, 0.0f);
		//mod.render();
		//glColor3f(0.0f, 1.0f, 1.0f);
		mod1.render();
		glRotatef(1.0f, 1.0f, 1.0f, 0.0f);
		glTranslatef(player.position.x, player.position.y, player.position.z);





		//glfwSwapBuffers(window);
	}
	
	/**
	 * Updates the window objects and polls events
	 *  
	 */
	public void update(){
		glfwSwapBuffers(window);
		glfwPollEvents();
		player.lookThrough();
	}
	
	/**
	 * Checks for key presses and window events
	 */
	public void pollevents(){

		if(KeyboardHandler.isKeyDown(GLFW_KEY_SPACE)){
			player.FlyUp(1);
		}
		if(KeyboardHandler.isKeyDown(GLFW_KEY_ESCAPE)){
			isRunning = false;
		}
		if(KeyboardHandler.isKeyDown(GLFW_KEY_W)){
			player.walkForward(1);
			System.out.println(player.position.x);
		}
		if(KeyboardHandler.isKeyDown(GLFW_KEY_S)){
			player.walkBackwards(1);
		}
		if(glfwWindowShouldClose(window)){
			isRunning = false;

		}

	}



}

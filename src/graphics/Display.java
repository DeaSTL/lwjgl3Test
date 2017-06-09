package graphics;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.glfw.GLFW.*;

public class Display {
	private long window;
	private int width;
	private int height;
	
	private String title;
	
	public Display(int width,int height,String title){
		this.width = width;
		this.height = height;
		this.title = title;
		initialize();
		
	}
	private void initialize(){
		glfwInit();
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE,GLFW_TRUE);
		window = glfwCreateWindow(width,height,title,NULL,NULL);
		glfwSwapInterval(2);
		glfwMakeContextCurrent(window);
		

	}
	public void sync(float frameRate){
		
	}
	public long getWindow() {
		return window;
	}

	public void setWindow(long window) {
		this.window = window;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void dispose(){
		glfwDestroyWindow(window);
	}
	public void show(){
		glfwShowWindow(window);
	}
}

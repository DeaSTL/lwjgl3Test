package event;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWWindowCloseCallback;

public class WindowHandler extends GLFWWindowCloseCallback{
	private static boolean closeRequest = false;
	@Override
	public void invoke(long arg0) {
		// TODO Auto-generated method stub
		closeRequest = true;
		
	}
	public boolean isCloseRequested(){
		return closeRequest;
	}
	
}

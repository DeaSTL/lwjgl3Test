package player;

import org.lwjgl.opengl.GL11;

import utils.Vector3;


public class Camera {

	public Camera() {
		// TODO Auto-generated constructor stub
	}
	//3d vector to store the camera's position in
    public   Vector3   position    = null;
    //the rotation around the Y axis of the camera
    private float       yaw         = 1.0f;
    //the rotation around the X axis of the camera
    private float       pitch       = 1.0f;
    public Camera(float x, float y, float z){
    	position = new Vector3(x,y,z);
    }
    public void yaw(float amount){
    	yaw += amount;
    }
    public void pitch(float amount){
    	pitch += amount;
    }
    public void walkForward(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw));
    }
    
     
    //moves the camera backward relative to its current rotation (yaw)
    public void walkBackwards(float distance)
    {
        position.x += distance * (float)Math.sin(Math.toRadians(yaw));
        position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
    }
     
    //strafes the camera left relitive to its current rotation (yaw)
    public void strafeLeft(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
    }
     
    //strafes the camera right relitive to its current rotation (yaw)
    public void strafeRight(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
    }
    public void FlyUp(float distance){
    	position.y -= distance;
    }
    //translates and rotate the matrix so that it looks through the camera
    //this dose basic what gluLookAt() does
    public void lookThrough()
    {
        //roatate the pitch around the X axis
        GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        //roatate the yaw around the Y axis
        GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        
        //translate to the position vector's location
        GL11.glTranslatef(position.x, position.y, position.z);
    }

}

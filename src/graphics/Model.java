package graphics;

import java.nio.FloatBuffer;

import org.lwjgl.system.MemoryStack;
import static org.lwjgl.system.MemoryUtil.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import static org.lwjgl.system.MemoryStack.*;

public abstract class Model {
	public float[] vertices;
	public FloatBuffer buffer;
	public int vbo;
	public int shapeType = GL_TRIANGLES;
	
	public Model() {
		
	}
	public abstract float[] getVertices();
	
	public int getArrayLength(){
		return getVertices().length;
	}
	public void GenerateBuffer(){
		try(MemoryStack stack = stackPush()){
			buffer = memAllocFloat(getArrayLength());
			
			buffer.put(vertices);
			
			buffer.flip();
		}
	}
	public void GenerateVBO(){
		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER,  buffer, GL_STATIC_DRAW);
		glEnableClientState(GL_VERTEX_ARRAY);
		glVertexPointer(3, GL_FLOAT, 0, 0L);
		
	}
	public void LoadModel(){
		vertices = getVertices();
		GenerateBuffer();
		GenerateVBO();
		
	}
	public void render(){
		glDrawArrays(shapeType, 0, getVertices().length);
	
	}
	
	

}

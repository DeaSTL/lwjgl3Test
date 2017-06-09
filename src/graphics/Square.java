package graphics;
import static org.lwjgl.opengl.GL11.*;

public class Square extends Model {
	public Square(){
		shapeType = GL_QUADS;
	}
	@Override
	public float[] getVertices() {
		float[] out = new float[]{
				 1.0f, 1.0f,0.0f,
				 1.0f,-1.0f,0.0f,
				-1.0f,-1.0f,0.0f,
				-1.0f, 1.0f,0.0f
				
			};
		return out;
		
	}

	

}

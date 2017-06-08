package graphics;

public class Triangle extends Model{

	

	@Override
	public float[] getVertices() {
		float[] out = new float[]{
			-1.0f,0.0f,0.0f,
			 1.0f,0.0f,0.0f,
			 0.0f,1.0f,0.0f
			
		};
		return out;
	}

}

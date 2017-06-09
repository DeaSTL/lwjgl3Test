package graphics;

import com.sudoplay.joise.noise.Interpolator;
import com.sudoplay.joise.noise.function.Function2DGradient;
import com.sudoplay.joise.noise.function.Function2DSimplex;

import utils.Vector3;

import static org.lwjgl.opengl.GL11.*;

import java.util.Arrays;
public class TerrainMesh extends Model {

	public TerrainMesh() {
		shapeType = GL_LINE_LOOP;
	}

	@Override
	public float[] getVertices() {
		
		//System.out.println(Arrays.toString(generateVerts(20)));
		return generateVerts(20);
		
	}
	private float[] generateVerts(int size){
		Function2DSimplex noise = new Function2DSimplex();
		float[] verts = new float[(size*size)*3];
		Vector3[][] nodes = GenerateNodes(size);

		for(int x = 0; x < size;x++){
			for(int y = 0; y < size;y++){
				nodes[x][y].y = (float)noise.get(x, y, 123942343L, Interpolator.LINEAR);
				System.out.println(nodes[x][y].y);
				verts[0+(x*y)] = x;
				verts[1+(x*y)] = nodes[x][y].y; 
				verts[2+(x*y)] = y;
			}
		}
		return verts;
	}
	public Vector3[][] GenerateNodes(int size){
		Vector3[][] nodes = new Vector3[size][size];
		for(int x = 0;x<size;x++){
			for(int y = 0;y<size;y++){
				nodes[x][y] = new Vector3(x,0,y);
			}
		}
		return nodes;
	}

}

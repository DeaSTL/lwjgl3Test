package graphics;

import com.sudoplay.joise.noise.Interpolator;
<<<<<<< HEAD
=======
import com.sudoplay.joise.noise.function.Function2DGradient;
>>>>>>> 82e41156984ef777300f19e568a9f1102bc80e23
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
		
<<<<<<< HEAD
		System.out.println(Arrays.toString(generateVerts(20)));
=======
		//System.out.println(Arrays.toString(generateVerts(20)));
>>>>>>> 82e41156984ef777300f19e568a9f1102bc80e23
		return generateVerts(20);
		
	}
	private float[] generateVerts(int size){
		Function2DSimplex noise = new Function2DSimplex();
		float[] verts = new float[(size*size)*3];
<<<<<<< HEAD
		Vector3[] nodes = GenerateNodes(size);
		
		for(int x = 0; x < size;x++){
			for(int y = 0; y < size;y++){
				nodes[x*y].y = (float)noise.get(x, y, 123942343L, Interpolator.NONE)/10;
				verts[0+(x*y)] = x;
				verts[1+(x*y)] = nodes[x*y].y; 
=======
		Vector3[][] nodes = GenerateNodes(size);

		for(int x = 0; x < size;x++){
			for(int y = 0; y < size;y++){
				nodes[x][y].y = (float)noise.get(x, y, 123942343L, Interpolator.LINEAR);
				System.out.println(nodes[x][y].y);
				verts[0+(x*y)] = x;
				verts[1+(x*y)] = nodes[x][y].y; 
>>>>>>> 82e41156984ef777300f19e568a9f1102bc80e23
				verts[2+(x*y)] = y;
			}
		}
		return verts;
	}
<<<<<<< HEAD
	public Vector3[] GenerateNodes(int size){
		Vector3[] nodes = new Vector3[size*size];
		for(int x = 0;x<size;x++){
			for(int y = 0;y<size;y++){
				nodes[x*y] = new Vector3(x,y,0);
=======
	public Vector3[][] GenerateNodes(int size){
		Vector3[][] nodes = new Vector3[size][size];
		for(int x = 0;x<size;x++){
			for(int y = 0;y<size;y++){
				nodes[x][y] = new Vector3(x,0,y);
>>>>>>> 82e41156984ef777300f19e568a9f1102bc80e23
			}
		}
		return nodes;
	}

}

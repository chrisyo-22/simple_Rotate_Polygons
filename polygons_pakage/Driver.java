package polygons_pakage;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Driver {
	public static void main(String[] args) throws Exception{ 
		Mesh mesh =new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("D:\\JavaPrograms\\B09 A1/temp.txt"); 
		//mesh.rotateYAxis(Math.PI/3);
		//mesh.setWriter(new OBJMeshWriter());
		//mesh.writeToFile("D:\\JavaPrograms\\B09 A1/test_write.obj");
		mesh.setWriter(new PLYMeshWriter());
		mesh.writeToFile("D:\\JavaPrograms\\B09 A1/test_read.ply");
		
	
	}
}	

package polygons_pakage;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class PLYMeshWriter implements MeshWriter{


	@Override
	public void write(String fileName, HashSet<Polygon> polygons) throws Exception {

		FileWriter filewrite = new FileWriter(fileName, false);
		ArrayList <Vertex> all_vertices = new ArrayList<Vertex>();
		ArrayList<ArrayList<Integer>> index_poly = new ArrayList<ArrayList<Integer>>();
		
		//do size in here
		for (Polygon poly: polygons) {
			ArrayList<Integer> temp_indexes = new ArrayList<Integer>();
			for(Vertex vertex:poly.vertices) {
				if(!all_vertices.contains(vertex)) {
					all_vertices.add(vertex);
				}
				temp_indexes.add(all_vertices.indexOf(vertex)+1);
			}
			index_poly.add(temp_indexes);
		}
		//System.out.println("Hello");

		filewrite.write("ply"+'\n');
		filewrite.write("format ascii 1.0"+'\n');
		filewrite.write("element vertex"+ " " +all_vertices.size()+'\n');
		filewrite.write("property float32 x"+'\n');
		filewrite.write("property float32 y"+'\n');
		filewrite.write("property float32 z"+'\n');
		filewrite.write("element face" + " " + index_poly.size()+'\n');
		filewrite.write("property list uint8 int32 vertex_indices"+'\n');
		filewrite.write("end_header"+'\n');
		
		for(Vertex i:all_vertices) {
			filewrite.write(i.getX()+ " " + i.getY()  + " "+ i.getZ() +'\n');
			//filewrite.write("v " + i.getX()+ " " + i.getY()  + " "+ i.getZ() +'\n');
		}
		for(int i = 0; i<index_poly.size();i++) {
			//System.out.println("my "+index_poly.get(i).size());
			filewrite.write(""+index_poly.get(i).size());
			for(int j = 0; j<index_poly.get(i).size();j++) {
				filewrite.write(" " + (index_poly.get(i).get(j)-1));
			}
			filewrite.write('\n');
		}
		
		
		filewrite.close();
	}
		
	


}

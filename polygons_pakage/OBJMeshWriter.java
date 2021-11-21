package polygons_pakage;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class OBJMeshWriter implements MeshWriter{
	
	@Override
	public void write(String fileName, HashSet<Polygon> polygons) throws Exception {

		
		FileWriter filewrite = new FileWriter(fileName, false);
		ArrayList <Vertex> all_vertices = new ArrayList<Vertex>();
		ArrayList<ArrayList<Integer>> index_poly = new ArrayList<ArrayList<Integer>>();
		//do size in here
		//int u = 0;
		for (Polygon poly: polygons) {
			ArrayList<Integer> temp_indexes = new ArrayList<Integer>();
			for(Vertex vertex:poly.vertices) {
				//u++;
				if(!all_vertices.contains(vertex)) {
					all_vertices.add(vertex);
				}
//				else if(all_vertices.contains(vertex)) {
//					System.out.println(all_vertices.get(all_vertices.indexOf(vertex)));
//					System.out.println(vertex);
//				}
				temp_indexes.add(all_vertices.indexOf(vertex)+1);
			}
			index_poly.add(temp_indexes);
		}
		//System.out.println("my length(polygons *its vertices) is: 31422, output is: "+ u);
		for(Vertex i:all_vertices) {
			filewrite.write("v " + i.getX()+ " " + i.getY()  + " "+ i.getZ() +'\n');
			//filewrite.write("v " + i.getX()+ " " + i.getY()  + " "+ i.getZ() +'\n');
		}
		for(int i = 0; i<index_poly.size();i++) {
			filewrite.write("f");
			for(int j = 0; j<index_poly.get(i).size();j++) {
				filewrite.write(" " + index_poly.get(i).get(j));
			}
			filewrite.write('\n');
		}
		
		
		filewrite.close();
	}

}

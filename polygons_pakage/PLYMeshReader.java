package polygons_pakage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class PLYMeshReader implements MeshReader{
	
	@Override
	public HashSet<Polygon> read(String fileName) throws Exception {
		int num_vertex = 0;
		int num_face = 0;
		HashSet<Polygon> my_Polygon = new HashSet<Polygon>();
		//ArrayList<ArrayList<Double>> all_vertices= new ArrayList<ArrayList<Double>>();
		File f = new File(fileName);
		
		if(f.getName().matches(".*\\.ply")) {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String line = reader.readLine();
			while(line != null && !line.startsWith("end_header")) {
				if(line != null && line.startsWith("element vertex")) {
					String[] num_vertex_string = line.split("vertex ");
					num_vertex = Integer.parseInt(num_vertex_string[1].strip());
					//System.out.println("The number of verties is : " + num_vertex);
				}
				if(line != null && line.startsWith("element face")) {
					String[] num_face_string = line.split("face ");
					num_face = Integer.parseInt(num_face_string[1].strip());
					//System.out.println("The number of verties is : " + num_face);
				}
				//System.out.println(line);
				line = reader.readLine();
			}
			double[][] all_vertices = new double[num_vertex][3];
			
			for(int i = 0; i< num_vertex; i++) {
				line = reader.readLine();
				//store all vertices into an arrayList.
				String[] tokens_vertices = line.split(" ");
				double[] num_array = Arrays.stream(tokens_vertices).mapToDouble(Double::parseDouble).toArray();
				all_vertices[i] = num_array;
				
				//System.out.println(line);
				
			}
			//2D:
			//System.out.println(Arrays.deepToString(all_vertices_1));
			//1D:
			//System.out.println(Arrays.toString(all_vertices_1));

			//store all polygon into 
			for(int i = 0; i < num_face; i++) {
				line = reader.readLine();
				LinkedHashSet <Vertex> my_vertex = new LinkedHashSet<Vertex>();
				
				String[] tokens_polygons = line.split(" ");
				int[] num_poly = Arrays.stream(tokens_polygons).mapToInt(Integer::parseInt).toArray();
				for(int k = 1; k<num_poly[0]+1; k++) {
					double temp_x = all_vertices[num_poly[k]][0];
					double temp_y = all_vertices[num_poly[k]][1];
					double temp_z = all_vertices[num_poly[k]][2];
					//System.out.println(num_poly[0]);
					Vertex t_vertex = new Vertex(temp_x,temp_y,temp_z);
					my_vertex.add(t_vertex);
				}
				Polygon t_polygon = new Polygon(my_vertex);
				
				//System.out.println(line);
				my_Polygon.add(t_polygon);
			}
			
			reader.close();
			
	}
		return my_Polygon;
	}
}

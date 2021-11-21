package polygons_pakage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class OBJMeshReader implements MeshReader{
	
	@Override
	public HashSet<Polygon> read(String fileName) throws Exception {
		HashSet<Polygon> my_Polygon = new HashSet<Polygon>();
		//LinkedHashSet<Vertex> all_Vertices = new LinkedHashSet<Vertex>();
		ArrayList<ArrayList<Double>> all_vertices= new ArrayList<ArrayList<Double>>();
		
		//int u = 0;
		File f = new File(fileName);
		if(f.getName().matches(".*\\.obj")) {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String line = reader.readLine();
			while(line != null) {
				
				if(line != null && line.startsWith("v")) {
					String[] temp_vetex = line.split(" ");
					double t_x,t_y,t_z;
					t_x = Double.parseDouble(temp_vetex[1]);
					t_y = Double.parseDouble(temp_vetex[2]);
					t_z = Double.parseDouble(temp_vetex[3]);
					ArrayList<Double> temp_xyz = new ArrayList<Double>();
					temp_xyz.add(t_x);
					temp_xyz.add(t_y);
					temp_xyz.add(t_z);
					all_vertices.add(temp_xyz); //store all vertices to an 2 dimensional ArrayList so we can easily access using index later.
					
				}
				//System.out.println("my fffffflength is: "+ all_vertices.size());
				
				if(line != null && line.startsWith("f")){
					
					String[] temp_face = line.split(" ");
					//u+=temp_face.length-1;
					//ArrayList<Double> face_index = new ArrayList<Double>();
					LinkedHashSet<Vertex> temp_Vertices = new LinkedHashSet<Vertex>();
					for (String i :temp_face) {
						//System.out.println(i);
						if(!i.startsWith("f")) {
							int f_index = Integer.parseInt(i);
							//System.out.println("my f_index is " +f_index);
							//using x,y,z for a single face index to create a Vertex obj and then add to temp_Vertices
							Vertex temp_v = new Vertex(all_vertices.get(f_index-1).get(0),all_vertices.get(f_index-1).get(1),all_vertices.get(f_index-1).get(2));
							temp_Vertices.add(temp_v);
						}
					}
					//System.out.println(temp_Vertices);
					my_Polygon.add(new Polygon(temp_Vertices));
				}
				
				line = reader.readLine();
			}
			//System.out.println("in mesh reader, totoal length is: " +u);
			
			reader.close();
				
			
		}

		return my_Polygon;


	}
}

package polygons_pakage;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Polygon extends GraphicalObject {
	 protected LinkedHashSet<Vertex> vertices;
	
	
	public Polygon(LinkedHashSet<Vertex> my_Vertex) {
		setVertices(my_Vertex);
	}



	public void setVertices(LinkedHashSet<Vertex> vertices) {
		this.vertices = vertices;
	}

	@Override
	public int hashCode() {
		int result = 0;
		for(Vertex i : vertices) {
			long num = Double.doubleToLongBits(i.hashCode());
			result *= (int)num^ (num>>32);
		}
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(getClass() != obj.getClass()) //this checks if the obj is the instance of the class. So the casting will be fine.
			return false;
		Polygon other = (Polygon)obj;
		ArrayList <Vertex> obj_1 = new ArrayList<Vertex>();
		ArrayList <Vertex> obj_2 = new ArrayList<Vertex>();
		
		if (vertices.size() != other.vertices.size()) return false;
		for(Vertex i: this.vertices) {
			obj_1.add(i);
		}
		for(Vertex i: other.vertices) {
			obj_2.add(i);
		}
		
		for(int i = 0; i < vertices.size();i++) {

			if (!obj_1.get(i).equals(obj_2.get(i)))
				return false;
		}
		return true;
	}
	
	@Override
	public void transform(double[][] matrix) {
		//System.out.println("hello");
		for (Vertex i: vertices) {
			i.transform(matrix);
		}
//		for (Vertex i: vertices) {
//			System.out.println(i.getX());
//			System.out.println(i.getY());
//			System.out.println(i.getZ());
//		}

		
	}
}

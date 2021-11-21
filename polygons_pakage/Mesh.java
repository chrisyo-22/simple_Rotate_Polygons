package polygons_pakage;

import java.util.HashSet;

public class Mesh extends GraphicalObject{
	HashSet<Polygon> polygons;
	MeshReader reader;
	MeshWriter writer;
	
	public void setReader(MeshReader objReader) {
		this.reader = objReader;
	}

	public void setWriter(MeshWriter plyWriter) {
		// TODO Auto-generated method stub
		this.writer = plyWriter;
	}

	public void readFromFile(String file_name) throws Exception {
		polygons = reader.read(file_name);
		
	}
	public void writeToFile(String file_name) throws Exception {
		// TODO Auto-generated method stub
		writer.write(file_name, polygons);
	}

	

	@Override
	public void transform(double[][] matrix) {
		for(Polygon my_polygon: polygons) {
			my_polygon.transform(matrix);
		}
		
	}
	@Override
	public int hashCode() {
		
		int result = 0;
		for(Polygon i: polygons) {
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
		Mesh other = (Mesh)obj;
		if(this.polygons.size()!= other.polygons.size())
			return false;

		for(Polygon this_poly: this.polygons) {
			if(!other.polygons.contains(this_poly)) {
				return false;
			}
		}
		return true;
		//return this.polygons.equals(other.polygons);
//		System.out.println(this.polygons.containsAll(other.polygons));
//		System.out.println(other.polygons.containsAll(this.polygons));
//		return this.polygons.containsAll(other.polygons) && other.polygons.containsAll(this.polygons);
	}

}

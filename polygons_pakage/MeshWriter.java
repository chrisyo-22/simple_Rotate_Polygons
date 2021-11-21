package polygons_pakage;

import java.util.HashSet;

public interface MeshWriter {
	public void write(String fileName, HashSet<Polygon> polygons) throws Exception;
	

}

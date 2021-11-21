package polygons_pakage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashSet;


import org.junit.jupiter.api.Test;

class TesingA1 {
	Vertex v_1 = new Vertex(1,2,3);
	Vertex v_2 = new Vertex(1,2,3);
	Vertex v_3 = new Vertex(1,52,3);
	Vertex v_4 = new Vertex(1,5,43);
	
	Vertex v_5 = new Vertex(11,2,3);
	Vertex v_6 = new Vertex(1,22,23);
	Vertex v_7 = new Vertex(21,2,3);
	Vertex v_8 = new Vertex(1,23,3);
	
	LinkedHashSet<Vertex> rotate_vertices_1 = new LinkedHashSet<Vertex>();
	LinkedHashSet<Vertex> rotate_vertices_2 = new LinkedHashSet<Vertex>();
	
	HashSet<Polygon> sum_polygons_1 = new HashSet<Polygon>();
	HashSet<Polygon> sum_polygons_2 = new HashSet<Polygon>();
	Mesh mesh = new Mesh();
	

	
	
	//Vertex class:
	@Test
	void testHashCode_1_vertex() {
		Vertex temp_1 = new Vertex(1,2,3);
		Vertex temp_2 = new Vertex(1,2,3);
		assertEquals(temp_1.hashCode(),temp_2.hashCode());
	}
	@Test
	void testHashCode_2_vertex() {
		Vertex temp_1 = new Vertex(1,1,3.01);
		Vertex temp_2 = new Vertex(1,1,3.0);
		assertNotEquals(temp_1.hashCode(),temp_2.hashCode());
	}
	@Test
	void testEquals_1_vertex() {
		Vertex temp_1 = new Vertex(1,1,3.01);
		Vertex temp_2 = new Vertex(1,1,3.0);
		assertFalse(temp_1.equals(temp_2));
	}
	@Test
	void testEquals_2_vertex() {
		Vertex temp_1 = new Vertex(1,1,3.01);
		//Vertex temp_2 = new Vertex(1,1,3.0);
		assertFalse(temp_1.equals(null));
	}
	@Test
	void testEquals_3_vertex() {
		Vertex temp_1 = new Vertex(1,1,3.01);
		Polygon my_polygon = new Polygon(null);
		//Vertex temp_2 = new Vertex(1,1,3.0);
		assertFalse(temp_1.equals(my_polygon));
	}
	@Test
	void testEquals_4_vertex() {
		Vertex temp_1 = new Vertex(1,1,3);
		Vertex temp_2 = new Vertex(1,1,3);
		//Vertex temp_2 = new Vertex(1,1,3.0);
		assertTrue(temp_1.equals(temp_2));
	}
	
	//toString:
	@Test
	void testToString_vertex() {
		String result = "x: 1.0 y: 2.0 z: 3.0";
		Vertex temp_1 = new Vertex(1,2,3);
		assertEquals(temp_1.toString(),result);
	}
	//equal in polygon class:
	@Test
	void testEqual_polygon_differentClass() {
		rotate_vertices_1.add(v_1);
		Polygon polygon_1 = new Polygon(rotate_vertices_1);
		assertNotEquals(polygon_1,v_1);
		
	}
	@Test
	void testEqual_polygon_null() {
		Polygon polygon_1 = new Polygon(rotate_vertices_1);
		assertNotEquals(polygon_1,null);
		
	}
	@Test
	void testEqual_polygon_differentSize() {
		Vertex vert_1 = new Vertex(1,2,3);
		Vertex vert_2 = new Vertex(1,22,3);
		Vertex vert_3 = new Vertex(1,2,3);
		LinkedHashSet<Vertex> vertices_1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> vertices_2 = new LinkedHashSet<Vertex>();
		vertices_1.add(vert_1);
		vertices_1.add(vert_2);
		
		vertices_2.add(vert_3);
		Polygon polygon_1 = new Polygon(vertices_1);
		Polygon polygon_2 = new Polygon(vertices_2);

		assertFalse(polygon_1.equals(polygon_2));
		
	}
	
	//(rotate)transform:
	@Test
	void testRotateX() {
		rotate_vertices_1.add(v_1);
		Polygon polygon_1 = new Polygon(rotate_vertices_1);
		sum_polygons_1.add(polygon_1);
		Mesh mesh_1 = new Mesh();
		mesh_1.polygons = sum_polygons_1;
		mesh_1.rotateXAxis(Math.PI);
		//System.out.println(v_1);
		
		Vertex result_vertex = new Vertex(1.0,-2.0,-3.0);
		rotate_vertices_2.add(result_vertex);
		Polygon polygon_2 = new Polygon(rotate_vertices_2);
		sum_polygons_2.add(polygon_2);
		Mesh mesh_2 = new Mesh();
		mesh_2.polygons = sum_polygons_2;
		assertTrue(mesh_1.equals(mesh_2));
		
	}
	
	@Test
	void testRotateY() {
		rotate_vertices_1.add(v_1);
		Polygon polygon_1 = new Polygon(rotate_vertices_1);
		sum_polygons_1.add(polygon_1);
		Mesh mesh_1 = new Mesh();
		mesh_1.polygons = sum_polygons_1;
		mesh_1.rotateYAxis(Math.PI);
		//System.out.println(v_1);
		
		Vertex result_vertex = new Vertex(-1.0,2.0,-3.0);
		rotate_vertices_2.add(result_vertex);
		Polygon polygon_2 = new Polygon(rotate_vertices_2);
		sum_polygons_2.add(polygon_2);
		Mesh mesh_2 = new Mesh();
		mesh_2.polygons = sum_polygons_2;
		assertTrue(mesh_1.equals(mesh_2));
	}
	
	@Test
	void testRotateZ() {
		rotate_vertices_1.add(v_1);
		Polygon polygon_1 = new Polygon(rotate_vertices_1);
		sum_polygons_1.add(polygon_1);
		Mesh mesh_1 = new Mesh();
		mesh_1.polygons = sum_polygons_1;
		mesh_1.rotateZAxis(Math.PI);
		//System.out.println(v_1);
		
		Vertex result_vertex = new Vertex(-1.0,-2.0,3.0);
		rotate_vertices_2.add(result_vertex);
		Polygon polygon_2 = new Polygon(rotate_vertices_2);
		sum_polygons_2.add(polygon_2);
		Mesh mesh_2 = new Mesh();
		mesh_2.polygons = sum_polygons_2;
		assertTrue(mesh_1.equals(mesh_2));
	}
	
	@Test
	void testRead_obj() throws Exception {
		Mesh m_expected = new Mesh();
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		Vertex t_3 = new Vertex(3.8,1.4,0.5);
		Vertex t_4 = new Vertex(4.1,1.6,0.6);
		
		LinkedHashSet<Vertex> temp_poly_1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> temp_poly_2 = new LinkedHashSet<Vertex>();
		
		temp_poly_1.add(t_1);
		temp_poly_1.add(t_2);
		temp_poly_1.add(t_3);
		
		temp_poly_2.add(t_2);
		temp_poly_2.add(t_3);
		temp_poly_2.add(t_4);
		
		Polygon e_polygon_1 = new Polygon(temp_poly_1);
		Polygon e_polygon_2 = new Polygon(temp_poly_2);
		
		HashSet<Polygon> e_all_poly = new HashSet<Polygon>();
		e_all_poly.add(e_polygon_1);
		e_all_poly.add(e_polygon_2);
		m_expected.polygons = e_all_poly;
		
		Mesh mesh_3 =new Mesh();
		mesh_3.polygons = e_all_poly;
		
		Mesh mesh =new Mesh();
		mesh.setReader(new OBJMeshReader());
		//File directory = new File("./");
		//System.out.println(directory.getAbsolutePath());
		mesh.readFromFile(".\\src\\assignment\\test_files/test_read.obj"); 
		//mesh.readFromFile("D:\\JavaPrograms\\B09 A1/test_read.obj"); 
		
		
//		for(Polygon i: mesh.polygons) {
//			for(Vertex j : i.vertices) {
//				System.out.println(j);
//			}
//		}
//		
//		for(Polygon i: m_expected.polygons) {
//			for(Vertex j : i.vertices) {
//				System.out.println(j);
//			}
//		}

		assertEquals(m_expected,mesh);
	}
	@Test
	void testRead_ply() throws Exception {
		Mesh m_expected = new Mesh();
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		Vertex t_3 = new Vertex(3.8,1.4,0.5);
		Vertex t_4 = new Vertex(4.1,1.6,0.6);
		
		LinkedHashSet<Vertex> temp_poly_1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> temp_poly_2 = new LinkedHashSet<Vertex>();
		
		temp_poly_1.add(t_1);
		temp_poly_1.add(t_2);
		temp_poly_1.add(t_3);
		
		temp_poly_2.add(t_2);
		temp_poly_2.add(t_3);
		temp_poly_2.add(t_4);
		
		Polygon e_polygon_1 = new Polygon(temp_poly_1);
		Polygon e_polygon_2 = new Polygon(temp_poly_2);
		
		HashSet<Polygon> e_all_poly = new HashSet<Polygon>();
		e_all_poly.add(e_polygon_1);
		e_all_poly.add(e_polygon_2);
		m_expected.polygons = e_all_poly;
		
		Mesh mesh_3 =new Mesh();
		mesh_3.polygons = e_all_poly;
		
		Mesh mesh =new Mesh();
		mesh.setReader(new PLYMeshReader());
		
		mesh.readFromFile(".\\src\\assignment\\test_files/test_read.ply"); 
		
//		for(Polygon i: mesh.polygons) {
//			for(Vertex j : i.vertices) {
//				System.out.println(j);
//			}
//		}
//		
//		for(Polygon i: m_expected.polygons) {
//			for(Vertex j : i.vertices) {
//				System.out.println(j);
//			}
//		}
		
		assertEquals(m_expected,mesh);
	}
	
	@Test
	void testWrite_obj() throws Exception {
		Mesh mesh = new Mesh();
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		Vertex t_3 = new Vertex(3.8,1.4,0.5);
		Vertex t_4 = new Vertex(4.1,1.6,0.6);
		
		LinkedHashSet<Vertex> temp_poly_1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> temp_poly_2 = new LinkedHashSet<Vertex>();
		
		temp_poly_1.add(t_1);
		temp_poly_1.add(t_2);
		temp_poly_1.add(t_3);
		
		temp_poly_2.add(t_2);
		temp_poly_2.add(t_3);
		temp_poly_2.add(t_4);
		
		Polygon e_polygon_1 = new Polygon(temp_poly_1);
		Polygon e_polygon_2 = new Polygon(temp_poly_2);
		
		HashSet<Polygon> e_all_poly = new HashSet<Polygon>();
		e_all_poly.add(e_polygon_1);
		e_all_poly.add(e_polygon_2);
		mesh.polygons = e_all_poly;
		mesh.setWriter(new OBJMeshWriter());
		mesh.writeToFile(".\\src\\assignment\\test_files/test_write.obj");
		Mesh mesh_actual =new Mesh();
		mesh_actual.setReader(new OBJMeshReader());
		mesh_actual.readFromFile(".\\src\\assignment\\test_files/test_write.obj"); 
		
		assertTrue(mesh_actual.equals(mesh));
	}
	
	
	@Test
	void testWrite_ply() throws Exception {
		Mesh mesh = new Mesh();
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		Vertex t_3 = new Vertex(3.8,1.4,0.5);
		Vertex t_4 = new Vertex(4.1,1.6,0.6);
		
		LinkedHashSet<Vertex> temp_poly_1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> temp_poly_2 = new LinkedHashSet<Vertex>();
		
		temp_poly_1.add(t_1);
		temp_poly_1.add(t_2);
		temp_poly_1.add(t_3);
		
		temp_poly_2.add(t_2);
		temp_poly_2.add(t_3);
		temp_poly_2.add(t_4);
		
		Polygon e_polygon_1 = new Polygon(temp_poly_1);
		Polygon e_polygon_2 = new Polygon(temp_poly_2);
		
		HashSet<Polygon> e_all_poly = new HashSet<Polygon>();
		e_all_poly.add(e_polygon_1);
		e_all_poly.add(e_polygon_2);
		mesh.polygons = e_all_poly;
		mesh.setWriter(new PLYMeshWriter());
		mesh.writeToFile(".\\src\\assignment\\test_files/test_write.ply");
		Mesh mesh_actual =new Mesh();
		mesh_actual.setReader(new PLYMeshReader());
		mesh_actual.readFromFile(".\\src\\assignment\\test_files/test_write.ply"); 
		assertTrue(mesh_actual.equals(mesh));
	}
	
	@Test
	void testEqual_mesh_1() {
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		LinkedHashSet<Vertex> temp_vertices_1 = new LinkedHashSet<Vertex>();
		temp_vertices_1.add(t_1);
		temp_vertices_1.add(t_2);
		Polygon my_poly = new Polygon(temp_vertices_1);
		HashSet<Polygon> all_polys = new HashSet<Polygon>();
		all_polys.add(my_poly);
		Mesh mesh = new Mesh();
		mesh.polygons = all_polys;
		
		Vertex t_3 = new Vertex(5.1,1.2,0.3);
		Vertex t_4 = new Vertex(4.9,1.5,0.3);
		LinkedHashSet<Vertex> temp_vertices_2 = new LinkedHashSet<Vertex>();
		temp_vertices_2.add(t_3);
		temp_vertices_2.add(t_4);
		Polygon my_poly_2 = new Polygon(temp_vertices_2);
		HashSet<Polygon> all_polys_2 = new HashSet<Polygon>();
		all_polys_2.add(my_poly_2);
		Mesh mesh_2 = new Mesh();
		mesh_2.polygons = all_polys_2;
		
		assertEquals(mesh.hashCode(),mesh_2.hashCode());
		
	}
	@Test
	void testEqual_mesh_2() {
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		LinkedHashSet<Vertex> temp_vertices_1 = new LinkedHashSet<Vertex>();
		temp_vertices_1.add(t_1);
		temp_vertices_1.add(t_2);
		Polygon my_poly = new Polygon(temp_vertices_1);
		HashSet<Polygon> all_polys = new HashSet<Polygon>();
		all_polys.add(my_poly);
		Mesh mesh = new Mesh();
		mesh.polygons = all_polys;
		
		assertFalse(mesh.equals(null));
		
	}
	
	@Test
	void testEqual_mesh_3() {
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		LinkedHashSet<Vertex> temp_vertices_1 = new LinkedHashSet<Vertex>();
		temp_vertices_1.add(t_1);
		temp_vertices_1.add(t_2);
		Polygon my_poly = new Polygon(temp_vertices_1);
		HashSet<Polygon> all_polys = new HashSet<Polygon>();
		all_polys.add(my_poly);
		Mesh mesh = new Mesh();
		mesh.polygons = all_polys;
		
		assertFalse(mesh.equals(t_1));
		
	}
	
	
	@Test
	void testEqual_mesh_4() {
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		LinkedHashSet<Vertex> temp_vertices_1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> temp_vertices_3 = new LinkedHashSet<Vertex>();
		
		temp_vertices_1.add(t_1);
		temp_vertices_1.add(t_2);
		
		temp_vertices_3.add(t_2);
		temp_vertices_3.add(v_4);
		Polygon my_poly = new Polygon(temp_vertices_1);
		Polygon my_poly_3 = new Polygon(temp_vertices_3);
		HashSet<Polygon> all_polys = new HashSet<Polygon>();
		all_polys.add(my_poly);
		all_polys.add(my_poly_3);
		Mesh mesh = new Mesh();
		mesh.polygons = all_polys;
		
		LinkedHashSet<Vertex> temp_vertices_2 = new LinkedHashSet<Vertex>();
		Polygon my_poly_2 = new Polygon(temp_vertices_2);
		HashSet<Polygon> all_polys_2 = new HashSet<Polygon>();
		all_polys_2.add(my_poly_2);
		Mesh mesh_2 = new Mesh();
		mesh_2.polygons = all_polys_2;
		assertFalse(mesh.equals(mesh_2));
		
	}
	
	@Test
	void testEqual_mesh_5() {
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		Vertex t_3 = new Vertex(52.15,16.2,0.3);
		Vertex t_4 = new Vertex(43.95,16.5,1.3);
		LinkedHashSet<Vertex> temp_vertices_1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> temp_vertices_2 = new LinkedHashSet<Vertex>();
		temp_vertices_1.add(t_1);
		temp_vertices_1.add(t_2);
		temp_vertices_2.add(t_3);
		temp_vertices_2.add(t_4);
		Polygon my_poly_1 = new Polygon(temp_vertices_1);
		Polygon my_poly_2 = new Polygon(temp_vertices_2);
		HashSet<Polygon> all_polys = new HashSet<Polygon>();
		all_polys.add(my_poly_1);
		all_polys.add(my_poly_2);
		Mesh mesh = new Mesh();
		mesh.polygons = all_polys;
		
		Vertex t_5 = new Vertex(5.1,1.2,0.3);
		Vertex t_6 = new Vertex(4.9,1.5,0.3);
		Vertex t_7 = new Vertex(5.13,1.222,6.3);
		Vertex t_8 = new Vertex(75.9,7.5,6.3);
		LinkedHashSet<Vertex> temp_vertices_3 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> temp_vertices_4 = new LinkedHashSet<Vertex>();
		temp_vertices_3.add(t_5);
		temp_vertices_3.add(t_6);
		temp_vertices_4.add(t_7);
		temp_vertices_4.add(t_8);
		Polygon my_poly_3 = new Polygon(temp_vertices_3);
		Polygon my_poly_4 = new Polygon(temp_vertices_4);
		HashSet<Polygon> all_polys_3 = new HashSet<Polygon>();
		all_polys_3.add(my_poly_3);
		all_polys_3.add(my_poly_4);
		Mesh mesh_2 = new Mesh();
		mesh_2.polygons = all_polys_3;

		assertFalse(mesh_2.equals(mesh));
		
	}
	
	@Test
	void testEqual_mesh_6() {
		Vertex t_1 = new Vertex(5.1,1.2,0.3);
		Vertex t_2 = new Vertex(4.9,1.5,0.3);
		LinkedHashSet<Vertex> temp_vertices_1 = new LinkedHashSet<Vertex>();
		temp_vertices_1.add(t_1);
		temp_vertices_1.add(t_2);
		Polygon my_poly = new Polygon(temp_vertices_1);
		HashSet<Polygon> all_polys = new HashSet<Polygon>();
		all_polys.add(my_poly);
		Mesh mesh = new Mesh();
		mesh.polygons = all_polys;
		
		Vertex t_3 = new Vertex(5.13,1.2,5.3);
		Vertex t_4 = new Vertex(4.9,565,0.3);
		Vertex t_5 = new Vertex(5.1,1.2,0.3);
		Vertex t_6 = new Vertex(4.9,1.5,0.3);
		LinkedHashSet<Vertex> temp_vertices_2 = new LinkedHashSet<Vertex>();
		temp_vertices_2.add(t_3);
		temp_vertices_2.add(t_4);
		temp_vertices_2.add(t_5);
		temp_vertices_2.add(t_6);
		Polygon my_poly_2 = new Polygon(temp_vertices_2);
		HashSet<Polygon> all_polys_2 = new HashSet<Polygon>();
		all_polys_2.add(my_poly_2);
		Mesh mesh_2 = new Mesh();
		mesh_2.polygons = all_polys_2;

		assertFalse(mesh.equals(mesh_2));
		
	}
	

	
	
}

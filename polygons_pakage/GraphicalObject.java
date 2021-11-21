package polygons_pakage;

public abstract class GraphicalObject {
	
	
	public abstract void transform(double matrix[][]);
	
	public void rotateXAxis(double theata) {
		double matrix_X [][]= {{ 1,        0,        0},
								{0, Math.cos(theata),   -Math.sin(theata)},
								{0, Math.sin(theata),    Math.cos(theata)} };
		transform(matrix_X);
	}
	
	public void rotateYAxis(double theata) {
		double matrix_Y [][]= {{  Math.cos(theata), 0,    Math.sin(theata)},
								{ 0,                1,    0},
								{-Math.sin(theata), 0,    Math.cos(theata)} };
		
//		double matrix_Y [][]= {{  Math.cos(theata), 0,    -Math.sin(theata)},
//								{ 0,                1,    0},
//								{Math.sin(theata), 0,    Math.cos(theata)} };
		transform(matrix_Y);
	}
	
	public void rotateZAxis(double theata) {
		double matrix_Z [][]= {
				{ Math.cos(theata), -Math.sin(theata), 0},
				{ Math.sin(theata), Math.cos(theata), 0},
				{ 0,                0,                1}};
				
		transform(matrix_Z);
	}
	
}

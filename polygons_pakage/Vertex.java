package polygons_pakage;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Vertex extends GraphicalObject{
	private double x;
	private double y;
	private double z;
	
	
	public Vertex(double x,double y,double z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	
	
	@Override
	public void transform(double matrix[][]) {	

		DecimalFormat df = new DecimalFormat("#.###############");
		//df.setRoundingMode(RoundingMode.HALF_EVEN);
		double t_x = x;
		double t_y = y;
		double t_z = z;
		this.x = Double.valueOf(df.format(matrix[0][0] * t_x + matrix[0][1] * t_y + matrix[0][2] * t_z));
		this.y = Double.valueOf(df.format(matrix[1][0] * t_x + matrix[1][1] * t_y + matrix[1][2] * t_z));
		this.z = Double.valueOf(df.format(matrix[2][0] * t_x + matrix[2][1] * t_y + matrix[2][2] * t_z));
		
//		this.x = Double.valueOf(df.format(Math.cos(Math.PI/3)*x + Math.sin(Math.PI/3)*z));
//		this.y = Double.valueOf(df.format(y));
//		this.z = Double.valueOf(df.format(-Math.sin(Math.PI/3)*x+Math.cos(Math.PI/3)*z));
		
		
		
//		this.x = matrix[0][0] * x + matrix[0][1] * y + matrix[0][2] * z;
//		this.y = matrix[1][0] * x + matrix[1][1] * y + matrix[1][2] * z;
//		this.z = matrix[2][0] * x + matrix[2][1] * y + matrix[2][2] * z;
	}
	
	@Override
	public int hashCode() {
		int prime_num = 37;
		long x_Bits = Double.doubleToLongBits(x);
		long y_Bits = Double.doubleToLongBits(y);
		long z_Bits = Double.doubleToLongBits(z);
		
		int result = (int) ((prime_num* x_Bits^ (x_Bits>>32) * y_Bits^ (y_Bits>>32) *z_Bits^ (z_Bits>>32))/17 *10000)/10;
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(getClass() != obj.getClass()) //this checks if the obj is the instance of the class. So the casting will be fine.
			return false;
		Vertex other = (Vertex)obj;
		if(this.x == other.getX() && this.y == other.getY() && this.z == other.getZ())//compare with x,y,z
		{
			//System.out.println("Yes it is the same");
			return true;
		}
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "x: "+ x + " y: " + y +" z: "+ z;
	}
	
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}



}

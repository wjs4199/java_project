
public class Arrow {
	private Gravity gravity;
	private Wind wind;
	private Power power;
	private Angle angle;
	private double arrow_x =0;
	private double arrow_y =0;
	private double arrow_z =0;
	
	private double arrow_dx;
	private double arrow_dy;
	private double arrow_dz;
	
	public Arrow(Gravity g, Wind w, Power p, Angle a) {
		this.gravity = g;
		this.wind = w;
		this.power = p;
		this.angle = a;
		
		arrow_x = 0;
		arrow_y = 0;
		arrow_z = 0;
		arrow_dx = power.get_velocity()*(Math.cos(angle.get_theta())+Math.cos(angle.get_deflection()))+wind.get_dx();
		arrow_dy = power.get_velocity()*Math.sin(angle.get_deflection()) + wind.get_dy();
		arrow_dz = power.get_velocity()*Math.sin(angle.get_theta());

	}
	
	public double fx() { // dx를 이용해서 위치 구하는 함수 구현 
		arrow_x = arrow_x + arrow_dx*0.0001;
		return arrow_x;
	}
	public double fy() { 
		arrow_y = arrow_y + arrow_dy*0.0001;
		return arrow_y;
	}
	public double fz() { // dz를 이용해서 위치 구하는 함수 구현
		arrow_dz = arrow_dz - gravity.get_gravity()*0.0001;
		arrow_z = arrow_z + arrow_dz*0.0001;
		return arrow_z;
	}
}

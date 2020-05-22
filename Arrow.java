
public class Arrow {
	private Gravity gravity = new Gravity();
	private Wind wind = new Wind();
	private Crowd crowd = new Crowd();
	private Power power = new Power();
	private Angle angle = new Angle();
	private double arrow_x =0;
	private double arrow_y =0;
	
	private double arrow_dx;
	private double arrow_dy;
	
	public Arrow() {
		arrow_x = 0;
		arrow_y = 0;
		arrow_dx = power.get()*Math.cos(angle.get())+wind.get();
		arrow_dy = power.get()*Math.sin(angle.get());
		System.out.println("Wind: "+wind.get()+" Crowd: "+crowd.get()+" Gravity: "+gravity.get());

	}
	
	public double fx() { // dx를 이용해서 위치 구하는 함수 구현 
		arrow_x = arrow_x + arrow_dx*0.0001;
		return arrow_x;
	}
	public double fy() { // dy를 이용해서 위치 구하는 함수 구현
		arrow_dy = arrow_dy - gravity.get()*0.0001;
		arrow_y = arrow_y + arrow_dy*0.0001;
		return arrow_y;
	}
}

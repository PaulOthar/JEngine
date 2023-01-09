package formats;

public class Vec2d {
	public static boolean CUSTOM_MODE = false;
	public static String CUSTOM_AXIS_FORMAT = "%s:%f";
	public static String CUSTOM_SPACE_FORMAT = " | ";
	public static String CUSTOM_BORDER_FORMAT = "[%s]";

	private double x;
	private double y;
	private double w;

	public Vec2d() {
	}

	public Vec2d(double x, double y) {
		this.set(x, y);
	}

	public Vec2d(double x, double y, double w) {
		this.set(x, y, w);
	}

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void set(double x, double y, double w) {
		this.set(x, y);
		this.w = w;
	}

	// Getters and Setters

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

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	// Other Methods

	@Override
	public String toString() {
		if (CUSTOM_MODE) {
			String x = String.format(CUSTOM_AXIS_FORMAT, "X", this.getX());
			String y = String.format(CUSTOM_AXIS_FORMAT, "Y", this.getY());
			String w = String.format(CUSTOM_AXIS_FORMAT, "W", this.getW());
			return String.format(CUSTOM_BORDER_FORMAT, x + CUSTOM_SPACE_FORMAT + y + CUSTOM_SPACE_FORMAT + w);
		} else {
			return String.format("[X:%f | Y:%f | W:%f]", this.getX(), this.getY(), this.getW());
		}
	}
}

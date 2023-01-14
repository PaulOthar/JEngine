package formats;

/**
 * The {@code Vec2d} class Represents a Vector in a 2D plane.
 * <p>
 * It contains the {@code X}(Horizontal) and {@code Y}(Vertical) Axis, with an W value for extra definitions.
 * <br>
 * It May be used to represent locations in the "Screen", or may be used as a texture coordinate (as {@code U}(X) and {@code V}(Y) Axis)
 * @author PaulOthar
 * @see formats.Vec3d
 */
public class Vec2d {
	
	/**
	 * {@code CUSTOM_MODE} is a customizable "{@code toString}" format, by enabling it, the return of the "{@code toString}" method will be formatted accordingly.
	 * <br><br>
	 * It is {@code false} by default.
	 */
	public static boolean CUSTOM_MODE = false;
	
	/**
	 * {@code CUSTOM_AXIS_FORMAT} is a format used in the {@code toString}, it will format the way Axis are returned.
	 * <p>
	 * Example:"X" = (Axis),"10.5" = (Value)<br>
	 * {@code %s:%f} => {@code X:10.5}
	 * <p>
	 * The Format can be changed to fit the user's need, but must follow the {@code %s} and {@code %f} order.
	 */
	public static String CUSTOM_AXIS_FORMAT = "%s:%f";
	
	/**
	 * {@code CUSTOM_SPACE_FORMAT} is a format used in the {@code toString}, it will format the Spaces between the Axis.
	 * <p>
	 * The Format can be changed to fit the user's need.
	 */
	public static String CUSTOM_SPACE_FORMAT = " | ";
	
	/**
	 * {@code CUSTOM_BORDER_FORMAT} is a format used in the {@code toString}, it will format the way the string border is returned.
	 * <p>
	 * The Format can be changed to fit the user's need, but must include the {@code %s} symbol.
	 */
	public static String CUSTOM_BORDER_FORMAT = "[%s]";

	private double x;
	private double y;
	private double w;

	/**
	 * Empty Constructor for the {@code Vec2d} class, {@code X},{@code Y} and {@code W} will be {@code 0} by default.
	 */
	public Vec2d() {
	}

	/**
	 * "Basic" constructor for the {@code Vec2d} class, defines the {@code X} and {@code Y} axis.({@code W} will be {@code 0} by default).
	 * @param x	Horizontal(Left(Negative) to Right(Positive)) Axis.
	 * @param y Vertical(Bottom(Negative) to Top(Positive)) Axis.
	 */
	public Vec2d(double x, double y) {
		this.set(x, y);
	}

	/**
	 * "Advanced" constructor for the {@code Vec2d} class, defines the {@code X} and {@code Y} axis, and also the {@code W} value.
	 * @param x	Horizontal(Left(Negative) to Right(Positive)) Axis.
	 * @param y Vertical(Bottom(Negative) to Top(Positive)) Axis.
	 * @param w Extra Value.
	 */
	public Vec2d(double x, double y, double w) {
		this.set(x, y, w);
	}

	/**
	 * Simpler Way to Set the {@code X} and {@code Y} axis values.
	 * @param x Horizontal(Left(Negative) to Right(Positive)) Axis.
	 * @param y Vertical(Bottom(Negative) to Top(Positive)) Axis.
	 */
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Simpler Way to Set the {@code X},{@code Y} axis and {@code W} value.
	 * @param x Horizontal(Left(Negative) to Right(Positive)) Axis.
	 * @param y Vertical(Bottom(Negative) to Top(Positive)) Axis.
	 * @param w Extra Value.
	 */
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
	
	/**
	 * Alternative for {@code getX}.
	 * @return x
	 */
	public double getU() {
		return this.x;
	}
	
	/**
	 * Alternative for {@code setX}.
	 * @param u = x value.
	 */
	public void setU(double u) {
		this.x = u;
	}
	
	/**
	 * Alternative for {@code getY}.
	 * @return y
	 */
	public double getV() {
		return this.y;
	}
	
	/**
	 * Alternative for {@code setY}.
	 * @param v = y value.
	 */
	public void setV(double v) {
		this.y = v;
	}
	
	public double[] toArray() {
		return new double[] {this.getX(),this.getY(),this.getW()};
	}
	
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

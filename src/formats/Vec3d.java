package formats;

/**
 * The {@code Vec3d} class Represents a Vector in a 3D space.
 * <p>
 * It contains the {@code X}(Horizontal),{@code Y}(Vertical) and {@code Z}(Frontal(?)) Axis, with an W value for extra definitions.
 * <br>
 * It May be used to represent locations in the "Space", to be later projected in 2D, and then be drawn in the screen.
 * @author PaulOthar
 * @see formats.Vec2d
 */
public class Vec3d extends Vec2d {
	private double z;

	/**
	 * Empty Constructor for the {@code Vec3d} class, {@code X},{@code Y},{@code Z} and {@code W} will be {@code 0} by default.
	 */
	public Vec3d() {
	}

	/**
	 * "Basic" constructor for the {@code Vec3d} class, defines the {@code X},{@code Y} and {@code Z} axis.({@code W} will be {@code 0} by default).
	 * @param x	Horizontal(Left(Negative) to Right(Positive)) Axis.
	 * @param y Vertical(Bottom(Negative) to Top(Positive)) Axis.
	 * @param z (Frontal(?))(Foward(Negative) and Backward(Positive)) Axis.
	 */
	public Vec3d(double x, double y, double z) {
		this.set(x, y, z);
	}

	/**
	 * "Advanced" constructor for the {@code Vec3d} class, defines the {@code X},{@code Y} and {@code Z} axis, and also the {@code W} value.
	 * @param x	Horizontal(Left(Negative) to Right(Positive)) Axis.
	 * @param y Vertical(Bottom(Negative) to Top(Positive)) Axis.
	 * @param z (Frontal(?))(Foward(Negative) and Backward(Positive)) Axis.
	 * @param w Extra Value.
	 */
	public Vec3d(double x, double y, double z, double w) {
		this.set(x, y, z, w);
	}

	
	/**
	 * Simpler Way to Set the {@code X},{@code Y} and {@code Z} axis values.
	 * @param x Horizontal(Left(Negative) to Right(Positive)) Axis.
	 * @param y Vertical(Bottom(Negative) to Top(Positive)) Axis.
	 * @param z (Frontal(?))(Foward(Negative) and Backward(Positive)) Axis.
	 */
	@Override
	public void set(double x, double y, double z) {
		this.set(x, y);
		this.z = z;
	}

	/**
	 * Simpler Way to Set the {@code X},{@code Y} and {@code Z} axis and also {@code W} value.
	 * @param x Horizontal(Left(Negative) to Right(Positive)) Axis.
	 * @param y Vertical(Bottom(Negative) to Top(Positive)) Axis.
	 * @param z (Frontal(?))(Foward(Negative) and Backward(Positive)) Axis.
	 * @param w Extra Value.
	 */
	public void set(double x, double y, double z, double w) {
		super.set(x, y, w);
		this.z = z;
	}

	// Getters and setters

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	// Other Methods

	@Override
	public double[] toArray() {
		return new double[] {this.getX(),this.getY(),this.getZ(),this.getW()};
	}
	
	@Override
	public String toString() {
		if (CUSTOM_MODE) {
			String x = String.format(CUSTOM_AXIS_FORMAT, "X", this.getX());
			String y = String.format(CUSTOM_AXIS_FORMAT, "Y", this.getY());
			String z = String.format(CUSTOM_AXIS_FORMAT, "Z", this.getZ());
			String w = String.format(CUSTOM_AXIS_FORMAT, "W", this.getW());
			return String.format(CUSTOM_BORDER_FORMAT,
					x + CUSTOM_SPACE_FORMAT + y + CUSTOM_SPACE_FORMAT + z + CUSTOM_SPACE_FORMAT + w);
		} else {
			return String.format("[X:%f | Y:%f | Z:%f | W:%f]", this.getX(), this.getY(), this.getZ(), this.getW());
		}
	}
}

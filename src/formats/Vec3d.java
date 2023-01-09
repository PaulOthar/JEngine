package formats;

public class Vec3d extends Vec2d {
	private double z;

	public Vec3d() {
	}

	public Vec3d(double x, double y, double z) {
		this.set(x, y, z);
	}

	public Vec3d(double x, double y, double z, double w) {
		this.set(x, y, z, w);
	}

	@Override
	public void set(double x, double y, double z) {
		this.set(x, y);
		this.z = z;
	}

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

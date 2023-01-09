package formats;

public class Triangle {
	private Vec3d[] pvec;//Position Vectors
	private Vec2d[] tvec;//Texture Vectors
	
	public Triangle() {
		this.pvec = new Vec3d[3];
		this.tvec = new Vec2d[3];
	}
	
	public Triangle(Vec3d p1,Vec3d p2,Vec3d p3) {
		this.pvec = new Vec3d[] {p1,p2,p3};
		this.tvec = new Vec2d[3];
	}
	
	public Triangle(Vec3d p1,Vec3d p2,Vec3d p3,Vec2d t1,Vec2d t2,Vec2d t3) {
		this.pvec = new Vec3d[] {p1,p2,p3};
		this.tvec = new Vec2d[] {t1,t2,t3};
	}

	public void putPosition(Vec3d vec,int index) {
		if(index < 3 && index >= 0) {
			this.getPvec()[index] = vec;
		}
	}
	
	public void putTexture(Vec2d vec,int index) {
		if(index < 3 || index >= 0) {
			this.getTvec()[index] = vec;
		}
	}
	
	//Getters and Setters
	
	public Vec3d[] getPvec() {
		return pvec;
	}

	public void setPvec(Vec3d[] pvec) {
		this.pvec = pvec;
	}

	public Vec2d[] getTvec() {
		return tvec;
	}

	public void setTvec(Vec2d[] tvec) {
		this.tvec = tvec;
	}
	
	//Other Methods
	
	@Override
	public String toString() {
		String positions = new String();
		String texture = new String();
		
		Vec3d[] pvecHolder = this.getPvec();
		Vec2d[] tvecHolder = this.getTvec();
		
		for(int i = 0;i<3;i++) {
			if(i>0) {
				positions += '\n';
				texture += '\n';
			}
			
			positions += pvecHolder[i];
			texture += tvecHolder[i];
		}
		
		return String.format("Position:\n%s\n\nTexture:\n%s", positions,texture);
	}
}

package formats;

public class Mesh {
	private Vec3d[] vectors;
	private Triangle[] triangles;
	
	public Mesh(int vecSize,int triSize) {
		this.vectors = new Vec3d[vecSize];
		this.triangles = new Triangle[triSize];
	}
	
	public void assignPositionVector(int Vector_Index,int Triangle_Index,int Slot_Index) {
		boolean vectorCheck = this.getVectors().length > Vector_Index && Vector_Index >= 0;
		boolean triangleCheck = this.getTriangles().length > Triangle_Index && Triangle_Index >= 0;
		
		if(!(vectorCheck && triangleCheck)) {
			return;
		}
		
		if(this.getTriangles()[Triangle_Index] == null) {
			return;
		}
		
		this.getTriangles()[Triangle_Index].putPosition(this.getVectors()[Vector_Index], Slot_Index);
	}
	
	//Getters and Setters

	public Vec3d[] getVectors() {
		return vectors;
	}

	public void setVectors(Vec3d[] vectors) {
		this.vectors = vectors;
	}

	public Triangle[] getTriangles() {
		return triangles;
	}

	public void setTriangles(Triangle[] triangles) {
		this.triangles = triangles;
	}
	
	//Other Methods
	
	@Override
	public String toString() {
		String output = new String();
		
		Triangle[] trianglesHolder = this.getTriangles();
		
		for(int i = 0;i<trianglesHolder.length;i++) {
			if(i>0) {
				output += "\n\n";
			}
			output += String.format("%d:\n%s", i,trianglesHolder[i]);
		}
		
		return output;
	}
}

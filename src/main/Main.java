package main;

import formats.Calculator;
import formats.Mesh;
import formats.Triangle;
import formats.Vec3d;
import formats.Vec2d;

public class Main {

	public static void main(String[] args) {
		Mesh m = new Mesh(1,10);
		m.getVectors()[0] = new Vec3d(22,32,42,52);
		
		m.getTriangles()[2] = new Triangle();
		
		m.assignPositionVector(0, 2, 1);
		
		System.out.println(Calculator.fieldOfView(Math.toRadians(45)));
	}
}

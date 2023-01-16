package formats;

public class Calculator {
	
	/**
	 * Creates a 4x4 Matrix of Double(Every cell is 0 by default).
	 * <br>
	 * matrix[Row][Column]
	 * <br><br>
	 * Row:<br>
	 * X,X,X,X<br>
	 * <br>
	 * Column:<br>
	 * X<br>
	 * X<br>
	 * X<br>
	 * X<br>
	 * @return
	 */
	public static double[][] matrix4x4(){
		return new double[4][4];
	}
	
	/**
	 * {@code aspectRatio} is the value of the proportion of the screen.
	 * @param width (Width of the Screen(Left to Right))
	 * @param height (Height of the Screen(Bottom to Top))
	 * @return {@code height/width}
	 */
	public static double aspectRatio(double width,double height) {
		return height/width;
	}
	
	/**
	 * {@code fieldOfView} is the value that represents the angle of the field of view.
	 * <br>
	 * This implies that something closer gets bigger, and something farther gets smaller.
	 * <br><br>
	 * Note that the lesser the angle, bigger the farther objects gets,giving the impression of zoom. 
	 * @param angle in radians
	 * @return {@code 1/tan(angle/2)}
	 */
	public static double fieldOfView(double angle) {
		return 1/Math.tan(angle/2);
	}
	
	/**
	 * @param near
	 * @param far
	 * @return
	 */
	public static double zNormalization(double near,double far) {
		return far/(far-near);
	}
	
	/**
	 * {@code projectionMatrix} when applied to a vector, will translate it from 3D to 2D, making it able to be drawn in a image.
	 * @param aspectRatio 
	 * @param fieldOfView
	 * @param zNormalization
	 * @param near
	 * @see #aspectRatio(double, double)
	 * @see #fieldOfView(double)
	 * @see #zNormalization(double, double)
	 * @see #matrix4x4()
	 * @return 4x4 {@code double} Matrix Containing Projection Data.
	 */
	public static double[][] projectionMatrix(double aspectRatio,double fieldOfView,double zNormalization,double near){
		double[][] projMatx = Calculator.matrix4x4();
		
		projMatx[0][0] = aspectRatio*fieldOfView;
		projMatx[1][1] = fieldOfView;
		projMatx[2][2] = zNormalization;
		projMatx[2][3] = 1;
		projMatx[3][2] = -zNormalization*near;
				
		return projMatx;
	}
	
	/**
	 * Applies any {@code 4x4 Double Matrix} in any {@code Vector(X,Y,Z,W)}
	 * @param input any {@code Vector(X,Y,Z,W)}
	 * @param output a pre-allocated {@code Vector} to recieve the result
	 * @param matrix any {@code 4x4 Double Matrix}
	 * 
	 * @see #matrix4x4()
	 */
	public static void multiplyMatrixVector(double[] input,double[] output,double[][] matrix) {
		int x = 0,y = 1,z = 2,w = 3;//For convenience and better understanding
		
		output[x] = input[x]*matrix[0][0] + input[y]*matrix[1][0] + input[z]*matrix[2][0] + input[w]*matrix[3][0];
		output[y] = input[x]*matrix[0][1] + input[y]*matrix[1][1] + input[z]*matrix[2][1] + input[w]*matrix[3][1];
		output[z] = input[x]*matrix[0][2] + input[y]*matrix[1][2] + input[z]*matrix[2][2] + input[w]*matrix[3][2];
		output[w] = input[x]*matrix[0][3] + input[y]*matrix[1][3] + input[z]*matrix[2][3] + input[w]*matrix[3][3];
	}
}
package tools;

public class VectorCalculator {
	
	public static int VECTOR_SIZE = 3;
	
	//Vector to Vector Operations
	
	public static void add_Vectors(double[] vector1,double[] vector2,double[] output) {
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output[i] = vector1[i]+vector2[i];
		}
	}
	
	public static void sub_Vectors(double[] vector1,double[] vector2,double[] output) {
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output[i] = vector1[i]-vector2[i];
		}
	}
	
	public static void mul_Vectors(double[] vector1,double[] vector2,double[] output) {
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output[i] = vector1[i]*vector2[i];
		}
	}
	
	public static void div_Vectors(double[] vector1,double[] vector2,double[] output) {
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output[i] = vector1[i]/vector2[i];
		}
	}
	
	//Vector to Value Operations
	
	public static void add_Value(double[] vector,double value,double[] output) {
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output[i] = vector[i]+value;
		}
	}
	
	public static void sub_Value(double[] vector,double value,double[] output) {
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output[i] = vector[i]-value;
		}
	}
	
	public static void mul_Value(double[] vector,double value,double[] output) {
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output[i] = vector[i]*value;
		}
	}
	
	public static void div_Value(double[] vector,double value,double[] output) {
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output[i] = vector[i]/value;
		}
	}
	
	//Other Operations
	
	public static double vectorSum(double[] vector) {
		double output = 0;
		
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output += vector[i];
		}
		
		return output;
	}
	
	public static double dotProduct_DEPRECATED(double[] vector1,double[] vector2) {
		double[] temporary = new double[VECTOR_SIZE];
		mul_Vectors(vector1,vector2,temporary);
		return vectorSum(temporary);
	}
	
	public static double dotProduct(double[] vector1,double[] vector2) {
		double output = 0;
		
		for(int i = 0;i<VECTOR_SIZE;i++) {
			output += vector1[i]*vector2[i];
		}
		
		return output;
	}
	
	public static double vectorLength(double[] vector) {
		return Math.sqrt(dotProduct(vector,vector));
	}
	
	public static void normalize(double[] vector,double[] output) {
		div_Value(vector,vectorLength(vector),output);
	}
	
	public static void crossProduct(double[] vector1,double[] vector2,double[] output) {
		output[0] = vector1[1]*vector2[2] - vector1[2]*vector2[1];
		output[1] = vector1[2]*vector2[0] - vector1[0]*vector2[2];
		output[2] = vector1[0]*vector2[1] - vector1[1]*vector2[0];
	}
	
	public static double intersect(double[] planePoint,double[] planeNormal,double[] lineStart,double[] lineEnd) {
		double planeDotProduct = dotProduct(planePoint,planeNormal);
		double startToNormalDotProduct = dotProduct(planeNormal,lineStart);
		double endToNormalDotProduct = dotProduct(planeNormal,lineEnd);
		
		return (planeDotProduct-startToNormalDotProduct)/(endToNormalDotProduct-startToNormalDotProduct);
	}
	
	public static void pointInLine(double[] lineStart,double[] lineEnd,double value,double[] output) {
		sub_Vectors(lineStart,lineEnd,output);
		mul_Value(output,value,output);
		add_Vectors(lineStart,output,output);
	}
	
	public static double insideness(double[] planeNormal,double planeDotProduct,double[] vector) {
		return dotProduct(planeNormal,vector)-planeDotProduct;
	}
	
	public static void calculateNormal(double[] vector1,double[] vector2,double[] vector3,double[] output) {
		double[] auxiliar = new double[output.length];
		
		sub_Vectors(vector2, vector1, auxiliar);
		sub_Vectors(vector3, vector1, output);
		
		crossProduct(auxiliar, output, output);
		
		normalize(output,output);
	}
}

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}

	public static void testKeepOnlyBlue() {
		Picture swan = new Picture("swan.jpg");
		swan.keepOnlyBlue();
		swan.explore();
	}
	
	public static void testNegate() {
		Picture swan = new Picture("swan.jpg");
		swan.negate();
		swan.explore();
	}
	
	public static void testGrayscale() {
		Picture swan = new Picture("swan.jpg");
		swan.grayscale();
		swan.explore();
	}
	
	public static void testFixUnderwater() {
		Picture water = new Picture("water.jpg");
		water.fixUnderwater();
		water.explore();
	}
	
	public static void testMirrorVerticalRightToLeft() {
		Picture swan = new Picture("redMotorcycle.jpg");
		swan.mirrorVerticalRightToLeft();
		swan.explore();
	}
	
	public static void testMirrorHorizontal() {
		Picture swan = new Picture("redMotorcycle.jpg");
		swan.mirrorHorizontal();
		swan.explore();
	}
	
	public static void testMirrorHorizontalBotToTop() {
		Picture swan = new Picture("redMotorcycle.jpg");
		swan.mirrorHorizontalBotToTop();
		swan.explore();
	}
	
	public static void testMirrorDiagonal() {
		Picture swan = new Picture("redMotorcycle.jpg");
		swan.mirrorDiagonal();
		swan.explore();
	}
	
	public static void testMirrorArms() {
		Picture snowman = new Picture ("snowman.jpg");
		snowman.explore();
		snowman.mirrorArms();
		snowman.explore();
	}
	
	public static void testMirrorGull() {
		Picture gull = new Picture ("seagull.jpg");
		gull.explore();
		gull.mirrorGull();
		gull.explore();
	}
	
	public static void testCopy() {
		Picture gull = new Picture ("seagull.jpg");
		Picture beach = new Picture ("beach.jpg");
		int fromStartRow = 50, fromStartCol = 50, fromEndRow = 150, fromEndCol = 150, toStartRow = 100, toStartCol = 100;
		beach.copy(gull, fromStartRow, fromStartCol, fromEndRow, fromEndCol, toStartRow, toStartCol);
		beach.explore();
	}
	
	public static void testMyCollage() {
		Picture gorge = new Picture("gorge.jpg");
		gorge.myCollage();
		gorge.explore();
	}
	
	public static void testEdgeDetection2() {
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection2(25);
		swan.explore();
	}
	
	public static void testEdgeDetection3() {
		Picture swan = new Picture("barbaraS.jpg");
		swan.edgeDetection3(25);
		swan.explore();
	}
	
	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		// testZeroBlue();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		// testMirrorVertical();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		// testCollage();
		// testCopy();
		// testMyCollage();
		// testEdgeDetection();
		// testEdgeDetection2();
		 testEdgeDetection3();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
		// testMirrorVerticalRightToLeft();
		// testMirrorHorizontal();
		// testMirrorHorizontalBotToTop();
		// testMirrorDiagonal();
	}
}
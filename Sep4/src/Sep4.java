import java.util.logging.Logger;
import java.util.logging.Level;

public class Sep4 {

	public static void main(String[] args) {

		Logger logger = Logger.getGlobal();
		// logger.setLevel(Level.OFF);

		logger.info("At the beginning of main");

		int result = add(5, 12);

		if (result != 17)
			logger.severe("Result was " + result + " not 17");

	}

	public static int add(int x, int y) {
		return x + Math.abs(y);
	}

}

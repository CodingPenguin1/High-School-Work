import static org.junit.Assert.*;

import org.junit.Test;

public class Sep4Test {

	@Test
	public void posAndPos() {
		int result = Sep4.add(5, 7);
		assertEquals(12, result);
	}
	
	@Test
	public void posAndNeg() {
		int result = Sep4.add(5, -7);
		assertEquals(-2, result);
	}

}

package xarxa2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ManageDataTests {

	@Test
	public void testEnviroment() {
		assertEquals(1, 1);
	}

	@Test
	public void testReadFile() {
		ManageData manager = new ManageData();
		assertNotNull(manager.readFile());
	}
	
	@Test
	public void testGetNames() {
		ManageData manager = new ManageData();
		List<Programmer> ap = manager.readFile();
		for (Programmer programmer : ap) {
			assertNotNull(programmer.getName());
		}
		
	}
}

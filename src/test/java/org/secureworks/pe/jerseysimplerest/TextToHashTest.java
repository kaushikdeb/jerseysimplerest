package org.secureworks.pe.jerseysimplerest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextToHashTest {

	@Test
	public void testGetMd5forText() {
		String testText = "ILoveJava";
		String md5Known = "35454B055CC325EA1AF2126E27707052";
		
		String md5Calculated = TextToHash.getMd5forText(testText);
		assertTrue("Md5 calculated is not correct", md5Known.equals(md5Calculated));
	}

	@Test
	public void testGetShaforText() {
		String testText = "ILoveJava";
		String md5Known = "D2F05B425E4D869FD963F32200F7117D69A98A0F";
		
		String md5Calculated = TextToHash.getShaforText(testText);
		assertTrue("SHA1 calculated is not correct", md5Known.equals(md5Calculated));
	}
}

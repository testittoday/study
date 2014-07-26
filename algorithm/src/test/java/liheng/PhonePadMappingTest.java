package liheng;

import static org.junit.Assert.*;

import org.junit.Test;

import qiao.PhonePadMapping;

public class PhonePadMappingTest {

	@Test
	public void test() {
		assertTrue(PhonePadMapping.getLetters((byte) '2') != null);
	}

}

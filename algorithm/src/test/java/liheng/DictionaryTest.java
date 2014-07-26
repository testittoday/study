package liheng;

import static org.junit.Assert.*;

import org.junit.Test;

import qiao.Dictionary;

public class DictionaryTest {

	@Test
	public void testGetWordsInt() {
		try {
			Dictionary.getWords(34556);
		} catch (Throwable th) {
			th.printStackTrace();
			fail(th.toString());
		}
	}

}

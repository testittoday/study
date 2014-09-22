package zhan.wordPhonePadMapping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class DictionaryProcessorTest {

	@Test
	public void test() {
		DictionaryProcessor dp = new DictionaryProcessor();
		dp.processDictionaryMapping();
		// Input:Digit string "23"
		// Output: ["ad", "ae", "be"].
		List<String> result = dp.getMap().get("23");
		print(result);
		assertTrue("result size: " + result.size(),
				result != null && result.size() == 3);
	}

	void print(List<String> result) {
		StringBuffer sb = new StringBuffer();
		for (String s : result) {
			sb.append(s);
			sb.append(", ");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}
}

package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZigZagStringTest {

	@Test
	public void testConvert() {

		String converted = ZigZagString.convert("ABC", 2);
		assertTrue("ACB".equals(converted));
		converted = ZigZagString.convert("ABCD", 2);
		assertTrue("ACBD".equals(converted));
		converted = ZigZagString.convert("PAYPALISHIRING", 3);
		System.out.println("converted:" + converted);
		assertTrue("PAHNAPLSIIGYIR".equals(converted));
		converted = ZigZagString.convert("PAYPALISHIRING", 4);
		System.out.println("converted:" + converted);
		assertTrue("PINALSIGYAHRPI".equals(converted));

		converted = ZigZagString
				.convert(
						"yrokktvusuiqiojfckyatryekijksvusokcyeavwufpctajxkixdbxjmitwcqqxfbbfhbadvfuaaujxfrwkvuuhep",
						76);
		System.out.println("converted:" + converted);
		assertTrue("yrokktvusuiqiojfckyatryekijksvusokcyeavwufpctajxkixdbxjmitwcqqxpfebhbufuhvbkawdrvffxujaua"
				.equals(converted));

		System.out
				.println(ZigZagString
						.convert(
								"twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd",
								4));

	}
}

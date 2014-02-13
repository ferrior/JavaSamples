import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * 
 */

/*
 . 	�κ��ַ���ƥ����߲�ƥ���н�������
\d 	�����ַ���[0-9]
\D 	�������ַ���[^0-9]
\s 	�հ��ַ���[\t\n\x0B\f\r]
\S 	�ǿհ��ַ���[^\s]
\w 	�����ַ���[a-zA-Z_0-9]
\W 	�ǵ����ַ���[^\w]
*/

/**
 * @author bliu
 * 
 */
public class RegxTest {

	private Pattern pattern = null;
	private Matcher matcher = null;
	private String str = null;
	private String regx = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		pattern = null;
		matcher = null;
	}

	@Test
	public void test() {
		str = "cat";
		regx = "cat";
		validate(regx, str, true);
	}
	
	
	@Test
	public void testquantifiers() {
		str = "dogdogdog";
		regx = "(dog){3}";
		validate(regx, str, true);
		
		str = "doggg";
		regx = "dog{3}";
		validate(regx, str, true);
	}

	

	@Test
	public void testUnion() {
		str = "3";
		regx = "[0-4[6-8]]";
		validate(regx, str, true);

		str = "5";
		regx = "[0-4[6-8]]";
		validate(regx, str, false);

		str = "3";
		regx = "[[0-4][6-8]]";
		validate(regx, str, true);

	}

	@Test
	public void testNegation() {
		str = "cat";
		regx = "[^bcr]at";
		validate(regx, str, false);

		str = "aat";
		regx = "[^[bcr]]at";
		validate(regx, str, false);

		str = "crat";// ??
		regx = "[(bcr)]at";
		validate(regx, str, false);

	}

	private void validate(String regx, String str, boolean result) {
		pattern = Pattern.compile(regx);
		matcher = pattern.matcher(str);
		assertEquals(result, matcher.matches());
	}

}

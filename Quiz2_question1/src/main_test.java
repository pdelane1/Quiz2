import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class main_test {
	
	double test_tuition_initial = 12520; // dollars
	double test_tuition_increase = 1; //as in 1%
	double test_APR_tuition = 1; //as in 1%
	double test_years = 20; // years

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_tuitionTotal() {
		assertTrue(main.tuitionTotal(test_tuition_initial, test_tuition_increase)==50836.22);
	}

	@Test
	public void test_monthlyPayments() {
		assertTrue(main.monthlyPayments(main.tuitionTotal(test_tuition_initial, test_tuition_increase), test_years, test_APR_tuition)==258.46);
	}

}

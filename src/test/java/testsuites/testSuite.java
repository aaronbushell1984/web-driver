package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.*;

@RunWith(Suite.class)
@SuiteClasses({
        Test_Contact_Form.class,
        Test_University_Details.class,
        Test_Investors_Highlights.class
})

public class testSuite {


}

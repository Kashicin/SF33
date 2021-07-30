import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class AppTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
    @BeforeClass
    void beforeClass() {
        System.out.println("Before class");
        currentTime();
    }
    @AfterClass
    void afterClass() {
        System.out.println("After class");
        currentTime();
    }
    @DataProvider(name = "DataProvider")
    Object[][] DataProvider() {
        return new Object[][] {
                {10, 30, 40},
                {0, 0, 0},
                {-10, 10, 0}
        };
    }
    @Test(dataProvider = "sumProvider")
    void testSum(int arg1, int arg2, int expected) {
        int sum = App.sumNumbers(arg1, arg2);
        System.out.println(sum);
        assertEquals(sum, expected);

    }
}

package test.com.ca.logic;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import com.ca.logic.MyDateServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestLeapYear {
    private MyDateServices dateService = new MyDateServices();
    private boolean expected;
    private int testId;
    private int testYear;

    public TestLeapYear(boolean expected, int testId, int testYear) {
        this.expected = expected;
        this.testId = testId;
        this.testYear = testYear;
    }

    @Parameters
    public static Collection<Object[]> getTestParameters() {
        Collection<Object[]> dataList = new ArrayList<>();
        //String filePath = "D:\\Projects\\JUnitDemos\\src\\resources";
        String fileName = "TestLeapYear.data";

        InputStream fis = null;
        BufferedReader reader = null;

        try {
            //fis = new FileInputStream(filePath+File.separator+fileName);
            reader = new BufferedReader(new InputStreamReader
                    (TestLeapYear.class.getResourceAsStream("/resources" + File.separator + fileName)));
            reader.readLine(); // Bypass head row

            String dataRow = reader.readLine();

            while (dataRow != null) {
                dataList.add(tokenize(dataRow));
                dataRow = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if ( reader != null ) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }

    private static Object[] tokenize(String dataRow) {
        String[] strArr = dataRow.split(",");
        boolean expected = Boolean.parseBoolean(strArr[0].trim());
        int testId = Integer.parseInt(strArr[1].trim());
        int testYear = Integer.parseInt(strArr[2].trim());
        Object[] objArr = {expected, testId, testYear};
        return objArr;
    }

    @Test
    public void leapYear() {
        assertEquals("TestCase: " + testId, expected, dateService.isLeapYear(testYear));
    }
}

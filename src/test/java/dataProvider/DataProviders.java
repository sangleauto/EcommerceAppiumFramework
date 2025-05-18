package dataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import commonTest.DataHelper;
import model.FormDataPOJO;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders{

    @DataProvider(name = "fillFormData")
    public Object[][] provideFillFormData(){
        String jsonStr = DataHelper.getStringJson("src/test/resources/data/FillForm.json");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            FormDataPOJO[] formDataArr = objectMapper.readValue(jsonStr, FormDataPOJO[].class);
            Object[][] data = new Object[formDataArr.length][3];
            for(int i = 0; i<formDataArr.length;i++){
                data[i][0] = formDataArr[i].getName();
                data[i][1] = formDataArr[i].getCountry();
                data[i][2] = formDataArr[i].getGender();
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse JSON data", e);
        }
    }
}

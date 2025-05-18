package dataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import commonTest.DataHelper;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProviders {

    @DataProvider(name = "fillFormData")
    public Object[][] provideFillFormData() {
        String jsonStr = DataHelper.getStringJson("src/test/resources/data/FillForm.json");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<LinkedHashMap<String, Object>> formDataList = objectMapper.readValue(jsonStr, new TypeReference<>() {
            });
            String[] keys = formDataList.getFirst().keySet().toArray(new String[0]);
            Object[][] data = new Object[formDataList.size()][keys.length];
            for (int i = 0; i < formDataList.size(); i++) {
                Map<String, Object> formData = formDataList.get(i);
                for (int j = 0; j < keys.length; j++) {
                    data[i][j] = formData.get(keys[j]);
                }
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse JSON data", e);
        }
    }
}

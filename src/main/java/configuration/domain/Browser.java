package configuration.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class Browser {
    private Map<String, String> browser = new HashMap<>();

    @JsonAnySetter
    void setBrowser(String key, String val) {
        browser.put(key, val);
    }

    public Map<String, String> getBrowser() {
        return browser;
    }
}

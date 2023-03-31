package configuration.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
public class Configuration {

    @Getter
    @JsonProperty("default environment")
    private String defaultEnvironment;

    private Browser browser;

    @Getter
    private List<Environment> environments;

    public Map<String, String> getBrowser() {
        return browser.getBrowser();
    }
}

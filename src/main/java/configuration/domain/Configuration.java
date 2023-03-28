package configuration.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Configuration(@JsonProperty("default environment")
                            String defaultEnvironment,
                            String browser,
                            List<Environment> environments) {
}

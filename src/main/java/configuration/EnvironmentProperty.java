package configuration;

import configuration.domain.Configuration;
import configuration.domain.Environment;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class EnvironmentProperty {

    private Configuration configuration;
    private Environment environment;
    private static EnvironmentProperty environmentPropertyInstance;

    private EnvironmentProperty() {
        try {
            configuration = YamlParser.getConfiguration();
            environment = configuration.environments().stream()
                    .filter(env -> env.envName().equals(configuration.defaultEnvironment()))
                    .reduce((a, b) -> {
                        throw new IllegalStateException("Multiple elements: " + a + ", " + b);
                    })
                    .orElse(null);
            log.info(String.format("EnvironmentProperty - browser: %s, env: %s",
                    configuration.browser(),
                    environment));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static EnvironmentProperty getInstance() {
        if (environmentPropertyInstance == null) {
            environmentPropertyInstance = new EnvironmentProperty();
        }
        return environmentPropertyInstance;
    }

    public String getBrowser() {
        return configuration.browser();
    }

    public Environment getEnvironment() {
        return environment;
    }
}

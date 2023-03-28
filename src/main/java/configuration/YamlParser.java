package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.domain.Configuration;

import java.io.File;
import java.io.IOException;

public class YamlParser {

    public static Configuration getConfiguration() throws IOException {
        return parseYaml(Configuration.class, "src/main/resources/config.yaml");
    }

    private static <T> T parseYaml(Class<T> objectClass, String pathname) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(new File(pathname), objectClass);
    }
}

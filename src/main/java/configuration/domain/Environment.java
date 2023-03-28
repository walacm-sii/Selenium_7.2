package configuration.domain;

public record Environment(String envName,
                          String webUrl,
                          String userName,
                          String password,
                          String mail,
                          int waitValue) {
}

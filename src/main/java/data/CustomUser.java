package data;

import configuration.EnvironmentProperty;

public record CustomUser(String name, String email, String password) {

    public CustomUser() {
        this(EnvironmentProperty.getInstance().getEnvironment().userName(),
                EnvironmentProperty.getInstance().getEnvironment().mail(),
                EnvironmentProperty.getInstance().getEnvironment().password());
    }
}

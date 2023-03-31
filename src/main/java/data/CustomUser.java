package data;


public record CustomUser(String name, String email, String password) {

    public CustomUser() {
        this(System.getProperty("userName"),
                System.getProperty("mail"),
                System.getProperty("password"));
    }
}

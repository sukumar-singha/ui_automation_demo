package com.example.framework.data;

public class UserData {
    private final String username;
    private final String password;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String role;
    
    private UserData(UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.role = builder.role;
    }
    
    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getRole() { return role; }
    
    // Builder class
    public static class UserBuilder {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String role;
        
        public UserBuilder(String username, String password) {
            this.username = username;
            this.password = password;
        }
        
        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }
        
        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public UserBuilder withRole(String role) {
            this.role = role;
            return this;
        }
        
        public UserData build() {
            return new UserData(this);
        }
    }
    
    // Predefined users for tests
    public static UserData getAdminUser() {
        return new UserBuilder("admin", "admin123")
                .withEmail("admin@example.com")
                .withFirstName("Admin")
                .withLastName("User")
                .withRole("admin")
                .build();
    }
    
    public static UserData getStandardUser() {
        return new UserBuilder("user", "password123")
                .withEmail("user@example.com")
                .withFirstName("Standard")
                .withLastName("User")
                .withRole("user")
                .build();
    }
}
package com.flipfit.config;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class Config extends Configuration {
    
    @NotNull
    @JsonProperty
    private String username;
    
    @NotNull
    @JsonProperty
    private String password;
    
    
    @NotNull
    @JsonProperty
    private String role;
    
    
    // Getters and setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}

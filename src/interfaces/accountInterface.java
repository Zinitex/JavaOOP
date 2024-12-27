
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author nanda
 */
public interface accountInterface {
    int getId();
    String getEmail();
    String getPassword();
    String getUsername();
    String getRole();
    
    void setId(int id);
    void setEmail(String email);
    void setPassword(String password);
    void setUsername(String username);
    void setRole(String role);
}

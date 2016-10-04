 /**
     * Uitleg class
     * @author: Juliana Goh & Negar Ahmadifard
     */
package nl.project.jn.servlets;

/**
 *
 * @author juulz
 */
public class User implements java.io.Serializable{

    /**
     *
     */
    private String username = null;
    private String firstName = null;
    private String lastName = null;
    private String emailAddress = null;
    private String userAccess =null;

    /**
     * Constructor of the class.
     * 
     * @param username
     * @param firstName
     * @param lastName
     * @param emailAdress
     */
     public User(String username, String firstName, String lastName, String emailAdress) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAdress;
    }

    /**
     *
     */
    public User() {
        
    }


    /**
     * Getter for username.
     * @return username
     */
    final public String getUsername() {
        return username;
    }

    /**
     * Setter for username.
     * @param username
     */
    final public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for firstname.
     * @return firstName
     */
    final public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstname.
     * @param firstName
     */
    final public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastname.
     * @return lastName
     */
    final public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastname.
     * @param lastName
     */
    final public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for emailadress.
     * @return
     */
    final public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter for emailadress.
     * @param emailAdress
     */
    final public void setEmailAddress(String emailAdress) {
        this.emailAddress = emailAdress;
    }

    /**
     *
     * @return
     */
    public String getUserAccess() {
        return userAccess;
    }

    /**
     *
     * @param userAccess
     */
    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }

}
package nl.project.jn.servlets;

/**
 * This class will be used for making a User object
 *
 * @author Juliana Goh & Negar Ahmadifard
 */
public class User implements java.io.Serializable{
    
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
     * Empty Constructor of the class
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
     * Getter for first name.
     * @return firstName
     */
    final public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for first name.
     * @param firstName
     */
    final public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for last name.
     * @return lastName
     */
    final public String getLastName() {
        return lastName;
    }

    /**
     * Setter for last name.
     * @param lastName
     */
    final public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for email address.
     * @return
     */
    final public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter for email address.
     * @param emailAdress
     */
    final public void setEmailAddress(String emailAdress) {
        this.emailAddress = emailAdress;
    }

    /**
     * getter for user access
     * @return
     */
    public String getUserAccess() {
        return userAccess;
    }

    /**
     * setter for user access
     * @param userAccess
     */
    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }

}

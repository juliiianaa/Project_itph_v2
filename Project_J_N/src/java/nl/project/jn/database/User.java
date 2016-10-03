 /**
     * Uitleg class
     * @author: Juliana Goh & Negar Ahmadifard
     */
package nl.project.jn.database;

/**
 *
 * @author juulz
 */
public class User implements java.io.Serializable{

    /**
     *
     */
//    public static final String GETUSERACCESS = null;
    private String username = null;
    private String firstName = null;
    private String lastName = null;
    private String emailAdress = null;
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
        this.emailAdress = emailAdress;
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
    final public String getEmailAdress() {
        return emailAdress;
    }

    /**
     * Setter for emailadress.
     * @param emailAdress
     */
    final public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
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

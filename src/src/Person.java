
/**
 * @author David Baker
 * @version 2014-04-15
 */
public class Person {
    private String fName;
    private String lName;
    private String state;
    private int age;

    /**
     * Initialize this person to the given parameters
     *
     * @param pFname First Name
     * @param pLname Last Name
     * @param pAge   Their Age
     * @param pState State of Origin
     */
    public Person(String pFname, String pLname, int pAge, String pState) {
        this.fName = pFname;
        this.lName = pLname;
        this.age = pAge;
        this.state = pState;
    }

    /**
     * Get the key. The Key is the lastname + firstname
     *
     * @return lastName+FirstName
     */
    public String sortKey() {
        return this.lName + this.fName;
    }

    /**
     * Get all fields of the Person class
     *
     * @return lastname, firstname, age, state
     */
    public String allFields() {
        return this.lName + "," + this.fName + "," + this.age + ","
                + this.state;
    }

    /**
     * comepare two keys from different Person classes
     *
     * @param otherPerson Person class used for comparsion
     * @return this < given -1, this == given 0, this > given 1
     */
    public int compareTo(Person otherPerson) {
        if (this.sortKey().compareTo(otherPerson.sortKey()) < 0)
            return -1;
        if (this.sortKey().compareTo(otherPerson.sortKey()) > 0)
            return 1;
        return 0;
    }

}

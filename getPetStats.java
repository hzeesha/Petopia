/**
 * This class is the getPetStats class and it extends the pet class and provides static methods to
 * retrieve various attributes of a pet, such as type, name, health, happiness,
 * fullness, sleep, and score.
 *
 * <p>This class serves as a utility for accessing pet stats globally within the application.</p>
 * 
 * <p>It uses the singleton pattern to ensure there is only one instance of the pet being accessed.</p>
 * 
 * @author team 34
 * @version 1.0
 * @since 2024-12-03
 */
public class getPetStats extends pet {

    /**
     * This is a static reference to a single pet instance.
     */
    private static pet pet;

    /**
     * this constructs a getPetStats object, initializing it with the given pet attributes.
     *
     * @param petType    the type of the pet (e.g., "Cat", "Dog", "Sheep")
     * @param petName    the name of the pet
     * @param health     the pet's health value
     * @param happiness  the pet's happiness value
     * @param fullness   the pet's fullness value
     * @param sleep      the pet's sleep value
     * @param score      the pet's score value
     */
    public getPetStats(String petType, String petName, int health, int happiness, int fullness, int sleep, int score) {
        super(petType, petName, health, happiness, fullness, sleep, score); // this calls the parent constructor
    }

    /**
     * this retrieves the pet's type
     *
     * @return the type of the pet as a String
     */
    public static String getPetType() {
        return pet.getPetType();
    }

    /**
     * this retrieves the pet's name.
     *
     * @return the name of the pet as a String
     */
    public static String getPetName() {
        return pet.getPetName();
    }

    /**
     * this retrieves the pet's health.
     *
     * @return the health of the pet as a String
     */
    public static String getHealth() {
        return pet.getHealth();
    }

    /**
     * this retrieves the pet's happiness.
     *
     * @return the happiness of the pet as a String
     */
    public static String getHappiness() {
        return pet.getHappiness();
    }

    /**
     * This retrieves the pet's fullness.
     *
     * @return the fullness of the pet as a String
     */
    public static String getFullness() {
        return pet.getFullness();
    }

    /**
     * This retrieves the pet's sleep level.
     *
     * @return the sleep level of the pet as a String
     */
    public static String getSleep() {
        return pet.getSleep();
    }

    /**
     * This retrieves the pet's score.
     *
     * @return the score of the pet as a String
     */
    public static String getScore() {
        return pet.getScore();
    }
}

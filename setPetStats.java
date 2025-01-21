/**
 * This class is the setPetStats class and it extends the pet class and provides methods
 * to set various attributes of a pet. It inherits all properties from the pet
 * class and adds setter methods for updating pet statistics.
 * 
 * <p>This class demonstrates the use of inheritance and method overriding in Java.</p>
 * 
 * @author group 34
 * @version 1.0
 * @since 2024-12-04
 * */
public class setPetStats extends pet {

    /**
     * This constructs a object with the specified attributes.
     * 
     * @param petType   the type of the pet (e.g., "Dog", "Cat").
     * @param petName   the name of the pet.
     * @param health    the health value of the pet.
     * @param happiness the happiness value of the pet.
     * @param fullness  the fullness value of the pet.
     * @param sleep     the sleep level of the pet.
     * @param balls     the number of balls the pet has.
     * @param fish      the number of fish the pet has.
     * @param bears     the number of bears the pet has.
     * @param milk      the amount of milk the pet has.
     * @param blocks    the number of blocks the pet has.
     * @param treats    the number of treats the pet has.
     * @param spinners  the number of spinners the pet has.
     * @param chicken   the amount of chicken the pet has.
     */
    public setPetStats(String petType, String petName, int health, int happiness, int fullness, int sleep, int balls, int fish, int bears, int milk, int blocks, int treats, int spinners, int chicken) {
        super(petType, petName, health, happiness, fullness, sleep, score); // Call the parent constructor
    }

    /**
     * this sets the type of the pet
     * 
     * @param petType the type of the pet (e.g., "Dog", "Cat").
     */
    public void setPetType(String petType) {
        super.setPetType(petType);
    }

    /**
     * this sets the name of the pet
     * 
     * @param petName the name of the pet.
     */
    public void setPetName(String petName) {
        super.setPetName(petName);
    }

    /**
     * this sets the health value of the pet
     * 
     * @param health the health value of the pet.
     */
    public void setHealth(int health) {
        super.setHealth(health);
    }

    /**
     * this sets the happiness value of the pet
     * 
     * @param happiness the happiness value of the pet.
     */
    public void setHappiness(int happiness) {
        super.setHappiness(happiness);
    }

    /**
     * this sets the fullness value of the pet
     * 
     * @param fullness the fullness value of the pet.
     */
    public void setFullness(int fullness) {
        super.setFullness(fullness);
    }

    /**
     * this sets the sleep level of the pet
     * 
     * @param sleep the sleep level of the pet.
     */
    public void setSleep(int sleep) {
        super.setSleep(sleep);
    }

    /**
     * this sets the score for the pet
     * 
     * @param score the score value of the pet.
     */
    public void setScore(int score) {
        super.setScore(score);
    }
}

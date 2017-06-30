/**
 * Created by Daniel on 6/30/2017.
 */
public class Port {
    /**
     * Port Number.
     */
    int num;
    /**
     * Port character.
     */
    char character;

    public Port(){
        // Used for main router.
    }

    /**
     * Is a port class for devices and Routers.
     * @param character
     * @param number
     */
    public Port(char character, int number) {
        this.num = number;
        this.character = character;
    }

    /**
     * Returns port num and char.
     * @return
     */
    public String toString() {
        return "" + character + num;
    }

    /**
     * reurns port num.
     * @return
     */
    public int getPortNumber(){
        return num;
    }

    /**
     * Returns port char
     * @return
     */
    public char getPrtCharacter() {
        return character;
    }
}

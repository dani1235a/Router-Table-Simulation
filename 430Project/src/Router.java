/**
 * Router class that holds devices.
 */
public class Router extends Device {

    /**
     * Array of devices connected to this router.
     */
    Device [] devices;
    /**
     * Boolean stating if the router is online.
     */
    private boolean isOnline;

    /**
     * Constructor that initiallizes the router.
     * @param routerName - name associated with router.
     */
    public Router(String routerName, String IP) {
        super(routerName);
        isOnline = true;
        super.setMyIPAddress(IP);

    }

    /**
     * Sets online to true or false
     * @param isOnline boolean that represents the router being online
     */
    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    /**
     * returns true if the router is online.
     * @return true if router is online.
     */
    public boolean getIsOnline(){
        return isOnline;
    }

}

/**
 * @author  Bryce Anderson
 * @version 1.0
 * This is the Class that keeps track of each device attached to a router.
 */
public class Device{

    /**
    * The name of the device
     */
    String myName;
    /**
     * The IP Address of the device.
     */
    String myIPAddress;

    /**
     * Gets the name of this device.
     * @return the name of the device
     */
    public String getName(){
        return myName;
    }

    /**
     * Gets the IP address of the device.
     * @return the IP address
     */
    public String getIPAddress() {
        return myIPAddress;
    }

    /**
     * Sets the name of this device.
     * @param theName
     */
    public void setMyName(String theName) {
        if (theName != null) {
            myName = theName;
        }
    }

    /**
     * Sets the IP address of this device.
     * @param theIP
     */
    public void setMyIPAddress(String theIP) {
        if(theIP != null) {
            myIPAddress = theIP;
        }
    }
}

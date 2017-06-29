import java.time.LocalDateTime;

/**
 * @author  Bryce Anderson
 * @version 1.1
 * This is the Class that keeps track of each device attached to a router.
 */
public class Device {

    /**
     * The name of the device
     */
    String myName;
    /**
     * The IP Address of the device.
     */
    String myIPAddress;

    /**
     * Time stamp for the devices creation
     */
    LocalDateTime myStamp;



    /**
     * Constructor for a device.
     * @param DeviceName name of device
     */
    public Device(String DeviceName, String theIP) {
        myName = DeviceName;
        myIPAddress = theIP;
        myStamp= LocalDateTime.now();
    }

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
     * @param theName the name of the device.
     */
    public void setMyName(String theName) {
        if (theName != null) {
            myName = theName;
        }
    }

    /**
     * Sets the IP address of this device.
     * @param theIP the IP address of the device.
     */
    public void setMyIPAddress(String theIP) {
        if(theIP != null) {
            myIPAddress = theIP;
        }
    }
}

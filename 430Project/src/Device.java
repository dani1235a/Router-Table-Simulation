import java.time.LocalDateTime;

/**
 * @author  Bryce Anderson
 * @version 1.1
 * @since 06/29/17
 * This is the Class that keeps track of each device attached to a router.
 */
public class Device {

    /**
     * Port of this device.
     */
    Port port;

    /**
     * The name of the device
     */
    String myName;
    /**
     * The IP Address of the device.
     */
    String myIPAddress;


    /**
     * The time and date that the device was connected.
     */
    LocalDateTime myStamp;



    /**
     * Constructor for a device.
     * @param DeviceName name of device
     */
    public Device(String DeviceName, String theIP,  Port port) {
        this.port = port;
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

    /**
     * Gets the time stamp of the device
     * @return myStamp
     */
    public LocalDateTime getTimeStamp() {
        return myStamp;
    }

    /**
     * Returns the port of device.
     * @return the port of device.
     */
    public Port getPort() {
        return port;
    }

    /**
     * Sets port of device.
     * @param p Sets port of device.
     */
    public void setPort(Port p) {
        port = p;
    }
}

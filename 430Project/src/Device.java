/**
 * @author  Bryce Anderson
 * @version 1.1
 * This is the Class that keeps track of each device attached to a router.
 */
public class Device {

    /**
     * Port of the device.
     */
    String port;

    /**
    * The name of the device
     */
    String myName;
    /**
     * The IP Address of the device.
     */
    String myIPAddress;
    /**
     * The port this device is connected to.
     */
    String myPort;

    //DateTime myTimeSpamp;

    /**
     * Constructor for a device.
     * @param DeviceName name of device
     */
    public Device(String DeviceName) {
        myName = DeviceName;
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
     * Gets the port
     * @return myPort
     */
    public String getPort() {return myPort;}

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
     * Sets the port for this device
     * @param thePort the port for the device
     */
    public void setPort(String thePort) {
        if(thePort != null) {
            myPort = thePort;
        }
    }
}

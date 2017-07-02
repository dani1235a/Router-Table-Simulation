import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Router class that holds devices.
 */
public class Router extends Device {

    /**
     * Used to Generate an IP address for a device.
     *
     */
    private int deviceIP = 0;

    /**
     * Array of devices connected to this router.
     */
    public ArrayList<Device> devices = new ArrayList<Device>();

    /**
     * Boolean stating if the router is online.
     */
    private boolean isOnline;

    /**
     * Constructor that initiallizes the router.
     * @param routerName - name associated with router.
     */
    public Router(String routerName, String IP, Port port) {
        super(routerName, IP, port);
        super.myStamp = LocalDateTime.now();
        isOnline = true;

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

    /**
     * Adds a given device to this router.
     * @param theDevice
     */
    public void addDevice(Device theDevice) {
        if(!devices.contains(theDevice)) {
            devices.add(theDevice);
        }
        if (!(theDevice instanceof Router)) {
            deviceIP++;
        }

    }
    
    /**
     * Removes a given device to this router.
     * @param theDevice
     */
    public void removeDevice(Device theDevice) {
        
        devices.remove(theDevice);
    }
    
    /**
     * Gives a list of all Device in this router.
     */
    public ArrayList<Device> getDeviceList() {
        return devices;
    }

    
    /**
     * Gives a list of all devices connected to the router.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Router Name: ");
        sb.append(this.myName);
        sb.append("\n\tDevices attached: ");
        for(Device a : devices) {
            sb.append(a.getName());
            sb.append(' ');
        }

        return sb.toString();
    }

    /**
     * Method used to Generate an IP for a newly added device.
     * @return
     */
    public String generateIPForDevice() {
        return "192.168.0." + (deviceIP + 1);
    }

}

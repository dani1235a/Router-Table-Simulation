import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Router class that holds devices.
 */
public class Router extends Device {

    /**
     * Array of devices connected to this router.
     */
    ArrayList<Device> devices = new ArrayList<Device>();

    /**
     * Boolean stating if the router is online.
     */
    private boolean isOnline;

    /**
     * Constructor that initiallizes the router.
     * @param routerName - name associated with router.
     */
    public Router(String routerName, String IP) {
        super(routerName, IP);
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

    }
    public ArrayList<Device> getDeviceList() {
        return devices;
    }

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

}

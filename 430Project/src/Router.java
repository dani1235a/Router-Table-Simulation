/**
 * Router class that
 */
public class Router extends Device {

    /**
     * The routing table inside this router.
     */
    private RouterTable table;

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
        // the IP address will be set from main.
//        super.setMyIPAddress("10.10.10.1");
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

    /**
     * Method that checks if an IP address is valid (available).
     * @param ip the IP you want to check
     * @return True if IP is not taken.
     */
    public boolean isValidIP(String ip) {
        return !table.isTaken(ip);
    }

    /**
     * This method adds a device to the router.
     * @param device the device being added
     * @param port the port the device is connected to.
     */
    public void addDevice(Device device, String port){
        if (device instanceof Router) {
            // Take the router table and add +1 to all of its hops and add to our own router table
            table.addRouter(device.getName(), device.getIPAddress(), port);
        } else {
            //assign device IP
            table.addDevice(device);
        }
    }

    /**
     * returns the router table.
     * @return router table. (in 2d array form)
     */
    private String[][] getTable() {
        return table.getRouterTable().clone();
    }

    /**
     * Inner class with RouterTable
     */
    private class RouterTable {
        /**
         * The 2d array that stores all the router data.
         */
        private String [][] routerTable;

        /**
         * Private Constructor
         */
        public RouterTable() {
            // WE know that we only have up to 10 devices on the network.
            routerTable = new String[16][16];
        }

        /**
         * Method to print out the table in fancy manner.
         * @return table with all the data in it
         */
        private String[][] getRouterTable() {
            return routerTable;
        }


        /**
         * Method to remove specified device from the table
         * @param ip ip address associted with the specific device
         */
        private void removeFromTable(String ip) {
            //TODO: remove this IP from the Table.
        }

        /**
         * Method that checks if an IP address is available.
         * @param ip
         * @return
         */
        private boolean isTaken(String ip) {
         //TODO: return true if this IP is taken
            return false;
        }

        /**
         * Adds another router to the router table
         * @param name
         * @param port
         * @param IP the IP
         */
        public void addRouter(String name, String IP, String port) {
            //TODO: take the table from other router and add its devices to my own table.
        }

        /**
         * Adds another device to router table.
         * @param device
         */
        public void addDevice(Device device) {
            //TODO: assign IP and add info to table.
        }
    }
}

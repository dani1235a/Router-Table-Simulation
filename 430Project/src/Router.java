/**
 * Router class that
 */
public class Router {

    /**
     * The name associated with this router.
     */
    private String routerName;

    /**
     * Constructor that initiallizes the router.
     * @param routerName - name associated with router.
     */
    public Router(String routerName) {
        this.routerName = routerName;
    }

    /**
     * Inner class with RouterTable
     */
    public class RouterTable {
        /**
         * The 2d array that stores all the router data.
         */
        private String [][] routerTable;

        /**
         * Private Constructor
         */
        private RouterTable() {}

        /**
         * Method to print out the table in fancy manner.
         * @return table with all the data in it
         */
        public String printRouterTable() {
            return "print fancy table here";
        }

        /**
         * Method to add a device to table.
         */
        public void addToTable() {

        }

        /**
         * Method to remove specified device from the table
         * @param ip ip address associted with the specific device
         */
        public void removeFromTable(String ip) {

        }

    }
}

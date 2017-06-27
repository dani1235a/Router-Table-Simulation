/**
 * Router class that
 */
public class Router {

    /**
     * The name associated with this router.
     */
    private String routerName;

    /**
     *
     * @param routerName
     */
    public Router(String routerName) {
        this.routerName = routerName;
    }

    public class RouterTable {

        private String [][] routerTable;

        /**
         *
         */
        private RouterTable() {

        }

        public String printRouterTable() {
            return "print fancy table here";
        }

        public void addToTable() {

        }

        public void removeFromTable(String ip) {

        }

    }
}

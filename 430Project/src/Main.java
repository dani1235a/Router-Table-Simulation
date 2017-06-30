import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author  Colin Casey
 * @version 1.0
 * This Class runs the console based UI.
 */
public class Main {

    private static int routerIPGenerator = 5;

    private static int Sports = 1;
    private static int Eports = 2;




    public static ArrayList<Router> routers = new ArrayList<Router>();

	/**
	 * Used to call console based UI method.
	 * @param args
	 */
	public static void main(String... args) {
		initData();
		console();
	}




	/**
	 * This method handles the console based UI
	 */
	public static void console() {
		Scanner user = new Scanner(System.in);
		boolean flag = true;
		int path = 0;
		while(flag) {
			if(path == 0) {
				System.out.println("Type in the number of your choice");
				System.out.println("1 Print off table");
				System.out.println("2 Update");
				System.out.println("3 Exit");
				path = user.nextInt();
			} if(path == 1) {
				toStrings();
			} if(path == 2) {
                changeTable();
			} if(path == 3) {
				flag = false;
				path = 0;
			} else {
				path = 0;
			}
		}
		user.close();
	}

	/**
	 * Initializes the data for the router table
	 * @author Bryce
	 */
	public static void initData() {
		Device device0 = new Device("Office Device1", "192.168.0.1", new Port('E',1));
        Device device1 = new Device("Office Device2", "192.168.0.2", new Port('E',2));
        Device device2 = new Device("Bedroom Device1", "192.168.0.1", new Port('S',1));
        Device device3 = new Device("Bedroom Device2", "192.168.0.2", new Port('S',1));
        Device device4 = new Device("Base Device1", "192.168.0.1", new Port('S',2));
        Device device5 = new Device("Base Device2", "192.168.0.2", new Port('S',2));
        Device device6 = new Device("Loft Device1", "192.168.0.1", new Port('S',0));
        Device device7 = new Device("Loft Device2", "192.168.0.2", new Port('S',0));

		Router router1 = new Router("Main Router", "10.10.0.1", new Port());
		Router router2 = new Router("Bedroom Router", "10.10.0.2", new Port('S',1));
		Router router3 = new Router("Basement Router", "10.10.0.3", new Port('S',2));
		Router router4 = new Router("Loft Router 1", "10.10.0.4", new Port('S',0));



		router1.addDevice(device0);
		router1.addDevice(device1);
		router2.addDevice(device2);
		router2.addDevice(device3);
		router3.addDevice(device4);
		router3.addDevice(device5);
		router4.addDevice(device6);
		router4.addDevice(device7);

		routers.add(router1);
		routers.add(router2);
		routers.add(router3);
		routers.add(router4);

//    	System.out.println(router1.toString());
//    	System.out.println(router2);
//    	System.out.println(router3);
//    	System.out.println(router4);

		System.out.println();

	}
	/**
	 * Used to add or remove from router table.
	 */
	public static void changeTable() {

	    Scanner scanner = new Scanner(System.in);
	    int selected = 0;

        while(true) {
            System.out.println("1) Add Device");
            System.out.println("2) Add Router");
            System.out.println("3) Remove Device");
            selected = scanner.nextInt();
            if (selected > 3 && selected < 0)
                System.out.println("Please enter a valid choice");
            if (selected >= 1 && selected <= 3)
                break;
        }



        if (selected == 1) {
            int routerSelected = -1;
            while (true) {
                System.out.println("Select a router you want to add the device to:");
                for (int i = 0; i < routers.size(); i++) {
                    System.out.println(i + ") " + routers.get(i).getName());
                }
                routerSelected = scanner.nextInt();
                if (routerSelected > routers.size() + 1) {
                    System.out.println("Please make a valid choice.");
                } else {
                    break;
                }
            }

            String ip = routers.get(routerSelected).generateIPForDevice();

            System.out.println("Enter Device Name: ");
            scanner.nextLine();
            String deviceName = scanner.nextLine();

            Port port;
            if (routerSelected == 0) {
                port = new Port('E', Eports);
            } else {
                port = routers.get(routerSelected).getPort();
            }

            Device newDevice = new Device(deviceName, ip, port);
            routers.get(routerSelected).addDevice(newDevice);

        } else if (selected == 2) {
            System.out.println("Enter Router Name: ");
            scanner.nextLine();
            String routerName = scanner.nextLine();

            String routerIP = "10.10.0." + routerIPGenerator;
            routerIPGenerator++;

            Router newRouter = new Router(routerName, routerIP);
            routers.add(newRouter);

        } else {
            // do nothing
        }

    }


	/**
	 * Used to print off router table.
	 */
	public static String toStrings() {

		int rCount = -1;
		int dCount = 0;

		System.out.println("Name \t\t|\t IP Address \t|\t Time \t\t\t\t|\t HOPs \t | \t Port");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		for(Router r : routers) {
			if(rCount != -1) {
				System.out.printf(r.getName() + "\t|\t" + r.getIPAddress() + "\t|\t" + r.getTimeStamp() + "\t\t|\t" + rCount + "\t" + r.getPort().toString() + "\n" );

			}
			rCount++;
			for(Device d : r.getDeviceList()) {
				System.out.printf(d.getName() + "\t|\t" + d.getIPAddress() + "\t|\t" + d.getTimeStamp() + "\t\t|\t" + dCount + "\t" + d.getPort().toString() + "\n");

			}
			dCount++;
		}

		return null;
	}

}
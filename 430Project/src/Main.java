import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author  Colin Casey
 * @version 1.0
 * This Class runs the console based UI.
 */
public class Main {

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

			} if(path == 2) {

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
		Device device0 = new Device("Office Device1", "192.68.0.1");
		Device device1 = new Device("Office Device2", "192.68.0.2");
		Device device2 = new Device("Bedroom Device1", "192.68.0.1");
		Device device3 = new Device("Bedroom Device2", "192.68.0.2");
		Device device4 = new Device("Base Device1", "192.68.0.1");
		Device device5 = new Device("Base Device2", "192.68.0.2");
		Device device6 = new Device("Loft Device1", "192.68.0.1");
		Device device7 = new Device("Loft Device2", "192.68.0.2");

		Router router1 = new Router("Office Router", "10.10.0.1");
		Router router2 = new Router("Bedroom Router", "10.10.0.2");
		Router router3 = new Router("Basement Router", "10.10.0.3");
		Router router4 = new Router("Loft Router", "10.10.0.4");



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

		toStrings();
		System.out.println();

	}
	/**
	 * Used to add or remove from router table.
	 */
	public static void changeTable() {

	}

	/**
	 * Used to print off router table.
	 */
	public static String toStrings() {

		int rCount = -1;
		int dCount = 0;
		System.out.println("Name \t\t|\t IP Address \t|\t Time \t\t\t\t|\t HOPs");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		for(Router r : routers) {
			if(rCount != -1) {
				System.out.println(r.getName() + "\t|\t" + r.getIPAddress() + "\t|\t" + r.getTimeStamp() + "\t\t|\t" + rCount);

			}
			rCount++;
			for(Device d : r.getDeviceList()) {
				System.out.println(d.getName() + "\t|\t" + d.getIPAddress() + "\t|\t" + d.getTimeStamp() + "\t\t|\t" + dCount);

			}
			dCount++;
		}

		return null;
	}

}
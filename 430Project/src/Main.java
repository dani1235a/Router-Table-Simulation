import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author  Colin Casey
 * @version 1.0
 * This Class runs the console based UI.
 */
public class Main {

    private static int routerIPGenerator = 5;

    private static int Sports = 3;
    private static int Eports = 2;
    private static int devices = 8;


    /**
     * A list of all routers in the system.
     */
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
		Device device0 = new Device("Office Device1", "192.168.0.1", new Port('E',0));
        Device device1 = new Device("Office Device2", "192.168.0.2", new Port('E',1));
        Device device2 = new Device("Bedroom Device1", "192.168.0.3", new Port('S',1));
        Device device3 = new Device("Bedroom Device2", "192.168.0.4", new Port('S',1));
        Device device4 = new Device("Base Device1", "192.168.0.5", new Port('S',2));
        Device device5 = new Device("Base Device2", "192.168.0.6", new Port('S',2));
        Device device6 = new Device("Loft Device1", "192.168.0.7", new Port('S',0));
        Device device7 = new Device("Loft Device2", "192.168.0.8", new Port('S',0));

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
                if (routerSelected >= routers.size() + 1) {
                    System.out.println("Please make a valid choice.");
                } else {
                    break;
                }
            }

            String ip = "192.168.0." + (devices + 1);
            devices++;

            System.out.println("Enter Device Name: ");
            scanner.nextLine();
            String deviceName = scanner.nextLine();

            Port port;
            if (routerSelected == 0) {
                port = new Port('E', Eports);
                Eports++;
            } else {
                port = routers.get(routerSelected).getPort();
            }

            Device newDevice = new Device(deviceName, ip, port);
            routers.get(routerSelected).addDevice(newDevice);

        } else if (selected == 2) {
            System.out.println("Which other router is this router connected to?");
            int count = 0;
            String linkedRouterName = "";
            for(Device d : routers) {
                if (d instanceof Router) {
                    System.out.println(count + ")" + d.getName());
                    count++;
                    for (int i = 0; i < ((Router) d).devices.size(); i++) {
                        if (((Router) d).devices.get(i) instanceof Router) {
                            System.out.println(count + ")" + d.getName());
                            count++;
                        }
                    }
                }
            }



            System.out.println("Enter New Router Name: ");
            scanner.nextLine();
            String routerName = scanner.nextLine();

            String routerIP = "10.10.0." + routerIPGenerator;
            routerIPGenerator++;

            Router newRouter = new Router(routerName, routerIP, new Port('S', Sports));
            Sports++;
            routers.add(newRouter);

        } else {
            //build devices table for input parsing
            //also print options
            System.out.println("Enter device or router to remove:");
            ArrayList<ArrayList<Device>> devicesByRouter = new ArrayList<ArrayList<Device>>();
            int optionNumber = 1;
            for (Router router : routers) {
                ArrayList<Device> devices = new ArrayList<Device>();
                devices.add(router);
                if (!router.getIPAddress().equals("10.10.0.1")) {
                    System.out.println(optionNumber + ") " + router.getName());
                    optionNumber++;
                }
                for (Device device : router.getDeviceList()) {
                    devices.add(device);
                    System.out.println(optionNumber + ") " + device.getName());
                    optionNumber++;
                }
                devicesByRouter.add(devices);
            }
            
            //get option input
            int input;
            while (true) {
                input = scanner.nextInt();
                if (input < 1 || input > optionNumber - 1) {
                    System.out.print("Enter a valid number: ");
                } else {
                    break;
                }
            }
            
            //find the device to remove
            int indexOffset = 0;
            for (ArrayList<Device> devices : devicesByRouter) {
                //checking if we have the device list for the correct device
                if (input < indexOffset + devices.size()) {
                    int deviceIndex = input - indexOffset;
                    //if this is 0, the device is a router
                    if (deviceIndex == 0) {
                        routers.remove(devices.get(deviceIndex));
                    } else {
                        //get the router and remove the device from its device list
                        ((Router) devices.get(0)).removeDevice(devices.get(deviceIndex));
                    }
                    break;
                } else {
                    indexOffset += devices.size();
                }
            }
        }

    }


	/**
	 * Used to print off router table.
	 */
	public static void toStrings() {

		StringBuilder sb = new StringBuilder(1024);
		sb.append(" Name");
		insertSpaces(sb, 29);
		sb.append("| IP Address");
		insertSpaces(sb, 6);
		sb.append("| Time");
		insertSpaces(sb, 20);
		sb.append("| Hops | Port\n");
		
		for (int i = 0; i < 92; i++) {
		    sb.append('-');
		}
		sb.append('\n');
		
		for (Router router : routers) {
		    if (!router.getIPAddress().equals("10.10.0.1")) {
		        sb.append(' ');
		        sb.append(String.format("%1$-32s", router.getName()));
		        sb.append(" | ");
		        sb.append(formatIp(router.getIPAddress()));
		        sb.append(" | ");
		        sb.append(router.getTimeStamp());
		        sb.append(" | 0    | ");
		        sb.append(router.getPort().toString());
		        sb.append('\n');
		    }
		    for (Device device : router.getDeviceList()) {
		        sb.append(' ');
                sb.append(String.format("%1$-32s", device.getName()));
                sb.append(" | ");
                sb.append(formatIp(device.getIPAddress()));
                sb.append(" | ");
                sb.append(device.getTimeStamp());
                sb.append(" | ");
                if (router.getIPAddress().equals("10.10.0.1")) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
                sb.append("    | ");
                sb.append(device.getPort().toString());
                sb.append('\n');
		    }
		}
		
		System.out.println(sb.toString());
	}
	
	/**
	 * This method is used to format IP addresses.
	 * @param theIpAddress
	 */
	private static String formatIp(String theIpAddress) {

        String[] pairs = theIpAddress.split("\\.");
	    StringBuilder sb = new StringBuilder(15);
	    for (int i = 0; i < 3; i++) {
	        sb.append(String.format("%1$3s", pairs[i]));
	        sb.append('.');
	    }
	    sb.append(String.format("%1$3s", pairs[3]));
	    return sb.toString();
    }

	/**
	 * This method is used to insert spaces to the string builder TheSb. This
	 * happens the number of times equal to the value theAmount.
	 * @param theSb
	 * @param theAmount
	 */
    private static void insertSpaces(StringBuilder theSb, int theAmount) {
	    
	    for (int i = 0; i < theAmount; i++) {
	        theSb.append(' ');
	    }
	}

}
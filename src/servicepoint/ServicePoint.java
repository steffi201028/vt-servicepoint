package servicepoint;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.htw.fiw.vs.IBinder;
import org.htw.fiw.vs.fernseher.IDisplayRemote;
import org.htw.fiw.vs.fernseher.IFernseherRemote;
import org.htw.fiw.vs.fernseher.IServicePoint;
<<<<<<< HEAD
import org.htw.fiw.vs.heartbeat.IPlayer;




public class ServicePoint extends UnicastRemoteObject implements Runnable,IServicePoint{


 IDisplayRemote displayRemote;
	private IBinder binder;
    boolean status;
	private static int observerIDTracker = 0;
	private int observerID;
	private String number;
	IPlayer player;
=======

public class ServicePoint extends UnicastRemoteObject implements Runnable,IServicePoint{

	private IDisplayRemote displayRemote;
	private IBinder binder;
	private boolean status;
	private static int observerIDTracker = 0;
	private int observerID;
>>>>>>> 7f022025c3334b635d07c8152320bc15c35ec2ee




	public ServicePoint(IBinder binder)  throws RemoteException{
		//super();
		try {
<<<<<<< HEAD
			//System.setProperty("java.rmi.server.hostname","141.45.204.2");
			displayRemote = (IDisplayRemote) binder.lookup("Display");
			this.binder = binder;
			//this.displayRemote = displayRemote;
			this.observerID = ++observerIDTracker;
			System.out.println("New Observer " + this.observerID);
         
			this.displayRemote.register(this);
=======
			System.setProperty("java.rmi.server.hostname", "141.45.152.61");
			displayRemote = (IDisplayRemote) binder.lookup("Display");
			this.binder = binder;
			this.displayRemote = displayRemote;
			this.observerID = ++observerIDTracker;
			System.out.println("New Observer " + this.observerID);
      
			displayRemote.register(this);
>>>>>>> 7f022025c3334b635d07c8152320bc15c35ec2ee

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
<<<<<<< HEAD
		
=======

>>>>>>> 7f022025c3334b635d07c8152320bc15c35ec2ee
		if(args.length == 2){
			String ip = args[0];
			int port = Integer.parseInt(args[1]);
			String protokoll = "rmi://";
			String url = protokoll + ip + ":" + port + "/binder";
			System.out.println("ServicePoint gestartet");
			try{
<<<<<<< HEAD
				//System.setProperty("java.rmi.server.hostname", "141.45.251.135");
=======
>>>>>>> 7f022025c3334b635d07c8152320bc15c35ec2ee
				IBinder binder = (IBinder) Naming.lookup(url);
				ServicePoint servicepoint = new ServicePoint(binder);
				Thread thread = new Thread(servicepoint);
				thread.start();
<<<<<<< HEAD
				for (String object : binder.list()) {
					System.out.println(object);
=======
				for (String service : binder.list()) {
					System.out.println(service);
>>>>>>> 7f022025c3334b635d07c8152320bc15c35ec2ee
				}
				System.out.println("SevicePoint laeuft...");

			}catch (MalformedURLException murle) { 
				System.out.println(); 
				System.out.println(
						"MalformedURLException"); 
				System.out.println(murle); 
			} 
			catch (RemoteException re) { 
				System.out.println(); 
				System.out.println(
						"RemoteException"); 
				System.out.println(re); 
			} 
			catch (NotBoundException nbe) { 
				System.out.println(); 
				System.out.println(
						"NotBoundException"); 
				System.out.println(nbe); 
			} 
			catch (
					java.lang.ArithmeticException
					ae) { 
				System.out.println(); 
				System.out.println(
						"java.lang.ArithmeticException"); 
				System.out.println(ae); 
			} 
		} else {
			System.out.println("Bitte IP-Adresse und Port als Programmparameter uebergeben");
		}
	}

	@Override
	public void run() {

		while(true){
			try {
				//Thread.sleep(100);

				for (String service : binder.list()) {
					if(service.contains("Fernseher")){
						IFernseherRemote fernseherRemote = (IFernseherRemote) binder.lookup(service);
<<<<<<< HEAD
						if(service.contains("team3/PlayerService")) {
						player = (IPlayer) binder.lookup(service);
						System.out.println(service);
						}
						if (status){
							
							fernseherRemote.turnOn();
							
						
						
						
						
							
						} else {
							fernseherRemote.turnOff();
							
=======
						if(fernseherRemote.getStatus() == false){
							fernseherRemote.turnOff();
						} else {
							fernseherRemote.turnOn();
>>>>>>> 7f022025c3334b635d07c8152320bc15c35ec2ee
						}

					}
				}
				/*catch (InterruptedException e) {
				e.printStackTrace();*/
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(boolean status) {
		 this.status = status;

		
	}
<<<<<<< HEAD

	@Override
	public void update(String number) throws RemoteException {
		this.number=number;
	}

	

	
	}

=======
}
>>>>>>> 7f022025c3334b635d07c8152320bc15c35ec2ee



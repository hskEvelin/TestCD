package main.java;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class StartParcelSizeService{

	public static void main(String[] args){
		/*
		IDatabaseHandler db = MySQLDatabaseHandler.getDatabaseHandler();
		//open Connection
		db.createParcelSizeTable();
		db.insertParcelSize("XS", 35);
		db.insertParcelSize("S",  50);
		db.insertParcelSize("M",  65);
		db.insertParcelSize("L",  80);
		db.insertParcelSize("XL", 300);
		*/
		
		//MyApplication app = new MyApplication();
		//app.getContainerResponseFilters().add(CORSFilter.class);
		ResourceConfig rc = new PackagesResourceConfig("main.java");
		rc.getProperties().put("com.sun.jersey.spi.container.ContainerResponseFilters",
								"main.java.CORSFilter");
		rc.getRootResourceClasses().add(ParcelSizeService.class);
		
        //System.out.println(app.isProviderClass(CORSFilter.class));
		HttpServer server;
		
		
		try {
			server = HttpServerFactory.create("http://localhost:1100/parcel", rc);
			server.start();
			
			//while(true){}
			//JOptionPane.showMessageDialog(null, "ParcelSize-Service started!\nClick to end");
			//server.stop(0);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
			//while(true){}
			//JOptionPane.showMessageDialog(null, "ParcelSize-Service started!\nClick to end");
			//server.stop(0);
		
	}
}
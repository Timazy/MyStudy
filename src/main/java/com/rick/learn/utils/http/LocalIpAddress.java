package com.rick.learn.utils.http;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/*
*	@author : Rick
*	@date : Jun 6, 2019
*	
*/
public class LocalIpAddress {

	public static void main(String[] args) throws SocketException, UnknownHostException {
//		Enumeration<?> interfaces = null;
//	    try {
//	        interfaces = NetworkInterface.getNetworkInterfaces();
//	    } catch (SocketException e) {
//	        e.printStackTrace();
//	    }
//	    InetAddress ip = null;
//	    if (interfaces != null) {
//	        while (interfaces.hasMoreElements()) {
//	            NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
//	            System.out.println("NI: " + ni.getName() + ", " + ni.getDisplayName());
//	            Enumeration<?> addresses = ni.getInetAddresses();
//	            while (addresses.hasMoreElements()) {
//	                ip = (InetAddress) addresses.nextElement();
//	                if (ip != null && (ip instanceof Inet4Address)) {
//	                	System.out.println("IP addr: " + ip.getHostAddress());
//	                    break;
//	                }
//	            }
//	        }
//	    }
		
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			System.out.println(Inet4Address.getLocalHost().getHostAddress());
			System.out.println(Inet6Address.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(final DatagramSocket socket = new DatagramSocket()){
			  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			  System.out.println( socket.getLocalAddress().getHostAddress());
			}
		
	}


    


}

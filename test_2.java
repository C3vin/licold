// UDP client sends a message to the server and gets a reply

import java.net.*;
import java.io.*;
public class UDPClient {

	public static void main(String args[]) { // args give message contents and server hostname DatagramSocket aSocket = null; try { aSocket = new DatagramSocket(); byte [] m = args[0].getBytes();

		InetAddress aHost = InetAddress.getByName(args[1]);

		int serverPort = 6789;

		DatagramPacket request = new DatagramPacket(m, m.length(), aHost, serverPort);
		aSocket.send(request);

		byte[] buffer = new byte[1000];

		DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
		aSocket.receive(reply);
		System.out.println("Reply: " + new String(reply.getData()));
	} catch (SocketException e) {
		System.out.println("Socket: " + e.getMessage());
	} catch (IOException e) {
		System.out.println("IO: " + e.getMessage());
	} finally {
		if (aSocket != null) aSocket.close();
	}

}
 



************

// UDP server repeatedly receives a request and sends it back to the client

import java.net.*;
import java.io.*;
public class UDPServer {

	public static void main(String args[]) {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(6789);

			byte[] buffer = new byte[1000];

			while (true) {
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
				aSocket.send(reply);
			}
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null) aSocket.close();
		}

	}

}


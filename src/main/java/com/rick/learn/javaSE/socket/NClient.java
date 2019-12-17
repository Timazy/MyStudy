package com.rick.learn.javaSE.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;

public class NClient {

	private Selector selector = null;
	static final int PORT = 30000;
	private Charset charset = Charset.forName("utf-8");
	
	private SocketChannel socketChannel = null;
	public void init() throws IOException{
		
		selector = Selector.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(isa);
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		new ClientThread().start();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			ByteBuffer buffer = charset.encode(scanner.nextLine());
			System.out.println("send Message:"+new String(buffer.array()));
			socketChannel.write(buffer);
//			try {
//				Thread.sleep(10000);
//				shutdown();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
	
	public void shutdown() throws IOException {
		if (socketChannel.isOpen()) {
			socketChannel.close();
		}
	}
	
	
	private class ClientThread extends Thread{
		
		public void run(){
			
				while(true) {
					int numKeys = 0;
					try {
						numKeys = selector.select();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (numKeys == 0) {
						System.out.println("select wake up with selectkeys zero");
					}
					Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
					while(keys.hasNext()){
						SelectionKey sk = keys.next();
						
						try {
							if (sk.isConnectable()) {
								SocketChannel sc = (SocketChannel) sk.channel();
								if (sc.isConnectionPending()) {
									sc.finishConnect();
								}
								//sc.configureBlocking(false);
								sc.register(selector, SelectionKey.OP_READ);
								System.out.println("client connected");
							}
							if(sk.isReadable()){
								SocketChannel sc = (SocketChannel) sk.channel();
								ByteBuffer buffer = ByteBuffer.allocate(1024);
								String content = "";
								while(sc.read(buffer) > 0){
									buffer.flip();
									content += charset.decode(buffer);
								}
								if (content.length() > 0) {
									System.out.println("聊天信息："+content);
								}else {
									sk.cancel();
									System.out.print("server offline");
								}
								
								//sk.interestOps(SelectionKey.OP_READ);
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							// TODO: handle exception
						}finally {
							selector.selectedKeys().remove(sk);
						}
							
					}
				}

		}
	}
	public static void main(String[] args) throws IOException{
		new NClient().init();
	}
}

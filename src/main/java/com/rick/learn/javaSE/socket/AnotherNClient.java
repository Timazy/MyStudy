package com.rick.learn.javaSE.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;


public class AnotherNClient {
	private Selector selector = null;
	static final int PORT = 30000;
	private Charset charset = Charset.forName("utf-8");
	
	private SocketChannel sc = null;
	public void init() throws IOException{
		
		selector = Selector.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		sc = SocketChannel.open(isa);
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
		new ClientThread().start();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			ByteBuffer buffer = charset.encode(scanner.nextLine());
			System.out.print("send Message:"+buffer.toString());
			sc.write(buffer);
		}
	}
	
	
	private class ClientThread extends Thread{
		
		public void run(){
			
			try {
				while(selector.select() > 0){
					for(SelectionKey sk: selector.selectedKeys()){
						selector.selectedKeys().remove(sk);
						
						if(sk.isReadable()){
							SocketChannel sc = (SocketChannel) sk.channel();
							ByteBuffer buffer = ByteBuffer.allocate(1024);
							String content = "";
							while(sc.read(buffer) > 0){
								sc.read(buffer);
								buffer.flip();
								content += charset.decode(buffer);
							}
							System.out.println("聊天信息："+content);
							sk.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException{
		new NClient().init();
	}
}

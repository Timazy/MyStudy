package com.timazy.learn.javaSE.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import sun.misc.Unsafe;


public class NServer {

	private Selector selector = null;
	static final int  PORT = 30000;
	//定义编解码的字符集对象
	private Charset charset = Charset.forName("utf-8");
	public ExecutorService pool = Executors.newCachedThreadPool();
	
	public void init() throws IOException{
		selector = SelectorProvider.provider().openSelector();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		
		ServerSocketChannel server = ServerSocketChannel.open();
		//server.socket().setOption(name, value)
		server.configureBlocking(false);
		server.bind(isa);
		server.register(selector, SelectionKey.OP_ACCEPT);

		while(true) {
			int numKeys = selector.select();
			if (numKeys == 0) {
				System.out.print("select wake up with selectkeys zero");
			}
			Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
			while (keys.hasNext()) {
				SelectionKey sk = keys.next();
//				selector.selectedKeys().remove(sk);
				System.out.println(sk.interestOps());
				try {
					if((sk.interestOps() & SelectionKey.OP_ACCEPT) != 0){
						SocketChannel sc = server.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
						System.out.println("server accept");
					}
					
					if((sk.interestOps() & SelectionKey.OP_READ) != 0){
						
						pool.execute(new ReadTask(sk));

					}
				} catch (Exception e) {
					e.printStackTrace();
					sk.cancel();
					if(sk.channel() != null){
						sk.channel().close();
					}
				}finally {
					keys.remove();
				}
				
			}
			
		}
		
	}
	
	public class ReadTask implements Runnable{

		public SelectionKey sk;
		
		public ReadTask(SelectionKey sk) {
			this.sk = sk;
		}
		
		
		@Override
		public void run() {
			
			try {
				// deregister OP_READ
				System.out.println("PREV SET : " + sk.interestOps());
	            sk.interestOps(sk.interestOps() & ~SelectionKey.OP_READ);
	            System.out.println("NEW SET : " + sk.interestOps());
	            
				SocketChannel sc = (SocketChannel) sk.channel();
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				
				String content = "";
				while(sc.read(buffer) > 0 ){
					buffer.flip();
					content += charset.decode(buffer);
				}
				
				System.out.println("读取的数据是："+ content);
				if(content.length() > 0) {
					//SocketChannel s = (SocketChannel) sk.channel();
					//s.write(charset.encode("server recall"));
					if(content.length() > 0){
					for(SelectionKey key : selector.keys()){
						Channel targetChannel = key.channel();
						if(targetChannel instanceof SocketChannel){
							SocketChannel dest = (SocketChannel) targetChannel;
							dest.write(charset.encode(content));
							}
						}
					}
					sk.interestOps(SelectionKey.OP_READ);
				} else {
					sk.cancel();
					System.out.println("client offline");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	public static void main(String[] args){
		try {
			new NServer().init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

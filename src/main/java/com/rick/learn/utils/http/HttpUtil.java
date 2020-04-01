package com.rick.learn.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
*	@author : Rick
*	@date : May 24, 2019
*	
*/
public class HttpUtil {

	
	 public static void main(String[] args) {
		 for (int i = 0; i < 10; i++) {
			new java.lang.Thread(new Runnable() {
				
				@Override
				public void run() {
					
					 for (int i=0;i<500;i++){
				            try {
				                StringBuilder sb = new StringBuilder();
				                URL restServiceURL = new URL("");
				                HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
				                // 打开输出开关
				                httpConnection.setRequestMethod("POST");
				                httpConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//				          httpConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
				                httpConnection.setRequestProperty("Accept", "application/json, text/plain, */*");
				                httpConnection.setDoOutput(true);
				                httpConnection.connect();

				                // 传递参数，获取HttpURLConnection对象的输出流
				                OutputStream outputStream = httpConnection.getOutputStream();
				                //请求参数发送
				                outputStream.write("{\"accountId\": 123345335,\"channel\": \"HQBS\"}".getBytes());
				                // flush输出流的缓冲
				                outputStream.flush();
				                if (httpConnection.getResponseCode() != 200) {
				                    throw new RuntimeException("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
				                }
				                //定义BufferedReader输入流来读取URL的响应
				                BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
				                System.out.println("Output from Server:  \n");
				                String output;
				                while ((output = responseBuffer.readLine()) != null) {
				                    System.out.println(output);
				                    sb.append(output);
				                    System.out.println("=============");
				                }
				                httpConnection.disconnect();
				                System.out.println(sb.toString());
				            }catch(IOException e){

				            }
				        }


				   
				}
			}).start();;
		}
	       
	 }
	
	
}

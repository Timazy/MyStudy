package com.timazy.learn.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.sun.corba.se.spi.orb.StringPair;

/*
*	@author : Rick
*	@date : Jun 14, 2019
*	
*/
public class GetSearchSqlFromLog {

	public static void main(String[] args) throws IOException {

		String test_path_from = "/Users/timazy/Downloads/a.log";
		String test_path_to = "/Users/timazy/Downloads/a.txt";
		
		String p_path_from = "/Users/timazy/Downloads/search-platform-center_info.log";
		String search_path_to = "/Users/timazy/Downloads/search.txt";
		String recommandByIds_path_toString ="/Users/timazy/Downloads/recommandId.txt";
		String similar_path_toString ="/Users/timazy/Downloads/similar.txt";
		String saima_from = "/Users/timazy/Downloads/search-platform-center_error.log";
		String saima_to = "/Users/timazy/Downloads/saima.txt";
		
        //FileWriter writer = new FileWriter("/Users/timazy/Downloads/recommandAccount.txt", true);  
        RandomAccessFile toFile = new RandomAccessFile(saima_to, "rw"); 
		File fromFile = new File(saima_from);  
        BufferedReader reader = null;  
        try {  
            reader = new BufferedReader(new FileReader(fromFile));  
            String tempString = null;  
            int line = 1;  
            while ((tempString = reader.readLine()) != null) {  
            	//String[] par = tempString.split("findItemBySelectionId发生异常，入参为：\\[");
            	String[] par = tempString.split("findItemBySelectionId发生异常，入参为：\\[");
            	if (par.length == 2) {
            		String paramString = par[1];
            		String p = paramString.split("\\]，异常信息为：")[0]+"\n";
//            		int a = p.indexOf("searchWord");
//            		if (a == -1 || p.charAt(a + 13) == '"') {
//            			continue;
//					}
            		appendMethodA(toFile,p.getBytes("utf-8"));
				}
            	
                line++;  
            }  
            reader.close();
        } catch (IOException e) {  
            e.printStackTrace();  
            return;  
        }  
		
	}
	
	   public static void appendMethodA(RandomAccessFile file,byte[] content) {  
	        try {  
	            // 文件长度，字节数  
	            long fileLength = file.length();  
	            //将写文件指针移到文件尾。  
	            file.seek(fileLength);  
	            file.write(content);
	            //file.writeBytes(content+"\n");  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	
	   public static void appendMethodB( FileWriter writer, String content) {  
	        try {  
	            writer.write(content+"\n");  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	   
	
}

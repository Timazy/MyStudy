package com.timazy.learn.abtest.sdk;
/*
*	@author : Rick
*	@date : 2019年4月29日
*	
*/

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.timazy.learn.abtest.entity.Domain;
import com.timazy.learn.abtest.entity.Exp;
import com.timazy.learn.abtest.entity.Layer;
import com.timazy.learn.abtest.strategy.Strategy;
import sun.misc.BASE64Encoder;

public class AbTestSDK {

	public static Map<Long, Domain> domain_map;
	
	static{
		Domain domain = new Domain(1);
		//左面的 
		Domain domain_left = new Domain(2);
		Layer layer1 = new Layer(2,1,Strategy.HASH,"id");
		layer1.getExps().add(new Exp(1,1,0,40,211,"location=left"));
		//右面的
		Layer layer2 = new Layer(1,2,Strategy.HASH,"id");
		Layer layer3 = new Layer(1, 3, Strategy.TAG, "age");
		layer2.getExps().add(new Exp(2, 2, 40, 100, 122, "location=right"));
		layer3.getExps().add(new Exp(3, 3, 0, 30, 133, "money=0"));
		layer3.getExps().add(new Exp(4, 3, 30, 100, 143, "money=100"));
		
		domain.getHeads().add(layer2);
		domain.getHeads().add(layer1);
		domain.getLayers().put(3l,layer3);
		
		domain_map = new HashMap<>();
		domain_map.put(domain.getDomainId(), domain);
	}
	
	/**
	 * deal heads
	 * @param domainId
	 * @param strategy
	 * @param key
	 * @return
	 * Exp
	 *
	 */
	public static Exp selectExpByStrategyKey(long domainId,Strategy strategy,String key){
		
		long locate = generalLocation(strategy, key);
		
		Domain domain = domain_map.get(domainId);
		// flow dispart
		List<Layer> layers = domain.getHeads();
		for(Layer layer : layers){
			List<Exp> exps = layer.getExps();
			for(Exp exp : exps){
				if (exp.getFrom() <= locate && exp.getTo() > locate) {
					//bingo
					return exp;
				}
			}
		}
		return null;
		
		
	}
	
	public static Exp selectExpByLayer(long domainId,long layerId,Map<String, String> imap){
		
		Domain domain = domain_map.get(domainId);
		Map<Long,Layer> layers = domain.getLayers();
		Layer layer = layers.get(layerId);
		if (layer != null) {
			long locate = generalLocation(layer.getStrategy(), imap.get(layer.getKey()));
			if (locate == -1) {
				return null;
			}
			for(Exp exp : layer.getExps()){
				if (exp.getFrom() <= locate && exp.getTo() > locate) {
					//bingo
					return exp;
				}
			}
		}
		
		return null;
		
		
	}
	
	public static long generalLocation(Strategy strategy,String key){
		long locate = -1;
		switch (strategy) {
		case HASH:
			locate = key.hashCode() % 100;
			break;
		case TAG:
			locate = Long.parseLong(key) % 100;
			break;
		default:
			break;
		}
		return locate;
	}
	
	public static void main(String[] args) {
		int[] bingoMd5 = new int[1000];
		int[] bingoHash = new int[1000];
		int[] myHash = new int[1000];
		String string = "rick123435";
		
		
		for(int i=0;i<100000;i++){
			String md5 = encodeMD5(string + getEnoughStr(""+i));
			String hash = string + getEnoughStr(""+i);
			String myhash = string + getEnoughStr("" +i);
			int hashcodemd5 = md5.hashCode();
			int hashcode = hash.hashCode();
			int myhashcode = hash(myhash);
			if (myhashcode<0) {
				myhashcode *=-1;
			}
			if (hashcode<0) {
				hashcode *=-1;
			}
			if (hashcodemd5<0) {
				hashcodemd5 *=-1;
			}
			bingoMd5[hashcodemd5%1000]++;
			bingoHash[hashcode%1000]++;
			myHash[myhashcode%1000]++;
		}
		long md5count= 0;
		for(int i=0;i<1000;i++){
			md5count += Math.pow(bingoMd5[i] - 100, 2);
		}
		System.out.println("md5 方差："+md5count);
		
		long hashcount= 0;
		for(int i=0;i<1000;i++){
			hashcount += Math.pow(bingoHash[i] - 100, 2);
		}
		System.out.println("hash 方差："+hashcount);
		
		long myhashcount= 0;
		for(int i=0;i<1000;i++){
			myhashcount += Math.pow(myHash[i] - 100, 2);
		}
		System.out.println("myhash 方差："+myhashcount);
		
	}
	
	 public static  int hash(Object key) {
	        int h;
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }
	 
	
	public static String getEnoughStr(String i){
		int compensation = 5-i.length();
		if (compensation == 0) {
			return i;
		}else if (compensation == 1) {
			return 0+i;
		}else if (compensation == 2) {
			return "00"+i;
		}else if (compensation == 3) {
			return "000"+i;
		}else if (compensation == 4) {
			return "0000"+i;
		}
		return i;
	}
	

	public static String encodeMD5(String str) {
		if (str == null || str.equals("")) {
			throw new RuntimeException("can not encodeMD5 empty string");
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md5.digest(str.getBytes("utf-8"));
			BASE64Encoder base64Encoder = new BASE64Encoder();
			String encodeStr = base64Encoder.encode(md5Bytes);
			return encodeStr;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
}

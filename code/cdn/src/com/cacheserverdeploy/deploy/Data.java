package com.cacheserverdeploy.deploy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/*
 * 最小费用最大流所用数据及其他所用数据
 */
public class Data {
	     public static HashMap<Integer,Integer> ying=new HashMap<Integer,Integer> ();///消费映射
	//路径信息
           public static  HashMap<Integer,ArrayList <Integer>> lujing=new HashMap<Integer,ArrayList <Integer>>();
           public static int lujing_num=0;
      //     int fuwuqi_weizhi=MaxCountOfArray.getid(caculation.wangluo_arr(Solve.part_two_int, Solve.length_two));
}
/*
 * 找出数组中最多的数，该点放置服务器
 */
class MaxCountOfArray {  
	
	public static HashSet<Integer> num_max=new  HashSet<Integer> () ;
		public static int getid(int[] arr){
	    	 Map<Integer, Integer> map = new HashMap<Integer,Integer>();  
		        for (int i = 0; i < arr.length; i++) {  
		            if (map.containsKey(arr[i])&&!num_max.contains(arr[i])) {  //不能为-1
		                map.put(arr[i], map.get(arr[i]) + 1);  
		            } else {  
		                map.put(arr[i], 0);  
		            }  
		  
		        }  
	        int count=-1;  
	        int max=Integer.MIN_VALUE;  
	        Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();  
	        while (iter.hasNext()) {  
	            Map.Entry<Integer,Integer> entry =  iter.next();  
	            if (entry.getValue()>count||(entry.getValue()==count&&entry.getKey()>max)) {  
	                max=entry.getKey();  
	                count=entry.getValue();  
	            }  
	        }  
	      //  System.out.println("最多"+max);
	        //System.out.println(max);  
	        //下面是刷新数据
	         num_max.add(max);
	    	    return max;
	    } 
  
}  

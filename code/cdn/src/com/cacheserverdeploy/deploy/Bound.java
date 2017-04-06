package com.cacheserverdeploy.deploy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * 边界合并
 */
public class Bound {
	
	     /*
	      * 合并函数
	      */
         public static void hebing(){
        /*	fuwuqi_init();
        	 is_chonghe();
        	 is_beyond();*/
        	 MinCostMaxFlow.xjbs(MinCostMaxFlow.n-1,MinCostMaxFlow.n-2);
        	 //System.out.println("cece"+MinCostMaxFlow.lu());
        	//luansou();
            // hebing_2();//第二次合并 
           //  hebing_3();//第二次合并 
        	// System.out.println(lu());
         }
         
         /*
          * 服务器初始化
          */
         public static void fuwuqi_init(){
        	 int ttt=Solve.length_three;
        	     for(int i=0;i<ttt;i++){
        	    	     Quanju.Server_place.add(Solve.num_3[i][1]);
        	    	     Quanju.is_place[Integer.valueOf(Solve.num_3[i][1])]=1;
        	    	     Quanju.dai.put(Solve.num_3[i][1], Integer.valueOf(Solve.num_3[i][2]));
        	    	     Quanju.Rout[i][0]=String.valueOf(i);//初始化路径
        	    	    // System.out.println(Quanju.dai.get(Solve.num_3[i][1]));
        	     }
        	     for(int i=0;i<ttt;i++){
    	    	     Quanju.Rout[i][1]=String.valueOf(Solve.num_3[i][1]);//初始化路径
    	     }
         }
         
         /*
          * 判断是否有重合2
          */
         public static void is_chonghe2(){
        	 int tt=Solve.length_three;
        	 HashMap<String, Integer> ce=new HashMap<String, Integer>();
        	 for(int i=0;i<tt;i++){//哈系一下  
	    	         ce.put(Solve.num_3[i][1], i);
 	        }
        	    int now=0; 
        	    int next=0;
        	    
        	    for(String a:Quanju.Server_place){//遍历服务器
				   	    	   //  now=next;
		        	    	int num1=0;
		        	    	int num2=0;
		        	    	int biaozhun=(int) (Solve.length_three/1.3);//这里调整
		        	    	num1++;
		        	    	if(num1>biaozhun){
		        	    		num1=0;
		        	    		      break;
		        	    	}
		   	    	     now=Integer.valueOf(a);
              	         for(String b:Quanju.Server_place){
	              	        	 num2++;
	              	        	 if(num2>biaozhun){
	              	        		     num2=0;
	              	        		     break;
	              	        	 }
              	        	        next=Integer.valueOf(b);
              	        	        int sh=shu.get_daikuan()[now][next];
		              	        	if(sh>0){//相交
		              	        		    if(sh>Quanju.dai.get(String.valueOf(now))&&Quanju.is_place[now]!=0&&Quanju.is_place[next]!=0){
		              	        		    	Quanju.Rout[ ce.get(String.valueOf(now))][2]=String.valueOf(next);
		              	        		 //   	Quanju.Rout[ ce.get(String.valueOf(next))][2]=String.valueOf(now);//原来的
		              	        		    	Quanju.is_place[now]=0;
		              	        		    	Quanju.is_place[next]=0;
		              	        		    }
		              	        	}
              	        	}
                } 
   	     
        	     /*for(String a:Quanju.Server_place){//遍历服务器
        	    	     now=next;
        	    	     next=Integer.valueOf(a);
        	    	   //  System.out.println(now+","+next+" ");
        	    	     if(shu.get_daikuan()[now][next]>0){//相交
        	    	    	       if(shu.get_daikuan()[now][next]>(int) Quanju.dai.get(String.valueOf(now))){
        	    	    	    	       Quanju.is_place[next]=0;
        	    	    	    	   //    Quanju.Rout[(int) (ce.get(next))][1]=String.valueOf(now);
        	    	    	    	       Quanju.Rout[(int) ce.get(String.valueOf(next))][2]=String.valueOf(now);
        	    	    	       }
        	    	     }  	    	    
        	     }*/

         }
         
         /*
          * 判断是否有重合
          */
         public static void is_chonghe(){
        	 HashMap<String, Integer> ce=new HashMap<String, Integer>();
        	 for(int i=0;i<Solve.length_three;i++){//哈系一下  
	    	         ce.put(Solve.num_3[i][1], i);
 	        }
        	    int now=0;
        	    int next=0;
        	    
        	    for(String a:Quanju.Server_place){//遍历服务器
		   	    	   //  now=next;
		   	    	     now=Integer.valueOf(a);
              	         for(String b:Quanju.Server_place){
              	        	        next=Integer.valueOf(b);
		              	        	if(shu.get_daikuan()[now][next]>0){//相交
		              	        		    if(shu.get_daikuan()[now][next]>Quanju.dai.get(String.valueOf(now))&&Quanju.is_place[now]!=0&&Quanju.is_place[next]!=0){
		              	        		    	Quanju.Rout[ ce.get(String.valueOf(now))][2]=String.valueOf(next);
		              	        		 //   	Quanju.Rout[ ce.get(String.valueOf(next))][2]=String.valueOf(now);//原来的
		              	        		    	Quanju.is_place[now]=0;
		              	        		    	Quanju.is_place[next]=0;
		              	        		    }
		              	        	}
              	        	}
                } 
   	     
        	     /*for(String a:Quanju.Server_place){//遍历服务器
        	    	     now=next;
        	    	     next=Integer.valueOf(a);
        	    	   //  System.out.println(now+","+next+" ");
        	    	     if(shu.get_daikuan()[now][next]>0){//相交
        	    	    	       if(shu.get_daikuan()[now][next]>(int) Quanju.dai.get(String.valueOf(now))){
        	    	    	    	       Quanju.is_place[next]=0;
        	    	    	    	   //    Quanju.Rout[(int) (ce.get(next))][1]=String.valueOf(now);
        	    	    	    	       Quanju.Rout[(int) ce.get(String.valueOf(next))][2]=String.valueOf(now);
        	    	    	       }
        	    	     }  	    	    
        	     }*/

         } 
         
         
         /*
          * 判断是否超带宽
          */
         public static void is_beyond(){
        	 for(int i=0;i<Solve.length_three;i++){
	        		 if(Quanju.Rout[i][2]!=null){
	        			      int a1=Integer.valueOf(Quanju.Rout[i][2]);
	        			      int a2=Integer.valueOf(Quanju.Rout[i][1]);
	        			      if(shu.get_daikuan()[a1][a2]<Solve.part_three_int[i][2]){//超带宽
	        			    	  Quanju.Rout[i][2]=null;//System.out.println("超了");
	        			      }else{
	        			    	      
	        			      }
	        		 }
	         }
         }
         
         
         /*
          * 路径转为字符
          */
         public static String lu(){
        	 String zong="";
        	 String [] cc=new String [Solve.length_three];
        	 for(int i=0;i<Solve.length_three;i++){//chuashihua 
	    	          cc[i]=Solve.num_3[i][2];
	         }
        	 for(int i=0;i<Solve.length_three;i++){
	    	        for(int b=0;b<100;b++){
	    	        	    if(Quanju.Rout[i][b]!=null){
	    	        	    	    cc[i]=Quanju.Rout[i][b]+" "+cc[i];
	    	        	    }else{
	    	        	    	    break;
	    	        	    }
	    	        }
	         }
        	 zong=cc[0];
        	 for(int i=1;i<Solve.length_three;i++){//chuashihua 
   	                 zong+="\n"+cc[i];
             }
        	     return zong;
         }
         
         /*
          * 第二次合并
          */
         public static void hebing_2(){
        	 		rest();//去掉使用的网络，剩下的
        	 		 init_server_first();
        	 		is_public();
        	 		//xjbs();
        	 	    is_beyond_2();
        	 	 	jianzhi();
         }
         
         /*
          * 乱搜
          */
         public static void luansou(){
	        	 rest();//去掉使用的网络，剩下的
		 		 init_server_first();
		 	//	is_public();
		 		xjbs2();
		 	    is_beyond_2();
		 	 	jianzhi();
         }
         
         /*
          * 第二次求出剩下的网络
          */
         public static void rest(){
        	      for(int i=Solve.num_wangluo-1;i>=0;i--){//网络初始化
        	    	      Quanju.Net.add(String.valueOf(i));
        	      }
        	      Iterator<String> it= Quanju.Net.iterator();//设置迭代器
        	      String ceshi="";
        	      while(it.hasNext()){
        	    	      //System.out.println(it.next());
        	    	      ceshi=it.next();
        	    	      for(int b=0;b<Solve.length_three;b++){
        	    	    	  if(Solve.num_3[b][1].equals(ceshi)){//这些点使用过
	        	    	    		  it.remove();
        	    	    	  }
        	    	      }
        	      }
        	      //System.out.println(Quanju.Net);
     
         }
         
         /*
          * 初始化第一层使用的服务器Quanju.use
          */
         public static void init_server_first(){
        	 for(int i=0;i<Solve.length_three;i++){
	    	        for(int b=0;b<100;b++){
	    	        	    if(Quanju.Rout[i][b]!=null){
	    	        	    	    
	    	        	    }else{//碰到空值了
	    	        	    	   Quanju.use.add(Quanju.Rout[i][b-1]);
	    	        	    	    break;
	    	        	    }
	    	        }
	         }
        	// System.out.println(Quanju.use);
         }
         
         /*
          * 判断是否有公共点
          */
         public static void is_public(){
        	       Iterator<String> it=Quanju.use.iterator();//设置迭代器
        	       Iterator<String> it_net=Quanju.Net.iterator();//未使用的迭代器
        	       String ceshi_it="";
        	       String ceshi_net="";
        	       String zhi="";
        	    	 while(it_net.hasNext()){//遍历未使用的网络
        	    	    	  ceshi_net=it_net.next();
        	    	    	//  System.out.println("a");
        	    	    	  //System.out.println(ceshi_net);
        	    	    	  it=Quanju.use.iterator();//设置迭代器
        	    	    	  while(it.hasNext()){//遍历使用的网络
        	    	    		      ceshi_it=it.next();
        	    	    		      //System.out.println(ceshi_it);
        	    	    		     // System.out.println(ceshi_it+","+ceshi_net+":"+shu.get_daikuan()[Integer.valueOf(ceshi_it)][Integer.valueOf(ceshi_net)]);
        	    	    		      if(shu.get_daikuan()[Integer.valueOf(ceshi_it)][Integer.valueOf(ceshi_net)]>0&&Quanju.visited[Integer.valueOf(ceshi_it)]==0){//相交
        	    	    		    	      Quanju.lianjie.put(ceshi_it, ceshi_net);
        	    	    		    	      Quanju.visited[Integer.valueOf(ceshi_it)]=1;
        	    	    		    	     // zhi=ceshi_net;
        	    	    		    	  //System.out.println(ceshi_it+","+ceshi_net);
        	    	    		      }
        	    	    	  }
        	    	    	 // Quanju.lianjie.put(ceshi_it, zhi);
        	    	    	 
        	    	 }
        	    	 update_2();//第二次更新路径
//        	       System.out.println(Quanju.lianjie.get("37"));//测试
         }
         
         /*
          * xjbs算法。。。。。。
          */
         public static void xjbs(){
        	       HashMap<String,String> r=new HashMap<String,String>();//路径和服务器对应关系
        	       HashMap<String,String> r_n=new HashMap<String,String>();//路径和服务器反对应关系
		  	       Iterator<String> it=Quanju.use.iterator();//设置迭代器
		  	       Iterator<String> it_net=Quanju.Net.iterator();//未使用的迭代器
		  	       HashSet<String> wai=new HashSet<String> ();//最外层（也就是服务器）
		  	     for(int i=0;i<Solve.length_three;i++){//找到最外层
		    	        for(int b=0;b<100;b++){
		    	        	    if(Quanju.Rout[i][b]!=null){
		    	        	    	    
		    	        	    }else{//碰到空值了
		    	        	    	r.put(Quanju.Rout[i][b-1],String.valueOf(i));
		    	        	    	wai.add(Quanju.Rout[i][b-1]);
		    	        	    	//System.out.println();
		    	        	    	    break;
		    	        	    }
		    	        }
		         }
		  	   // System.out.println(r);
		  	     Iterator<String> it_wai=wai.iterator();//设置已放置的服务器的迭代器
		  	   String ceshi_it="";
	  	       String ceshi_net="";
	  	       String ceshi_wai="";
		  	     while(it_wai.hasNext()){//遍历服务器
		  	    	    ceshi_wai=it_wai.next();
		  	    	    int mincost=Integer.MAX_VALUE;//最小费用
		  	    	  it_net=Quanju.Net.iterator();//未使用的迭代器
		  	    	    while(it_net.hasNext()){//遍历未使用的网络
		  	    	    	    ceshi_net=it_net.next();
		  	    	    	   int xuyaodaikuan=Solve.part_three_int[Integer.valueOf(r.get(ceshi_wai))][2];
		  	    	    	  //  System.out.println(xuyaodaikuan);
		  	    	    	   int feiyong=shu.daikuandanjia()[Integer.valueOf(ceshi_wai)][Integer.valueOf(ceshi_net)];
		  	    	    	   //使用的费用
		  	    	    	    if(shu.get_daikuan()[Integer.valueOf(ceshi_wai)][Integer.valueOf(ceshi_net)]>xuyaodaikuan&&feiyong<mincost){
		  	    	    	    	    //条件：相交，带宽不超标,费用最小
		  	    	    	    	       mincost=feiyong;
		  	    	    	    	     Quanju.lianjie.put(ceshi_wai,ceshi_net);
		  	    	    	    	    
		  	    	    	    }
		  	    	    }
		  	     }
		  	       
		  	    	 update_2();//第二次更新路径
        	      
         }
         
         /*
          * xjbs算法2
          */
         public static void xjbs2(){
                   
         }
         /*
          * 第二次更新路径
          */
         public static void update_2(){
        	 for(int i=0;i<Solve.length_three;i++){
	    	        for(int b=0;b<100;b++){
	    	        	    if(Quanju.Rout[i][b]!=null){
	    	        	    	    
	    	        	    }else{//碰到空值了
	    	        	    	Quanju.Rout[i][b]=Quanju.lianjie.get(Quanju.Rout[i][b-1]);
	    	        	    	//System.out.println();
	    	        	    	    break;
	    	        	    }
	    	        }
	         }
         }
         
         /*
          * 第二次判断带宽
          */
         public static void is_beyond_2(){
        	 for(int i=0;i<Solve.length_three;i++){
	        		 for(int b=0;b<100;b++){
	 	        	    if(Quanju.Rout[i][b]!=null){
	 	        	    	    
	 	        	    }else{//碰到空值了
	 	        	    	    int a1=Integer.valueOf(Quanju.Rout[i][b-1]);
	        			        int a2=Integer.valueOf(Quanju.Rout[i][b-2]);
	        			        Quanju.daikuan_use[a1][a2]+=Solve.part_three_int[i][2];//记得初始化
	 	        	    	   // if(shu.get_daikuan()[a1][a2]<Solve.part_three_int[i][2]&&b>=3){//原来的
	        			        if(shu.get_daikuan()[a1][a2]<Quanju.daikuan_use[a1][a2]&&b>=3){
	 	        	    	    	    //    System.out.println(i+":"+a1+">"+a2+"抄了");
	 	        	    	    	        Quanju.Rout[i][b-1]=null;
	 	        	    	    }
	 	        	    	    break;
	 	        	    }
	 	            }
	        		/* if(Quanju.Rout[i][2]!=null){
	        			      int a1=Integer.valueOf(Quanju.Rout[i][2]);
	        			      int a2=Integer.valueOf(Quanju.Rout[i][1]);
	        			      if(shu.get_daikuan()[a1][a2]<Solve.part_three_int[i][2]){//超带宽
	        			    	  Quanju.Rout[i][2]=null;//System.out.println("超了");
	        			      }else{
	        			    	      
	        			      }
	        		 }*/
	         }
         }
         
         /*
          * 剪枝
          */
         public static void jianzhi(){
	        	 for(int i=0;i<Solve.num_wangluo;i++){
	        		     Quanju.num[i]=0;
	        	 }
	        	 for(int i=0;i<Solve.length_three;i++){//剪枝所用hashset初始化
		    	        for(int b=0;b<100;b++){
		    	        	    if(Quanju.Rout[i][b]!=null){
		    	        	    	    
		    	        	    }else{//碰到空值了
		    	        	    	    Quanju.num[Integer.valueOf(Quanju.Rout[i][b-1])]+=1;
		    	        	    	    break;
		    	        	    }
		    	        }
		         }
        	   //System.out.println(Quanju.jianzhi_use);
	        	 for(int i=0;i<Solve.length_three;i++){
		        		 for(int b=0;b<100;b++){
		    	        	    if(Quanju.Rout[i][b]!=null){
		    	        	    	    
		    	        	    }else{//碰到空值了
		    	        	    	    if(Quanju.num[Integer.valueOf(Quanju.Rout[i][b-1])]<=1&&b>=3){//只有一个外点
		    	        	    	    	    //System.out.println();
		    	        	    	    	    Quanju.Rout[i][b-1]=null;
		    	        	    	    }
		    	        	    	    break;
		    	        	    }
		    	         }
	        	 }
         }
         
         /*
          * 第三次合并
          */
         public static void hebing_3(){
	        	 real_init();
	        	 shengyu();
	        	  is_public();
	        	  is_beyond_2();
	        	  jianzhi();
         }
         
         /*
          * 初始化
          */
         public static void real_init(){
        	     for(int i=0;i<Solve.num_wangluo;i++){
        	    	     Quanju.visited[i]=0;
        	    	     for(int b=0;b<Solve.num_wangluo;b++){
        	    	    	     Quanju.daikuan_use[i][b]=0;
        	    	    	     Quanju.daikuan_use[b][i]=0;
        	    	     }
        	     }
        	     
         }
         /*
          * 求剩余的数,使用过的放在Quanju.it_use里,剩余的放在Quanju.Net
          */
         public static void shengyu(){
        	
        	 String ceshi="";
        	     Iterator<String> it_use=Quanju.use.iterator();//使用的节点迭代器
        	     while(it_use.hasNext()){
        	    	 ceshi=it_use.next();
        	    	     it_use.remove();//初始化，使干净
        	    	 //System.out.println("Start");
        	     }
        	     for(int i=0;i<Solve.length_three;i++){
	        	    	 for(int b=0;b<100;b++){
			    	        	    if(Quanju.Rout[i][b]!=null){
			    	        	    	        Quanju.use.add(Quanju.Rout[i][b]);
			    	        	    }else{//碰到空值了
			    	        	    	    break;
			    	        	    }
		    	         }
        	     }
        	    // System.out.println(Quanju.use);
        	     
        	    
        	         Iterator<String>it_net=Quanju.Net.iterator();//所有的网络的迭代器
        	         String ceshi2="";
        	         while(it_net.hasNext()){
        	            	 ceshi2=it_net.next();
        	            	 it_net.remove();
        	         }
	        	    for(int i=0;i<Solve.num_wangluo;i++){
	    	    	        Quanju.Net.add(String.valueOf(i));
	    	        } 
       	         it_net=Quanju.Net.iterator();
       	         while(it_net.hasNext()){
       	        	   ceshi2=it_net.next();
       	        	    it_use=Quanju.use.iterator();//使用的节点迭代器
       	        	    while(it_use.hasNext()){
       	        	    	    ceshi=it_use.next();
       	        	    	    if(ceshi.equals(ceshi2)){//表示已经使用了
       	        	    	    	    it_net.remove();
       	        	    	    }
       	        	    }
       	         }
       	         //[19, 35, 17, 36, 18, 33, 16, 39, 14, 11, 12, 21, 20, 42, 41, 40, 49, 48, 45, 47, 46, 23, 24, 25, 26, 27, 28, 29, 10, 30, 32, 31, 9]
       	     //   System.out.println(Quanju.Net);
         }
         
}

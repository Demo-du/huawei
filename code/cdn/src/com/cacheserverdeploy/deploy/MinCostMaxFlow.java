package com.cacheserverdeploy.deploy;


import java.util.ArrayList;
/*算法竞赛入门经典 最小费用最大流问题  
 * */  
import java.util.Arrays;  
import java.util.LinkedList;  
import java.util.Scanner;  
  
public class MinCostMaxFlow {  
	    public static final int MAX = 1<<30;  
	    public static  ArrayList<Integer> jilu_1=new ArrayList<Integer>();//记录路径
	    public static ArrayList<Integer> jilu_2=new ArrayList<Integer>();//记录路径
	    public static int n=Solve.num_wangluo+2;//节点个数  +超级源超级汇
	    public static int m=Solve.length_two*2+Solve.length_three+Solve.length_three/2;//路径数  //要改
	    public static int[][] cap = new int[n][n];//边的容量  //少了1
	    public static int[][] cost = new int[n][n];//边的费用 
	    public static int[][] flow = new int[m][m];//实际流量  
	    public static int[][] flow_n = new int[m][m];//实际流量  
	    public static int  f = 0, c = 0;
	    public static int[] a = new int[n+1];//a[i]节点i路径上的最小费用  
	    public static  int[] p = new int[n+1];//记录增广路上节点的父亲  
	    public static LinkedList<Integer> q = new LinkedList<Integer>();  
	    public static String ceshi="";
	    public static int liuliang=0;
	    public static int[] rl=new int [50000];//最后的流量
	    public static void xjbs(int s,int t){//xjbs最小费用最大流。。。
	    	      init_shuzu();
	    	      server_place();
	  	        for(; ;) {  
			            Arrays.fill(a, MAX);  
			            a[s] = 0;  //a[i]节点i路径上的最小费用  
			            q.offer(s); 
			            while(q.size() > 0) {//使用BFS找s-t最短路   
			                int u = q.poll();  //移除表头的第一个元素
			                for(int v=0; v<n; v++) { //可能从0开始 ,遍历节点
			                    if(cap[u][v] > flow[u][v] && a[v] > a[u] + cost[u][v]) {//找到新节点  
			                        p[v] = u;//记录v的父亲  
			                        q.offer(v);//v入队  
			                        a[v] = a[u] + cost[u][v];//更新费用值  
			                        jilu_1.add(u);
			                        jilu_1.add(v);
			                        // System.out.print(u+">"+v+" ");         
			                    }  
			                }  
			                if(jilu_1.size()!=0){
				            //    System.out.println(jilu_1.get(0));
				                jilu_2.add(jilu_1.get(0));
			                }
			               // System.out.print(jilu_1);
			                
			              // jilu_2.add(jilu_1.get(0));
			             //   jilu_1.clear();
			            }  
		            
			            if(a[t] == MAX) break;//汇点不可达表明 当前流已经是最小费用最大流  
			          //  System.out.println("=====");
			            int d = MAX;  
			            for(int u = t; u!=s; u=p[u]) {//从汇点逆向计算可改进量  
			                d = Math.min(d, cap[p[u]][u] - flow[p[u]][u]);  
			            }  
			            for(int u = t; u!=s; u=p[u]) {  
			                flow[p[u]][u] += d;//更新正向流量  
			              //  flow[u][p[u]] -= d;//更新逆向流量  
			            }  
		            c += d*a[t];//更新总费用  
		            f += d;//更新从s流出的总流量
		           // System.out.println(jilu_2);
		      //      System.out.println(zhuanhuan(jilu_1,n-1,n-2));
		            if(ceshi.equals(zhuanhuan(jilu_1,n-1,n-2))){//两行相同
		            	     rl[Data.lujing_num-1]+=d;
		            }else{//不相同，正常
		            	      Data.lujing.put(Data.lujing_num, zhuanhuan(jilu_1,n-1,n-2));
		            	      rl[Data.lujing_num]=d;
		            	      Data.lujing_num++;
		            }
		        //    System.out.println((jilu_1));
		            liuliang=flow[zhuanhuan(jilu_1,n-1,n-2).get(1)][zhuanhuan(jilu_1,n-1,n-2).get(0)]-  flow_n[zhuanhuan(jilu_1,n-1,n-2).get(1)][zhuanhuan(jilu_1,n-1,n-2).get(0)];
		            flow_n[jilu_1.get(1)][jilu_1.get(0)]=flow[jilu_1.get(1)][jilu_1.get(0)];
		        //    System.out.println("流量："+d);
		            ceshi=zhuanhuan(jilu_1,n-1,n-2).toString();//转化为字符串
		            jilu_2.clear();
		            jilu_1.clear();
		        }  
	  	      //System.out.println(flow[2][4]);
	  	        System.out.println(cap[38][50]);
	  	      System.out.println("流费用"+c);
		        System.out.println("the maxmum flow is " + f + " and the minmum cost is " + (c+Solve.length_three/2.5*100));  
	/*	        for(int i=0;i<Data.lujing_num;i++){
		        	    // System.out.println("修改："+i+Data.lujing.get(i));
		        	 //    System.out.println("修改流量："+rl[i]);
		        }*/
		      //  System.out.print("最后"+lu());
	    }
	    public static void init_shuzu(){//初始化数组
	    	     for(int i=0;i<n-2;i++){
		    	    	  for(int b=0;b<n-2;b++){
		    	    		     cap[i][b]=shu.get_daikuan_min()[i][b];
		    	    		     cost[i][b]=shu.daikuandanjia()[i][b];
		    	    	  }
	    	      }
	    	     for(int i=0;i<Solve.length_three;i++){//超级汇 
	    	    	        cap[Solve.part_three_int[i][1]][n-2]=Solve.part_three_int[i][2];
	    	    	        cost[Solve.part_three_int[i][1]][n-2]=0;
	    	      }
	    }
	    public static void server_place(){
			    	Bound.fuwuqi_init();
			    	Bound.is_chonghe();
			    	Bound.is_beyond();
			    	Bound.rest();//去掉使用的网络，剩下的
			    	Bound.init_server_first();
	    	   int jishu1=(int) (Solve.length_three/2.5);
	   // 	  for(int i=0;i<jishu1;i++)
	    	  {
	    		//   int fuwuqi_weizhi=MaxCountOfArray.getid(caculation.wangluo_arr(Solve.part_two_int, Solve.length_two));
	    		//   cap[n-1][fuwuqi_weizhi]=Integer.MAX_VALUE;
	   	       //    cost[n-1][fuwuqi_weizhi]=0;
	    	   }
	    	//  cap[n-1][fuwuqi_weizhi]=Integer.MAX_VALUE;
  	        //  cost[n-1][fuwuqi_weizhi]=0;
	    /*	  for(int i=0;i<Solve.length_three/1.5;i++){//超级源
		    	        cap[n-1][i]=Integer.MAX_VALUE;
		    	        cost[n-1][i]=0;
	            }*/
	    	   int num11=0;
	    	   for(String aa:Quanju.use){
	    		   cap[n-1][Integer.valueOf(aa)]=Integer.MAX_VALUE;
	    		   cost[n-1][Integer.valueOf(aa)]=0;
	    		 //  System.out.println("hhh"+Integer.valueOf(aa));
	    	   }
	    	//   System.out.println(Quanju.use);
  	  /*      for(int i=0;i<Solve.length_three;i=i+3){
	  	        	cap[n-1][Solve.part_three_int[i][1]]=Integer.MAX_VALUE;
	    	        cost[n-1][Solve.part_three_int[i][1]]=0;
  	        }*/
	    }
	    public static ArrayList<Integer> zhuanhuan(ArrayList<Integer> ji,int kaishi,int jieshu){
		    	ArrayList<Integer>result=new ArrayList<Integer>();
		    	int temp=jieshu;
		    	int length=ji.size();
		    	
		    	for(int i=length-1;i>=0;i--){
		            /* if(ji.get(i)==kaishi){
		            	 
		            	 result.add(ji.get(i));
		            	 break;
		             }*/
			            if(ji.get(i)==temp&&i%2!=0){
			            	 result.add(temp);
			            	 //if(result.get(result.size()-1)!=ji.get(i-1))
			            	 //result.add(ji.get(i-1));
			            	 temp=ji.get(i-1);
			             }
			            if(temp==kaishi){
			           	 
			           	 result.add(temp);
			           	 break;
			            }
		    	}
				return result;
		}
	    
	    /*
	     * 返回最终信息
	     */
	    public static String lu(){
	    	 yingshe();//映射消费
	    	 String [] ccc=new String[Data.lujing_num];
	    	  String cc="";
	    	  int lujingchangdu=Data.lujing_num;
	    	  for(int i=0;i<lujingchangdu;i++){
	    		        ccc[i]=String.valueOf(Data.ying.get(Data.lujing.get(i).get(1)))+" "+String.valueOf(rl[i]);
	    	  }
	    	   for(int i=0;i<lujingchangdu;i++){//遍历每条路径
	    		       int b=Data.lujing.get(i).size();//该路径长度
	    		     //  System.out.println("dd"+Data.lujing.get(0).size());
	    		       for(int c=1;c<=b-2;c++){
	    		    	  //    cc=String.valueOf(Data.lujing.get(i).get(c))+" "+cc;;
	    		    	     ccc[i]=String.valueOf(Data.lujing.get(i).get(c))+" "+ccc[i];
	    		       }
	    		      // cc=cc+"节点 "+String.valueOf(Data.ying.get(Data.lujing.get(i).get(1)));//改;
	    		   //    cc=cc+String.valueOf(rl[i]);//流量
	    		       
	    		       //cc="\n"+cc;
	    	   }
	    	   for(int i=0;i<lujingchangdu-1;i++){
	    		       cc=cc+ccc[i]+"\n";
	    	   }
	    	   cc=cc+ccc[lujingchangdu-1];
		     	return cc; 	       
	    }
	    public static void yingshe(){//映射消费
	    	       for(int i=0;i<Solve.length_three;i++){
	    	    	         Data.ying.put(Solve.part_three_int[i][1], Solve.part_three_int[i][0]);
	    	       }
	    }
	/*    public static void main(String[] args) {  
	        Scanner scanner = new Scanner(System.in); 
	        ArrayList<Integer> jilu_1=new ArrayList<Integer>();//记录路径
	        ArrayList<Integer> jilu_2=new ArrayList<Integer>();//记录路径
	        int n = scanner.nextInt();//节点个数  
	        int m = scanner.nextInt();//路径数  
	        int s = scanner.nextInt();//起点  
	        int t = scanner.nextInt();//终点  
	        int[][] cap = new int[n+1][n+1];//边的容量  
	        int[][] cost = new int[n+1][n+1];//边的费用  
	        for(int i=0; i<m; i++) {  
	            int u = scanner.nextInt();  
	            int v = scanner.nextInt();  
	            cap[u][v] = scanner.nextInt(); //带宽限制 
	            cost[u][v] = scanner.nextInt();  
	        }  
	        int[][] flow = new int[m][m];//实际流量  
	        int f = 0, c = 0;;  
	        int[] a = new int[n+1];//a[i]节点i路径上的最小费用  
	        int[] p = new int[n+1];//记录增广路上节点的父亲  
	        LinkedList<Integer> q = new LinkedList<Integer>();  
	        for(; ;) {  
	            Arrays.fill(a, MAX);  
	            a[s] = 0;  //a[i]节点i路径上的最小费用  
	            q.offer(s); 
	            while(q.size() > 0) {//使用BFS找s-t最短路   
	                int u = q.poll();  //移除表头的第一个元素
	                for(int v=1; v<=n; v++) { //可能从0开始 ,遍历节点
	                    if(cap[u][v] > flow[u][v] && a[v] > a[u] + cost[u][v]) {//找到新节点  
	                        p[v] = u;//记录v的父亲  
	                        q.offer(v);//v入队  
	                        a[v] = a[u] + cost[u][v];//更新费用值  
	                        jilu_1.add(u);
	                        // System.out.print(u+">"+v+" ");         
	                    }  
	                }  
	                if(jilu_1.size()!=0){
		            //    System.out.println(jilu_1.get(0));
		                jilu_2.add(jilu_1.get(0));
	                }
	               // System.out.print(jilu_1);
	                
	              // jilu_2.add(jilu_1.get(0));
	                jilu_1.clear();
	            }  
	            
	            if(a[t] == MAX) break;//汇点不可达表明 当前流已经是最小费用最大流  
	          //  System.out.println("=====");
	            int d = MAX;  
	            for(int u = t; u!=s; u=p[u]) {//从汇点逆向计算可改进量  
	                d = Math.min(d, cap[p[u]][u] - flow[p[u]][u]);  
	            }  
	            for(int u = t; u!=s; u=p[u]) {  
	                flow[p[u]][u] += d;//更新正向流量  
	              //  flow[u][p[u]] -= d;//更新逆向流量  
	            }  
	            c += d*a[t];//更新总费用  
	            f += d;//更新从s流出的总流量
	            System.out.println(jilu_2);
	            jilu_2.clear();
	        }  
	        System.out.println(flow[2][4]);
	        System.out.println("the maxmum flow is " + f + " and the minmum cost is " + c);  
	    }  */
}  

/*
4
10
1
4
1 2 2 2
2 1 2 2
1 3 1 5
3 1 1 5
2 3 1 2
3 2 1 2
2 4 1 3
4 2 1 3
3 4 1 1
4 3 1 1
 */
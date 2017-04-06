package com.cacheserverdeploy.deploy;

import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Map.Entry;  

public class Zuicha
{
	public static int wangluoshu;
	public static int money_sum=0;//总费用
	public static int [] fuwuqi_place;//服务器位置
	public static String [] args = new String[2];
	public static String[] graphContent; //文件内容
    /**
     * 你需要完成的入口
     * <功能详细描述>
     * @param graphContent 用例信息文件
     * @return [参数说明] 输出结果信息
     * @see [类、类#方法、类#成员]
     */
	
	public static int get_numwangluo(String[] graphContent1){
		  /**do your work here**/
    	graphContent=graphContent1;//文件内容赋值
    	Solve.chuli_first();
    	Solve.chuli_second();
    	Solve.chuli_third();
		    return Solve.num_wangluo;
	}
    public static String[] deployServer(String[] graphContent1)
    {
        /**do your work here**/
    	graphContent=graphContent1;//文件内容赋值
    	Solve.chuli_first();
    	Solve.chuli_second();
    	Solve.chuli_third();
    	fuwuqi_place=new int [Solve.num_wangluo] ;//每个网络节点是否放服务器
    	//fuwuqi_weizhi第一个服务器位置
    
    	/*
    	 * 测试，放在最外
    	 */
    	
    	String wangluohujing=Integer.toString(Solve.length_three);//网络路径数量
    	String []jiedianshunxu=new String [Solve.length_three];//节点顺序定义
    	String zongde="";
    	for(int i=0;i<Solve.length_three;i++){
    		jiedianshunxu[i]=Solve.num_3[i][1]+" ";//Integer.toString(Solve.part_three_int[1][i])+" ";
    	}
    	String [] zong=new String[Solve.length_three];
    	
    	for(int a=0;a<Solve.length_three;a++){
    		zong[a]="";
    		zong[a]=zong[a]+jiedianshunxu[a]+Solve.num_3[a][0]+" "+Solve.num_3[a][2];
    	}
    	
    	for(int a=0;a<Solve.length_three-1;a++){
    		zongde=zongde+zong[a]+"\n";
    	}
    	
    /*	for(int a=0;a<Solve.length_three-1;a++){
    		zongde=zongde+zong[a]+"\n";
    	}*/
    	money_sum=Integer.parseInt(wangluohujing)*Solve.money_fuwuqi;//第一阶段总费用
    	zongde=zongde+zong[Solve.length_three-1];//这里就是放在最外的策略，一般不会是最佳
    			////以上求出最差的方案，作为对比
    	//System.out.println(shu.get_daikuan()[0][5]);
    	//System.out.print(shu.daikuandanjia()[0][5]);
    //	System.out.print(money_sum);
    	//System.out.println(shu.get_zuiduan_in());
    	//caculation.route();
    //	Bound.hebing();
    	if(Solve.num_wangluo>400){
    		return new String[]{wangluohujing,"\r",Bound.lu()};
    	}
    	else
    	return new String[]{String.valueOf(Data.lujing_num),"\r",MinCostMaxFlow.lu()};
    }//main函数结尾
    public static String[] init(String[] graphContent1)
    {
        /**do your work here**/
    	graphContent=graphContent1;//文件内容赋值
    	Solve.chuli_first();
    	Solve.chuli_second();
    	Solve.chuli_third();
    	fuwuqi_place=new int [Solve.num_wangluo] ;//每个网络节点是否放服务器
    	//fuwuqi_weizhi第一个服务器位置
    
    	/*
    	 * 测试，放在最外
    	 */
    	
    	String wangluohujing=Integer.toString(Solve.length_three);//网络路径数量
    	String []jiedianshunxu=new String [Solve.length_three];//节点顺序定义
    	String zongde="";
    	for(int i=0;i<Solve.length_three;i++){
    		jiedianshunxu[i]=Solve.num_3[i][1]+" ";//Integer.toString(Solve.part_three_int[1][i])+" ";
    	}
    	String [] zong=new String[Solve.length_three];
    	
    	for(int a=0;a<Solve.length_three;a++){
    		zong[a]="";
    		zong[a]=zong[a]+jiedianshunxu[a]+Solve.num_3[a][0]+" "+Solve.num_3[a][2];
    	}
    	
    	for(int a=0;a<Solve.length_three-1;a++){
    		zongde=zongde+zong[a]+"\n";
    	}
    	
    /*	for(int a=0;a<Solve.length_three-1;a++){
    		zongde=zongde+zong[a]+"\n";
    	}*/
    	money_sum=Integer.parseInt(wangluohujing)*Solve.money_fuwuqi;//第一阶段总费用
    	zongde=zongde+zong[Solve.length_three-1];//这里就是放在最外的策略，一般不会是最佳
    			////以上求出最差的方案，作为对比
    	//System.out.println(shu.get_daikuan()[0][5]);
    	//System.out.print(shu.daikuandanjia()[0][5]);
    //	System.out.print(money_sum);
    	//System.out.println(shu.get_zuiduan_in());
    	//caculation.route();
    //	Bound.hebing();

    	return new String[]{wangluohujing,"\r",zongde};
    }//main函数结尾
    
}//第一个类结尾}


/*
 * 文件处理类Solve
 */
class Solve {
	//public static String [] args = new String[3];
	//public static String[] graphContent; //文件内容
	public static int num_line;//=graphContent.length;//数据行数
	public static   String [] num_1;//=graphContent[0].split(" ");//第一行分割
	public static   String [][] num_2;//=new String[1000][1000];;//第二部分分割
	public static   String [][] num_3;//=new String[1000][1000];;//第二部分分割
	public static  int num_wangluo ;//= Integer.parseInt(num_1[0]);//网络节点个数
	public static  int num_lianlu;//=Integer.parseInt(num_1[1]);//链路条数
	public static  int num_xiaofei;//=Integer.parseInt(num_1[2]);//消费节点个数
	public  static  int money_fuwuqi;//=Integer.parseInt(graphContent[2]);//服务器成本
	public static  int [] Id_kong=new int [3];;//=null;空格ID
	public static  int kong_zeng=0;//空格ID递增用
	public static   String [] part_two;//=new  String [1000];//第二部分内容
	public static   String [] part_three;;//=new  String [1000];//第三部分内容
	
	public static  int [] []part_two_int;//=new int [];第二部分内容整数矩阵1:链路起始节点
	//2：链路终止节点 3：总带宽    4：单位网络租用费用
	public static  int [] []part_three_int;//=new int [];第三部分内容整数矩阵1:消费节点
	//2:相连网络节点ID 3：视频带宽消耗需求
	
	public static  int part_two_id=0;//第二部分打标号
	public static  int part_three_id=0;//第三部分打标号
	public static  int length_two=0;//第二部分长度
	public static  int length_three=0;//第三部分长度
	
	/*public  static String  get_graphFilePath(){//获取文件内容
		return "/home/codecraft/workspace/huawei/case0.txt";//文件路径
	}*/

	//处理第一部分
	public static void chuli_first(){
	//	Deploy.graphContent = FileUtil.read( get_graphFilePath(), null);
		num_line=Zuicha.graphContent.length;//数据行数
	//	String [] num_1=graphContent[0].split(" ");//第一行分割
	//	num_1=new String[6];
		 num_1=Zuicha.graphContent[0].split(" ");//第一行分割
		num_wangluo = Integer.parseInt(num_1[0]);//网络节点个数
		num_lianlu=Integer.parseInt(num_1[1]);//链路条数
		num_xiaofei=Integer.parseInt(num_1[2]);//消费节点个数
		money_fuwuqi=Integer.parseInt(Zuicha.graphContent[2]);//服务器成本
		kong_zeng=0;//空格ID递增用
		//找出空格所在点
		   for(int i=0;i<num_line;i++){
			   if(Zuicha.graphContent[i].length()<=0){
				   Id_kong[kong_zeng]=i;
				   kong_zeng++;
			   }
		   }
	}
	
	//处理第二部分
	public static void chuli_second(){
		   part_two_id=0;
		   length_two=Id_kong[2]-Id_kong[1]-1;
		   part_two=new String[length_two];
			for(int i=Id_kong[1]+1;i<Id_kong[2];i++){
				   part_two[part_two_id]=Zuicha.graphContent[i];//将截取的值赋给part_two
				   part_two_id++;
		      }
			num_2=new String[length_two][4];
			for(int a=0;a<length_two;a++){//将第二部分分割放在字符串矩阵num_2中
				  for(int x=0;x<4;x++){
					  num_2[a]= part_two[a].split(" ");
					  //System.out.print(num_2[a][x]);
				  }
				  //System.out.print("\n");
			}
			part_two_int=new int [length_two][4];
			for(int a=0;a<length_two;a++){//将第二部分分割放在整数矩阵num_two中
				  for(int x=0;x<4;x++){
					  part_two_int[a][x]=Integer.parseInt(num_2[a][x]);
				  }
			}
			
	}
	
	//处理第三部分
	public static void chuli_third(){
		  length_three=num_line-Id_kong[2]-1;//第三部分长度
		  part_three=new String[length_three];
		  part_three_id=0;
		  for(int i=Id_kong[2]+1;i<num_line;i++){
			   part_three[part_three_id]=Zuicha.graphContent[i];//将截取的值赋给part_three
			   //System.out.println(part_three[part_three_id]);
		       part_three_id++;
		  }
		  
		 num_3=new String[length_three][3];

		  for(int b=0;b<length_three;b++)  {//将第三部分分割放在字符串矩阵num_3中
			  for(int x=0;x<3;x++){
				  num_3[b]=part_three[b].split(" ");
				//  System.out.print(num_3[b][x]);
			  }
			//  System.out.print("\n");
		}
		   part_three_int=new int [length_three][3];
			for(int a=0;a<length_three;a++){//将第二部分分割放在整数矩阵num_three_int中
				  for(int x=0;x<3;x++){
					  part_three_int[a][x]=Integer.parseInt(num_3[a][x]);
					//  System.out.print(num_3[a][x]);
				  }
				//  System.out.print("\n");
			}
	}
	
}


/*
 * 算法类
 */
class caculation{
	
	    /*
	     * 
	     * */
	     public static int [] wangluo_arr(int [][] ceshi,int length){
	    	    int [] shuzu=new int [length*2];
	    	    int jishu=0;
	    	    for(int i=0;i<length;i++){
	    	    	   shuzu[jishu]=ceshi[i][0];
	    	    	   jishu++;
	    	    	   shuzu[jishu]=ceshi[i][1];
	    	    	   jishu++;
	    	    }
	    	     return shuzu;
	     }

	     /*
	      * 看看结果有没有点简化
	      */
	    /* void chachong(){
	    	     for(int i=0;i<Solve.length_three;i++){
	    	    	     for(int b=i+1;b<Solve.length_three;b++){
	    	    	    	     if(shu.get_daikuan()[Solve.part_three_int[i][1]][Solve.part_three_int[b][1]]!=-1&&Solve.part_three_int[b][2]<shu.get_daikuan()[Solve.part_three_int[i][1]][Solve.part_three_int[b][1]]){//联通
	    	    	    	    	     djj+=
	    	    	    	     }
	    	    	     }
	    	     }
	     }*/
}

/*
*数据类
*/
class shu{
	      public static  boolean time_flag=false;
	     // public static int[] daikuan;
	public static String djj="";
	      public static String zuiduanzong="";//最短路径求总的
	      public static int [][] get_daikuan_min(){
    	      int [][] daikuan=new int [Solve.num_wangluo][Solve.num_wangluo];//带宽矩阵打大小
    	      for(int i=0;i<Solve.length_two;i++){
    	    	  //这里数组矩阵构造比较麻烦，看看题目里例子就明白类
    	    	  daikuan[Solve.part_two_int[i][0]][Solve.part_two_int[i][1]]=Solve.part_two_int[i][2];
    	    	  daikuan[Solve.part_two_int[i][1]][Solve.part_two_int[i][0]]=Solve.part_two_int[i][2];
    	      }
    	      return daikuan;
      }
	       //public static int fuwuqi_weizhi=MaxCountOfArray.getid(caculation.wangluo_arr(Solve.part_two_int, Solve.length_two));
	      public static int [][] get_daikuan(){
	    	      int [][] daikuan=new int [Solve.num_wangluo][Solve.num_wangluo];//带宽矩阵打大小
	    	      for(int i=0;i<Solve.num_wangluo;i++){
	    	    	  for(int a=0;a<Solve.num_wangluo;a++){
	    	    		  daikuan[i][a]=-1;//初始化，-1表示不联通
	    	    	  }
	    	      }
	    	      for(int i=0;i<Solve.num_wangluo;i++){
	    	    	  daikuan[i][i]=0;
	    	      }
	    	      for(int i=0;i<Solve.length_two;i++){
	    	    	  //这里数组矩阵构造比较麻烦，看看题目里例子就明白类
	    	    	  daikuan[Solve.part_two_int[i][0]][Solve.part_two_int[i][1]]=Solve.part_two_int[i][2];
	    	    	  daikuan[Solve.part_two_int[i][1]][Solve.part_two_int[i][0]]=Solve.part_two_int[i][2];
	    	      }
	    	      return daikuan;
	      }
	      public static int [][] get_daikuan_n(){//带宽积累
    	      int [][] daikuan=new int [Solve.num_wangluo][Solve.num_wangluo];//带宽矩阵打大小
    	      for(int i=0;i<Solve.num_wangluo;i++){
    	    	  for(int a=0;a<Solve.num_wangluo;a++){
    	    		  daikuan[i][a]=0;
    	    	  }
    	      }
    	      return daikuan;
          }
	      public static int[][] daikuandanjia(){
	    	  int [][] daikuandanjia=new int [Solve.num_wangluo][Solve.num_wangluo];//带宽单价矩阵打大小
	    	  for(int i=0;i<Solve.num_wangluo;i++){
    	    	  for(int a=0;a<Solve.num_wangluo;a++){
    	    		  daikuandanjia[i][0]=0;//初始化，-1表示不联通
    	    	  }
    	      }
    	      for(int i=0;i<Solve.num_wangluo;i++){
    	    	  daikuandanjia[i][i]=0;
    	      }
	    	  for(int i=0;i<Solve.length_two;i++){
    	    	  //这里数组矩阵构造比较麻烦，看看题目里例子就明白类
	    		  daikuandanjia[Solve.part_two_int[i][0]][Solve.part_two_int[i][1]]=Solve.part_two_int[i][3];
	    		  daikuandanjia[Solve.part_two_int[i][1]][Solve.part_two_int[i][0]]=Solve.part_two_int[i][3];
    	      }
	    	  return daikuandanjia;
	      }
          public static String get_zuiduan_in(){//求矩阵格式最短路径
        	      String a="";
        	      for(int i=0;i<Solve.length_two;i++){
        	    	     a+=String.valueOf(i)+","+Solve.num_2[i][0]+","+Solve.num_2[i][1]+","+Solve.num_2[i][3]+"\n";
        	      }
        	      for(int i=0;i<Solve.length_two;i++){
     	    	     a+=String.valueOf(i+Solve.length_two)+","+Solve.num_2[i][1]+","+Solve.num_2[i][0]+","+Solve.num_2[i][3]+"\n";
     	      }
        	      return a;
        	  }
          public static String []chujuzhen;
}


package com.cacheserverdeploy.deploy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * 全局变量
 */
public class Quanju {
       public static  ArrayList<String> Server_place=new ArrayList<String>();//服务器位置
       public static int [] is_place=new int[Solve.num_wangluo];//判断该点是否三服务器
       public static  String [][] Rout=new String[Solve.length_three][100] ;//路径
       public static LinkedList<String>Net=new LinkedList<String>();//网络
    //   public static HashSet<String> all_net=new HashSet<String>();//所有网络
       public static HashMap<String, Integer> dai=new HashMap<String, Integer>();//每个消费节点所需要带宽
       public static HashSet<String> use=new HashSet<String>();//第一层真正使用的
       public static HashSet<String> jianzhi_use=new HashSet<String>();//剪枝用
       public static int [] num=new int [Solve.num_wangluo];//剪枝用来统计数目的数组
       //public static int [] visited_2=new int[Solve.num_wangluo];//遍历过的
       public static HashMap<String, String> lianjie=new HashMap<String, String>();//第一层第二层的连接
       public static int [] visited=new int [Solve.num_wangluo];
       public static int [][]daikuan_use=new int[Solve.num_wangluo][Solve.num_wangluo]; //带宽使用
}

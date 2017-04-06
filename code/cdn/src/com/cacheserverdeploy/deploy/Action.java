package com.cacheserverdeploy.deploy;

import java.util.LinkedList;
import java.util.List;

public class Action {
          public static String[]  ss(String[] graphContent){
        	  /**do your work here**/
        	  String[] init_0=Zuicha.init(graphContent);//初始化
        	  if(Solve.num_wangluo>400)
        	  {
        		  Bound.fuwuqi_init();
         		 Bound.is_chonghe2();
         		 Bound.is_beyond();
        	  }
        	  else
        	  {
        		//  System.out.print(Solve.num_wangluo);
        	/*	 Bound.fuwuqi_init();
        		 Bound.is_chonghe();
        		 Bound.is_beyond();*/Bound.hebing();
        	  }
        	  //System.out.println(shu.get_daikuan()[0][1]);
        	  String[] init_1=Zuicha.deployServer(graphContent);//初始化
          	return init_1;
          }
}

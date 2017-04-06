package com.cacheserverdeploy.deploy;


public class Deploy
{
    /**
     * 你需要完成的入口
     * <功能详细描述>
     * @param graphContent 用例信息文件
     * @return [参数说明] 输出结果信息
     * @see [类、类#方法、类#成员]
     */
    public static String[] deployServer(String[] graphContent)
    {
    	if(Zuicha.get_numwangluo(graphContent)>400)
    	//  return Zuicha.deployServer(graphContent);
    	return Action.ss(graphContent);   
    	else 
   		return Action.ss(graphContent);   
     //	return Zuicha.deployServer(graphContent);
    }

}

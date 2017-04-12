package cn.easybuy.utils;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemcachedUtils {
	static MemCachedClient client = null;
	static String[] connectUrls = new String[] { "127.0.0.1:11211" };
	// 初始化连接
	static {
		String[] attr = connectUrls;
		client = new MemCachedClient();
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(attr);
		pool.setWeights(new Integer[] { 3 });
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxIdle(1000 * 30 * 30);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketConnectTO(30);
		pool.initialize();
	}

	// 添加数据
	public static void add(String key, Object object) {
		client.set(key, object);
	}

	// 删除数据
	public static void del(String key) {
		client.delete(key);
	}

	// 获得数据
	public static Object get(String key) {
		return client.get(key);
	}
}

package cn.easybuy.utils;

/**
 * 判断是否为空工具类
 * 
 * @author 王涛 2017年5月23日
 */
public class EmptyUtils {
	// 判断是否为空
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		// if (obj instanceof CharSequence) {
		//
		// }
		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			if (object.length == 0) {
				return true;
			}
			boolean empty = true;
			for (int i = 0; i < object.length; i++) {
				if (!isEmpty(object[i])) {
					empty = false;
					break;
				}
			}
			return empty;
		}
		return false;
	}

	// 非空
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}

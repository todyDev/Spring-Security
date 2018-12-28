package tody.common.util;

import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;

public class MessageUtils {
	
	private static MessageSourceAccessor msAcc = null;
	
	public void setMessageSourceAccessor(MessageSourceAccessor msAcc) {
		MessageUtils.msAcc = msAcc;
	}
	
	public static String getMessage(String code) {
		return msAcc.getMessage(code, Locale.getDefault());
	}
	
	public static String getMessage(String code, Object[] objs) {
		return msAcc.getMessage(code, objs, Locale.getDefault());
	}

}

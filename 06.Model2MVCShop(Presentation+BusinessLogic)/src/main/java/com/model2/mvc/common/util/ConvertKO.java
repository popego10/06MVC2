package com.model2.mvc.common.util;

import java.io.UnsupportedEncodingException;

public class ConvertKO {

	public String convertKo(String paramValue){
		String convertParamValue=null;
		try{
			byte[] b= paramValue.getBytes("8859_1");
			convertParamValue = new String(b, "EUC_KR");
		}catch(UnsupportedEncodingException uee){
			System.out.println("한글 변환중 Exception 발생");
			uee.printStackTrace();
		}
		return convertParamValue;
	}
}

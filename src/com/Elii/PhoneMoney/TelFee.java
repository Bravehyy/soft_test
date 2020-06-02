package com.Elii.PhoneMoney;

import java.text.DecimalFormat;
public class TelFee {
	public static Double Fee(String strT,String strE) {
		double telFee;
		System.out.println("通话起始时间（如20170102030405）:"+strT);
		System.out.println("通话截止时间（如20170102030405）:"+strE);
		HoldingTime ht = new HoldingTime(strT,strE);
		System.out.println("电话接通时间："+ht.DateFormate(ht.startT));
		System.out.println("电话结束时间："+ht.DateFormate(ht.endT));
		DecimalFormat fee = new DecimalFormat("######0.00"); 
		long minute = ht.getHoldingTime();
		//计算话费
		if(minute <= 20){
			telFee = 0.05*minute;
		}else{
			telFee = 1.00 + (minute - 20)*0.1;
		}
		System.out.println("通话时间为："+minute+"分钟");
		System.out.println("本次通话话费为："+fee.format(telFee)+"美元");
		return telFee;
	}
	
	public static void main(String[] args) {
		System.out.println(TelFee.Fee("20201025015922", "20201025030519"));
	}
}
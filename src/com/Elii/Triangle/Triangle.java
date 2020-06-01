package com.Elii.Triangle;

public class Triangle {

	public static String classify(int a,int b,int c) {
		if((a<1||a>100)||(b<1||b>100)||(c<1||c>100)) {
			return "输入错误";
		}else if(!((a+b>c)&&(a+c>b)&&(c+b>a))){
			return "非三角形";
		}else if(a==b&&a==c&&b==c) {
			return "等边三角形";
		}else if(a!=b&&a!=c&&b!=c) {
			return "一般三角形";
		}else {
			return "等腰三角形";
		}
		
	}
	
}

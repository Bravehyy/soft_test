package experiment6;

public class Triangle {

	public static String classify(int a,int b,int c) {
		int limit=100;
		if((a<1||a>limit)||(b<1||b>limit)||(c<1||c>limit)) {
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



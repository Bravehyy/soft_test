package VirusClass;

public class Virus {
	public static int classify(boolean c1,boolean c2,boolean c3){
		if(c1==true&&c3==true){
			return 1;
		}else if(c1==true&&c3==false){
			return 2;
		}else if(c1==false&&c3==true){
			return 3;
		}else{
			return 4;
		}
	}
}

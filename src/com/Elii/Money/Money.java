package com.Elii.Money;


public class Money {
	public static double forMoney(int num_lock,int num_stock,int num_barrel) {
		double lockPrice=45;
		double stockPrice=30;
		double barrelPrice=25;
		double money;
		if(num_lock>70) {
			System.out.println("枪机数量超限！");
			return 0;
		}
		if(num_stock>80) {
			System.out.println("枪托数量超限！");
			return 0;
		}
		if(num_barrel>90) {
			System.out.println("枪管数量超限！");
			return 0;
		}
		double total_money=num_lock*lockPrice+num_stock*stockPrice+num_barrel*barrelPrice;
		if(total_money>1800) {
			money=0.1*1000;
			money+=0.15*800;
			money+=0.2*(total_money-1800);
		}
		else if(total_money>1000) {
			money=0.1*1000;
			money+=0.15*(total_money-1000);
		}
		else {
			money=0.1*total_money;
		}
		return money;
	}

//	public static void main(String[] args) {
//	//	int num[][]= {{70,80,90},{-1}};
//		double result=forMoney(15,10,10);
//		System.out.println(result);
//	}
}
package com.Elii.NextDate;

public class NextDate {

	public static String forNextDay(int year,int month,int day) {
		if(year<1900||year>2050) {
			return "年输入错误";
		}
		if(month<1||month>12) {
			return "月输入错误";
		}
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			if(day>31||day<1)
				return "日输入错误";
		}
		if(month==4||month==6||month==9||month==11) {
			if(day>30||day<1)
				return "日输入错误";
		}
		if((year%4==0&&year%100!=0)||(year%400==0))
		{
			if(month==2)
			{
				if(day>29)
				{
					return "日输入错误";
				}
				else
				{
					if(day==29)
					{
						day=1;
					}
					else
					{
						day++;
					}
				}
			}
		}else
		{
			if(month==2)
			{
				if(day>28)
				{
					return "日输入错误";
				}
				else
				{
					if(day==28)
					{
						day=1;
					}
					else
					{
						day++;
					}
				}
			}
		}
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			if(day==31)
			{
				month++;
				day=1;
				break;
			}
			else
			{
				day++;
				break;
			}
		case 2:
			if(day==1)
			{
				month++;
				break;
			}
			else
			{
				break;
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if(day==30)
			{
				month++;
				day=1;
				break;
			}
			else
			{
				day++;
				break;
			}
		case 12:
			if(day==31)
			{
				year++;
				month=1;
				day=1;
				break;
			}
			else
			{
				day++;
				break;
			}
		}
		return year+" "+month+" "+day;
	}
	
//	public static void main(String[] args) {
//		String result=forNextDay(2019,2,28);
//		System.out.println(result);
//	}
	
}
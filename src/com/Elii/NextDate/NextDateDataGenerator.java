package com.Elii.NextDate;

/**
 * �߽�ֵ�����������ɳ���
 */


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class NextDateDataGenerator {
	private final static String destDir = "F:/软件测试/实验二/NextDate/";
	public static void main(String[] args) throws Exception {
		//生成一般边界测试数据
		test1NormalBoundaryValue();
		
		//生成健壮性测试数据
		test2WorstCaseBoundaryValue();
		
		//生成最坏情况测试数据
		test3RobustBoundaryValue();
		
		//生成健壮最坏情况测试用例
		test4RobustWorstCaseBoundaryValue();
	}
	//一般边界值测试：4n+1
	public static void test1NormalBoundaryValue() throws Exception // Parameters!
	{
		int[] sideA = { 1900, 1901, 1975, 2049, 2050 };
		int[] sideB = { 1, 2, 6, 11, 12 };
		int[] sideC = { 1, 2, 15, 30, 31 };
		FileOutputStream fos = new FileOutputStream(destDir+"NextDate一般边界测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "year", "month", "day", "期望输出");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int year : sideA) {
			for (int month : sideB) {
				for (int day : sideC) {
					if (month == 6 && day == 15 || year == 1975 && day == 15 || year == 1975 && month == 6) {
						csvPrinter.printRecord(++num, year, month, day, NextDate.forNextDay(year, month, day));
					}
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();
	}

	// 健壮性测试：6n+1
	public static void test2WorstCaseBoundaryValue() throws Exception // Parameters!
	{
		int[] sideA = { 1899, 1900, 1901, 1975, 2049, 2050, 2051 };
		int[] sideB = { 0, 1, 2, 6, 11, 12, 13 };
		int[] sideC = { 0, 1, 2, 15, 30, 31, 32 };
		FileOutputStream fos = new FileOutputStream(destDir+"NextDate健壮性测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "year", "month", "day", "期望输出ֵ");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int year : sideA) {
			for (int month : sideB) {
				for (int day : sideC) {
					if (month == 6 && day == 15 || year == 1975 && day == 15 || year == 1975 && month == 6) {
						csvPrinter.printRecord(++num, year, month, day,NextDate.forNextDay(year, month, day));
					}
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();
	}

	// 最坏情况测试5的n次方
	public static void test3RobustBoundaryValue() throws Exception // Parameters!
	{
		int[] sideA = { 1900, 1901, 1975, 2049, 2050 };
		int[] sideB = { 1, 2, 6, 11, 12 };
		int[] sideC = { 1, 2, 15, 30, 31 };
		FileOutputStream fos = new FileOutputStream(destDir+"NextDate最坏情况测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "year", "month", "day", "期望输出ֵ");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int year : sideA) {
			for (int month : sideB) {
				for (int day : sideC) {
					csvPrinter.printRecord(++num, year, month, day,NextDate.forNextDay(year, month, day));
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();
	}

	// 健壮最坏情况测试7的n次方
	public static void test4RobustWorstCaseBoundaryValue() throws Exception // Parameters!
	{

		int[] sideA = { 1899, 1900, 1901, 1975, 2049, 2050, 2051 };
		int[] sideB = { 0, 1, 2, 6, 11, 12, 13 };
		int[] sideC = { 0, 1, 2, 15, 30, 31, 32 };
		FileOutputStream fos = new FileOutputStream(destDir+"NextDate健壮性最坏情况测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号","year", "month", "day","期望输出");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int year : sideA) {
			for (int month : sideB) {
				for (int day : sideC) {
					csvPrinter.printRecord(++num, year, month, day,NextDate.forNextDay(year, month, day));
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();

	}
}
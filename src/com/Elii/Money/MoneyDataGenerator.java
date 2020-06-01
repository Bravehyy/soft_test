package com.Elii.Money;

/**
 * �߽�ֵ�����������ɳ���
 */


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MoneyDataGenerator {
	private final static String destDir = "F:/软件测试/实验二/Money/";
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
		int[] sideA = { 1, 2, 35, 69, 70 };
		int[] sideB = { 1, 2, 40, 79, 80 };
		int[] sideC = { 1, 2, 45, 89, 90 };
		FileOutputStream fos = new FileOutputStream(destDir+"Money一般边界测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "locks", "stocks", "barrels", "期望输出");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);
		
		int num = 0;
		for (int locks : sideA) {
			for (int stocks : sideB) {
				for (int barrels : sideC) {
					if (stocks == 40 && barrels == 45 || locks == 35 && barrels == 45 || locks == 35 && stocks == 40) {
						csvPrinter.printRecord(++num, locks, stocks, barrels, Money.forMoney(locks, stocks, barrels));
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
		int[] sideA = { 0, 1, 2, 35, 69, 70, 71 };
		int[] sideB = { 0, 1, 2, 40, 79, 80, 81 };
		int[] sideC = { 0, 1, 2, 45, 89, 90, 91 };
		FileOutputStream fos = new FileOutputStream(destDir+"MoneyNextDate健壮性测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "locks", "stocks", "barrels", "期望输出");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int locks : sideA) {
			for (int stocks : sideB) {
				for (int barrels : sideC) {
					if (stocks == 40 && barrels == 45 || locks == 35 && barrels == 45 || locks == 35 && stocks == 40) {
						csvPrinter.printRecord(++num, locks, stocks, barrels, Money.forMoney(locks, stocks, barrels));
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
		int[] sideA = { 1, 2, 35, 69, 70 };
		int[] sideB = { 1, 2, 40, 79, 80 };
		int[] sideC = { 1, 2, 45, 89, 90 };
		FileOutputStream fos = new FileOutputStream(destDir+"Money最坏情况测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "locks", "stocks", "barrels", "期望输出");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int locks : sideA) {
			for (int stocks : sideB) {
				for (int barrels : sideC) {
					csvPrinter.printRecord(++num, locks, stocks, barrels,Money.forMoney(locks, stocks, barrels));
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();
	}

	// 健壮最坏情况测试7的n次方
	public static void test4RobustWorstCaseBoundaryValue() throws Exception // Parameters!
	{

		int[] sideA = { 0, 1, 2, 35, 69, 70, 71 };
		int[] sideB = { 0, 1, 2, 40, 79, 80, 81 };
		int[] sideC = { 0, 1, 2, 45, 89, 90, 91 };
		FileOutputStream fos = new FileOutputStream(destDir+"NextDate健壮性最坏情况测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "locks", "stocks", "barrels", "期望输出");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int locks : sideA) {
			for (int stocks : sideB) {
				for (int barrels : sideC) {
					csvPrinter.printRecord(++num, locks, stocks, barrels,Money.forMoney(locks, stocks, barrels));
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();

	}
}
package com.Elii.Money;

/**
 * �߽�ֵ�����������ɳ���
 */

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class MoneyDataGenerator {
	private final static String destDir = "F:/�������/ʵ���/Money/";
	public static void main(String[] args) throws Exception {
		//����һ��߽��������
		test1NormalBoundaryValue();

		//���ɽ�׳�Բ�������
		test2WorstCaseBoundaryValue();

		//����������������
		test3RobustBoundaryValue();

		//���ɽ�׳������������
		test4RobustWorstCaseBoundaryValue();
	}
	//һ��߽�ֵ���ԣ�4n+1
	public static void test1NormalBoundaryValue() throws Exception // Parameters!
	{
		int[] sideA = { 1, 2, 35, 69, 70 };
		int[] sideB = { 1, 2, 40, 79, 80 };
		int[] sideC = { 1, 2, 45, 89, 90 };
		FileOutputStream fos = new FileOutputStream(destDir+"Money�߽�ֵ������������.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("�������", "locks", "stocks", "barrels", "�������");
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

	// ��׳�Բ��ԣ�6n+1
	public static void test2WorstCaseBoundaryValue() throws Exception // Parameters!
	{
		int[] sideA = { 0, 1, 2, 35, 69, 70, 71 };
		int[] sideB = { 0, 1, 2, 40, 79, 80, 81 };
		int[] sideC = { 0, 1, 2, 45, 89, 90, 91 };
		FileOutputStream fos = new FileOutputStream(destDir+"Money��׳�Բ�������.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("�������", "locks", "stocks", "barrels", "�������");
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

	// ��������5��n�η�
	public static void test3RobustBoundaryValue() throws Exception // Parameters!
	{
		int[] sideA = { 1, 2, 35, 69, 70 };
		int[] sideB = { 1, 2, 40, 79, 80 };
		int[] sideC = { 1, 2, 45, 89, 90 };
		FileOutputStream fos = new FileOutputStream(destDir+"Money������������.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("�������", "locks", "stocks", "barrels", "�������");
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

	// ��׳��������7��n�η�
	public static void test4RobustWorstCaseBoundaryValue() throws Exception // Parameters!
	{

		int[] sideA = { 0, 1, 2, 35, 69, 70, 71 };
		int[] sideB = { 0, 1, 2, 40, 79, 80, 81 };
		int[] sideC = { 0, 1, 2, 45, 89, 90, 91 };
		FileOutputStream fos = new FileOutputStream(destDir+"Money��׳������������.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("�������", "locks", "stocks", "barrels", "�������");
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
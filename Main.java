package dataminingKNN;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap So Luong Con Vat");
		int n = sc.nextInt();
		System.out.println("Nhap Vi Tri Con Vat");
		System.out.println("X0");
		double x0 = sc.nextDouble();
		System.out.println("Y0");
		double y0 = sc.nextDouble();
		viTri[] a = new viTri[n];
		for (int i = 0; i < n; i++) {
			System.out.println("----------------");
            int id = i;
            System.out.println("id = " + id + " ");
            System.out.print("x" + i + "= ");
            double x = sc.nextDouble();
            System.out.print("y" + i + "= ");
            double y = sc.nextDouble();
            System.out.println("Ten Con Vat "+ id + " ");
            sc.nextLine();
            String loaiVat = sc.nextLine();
            a[i] = new viTri(id, x, y, x0, y0, loaiVat);
            a[i].khoangCach();
        }
		Arrays.sort(a, new Comparator<viTri>() {
			public int compare(viTri c1,viTri c2) {
				if(c1.khoangCach() < c2.khoangCach()) {
					return -1;
				}
				else {
					return 1;
				}
			}
		});
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Sau Khi Sap Xep!");
		System.out.println("Id\t X\t Y\tConVat\t\tKhoang Cach Voi Con Can Tim");
		for(viTri b : a) {
			System.out.println(b);
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Ban Muon Chon Bao Nhieu Con Vat Gan Nhat De Dua Ra Quyet Dinh ?");
		int choice = sc.nextInt();
		System.out.println("Top " + n + " Con Vat Gan Nhat:");
		System.out.println("Id\t X\t Y\tConVat\t\tKhoang Cach Voi Con Can Tim");
		Map<String, Integer> conVat = new HashMap<>();
        for (int i = 0; i < n; i++) {
            viTri b = a[i];
            System.out.println(b);
            conVat.put(b.getLoaiVat(), conVat.getOrDefault(b.getLoaiVat(), 0) + 1);
        }
        String conNhieuNhat = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : conVat.entrySet()) {
            if (entry.getValue() > maxCount) {
                conNhieuNhat = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("\nLoai Vat Xuat Hien Nhieu Nhat Trong Top " + n + " La: " + conNhieuNhat + " (" + maxCount + " lan)");
	}
}

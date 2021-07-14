package finish_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataIO {
	static String root = "C:\\Users\\TNC.W\\Documents\\data\\";
	public static ArrayList<SinhVien> listSinhVien = new ArrayList<>();
	public static ArrayList<MonHoc> listMonHoc = new ArrayList<>();
	public static ArrayList<Diem> listDiem = new ArrayList<>();
	public static void docDulieu() {
		docFileSV();
		docFileMH();
		docFileDiem();
	}
	
	public static void docFileSV() {
		File fileSV = new File(root+"sinhvien_en.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileSV);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#")) {
					continue;
				}
				String parts[] = line.split(";");
				SinhVien sv = new SinhVien(parts[0], parts[1], parts[2], parts[3], parts[4]);
				listSinhVien.add(sv);
			}
		} catch (IOException e) {
			System.out.println("Khong doc duoc file sinhvien.txt!");
		} finally {
				try {
					if (br != null) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void docFileMH() {
		File fileMH = new File(root+"monhoc_en.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileMH);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#")) {
					continue;
				}
				String parts[] = line.split(";");
				double heSo = Double.parseDouble(parts[2]);
				MonHoc mh = new MonHoc(parts[0], parts[1], heSo);
				listMonHoc.add(mh);
			}
		} catch (IOException e) {
			System.out.println("Khong doc duoc file monhoc.txt!");
		} finally {
				try {
					if (br != null) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void docFileDiem() {
		File fileDiem = new File(root+"diem.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileDiem);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#")) {
					continue;
				}
				String parts[] = line.split(";");
				double d = Double.parseDouble(parts[2]);
				Diem diem = new Diem(parts[0], parts[1], d);
				listDiem.add(diem);
			}
		} catch (IOException e) {
			System.out.println("Khong doc duoc file diem.txt!");
		} finally {
				try {
					if (br != null) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	public static void ghiFileSV() {
		File fileSV = new File(root+"sinhvien_en.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(fileSV);
			bw = new BufferedWriter(fw);
			bw.write("# ma sv; ho dem; ten; ngay sinh; gioi tinh");
			bw.newLine();
			for (SinhVien sv : listSinhVien) {
				bw.write(sv.getMaSV()+";"+sv.getHoDem()+";"+sv.getTen()+";"+sv.getNgaySinh()+";"+sv.getGioiTinh());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Khong ghi duoc file sinhvien.txt!");
		} finally {
				try {
					if (bw != null) bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}

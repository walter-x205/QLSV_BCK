package finish_project;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class MenuCapNhatDS {
	static Scanner sc = new Scanner(System.in);
	public static void menuCapNhatDS() {
		String chon;
		do {
			System.out.println("\n\n");
			System.out.println("┏━━━━━━━━━━ CAP NHAT DANH SACH ━━━━━━━━━━┓");
			System.out.println("┃ 1.Cap nhat danh sach sinh vien         ┃");
			System.out.println("┃ 2.Cap nhat danh sach mon hoc           ┃");
			System.out.println("┃ 3.Cap nhat bang diem                   ┃");
			System.out.println("┃ 0.Tro ve menu truoc                    ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("Chon: ");
			chon = sc.nextLine();
			switch (chon) {
			case "1":
				capNhatDSSV();
				break;
			case "2":
				capNhatDSMH();
				break;
			case "3":
				System.out.println("Tinh nang hien dang update!Xin vui long cho!\n\n");
				break;
			case "0":
				System.out.println("[tro ve]");
				break;
			default:
				System.out.println("Khong co chuc nang do!\n");
				break;
			}
		} while (!chon.equals("0"));		
	}
	
	public static void capNhatDSMH() {
		String chon;
		do {
			System.out.println("\n\n");
			System.out.println("┏━━━━━━━━ DANH SACH MON HOC ━━━━━━━━┓");
			System.out.println("┃ 1.Them mon hoc                    ┃");
			System.out.println("┃ 2.Sua thong tin mon hoc           ┃");
			System.out.println("┃ 3.Xoa mon hoc                     ┃");
			System.out.println("┃ 4.Hien thi danh sach mon hoc      ┃");
			System.out.println("┃ 0.Tro ve menu truoc               ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("Chon: ");
			chon = sc.nextLine();
			switch (chon) {
			case "1":
				themMH();
				break;
			case "2":
				suaMH();
				break;
			case "3":
				xoaMH();
				break;
			case "4":
				inDSMH();
				break;
			case "0":
				System.out.println("[tro ve]");
				break;
			default:
				System.out.println("Khong co chuc nang do!\n");
				break;
			}
		} while (!chon.equals("0"));
	}
	
	public static void themMH() {
		System.out.println("Tinh nang nay hien dang duoc update! Vui long cho them!\n\n");
	}
	
	public static void suaMH() {
		System.out.println("Tinh nang nay hien dang duoc update! Vui long cho them!\n\n");
	}
	
	public static void xoaMH() {
		System.out.println("Tinh nang nay hien dang duoc update! Vui long cho them!\n\n");
	}
	
	public static void inDSMH() {
		Comparator<MonHoc> comp = new Comparator<MonHoc>() {

			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMH().compareTo(o2.getTenMH());
			}
		};
		DataIO.listMonHoc.sort(comp);
		String chon;
		int perPage = 20;
		int pages = DataIO.listMonHoc.size()/perPage + 1;
		int pageNumber = 1;
		do {
			int start = perPage*(pageNumber-1);
			int end = start+perPage;
			if (end > DataIO.listMonHoc.size()) {
				end = DataIO.listMonHoc.size();
			}
			System.out.println("      ========DANH SACH MON HOC========");
			System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ Ma MH ┃          Ten mon hoc           ┃  He so ┃");
			System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╋━━━━━━━━┫");
			for (int i = start; i < end; i++) {
				DataIO.listMonHoc.get(i).inMH();
			}
			System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━┛");
			System.out.println("      -------------- Trang "+pageNumber+"/"+pages+" ---------------");
			System.out.println("\n\n");
			System.out.println("1.Xem trang tiep theo \t 2.Xem trang cuoi cung \t 3.Xem trang so");
			System.out.println("4.Xem trang truoc do \t 5.Xem trang dau tien \t 0.Thoat xem");
			System.out.println("Lua chon: ");
			chon = sc.nextLine();
			switch (chon) {
			case "1":
				{
					if (pageNumber < pages) {
						pageNumber++;
					} else {
						System.out.println("Ban dang o trang cuoi!");
					}
				}
				break;
			case "2":
				pageNumber = pages;
				break;
			case "3":
				{
					System.out.println("Nhap so trang: ");
					int nhap = sc.nextInt();
					sc.nextLine();
					if (nhap > pages || nhap < 1) {
						System.out.println("Khong co trang ban can xem!");
					} else {
						pageNumber = nhap;
					}
				}
				break;
			case "4":
				{
					if (pageNumber > 1) {
						pageNumber--;
					} else {
						System.out.println("Ban dang o trang dau tien!");
					}
				}
				break;
			case "5":
				pageNumber = 1;
				break;
			case "0":
				System.out.println("[tro ve]");
				break;
			default:
				System.out.println("Khong co chuc nang do!\n");
				break;
			}
		} while (!chon.equals("0"));
	}
	
	public static void capNhatDSSV() {
		String chon;
		do {
			System.out.println("\n\n");
			System.out.println("┏━━━━━━━ DANH SACH SINH VIEN ━━━━━━━┓");
			System.out.println("┃ 1.Them sinh vien                  ┃");
			System.out.println("┃ 2.Sua thong tin sinh vien         ┃");
			System.out.println("┃ 3.Xoa sinh vien                   ┃");
			System.out.println("┃ 4.Hien thi danh sach              ┃");
			System.out.println("┃ 0.Tro ve menu truoc               ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("Chon: ");
			chon = sc.nextLine();
			switch (chon) {
			case "1":
				themSV();
				break;
			case "2":
				suaSV();
				break;
			case "3":
				xoaSV();
				break;
			case "4":
				inDSSV();
				break;
			case "0":
				System.out.println("[tro ve]");
				break;
			default:
				System.out.println("Khong co chuc nang do!\n");
				break;
			}
		} while (!chon.equals("0"));
	}
	
	public static void themSV() {
		String maSV, hoTen, ngaySinh, gioiTinh, hoDem, ten;
		int duoi = DataIO.listSinhVien.size()+1;
		maSV = "SV"+ String.format("%05d", duoi);
		System.out.println("Nhap thong tin sinh vien theo dang sau: ");
		System.out.println("[Ho va ten];[Ngay sinh];[Gioi tinh]");
		System.out.println("VD: Nguyen Van A;01/01/2000;Nam");
		System.out.println("Nhap exit de quay lai");
		System.out.println("Nhap: ");
		try {
			String nhap = sc.nextLine();
			if (nhap.equals("exit")) {
				return;
			} else {
				nhap = nhap+" ";
				String part[] = nhap.split(";");
				hoTen = part[0];
				hoTen.trim();
				if (hoTen.equals("")) {
				hoDem = null;
				ten = null;
				} else {
					ten = hoTen.substring(hoTen.lastIndexOf(" ")+1);
					hoDem = hoTen.substring(0, hoTen.lastIndexOf(" "));
				}
				ngaySinh = part[1];
				if (ngaySinh.equals("")) {
					ngaySinh = null;
				}
				gioiTinh = part[2];
				if (gioiTinh.equals(" ")) {
					gioiTinh = null;
				}
				SinhVien SV = new SinhVien(maSV, hoDem, ten, ngaySinh, gioiTinh);
				DataIO.listSinhVien.add(SV);
				DataIO.ghiFileSV();
				System.out.println("Da them thanh cong!");
				System.out.println("Sinh vien: ["+maSV+"   "+hoDem+" "+ten+"    "+ngaySinh+"   "+gioiTinh+"]");
				System.out.println();
				System.out.println();
			} 
		} catch (Exception e) {
			System.out.println("Them khong thanh cong \n\n");
		}
	}
	
	public static void suaSV() {
		String hoTen, ngaySinh, gioiTinh, hoDem, ten;
		System.out.println("Nhap ma sinh vien can sua thong tin");
		System.out.println("Ma sinh vien: ");
		String MSV = sc.nextLine();
		int index = -1;
		for (int i = 0; i < DataIO.listSinhVien.size(); i++) {
			if (MSV.equals(DataIO.listSinhVien.get(i).getMaSV())) {
				index = i;
				break;
			} else {
				continue;
			}
		}
		if (index >= 0) {
			System.out.println("Tim thay sinh vien: ["+DataIO.listSinhVien.get(index).getMaSV()+"   "
													  +DataIO.listSinhVien.get(index).getHoDem()+" "
													  +DataIO.listSinhVien.get(index).getTen()+"   "
													  +DataIO.listSinhVien.get(index).getNgaySinh()+"   "
													  +DataIO.listSinhVien.get(index).getGioiTinh()+"]\n");
			System.out.println("Nhap thong tin sua doi theo dang sau");
			System.out.println("[Ho va ten];[Ngay sinh];[Gioi tinh]");
			System.out.println("Muc nao khong sua thi bo qua");
			System.out.println("VD: Nguyen Van A;;Nam");
			System.out.println("Nhap exit de quay lai");
			System.out.println("Nhap: ");
			try {
				String nhap = sc.nextLine();
				if (nhap.equals("exit")) {
					return;
				} else {
					nhap = nhap+" ";
					String part[] = nhap.split(";");
					hoTen = part[0];
					hoTen.trim();
					if (hoTen.equals("")) {
					hoDem = DataIO.listSinhVien.get(index).getHoDem();
					ten = DataIO.listSinhVien.get(index).getTen();
					} else {
						ten = hoTen.substring(hoTen.lastIndexOf(" ")+1);
						hoDem = hoTen.substring(0, hoTen.lastIndexOf(" "));
					}
					ngaySinh = part[1];
					if (ngaySinh.equals("")) {
						ngaySinh = DataIO.listSinhVien.get(index).getNgaySinh();
					}
					gioiTinh = part[2];
					if (gioiTinh.equals(" ")) {
						gioiTinh = DataIO.listSinhVien.get(index).getGioiTinh();
					}
					SinhVien SV = new SinhVien(MSV, hoDem, ten, ngaySinh, gioiTinh);
					DataIO.listSinhVien.set(index, SV);
					DataIO.ghiFileSV();
					System.out.println("Da sua thanh cong!");
					System.out.println("Sinh vien: ["+DataIO.listSinhVien.get(index).getMaSV()+"   "
							  +DataIO.listSinhVien.get(index).getHoDem()+" "
							  +DataIO.listSinhVien.get(index).getTen()+"   "
							  +DataIO.listSinhVien.get(index).getNgaySinh()+"   "
							  +DataIO.listSinhVien.get(index).getGioiTinh()+"]\n");
					System.out.println();
					System.out.println();
				} 
			} catch (Exception e) {
				System.out.println("Sua khong thanh cong \n\n");
			}
		} else {
			System.out.println("Khong tim thay sinh vien nao!\n\n");
		}
	}
	
	public static void xoaSV() {
		System.out.println("Nhap ma sinh vien can xoa");
		System.out.println("Ma sinh vien: ");
		String MSV = sc.nextLine();
		int index = -1;
		for (int i = 0; i < DataIO.listSinhVien.size(); i++) {
			if (MSV.equals(DataIO.listSinhVien.get(i).getMaSV())) {
				index = i;
				break;
			} else {
				continue;
			}
		}
		if (index >= 0) {
			System.out.println("Tim thay sinh vien: ["+DataIO.listSinhVien.get(index).getMaSV()+"   "
													  +DataIO.listSinhVien.get(index).getHoDem()+" "
													  +DataIO.listSinhVien.get(index).getTen()+"   "
													  +DataIO.listSinhVien.get(index).getNgaySinh()+"   "
													  +DataIO.listSinhVien.get(index).getGioiTinh()+"]\n");
			System.out.println("Ban co chac chan muon xoa khong (c/k)?");
			String luaChon = sc.nextLine();
			if (luaChon.equals("c")) {
				for (int i = 0; i < DataIO.listDiem.size(); i++) {
					if (MSV.equals(DataIO.listDiem.get(i).getSV())) {
						System.out.println("Khong the xoa sinh vien da co diem!");
						return;
					} else continue;
				}
				DataIO.listSinhVien.remove(index);
				System.out.println("Xoa thanh cong! \n\n");
				DataIO.ghiFileSV();
			} else {
				System.out.println("\n\n");
			}
		} else {
			System.out.println("Khong tim thay sinh vien nao!\n\n");
		}
	}
	
	public static void inDSSV() {
		Comparator<SinhVien> comp = new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				Locale vn = new Locale("vi");
				Collator vnCollator = Collator.getInstance(vn);
				if (o1.getTen().equals(o2.getTen())) {
					return vnCollator.compare(o1.getHoDem(), o2.getHoDem());
				} else {
					return vnCollator.compare(o1.getTen(), o2.getTen());
				}
				
			}
		};
		DataIO.listSinhVien.sort(comp);
		String chon;
		int perPage = 30;
		int pages = DataIO.listSinhVien.size()/perPage + 1;
		int pageNumber = 1;
		do {
			int start = perPage*(pageNumber-1);
			int end = start+perPage;
			if (end > DataIO.listSinhVien.size()) {
				end = DataIO.listSinhVien.size();
			}
			System.out.println("\n\n            ============== DANH SACH SINH VIEN ==============");
			System.out.println("┏━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━┳━━━━━━━━━━┓");
			System.out.println("┃   Ma SV   ┃          Ho dem           ┃   Ten    ┃   Ngay sinh  ┃ Gioi tinh┃");
			System.out.println("┣━━━━━━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━━━━━╋━━━━━━━━━━╋━━━━━━━━━━━━━━╋━━━━━━━━━━┫");
			for (int i = start; i < end; i++) {
				DataIO.listSinhVien.get(i).inSV();
			}
			System.out.println("┗━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━┻━━━━━━━━━━┛");
			System.out.println("                 ---------------- Trang "+pageNumber+"/"+pages+" -----------------");
			System.out.println("\n\n");
			System.out.println("1.Xem trang tiep theo \t 2.Xem trang cuoi cung \t 3.Xem trang so");
			System.out.println("4.Xem trang truoc do \t 5.Xem trang dau tien \t 6.Xem thong tin chi tiet");
			System.out.println("0.Thoat xem");
			System.out.println("Lua chon: ");
			chon = sc.nextLine();
			switch (chon) {
			case "1":
				{
					if (pageNumber < pages) {
						pageNumber++;
					} else {
						System.out.println("Ban dang o trang cuoi!");
					}
				}
				break;
			case "2":
				pageNumber = pages;
				break;
			case "3":
				{
					System.out.println("Nhap so trang: ");
					int nhap = sc.nextInt();
					sc.nextLine();
					if (nhap > pages || nhap < 1) {
						System.out.println("Khong co trang ban can xem!");
					} else {
						pageNumber = nhap;
					}
				}
				break;
			case "4":
				{
					if (pageNumber > 1) {
						pageNumber--;
					} else {
						System.out.println("Ban dang o trang dau tien!");
					}
				}
				break;
			case "5":
				pageNumber = 1;
				break;
			case "6":
				MenuTimKiem.timTheoMa();
				String e;
				do {
				System.out.println("Nhap ... de tro ve");
				e = sc.nextLine();
				} while (!e.equals("..."));
				break;
			case "0":
				System.out.println("[tro ve]");
				break;
			default:
				System.out.println("Khong co chuc nang do!\n");
				break;
			}
		} while (!chon.equals("0"));
	}
}

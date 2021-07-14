package finish_project;

import java.util.Comparator;
import java.util.Scanner;

public class MenuBangDiem {
	static Scanner sc = new Scanner(System.in);
	public static void menuBangDiem() {
		String chon;
		do {
			System.out.println("\n\n");
			System.out.println("┏━━━━━━━━━━━━━━━ BANG DIEM ━━━━━━━━━━━━━━┓");
			System.out.println("┃ 1.Bang diem theo danh sach sinh vien   ┃");
			System.out.println("┃ 2.Bang diem theo danh sach mon hoc     ┃");
			System.out.println("┃ 0.Tro ve menu truoc                    ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("Chon: ");
			chon = sc.nextLine();
			switch (chon) {
			case "1":
				diemTheoSV();
				break;
			case "2":
				diemTheoMH();
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
	
	public static void diemTheoMH() {
		System.out.println("Tinh nang nay dang duoc update! Vui long cho them!\n\n");
	}
	
	public static void diemTheoSV() {
		Comparator<SinhVien> comp = new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return (o1.getMaSV().compareTo(o2.getMaSV())); 

			}
		};
		DataIO.listSinhVien.sort(comp);
		String chon;
		int perPage = 5;
		int pages = DataIO.listSinhVien.size()/perPage + 1;
		int pageNumber = 1;
		do {
			int start = perPage*(pageNumber-1);
			int end = start+perPage;
			if (end > DataIO.listSinhVien.size()) {
				end = DataIO.listSinhVien.size();
			}
			System.out.println("   ============== BANG DIEM SINH VIEN ==============");
			for (int j = start; j < end; j++) {
				System.out.println("┏━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┓");
				System.out.format("┃%-10s ┃%-30s ┃%-10s ┃\n",DataIO.listSinhVien.get(j).getMaSV(),
						 								 DataIO.listSinhVien.get(j).getHoDem()+" "+DataIO.listSinhVien.get(j).getTen(),
						 								 DataIO.listSinhVien.get(j).getNgaySinh());
				System.out.println("┣━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┫");
				int check = 0;
				double heSo = 0;
				double dtk = 0;
				for (int i = 0; i < DataIO.listDiem.size(); i++) {
					if (DataIO.listDiem.get(i).getSV().equals(DataIO.listSinhVien.get(j).getMaSV())) {
						check++;
						String mon = DataIO.listDiem.get(i).getMH();
						for (MonHoc mh : DataIO.listMonHoc) {
							if (mh.getMaMH().equals(mon)) {
								heSo = heSo + mh.getHeSo();
								dtk = dtk + DataIO.listDiem.get(i).getDiem()*mh.getHeSo();
							} else continue;
						}
					} else {
						continue;
					}
				}
				if (check == 0) {
					System.out.format("┃DTK: %50.2f┃\n",0.00);
					System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
					System.out.println("┃Sinh vien chua co diem mon nao                         ┃");
				} else {
					double dtb = dtk/heSo;
					System.out.format("┃DTK: %50.2f┃\n",dtb);
					System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
				}
				
				for (int i = 0; i < DataIO.listDiem.size(); i++) {
					if (DataIO.listDiem.get(i).getSV().equals(DataIO.listSinhVien.get(j).getMaSV())) {
						String mon = DataIO.listDiem.get(i).getMH();
						for (MonHoc mh : DataIO.listMonHoc) {
							if (mh.getMaMH().equals(mon)) {
								System.out.format("┃%-6s  %-25s  %20.2f┃\n",mon,mh.getTenMH(),DataIO.listDiem.get(i).getDiem());
							} else continue;
						}
					} else {
						continue;
					}
				}
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n\n");
			}
			System.out.println("  ---------------- Trang "+pageNumber+"/"+pages+" -----------------");
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
}

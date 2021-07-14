package finish_project;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\t\t╔═══════════════════════════════════╗");
		System.out.println("\t\t║                                   ║");
		System.out.println("\t\t║    PHAN MEM QUAN LI SINH VIEN     ║");
		System.out.println("\t\t║            beta 1.0.0             ║");
		System.out.println("\t\t║                                   ║");
		System.out.println("\t\t╚═══════════════════════════════════╝");
		DataIO.docDulieu();
		menuChinh();
		System.out.println("Chuong trinh ket thuc!");
	}
	
	public static void menuChinh() {
		String chon;
		do {
			System.out.println("\n\n");
			System.out.println("┏━━━━━━━ MOI CHON TAC VU ━━━━━━━┓");
			System.out.println("┃ 1.Cap nhat danh sach          ┃");
			System.out.println("┃ 2.Hien thi bang diem          ┃");
			System.out.println("┃ 3.Tim kiem                    ┃");
			System.out.println("┃ 0.Thoat                       ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("Chon: ");
			chon = sc.nextLine();
			switch (chon) {
			case "1":
				MenuCapNhatDS.menuCapNhatDS();
				break;
			case "2":
				MenuBangDiem.menuBangDiem();
				break;
			case "3":
				MenuTimKiem.timKiem();
				break;
			case "0":
				break;
			default:
				System.out.println("Khong co chuc nang do!\n");
				break;
			}	
		} while (!chon.equals("0"));
	}
	
}

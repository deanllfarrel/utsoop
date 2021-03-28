import java.io.IOException;
import java.util.*;

public class Main {
static ArrayList<Barang> barang = new ArrayList<Barang>();
static ArrayList<Order> order = new ArrayList<Order>();

static void Menu () {
	System.out.println("---------------Menu Toko Voucher & HP---------------");
	System.out.println("1. Pesan Barang\n2. Lihat Pesanan\n3. Barang Baru\n0. Exit\n");
	System.out.print("Pilihan : ");
}

public static void main(String[] args) {
Scanner scan = new Scanner (System.in);	
int input,menu,jml,uang,save = 1;
String nama;
String warna;
String pesanan; 
int harga,load,stok = 0;
double ppn = 0;
boolean cek = false;
	
	while (true) {
	cek = false;
	Menu();
	menu = scan.nextInt();
	if (menu == 0) {
		break;
	}
	
	switch (menu) {
	case 1 :
		System.out.println("Daftar Barang Toko Voucher & HP");
		for (Barang i : barang) {
			if (i.getId().contains("H")) {
			Handphone handphone = (Handphone) i;
			System.out.println("ID \t: "+ i.getId());
			System.out.println("Nama \t: "+ i.getNama() + " "+handphone.getWarna());
			System.out.println("Stok \t: " + i.getStock());
			System.out.format("Harga \t: %.0f%n", i.getHarga());
			System.out.println("---------------------------------------------------------------");
			} else {
			Voucher voucher = (Voucher) i;
			System.out.println("ID \t: "+ i.getId());
			System.out.println("Nama \t: "+ i.getNama());
			System.out.format("Nominal : %.0f%n" , i.getHarga());
			System.out.println("Stok \t: " + i.getStock());
			System.out.format("Harga \t: %.0f%n", voucher.gethargaJual());
			System.out.println("---------------------------------------------------------------");
				}
		}
		
		System.out.println("Ketik 0 untuk batal");
		System.out.print("Pesan Barang (ID) : \n");
		scan.nextLine();
		pesanan = scan.nextLine();
		if (pesanan.equals("0")) {
			System.out.println("Menu dibatalkan!");
		}
		save = 0;
		for (Barang i : barang) {
			cek = true;
			if (pesanan.equalsIgnoreCase(i.getId())) {
				cek = true;
				System.out.print("Masukkan jumlah barang: ");
				jml = scan.nextInt();
				if (jml > i.getStock()) {
					System.out.println("Stok barang tidak cukup...");
					try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } break;
				}
				if (pesanan.matches(".*(H|h).*")){
                    System.out.format(jml+" @ "+i.getNama()+" dengan total harga %.0f%n",i.getHarga()*jml);
                } else {
                    System.out.format(jml+" @ "+i.getNama()+" %.0f dengan total harga %.0f%n",i.getHarga(),((Voucher)i).gethargaJual()*jml);
                }
                System.out.print("Masukan jumlah uang untuk membayar pesanan anda : ");
                harga = scan.nextInt();
                if(harga < i.getHarga()) {
                    System.out.println("Jumlah uang yang anda berikan tidak cukup! Silahkan coba lagi");
                    break;
                }
                if(pesanan.contains("H")) {
                    order.add(new Order("O"+pesanan,barang.get(save),jml));
                } else {
                    order.add(new Order("O"+pesanan,barang.get(save),jml));
                }
                
                i.minusStock(jml);
                System.out.println("Barang telah berhasil dipesan!");
                break;
            }
            save++;
        }
        if(!cek) {
            System.out.println("Input  salah.. Silahkan coba lagi.");
        } break;
        
	case 2 :
		load = 0;
		System.out.println("Daftar Pesanan Toko Multiguna");
		
		for (Order i : order) {
			
			if (i.getId().matches(".*(H|h).*")) {
			System.out.println("ID \t: "+ i.getId());
			System.out.println("Nama \t: "+ ((Handphone)i.getBarang()).getNama());
			System.out.println("Jumlah \t: " + i.getJumlah());
			System.out.format("Total \t: %.0f%n" , ((Handphone)i.getBarang()).getHarga()*i.getJumlah()); 
			System.out.println("-------------------------------------------------------");
			} 
			else {
			System.out.println("ID \t: "+ i.getId());
			System.out.println("Nama \t: "+ ((Voucher)i.getBarang()).getNama());
			System.out.println("Jumlah \t: " + i.getJumlah());
			System.out.format("Total \t: %.0f%n" , ((Voucher)i.getBarang()).getHarga()*i.getJumlah());
			System.out.println("-------------------------------------------------------");
			}
		}
	break;
	
	case 3 :
		System.out.print("Voucher / Handphone (V/H): ");
		input = scan.next().charAt(0);
		if (input == 'v' || input =='V') {
			System.out.print("Nama : ");
			scan.nextLine();
			nama = scan.nextLine();
			System.out.print("Harga : ");
			harga = scan.nextInt();
			System.out.print("Stok : ");
			stok = scan.nextInt();
			System.out.print("PPN : ");
			ppn = scan.nextDouble();
			barang.add(new Voucher("V0"+(barang.size()+1),nama,harga,stok,ppn));
			System.out.println("Voucher berhasil di input!");
			
		}else if (input == 'h' || input =='H') {
			System.out.print("Nama : ");
			scan.nextLine();
			nama = scan.nextLine();
			System.out.print("Harga : ");
			harga = scan.nextInt();
			System.out.print("Stok : ");
			stok = scan.nextInt();
			System.out.print("Warna : ");
			scan.nextLine();
			warna = scan.nextLine();
			barang.add(new Handphone("H0"+(barang.size()+1),nama,harga,stok,warna));
			System.out.println("Handphone berhasil di input!");
		}
		break;
	}
	}
}
}
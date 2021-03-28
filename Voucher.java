public class Voucher extends Barang{
private double pajak;
public static int total;


public Voucher (String id, String nama, double harga, int stock, double pajak) {
	super(id, nama, harga,stock);
	this.stock = stock;
	this.pajak = pajak;
	
}

public double getPajak () {
	return pajak;
}

public double gethargaJual() {
	return  harga+(pajak * harga);
}
}
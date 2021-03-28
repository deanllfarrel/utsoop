public class Handphone extends Barang{
private String warna;
public static int total;

public Handphone () {}
public Handphone (String id, String nama, double harga, int stock, String warna) {
	super(id, nama, harga,stock);
	this.stock = stock;
	this.warna = warna;
}

public String getWarna() {
	return warna;
}
}
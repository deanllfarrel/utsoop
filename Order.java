public class Order{
private String id;
private Barang barang;
private int jumlah;
public int total;


public Order (String id, Barang barang , int jumlah) {
	this.id = id;
	this.jumlah = jumlah;
	this.barang = barang;
}

public String getId() {
	return id;
}

public Barang getBarang () {
	return barang;
}

public int getJumlah() {
	return jumlah;
}
}
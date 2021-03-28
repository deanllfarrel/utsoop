public class Barang {
	protected  String id;
	protected  String nama;
	protected  int stock;
	protected  double harga;
	
	public Barang () {}
	public Barang (String id, String nama, double harga, int stock) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
		this.stock = stock;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getNama() {
		return this.nama;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public double getHarga() {
		return this.harga;
	}
	
	public void minusStock(int qty) {
		this.stock -= qty;
	}
}
package info.blogbasbas.hari3;


import com.google.gson.annotations.SerializedName;


public class RecordsItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("email")
	private String email;

	@SerializedName("alamat")
	private String alamat;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"RecordsItem{" + 
			"nama = '" + nama + '\'' + 
			",email = '" + email + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}
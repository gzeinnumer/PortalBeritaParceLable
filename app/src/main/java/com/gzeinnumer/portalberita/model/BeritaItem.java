package com.gzeinnumer.portalberita.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

//todo 3. model pojo
public class BeritaItem implements Parcelable {

	@SerializedName("penulis")
	private String penulis;

	@SerializedName("foto")
	private String foto;

	@SerializedName("id")
	private String id;

	@SerializedName("judul_berita")
	private String judulBerita;

	@SerializedName("tanggal_posting")
	private String tanggalPosting;

	@SerializedName("isi_berita")
	private String isiBerita;

	public BeritaItem(String penulis, String foto, String id, String judulBerita, String tanggalPosting, String isiBerita) {
		this.penulis = penulis;
		this.foto = foto;
		this.id = id;
		this.judulBerita = judulBerita;
		this.tanggalPosting = tanggalPosting;
		this.isiBerita = isiBerita;
	}

	public void setPenulis(String penulis){
		this.penulis = penulis;
	}

	public String getPenulis(){
		return penulis;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJudulBerita(String judulBerita){
		this.judulBerita = judulBerita;
	}

	public String getJudulBerita(){
		return judulBerita;
	}

	public void setTanggalPosting(String tanggalPosting){
		this.tanggalPosting = tanggalPosting;
	}

	public String getTanggalPosting(){
		return tanggalPosting;
	}

	public void setIsiBerita(String isiBerita){
		this.isiBerita = isiBerita;
	}

	public String getIsiBerita(){
		return isiBerita;
	}


	public BeritaItem(Parcel in) {
		penulis = in.readString();
		foto = in.readString();
		id = in.readString();
		judulBerita = in.readString();
		tanggalPosting = in.readString();
		isiBerita = in.readString();
	}
	public static final Creator<BeritaItem> CREATOR = new Creator<BeritaItem>() {
		@Override
		public BeritaItem createFromParcel(Parcel in) {
			return new BeritaItem(in);
		}

		@Override
		public BeritaItem[] newArray(int size) {
			return new BeritaItem[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(penulis);
		dest.writeString(foto);
		dest.writeString(id);
		dest.writeString(judulBerita);
		dest.writeString(tanggalPosting);
		dest.writeString(isiBerita);
	}
}
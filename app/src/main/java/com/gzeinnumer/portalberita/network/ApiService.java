package com.gzeinnumer.portalberita.network;


import com.gzeinnumer.portalberita.model.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    @GET("tampil_berita.php")
    Call<ResponseBerita> showAllBerita();
}

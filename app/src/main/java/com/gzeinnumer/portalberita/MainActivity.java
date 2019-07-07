package com.gzeinnumer.portalberita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.gzeinnumer.portalberita.adapter.AdapterBerita;
import com.gzeinnumer.portalberita.model.BeritaItem;
import com.gzeinnumer.portalberita.model.ResponseBerita;
import com.gzeinnumer.portalberita.network.ConfigRetrofit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //todo 2. pojo
    @BindView(R.id.listBerita)
    RecyclerView listBerita;
    private List<BeritaItem> dataBerita;
    private AdapterBerita adapterBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //todo 8. test koneksi
        sendRequestBerita();

    }

    private void sendRequestBerita() {
        //todo 9. buat ini
        ConfigRetrofit.getInstance().showAllBerita().enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                boolean status = response.body().isStatus();
                dataBerita = response.body().getBerita();
                if (status){
                    Toast.makeText(getApplicationContext(), "Terhubung nih!!",Toast.LENGTH_SHORT).show();
                    //todo 11.
                    initData();
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initData() {
        adapterBerita = new AdapterBerita(getApplicationContext(), dataBerita);
        listBerita.setAdapter(adapterBerita);
        listBerita.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}

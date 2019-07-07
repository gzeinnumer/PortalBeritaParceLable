package com.gzeinnumer.portalberita.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gzeinnumer.portalberita.BuildConfig;
import com.gzeinnumer.portalberita.R;
import com.gzeinnumer.portalberita.model.BeritaItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Detail extends AppCompatActivity {

    @BindView(R.id.gambarDet)
    ImageView gambarDet;
    @BindView(R.id.namaDet)
    TextView namaDet;
    @BindView(R.id.penulisDet)
    TextView penulisDet;
    @BindView(R.id.tanggalDet)
    TextView tanggalDet;
    @BindView(R.id.beritaDet)
    TextView beritaDet;

    BeritaItem dataDiterima;

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        //todo 13.
        Bundle bundle = getIntent().getExtras();
        dataDiterima = bundle.getParcelable("data");
        namaDet.setText(dataDiterima.getJudulBerita());
        penulisDet.setText(dataDiterima.getPenulis());
        tanggalDet.setText(dataDiterima.getTanggalPosting());
        //beritaDet.setText(intent.getStringExtra("berita"));
        myWebView = findViewById(R.id.webBerita);
        myWebView.loadData(dataDiterima.getIsiBerita(), "text/html", "utf-8");
        Picasso.get()
                .load(BuildConfig.BASE_URL+"images/"+dataDiterima.getFoto())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.mipmap.ic_launcher)
                .into(gambarDet);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

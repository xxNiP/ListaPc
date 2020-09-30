package com.example.listapc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtProductoNombreD, txtProductoDescripD, txtProductoPrecioD;
    private ImageView imgProductoD;
    private Button btnCompra;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle);

        getSupportActionBar().setTitle("Producto");
        findViews();

        Intent intent =getIntent();

        Bundle extras = intent.getExtras();
        txtProductoDescripD.setText(extras.getString("E_DESCRIPCION"));
        txtProductoNombreD.setText(extras.getString("E_NOMBRE"));
        txtProductoPrecioD.setText("$"+String.valueOf(extras.getFloat("E_PRECIO")));
        Picasso.get().load("https://http2.mlstatic.com/D_NQ_NP_634540-MLA42609806883_072020-W.jpg"+extras.getInt("E_ID")).into(imgProductoD);

    }

    private void findViews(){
        txtProductoPrecioD = findViewById(R.id.txtProductoPrecio);
        txtProductoNombreD = findViewById(R.id.txtProductoNombre);
        txtProductoDescripD = findViewById(R.id.txtProductoDescrip);
        imgProductoD = findViewById(R.id.imgProducto);
        btnCompra = findViewById(R.id.btnCompra);

        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetalleActivity.this, "Compra", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

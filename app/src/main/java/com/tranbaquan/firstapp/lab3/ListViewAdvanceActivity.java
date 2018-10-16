package com.tranbaquan.firstapp.lab3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.tranbaquan.firstapp.R;
import com.tranbaquan.firstapp.lab3.adapter.CustomAdapter;
import com.tranbaquan.firstapp.lab3.model.Book;
import com.tranbaquan.firstapp.lab3.model.Newspaper;
import com.tranbaquan.firstapp.lab3.model.Pen;
import com.tranbaquan.firstapp.lab3.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdvanceActivity extends AppCompatActivity {

    private Button addProduct, deleteProduct;
    private EditText productId, productName;
    private RadioGroup productType;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Product> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_advance);

        data = new ArrayList<>();
        addProduct = findViewById(R.id.bt_add_product);
        deleteProduct = findViewById(R.id.bt_delete);
        productId = findViewById(R.id.et_product_id);
        productName = findViewById(R.id.et_product_name);
        productType = findViewById(R.id.rg_product_type);
        recyclerView = findViewById(R.id.rc_product_list);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct(view);
                adapter.notifyDataSetChanged();
            }
        });

        deleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeProduct();
            }
        });

    }

    private Product getProduct(int id) {
        String productIdString = productId.getText().toString();
        String productNameString = productName.getText().toString();

        Product p = null;
        switch (id) {
            case R.id.rb_book:
                p = new Book(productIdString, productNameString);
                break;
            case R.id.rb_newspaper:
                p = new Newspaper(productIdString, productNameString);
                break;
            case R.id.rb_pen:
                p = new Pen(productIdString, productNameString);
                break;
        }
        return p;
    }

    private void addProduct(View view) {
        Product p = getProduct(productType.getCheckedRadioButtonId());
        data.add(p);
    }

    private void removeProduct() {
        for (int i = data.size() - 1; i >= 0; i--) {
            CustomAdapter.ViewHolder viewHolder = (CustomAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
            if(viewHolder.getCheckBox().isChecked()) {
                data.remove(i);
                adapter.notifyItemRemoved(i);
                adapter.notifyItemRangeChanged(i, data.size());
            }
        }
    }
}

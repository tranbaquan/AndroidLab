package com.tranbaquan.firstapp.lab3.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tranbaquan.firstapp.R;
import com.tranbaquan.firstapp.lab3.model.Product;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Product> productSet;

    public CustomAdapter(List<Product> productSet) {
        this.productSet = productSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.getProductId().setText(productSet.get(position).getId());
        holder.getProductName().setText(productSet.get(position).getName());
        holder.getProductType().setText(productSet.get(position).getItemType().getType());
        holder.setIconType(productSet.get(position));
        holder.getCheckBox().setChecked(false);
    }

    @Override
    public int getItemCount() {
        return productSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productId;
        private final TextView productName;
        private final TextView productType;
        private final CheckBox checkBox;
        private final ImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            productId = itemView.findViewById(R.id.tv_product_id);
            productName = itemView.findViewById(R.id.tv_product_name);
            productType = itemView.findViewById(R.id.tv_product_type);
            checkBox = itemView.findViewById(R.id.cb_select_product);
            imageView = itemView.findViewById(R.id.iv_icon_type);
        }

        private void setIconType(Product p) {
            int id = 0;
            switch (p.getItemType()) {
                case PEN:
                    id = imageView.getResources().getIdentifier("@android:drawable/ic_input_add", null, null);
                    break;
                case BOOK:
                    id = imageView.getResources().getIdentifier("@android:drawable/ic_menu_add", null, null);
                    break;
                case NEWSPAPER:
                    id = imageView.getResources().getIdentifier("@android:drawable/ic_lock_idle_alarm", null, null);
                    break;
            }
            imageView.setImageResource(id);
        }

        public TextView getProductId() {
            return productId;
        }

        public TextView getProductName() {
            return productName;
        }

        public TextView getProductType() {
            return productType;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public ImageView getImageView() {
            return imageView;
        }

    }
}

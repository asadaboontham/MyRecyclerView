package com.example.asadaboomtham.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext())
                .inflate(R.layout.product_cardview_layout, parent, false);

        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.tvName.setText(product.name);
        holder.tvPrice.setText("" + product.price);

        String fullUrl = "http://c0b42819.ngrok.io/customer/" + product.image_url;

        Picasso.with(context)
                .load(fullUrl)
                .placeholder(R.drawable.pp)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.ivImageUrl);

    }

    @Override
    public int getItemCount() {
        if (products != null) {
            return products.size();
        }
        return 0;
    }


    //ViewHolder class
    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public CardView cvProduct;
        public ImageView ivImageUrl;
        public TextView tvName;
        public TextView tvPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);
            cvProduct = (CardView) itemView.findViewById(R.id.cvProduct);
            ivImageUrl = (ImageView) itemView.findViewById(R.id.ivImageUrl);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);

        }
    }
}

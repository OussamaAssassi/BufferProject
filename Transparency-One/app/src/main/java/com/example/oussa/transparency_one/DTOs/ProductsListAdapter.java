package com.example.oussa.transparency_one.DTOs;

/**
 * Created by oussa on 28/09/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.oussa.transparency_one.R;

import java.util.List;

public class ProductsListAdapter extends ArrayAdapter<Product> {

    public ProductsListAdapter(Context context, List<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_product,parent, false);
        }

        ProductViewHolder viewHolder = (ProductViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ProductViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Source> sources
        Product product = getItem(position);
        viewHolder.name.setText(product.getName());

        return convertView;
    }

    private class ProductViewHolder{
        public TextView name;
    }
}

package com.example.oussa.transparency_one.Adapters;

/**
 * Created by oussa on 28/09/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oussa.transparency_one.DTOs.Product;
import com.example.oussa.transparency_one.R;

import java.util.List;

public class SourcesListAdapter extends ArrayAdapter<Product> {

    public SourcesListAdapter(Context context, List<Product> sources) {
        super(context, 0, sources);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_source,parent, false);
        }

        SourcetViewHolder viewHolder = (SourcetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new SourcetViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.supplierName = (TextView) convertView.findViewById(R.id.supplierName);
            viewHolder.picture = (ImageView) convertView.findViewById(R.id.picture);
            convertView.setTag(viewHolder);
        }

        Product source = getItem(position);
        viewHolder.name.setText(source.getName());
        viewHolder.supplierName.setText(source.getSupplierName());
        viewHolder.picture.setImageResource(source.getPicture());

        return convertView;
    }

    private class SourcetViewHolder{
        public TextView name;
        public TextView supplierName;
        public ImageView picture;
    }
}

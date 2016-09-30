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

public class ComponentsListAdapter extends ArrayAdapter<Product> {

    public ComponentsListAdapter(Context context, List<Product> components) {
        super(context, 0, components);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_component,parent, false);
        }

        ComponentViewHolder viewHolder = (ComponentViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ComponentViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }

        Product component = getItem(position);
        viewHolder.name.setText(component.getName());
        viewHolder.statusPicture = (ImageView) convertView.findViewById(R.id.picture);

        return convertView;
    }

    private class ComponentViewHolder{
        public TextView name;
        public ImageView statusPicture;
    }
}

package com.example.oussa.transparency_one.Adapters;

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

public class VisibilitiesListAdapter extends ArrayAdapter<String> {

    public VisibilitiesListAdapter(Context context, List<String> visibilities) {
        super(context, 0, visibilities);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_product,parent, false);
        }

        VisibilityViewHolder viewHolder = (VisibilityViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new VisibilityViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }

        String visibility = getItem(position);
        viewHolder.name.setText(visibility);

        return convertView;
    }

    private class VisibilityViewHolder{
        public TextView name;
    }
}

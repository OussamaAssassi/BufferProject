package com.example.oussa.transparency_one;

/**
 * Created by oussa on 28/09/2016.
 */
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import java.util.List;

public class SourceAdapter extends ArrayAdapter<Source> {

    public SourceAdapter(Context context, List<Source> sources) {
        super(context, 0, sources);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_source,parent, false);
        }

        SourceViewHolder viewHolder = (SourceViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new SourceViewHolder();
            viewHolder.sourceName = (TextView) convertView.findViewById(R.id.sourceName);
            viewHolder.supplierName = (TextView) convertView.findViewById(R.id.supplierName);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Source> sources
        Source source = getItem(position);
        viewHolder.sourceName.setText(source.getSourceName());
        viewHolder.supplierName.setText(source.getSupplierName());

        return convertView;
    }

    private class SourceViewHolder{
        public TextView sourceName;
        public TextView supplierName;
    }
}

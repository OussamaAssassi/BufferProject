package com.example.oussa.transparency_one;

/**
 * Created by oussa on 28/09/2016.
 */
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import java.util.List;

public class ReceivedNotificationAdapter extends ArrayAdapter<Notification> {

    public ReceivedNotificationAdapter(Context context, List<Notification> notifications) {
        super(context, 0, notifications);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_received,parent, false);
        }


        NotificationViewHolder viewHolder = (NotificationViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new NotificationViewHolder();
            viewHolder.productName = (TextView) convertView.findViewById(R.id.productName);
            viewHolder.supplierName = (TextView) convertView.findViewById(R.id.supplierName);
            viewHolder.picture = (ImageView) convertView.findViewById(R.id.picture);
            viewHolder.creationDate = (TextView) convertView.findViewById(R.id.creationDate);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Source> sources
        Notification notification = getItem(position);
        viewHolder.productName.setText(notification.getProductName());
        viewHolder.supplierName.setText(notification.getSupplierName());
        viewHolder.creationDate.setText(notification.getCreationDate());
        viewHolder.picture.setImageResource(notification.getPicture());

        return convertView;
    }

    private class NotificationViewHolder{
        public TextView productName;
        public TextView supplierName;
        public ImageView picture;
        public TextView creationDate;
    }
}

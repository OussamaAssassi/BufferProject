package com.example.oussa.transparency_one.Adapters;

/**
 * Created by oussa on 28/09/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.oussa.transparency_one.DTOs.Notification;
import com.example.oussa.transparency_one.R;

import java.util.List;

public class SentNotificationAdapter extends ArrayAdapter<Notification> {

    public SentNotificationAdapter(Context context, List<Notification> notifications) {
        super(context, 0, notifications);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_sent,parent, false);
        }

        NotificationViewHolder viewHolder = (NotificationViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new NotificationViewHolder();
            viewHolder.productName = (TextView) convertView.findViewById(R.id.productName);
            viewHolder.supplierName = (TextView) convertView.findViewById(R.id.supplierName);
            viewHolder.creationDate = (TextView) convertView.findViewById(R.id.creationDate);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            convertView.setTag(viewHolder);
        }

        Notification notification = getItem(position);
        viewHolder.productName.setText(notification.getProductName());
        viewHolder.supplierName.setText(notification.getSupplierName());
        viewHolder.creationDate.setText(notification.getCreationDate());
        viewHolder.checkBox.setChecked(notification.getSelected());
        createCheckedHolder();
        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkedHolder[position] = isChecked;
            }
        });

        return convertView;
    }

    private class NotificationViewHolder{
        public TextView productName;
        public TextView supplierName;
        public TextView creationDate;
        public CheckBox checkBox;
    }

    public boolean[] checkedHolder;

    private void createCheckedHolder() {
        checkedHolder = new boolean[getCount()];
    }
}

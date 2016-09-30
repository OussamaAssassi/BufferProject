package com.example.oussa.transparency_one;

import com.example.oussa.transparency_one.DTOs.Notification;
import com.example.oussa.transparency_one.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon.Budin on 30/09/2016.
 */

public class NotificationsService {
    public List<Notification> getMockedNotifications(String notificationType){
        if(notificationType == "received")
        {
            List<Notification> notifications = new ArrayList<Notification>();
            notifications.add(new Notification("Paella", "Jumpy Fishes Ltd", "2 hours ago", R.drawable.hands_icon));
            notifications.add(new Notification("Marshmallows", "Candies for us", "4 hours ago", R.drawable.eye_icon));
            notifications.add(new Notification("Yogurt Cherry", "Milk & co", "1 day ago", R.drawable.hands_icon));
            notifications.add(new Notification("Mayan Drink", "Energy inc.", "1 week ago", R.drawable.hands_icon));
            notifications.add(new Notification("Lakewood Drink", "Drink corp", "2 months ago", R.drawable.eye_icon));
            return notifications;

        }
        else if(notificationType == "sent"){

            List<Notification> notifications = new ArrayList<Notification>();

            notifications.add(new Notification("Pizza dough", "Supplier 1", "1 hour ago", 1));
            notifications.add(new Notification("Tomatoes", "Supplier 2", "3 hours ago", 1));
            notifications.add(new Notification("Mushrooms", "Supplier 3", "4 days ago", 1));
            notifications.add(new Notification("Ham", "Supplier 4", "1 week ago", 1));
            notifications.add(new Notification("Pizza box", "Supplier 5", "1 month ago", 1));
            return notifications;
        }
        else{
            return null;
        }
    }
}

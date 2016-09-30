package com.example.oussa.transparency_one;

import com.example.oussa.transparency_one.DTOs.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon.Budin on 30/09/2016.
 */


public class NotificationsService {

    private android.content.Context applicationContext;
    public NotificationsService(android.content.Context applicationContext) {
        createSentBaseList();
        this.applicationContext = applicationContext;
        GlobalVariable appState = ((GlobalVariable)applicationContext);
        if(appState.getReceivedNotificationsState() == null) {
            List<Notification> baseReceivedNotifications = createReceivedBaseList();
            appState.setReceivedNotificationsState(baseReceivedNotifications);
        }
        if(appState.getSentNotificationsState() == null) {
            List<Notification> baseSentNotifications = createReceivedBaseList();
            appState.setSentNotificationsState(baseSentNotifications);
        }
    }

    private List<Notification> createReceivedBaseList()
    {
        List<Notification> receivedNotifications;
        receivedNotifications = new ArrayList<Notification>();
        receivedNotifications.add(new Notification("Paella", "Jumpy Fishes Ltd", "Just now", R.drawable.hands_icon));
        receivedNotifications.add(new Notification("Marshmallows", "Candies for us", "4 hours ago", R.drawable.eye_icon));
        receivedNotifications.add(new Notification("Yogurt Cherry", "Milk & co", "1 day ago", R.drawable.hands_icon));
        receivedNotifications.add(new Notification("Mayan Drink", "Energy inc.", "1 week ago", R.drawable.hands_icon));
        receivedNotifications.add(new Notification("Lakewood Drink", "Drink corp", "2 months ago", R.drawable.eye_icon));
        return receivedNotifications;
    }
    private List<Notification> createSentBaseList()
    {
        List<Notification> sentNotifications;
        sentNotifications = new ArrayList<Notification>();
        sentNotifications.add(new Notification("Pizza dough", "Supplier 1", "1 hour ago", 1));
        sentNotifications.add(new Notification("Tomatoes", "Supplier 2", "3 hours ago", 1));
        sentNotifications.add(new Notification("Mushrooms", "Supplier 3", "4 days ago", 1));
        sentNotifications.add(new Notification("Ham", "Supplier 4", "1 week ago", 1));
        sentNotifications.add(new Notification("Pizza box", "Supplier 5", "1 month ago", 1));
        return sentNotifications;
    }

    public List<Notification> getReceivedNotifications() {
        GlobalVariable appState = ((GlobalVariable)this.applicationContext);
        List<Notification> allNotifications = appState.getReceivedNotificationsState();

        return allNotifications;
    }

    public void setReceivedNotifications(List<Notification> receivedNotifications) {
        GlobalVariable appState = ((GlobalVariable)this.applicationContext);
        appState.setReceivedNotificationsState(receivedNotifications);
    }

    public List<Notification> getSentNotifications() {
        GlobalVariable appState = ((GlobalVariable)this.applicationContext);
        return appState.getSentNotificationsState();
    }

    public void setRsentNotifications(List<Notification> sentNotifications) {
        GlobalVariable appState = ((GlobalVariable)this.applicationContext);
        appState.setSentNotificationsState(sentNotifications);
    }

    public void fulFilReceivedNotification(int position)
    {
        GlobalVariable appState = ((GlobalVariable)this.applicationContext);

        List<Notification> notifs = appState.getSentNotificationsState();
        Notification toBeFulfilled = notifs.get(position);
        toBeFulfilled.setWasFulfilled(true);
        appState.setReceivedNotificationsState(notifs);
    }
}

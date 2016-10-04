package com.transparency_one;

import android.app.Application;

import com.transparency_one.DTOs.Notification;

import java.util.List;

/**
 * Created by Simon.Budin on 30/09/2016.
 */

public class GlobalVariable extends Application
{
    private List<Notification> receivedNotifications;
    private List<Notification> sentNotifications;

    public List<Notification> getReceivedNotificationsState()
    {
        return receivedNotifications;
    }

    public void setReceivedNotificationsState(List<Notification> notifications)
    {
        receivedNotifications = notifications;
    }

    public List<Notification> getSentNotificationsState()
    {
        return sentNotifications;
    }

    public void setSentNotificationsState(List<Notification> notifications)
    {
        sentNotifications = notifications;
    }
}
package com.flipfit.business;

public class WaitingListImpl implements WaitingList {
    public void addUserToWaitingList(int userId, int waitingListId) {
        System.out.println("User added to waiting list successfully");
    }
    
    public void removeFromWaitingList(int userId, int waitingListId) {
        System.out.println("User removed from waiting list successfully");
    }
}

package com.flipfit.business;

public interface WaitingList {
    public void addUserToWaitingList(int userId, int waitingListId);
    public void removeFromWaitingList(int userId, int waitingListId);
}

package com.flipfit.bean;

import java.util.Queue;

public class WaitingList {
    public Long waitListId;
    public Queue<Integer> waitingList;
    
    public Long getWaitListId() {
        return waitListId;
    }
    
    public void setWaitListId(Long waitListId) {
        this.waitListId = waitListId;
    }
    
    public Queue<Integer> getWaitingList() {
        return waitingList;
    }
    
    public void setWaitingList(Queue<Integer> waitingList) {
        this.waitingList = waitingList;
    }
}

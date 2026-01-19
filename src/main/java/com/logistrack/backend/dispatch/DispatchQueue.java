package com.logistrack.backend.dispatch;

import com.logistrack.domain.Parcel;
import java.util.ArrayDeque;
import java.util.Queue;

public class DispatchQueue {

    private final Queue<Parcel> queue = new ArrayDeque<>();

    public void enqueue(Parcel parcel) {
        queue.offer(parcel);
    }

    public Parcel dispatch() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }
}

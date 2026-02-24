package com.logistrack.backend.sorting;

import com.logistrack.domain.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ParcelSorter {

    private final PriorityQueue<Parcel> queue = new PriorityQueue<>(new ParcelPriorityComparator());

    public void accept(Parcel parcel) {
        queue.offer(parcel);
    }

    public Parcel next() {
        return queue.poll();
    }

    public int pendingCount() {
        return queue.size();
    }

    public List<Parcel> getPendingParcels() {
        List<Parcel> sorted = new ArrayList<>(queue);
        sorted.sort(new ParcelPriorityComparator());
        return Collections.unmodifiableList(sorted);
    }
}

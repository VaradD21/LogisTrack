package com.logistrack.backend.sorting;

import com.logistrack.domain.Parcel;
import java.util.Comparator;
import com.logistrack.domain.Parcel.Priority;

public class ParcelPriorityComparator implements Comparator<Parcel> {

    @Override
    public int compare(Parcel p1, Parcel p2) {

        int r1 = rank(p1.getPriority());
        int r2 = rank(p2.getPriority());

        if (r1 != r2) {
            return Integer.compare(r2, r1); // higher priority first
        }

        return Double.compare(p1.getWeight(), p2.getWeight());
    }

    private int rank(Priority priority) {
        switch (priority) {
            case URGENT:
                return 3;
            case EXPRESS:
                return 2;
            case NORMAL:
                return 1;
            default:
                return 0;
        }
    }
}

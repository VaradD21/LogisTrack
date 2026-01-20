package com.logistrack.service;

import com.logistrack.backend.sorting.ParcelSorter;
import com.logistrack.backend.dispatch.DispatchQueue;
import com.logistrack.domain.Parcel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ParcelService {

    private final ParcelSorter sorter = new ParcelSorter();
    private final Map<String, DispatchQueue> dispatchQueues = new HashMap<>();

    public void acceptParcel(Parcel parcel) {
        sorter.accept(parcel);
    }

    public void sortNextParcel() {
        Parcel parcel = sorter.next();
        if (parcel == null) return;

        parcel.markSorted();

        dispatchQueues
                .computeIfAbsent(parcel.getDestinationZone(),
                        z -> new DispatchQueue())
                .enqueue(parcel);
    }

    public Map<String, DispatchQueue> getAllDispatchQueues() {
        return dispatchQueues;
    }
}

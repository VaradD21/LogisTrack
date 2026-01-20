package com.logistrack.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "parcels")
public class Parcel {

    @Id
    @Column(nullable = false, unique = true)
    private final String parcelId;

    @Column(nullable = false)
    private final String source;

    @Column(nullable = false)
    private final String destination;

    @Column(nullable = false)
    private final double weight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private final Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Priority {
        URGENT,
        EXPRESS,
        NORMAL
       // SCHEDULED
    }

    public enum Status {
        RECEIVED,
        SORTED,
        DISPATCHED
        //PENDING
    }

    public Parcel(String parcelId,
            String sourceHub,
            String destinationZone,
            double weight,
            Priority priority) {
        this.parcelId = parcelId;
        this.source = sourceHub;
        this.destination = destinationZone;
        this.weight = weight;
        this.priority = priority;
        this.status = Status.RECEIVED;
    }

    public String getParcelId() {
        return parcelId;
    }

    public String getDestinationZone() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public double getWeight() {
        return weight;
    }

    public Parcel.Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void markSorted() {
        this.status = Status.SORTED;
    }

    public void markDispatched() {
        this.status = Status.DISPATCHED;
    }
}

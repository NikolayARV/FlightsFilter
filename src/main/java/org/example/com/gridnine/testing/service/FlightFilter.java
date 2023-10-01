package org.example.com.gridnine.testing.service;

import org.example.com.gridnine.testing.model.Flight;
import org.example.com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilter {
    public static List<Flight> checkDepInThePast(List<Flight> flights) {
        List<Flight> sortedFlights = new ArrayList<>();
        for (Flight flight : flights) {
            sortedFlights.add(checkDepInThePast(flight));
        }
        return sortedFlights;
    }


    public static List<Flight> checkDepIsBeforeArrives(List<Flight> flights) {
        List<Flight> sortedFlights = new ArrayList<>();
        for (Flight flight : flights) {
            sortedFlights.add(checkDepIsBeforeArrives(flight));
        }
        return sortedFlights;
    }


    public static List<Flight> checkFlightWithMoreThanTwoHoursGroundTime(List<Flight> flights) {
        List<Flight> sortedFlights = new ArrayList<>();
        for (Flight flight : flights) {
            sortedFlights.add(checkFlightWithMoreThanTwoHoursGroundTime(flight));
        }
        return sortedFlights;
    }

    public static Flight checkDepInThePast(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (!checkSegmentDepInThePast(segment)) {
                return null;
            }
        }
        return flight;
    }
    public static Flight checkDepIsBeforeArrives(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (!checkDepIsBeforeArrives(segment)) {
                return null;
            }
        }
        return flight;
    }
    public static Flight checkFlightWithMoreThanTwoHoursGroundTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (int i = 0; i<(segments.size()-1); i++) {
            if (segments.get(i).getArrivalDate().plusHours(2).isBefore(segments.get(i+1).getDepartureDate())) {
                return null;
            }
        }
        return flight;
    }

    public static boolean checkSegmentDepInThePast(Segment segment) {
        return segment.getDepartureDate().isAfter(LocalDateTime.now());
    }


    public static boolean checkDepIsBeforeArrives(Segment segment) {
        return segment.getDepartureDate().isBefore(segment.getArrivalDate());
    }

}

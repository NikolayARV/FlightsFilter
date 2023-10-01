package org.example;

import org.example.com.gridnine.testing.model.Flight;
import org.example.com.gridnine.testing.service.FlightBuilder;
import org.example.com.gridnine.testing.service.FlightFilter;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        // Получаем тестовый набор полетов
        System.out.println(flights);

        //Получаем набот полетов, из которого исключены полеты с вылетами до текущего времени

        System.out.println(FlightFilter.checkDepInThePast(flights));

        //Получаем набот полетов, из которого исключены полеты, где
        //имеются сегменты с датой прилёта раньше даты вылета

        System.out.println(FlightFilter.checkDepIsBeforeArrives(flights));

        //Получаем набот полетов, из которого исключены полеты, где
        //общее время, проведённое на земле превышает два часа

        System.out.println(FlightFilter.checkFlightWithMoreThanTwoHoursGroundTime(flights));
        }
    }


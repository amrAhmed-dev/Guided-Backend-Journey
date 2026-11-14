package com.example.repository;

import com.example.entity.Fare;
import com.example.entity.TicketCategory;

import java.util.List;

public class FareDataBase {
    public static final List<Fare> database = List.of(
            new Fare(
                    101,
                    TicketCategory.STANDARD,
                    12,
                    45,
                    24.50,
                    true
            ),
            new Fare(
                    102,
                    TicketCategory.ECONOMY,
                    5,
                    88,
                    120.00,
                    true
            ),
            new Fare(
                    103,
                    TicketCategory.ECONOMY,
                    67,
                    12,
                    15.75,
                    false
           ),
            new Fare(
                    104,
                    TicketCategory.ECONOMY,
                    34,
                    76,
                    85.50,
                    true
           ),
            new Fare(
                    105,
                    TicketCategory.STANDARD,
                    91,
                    23,
                    32.00,
                    true
                )
    );
}

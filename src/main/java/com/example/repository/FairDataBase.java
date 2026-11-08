package com.example.repository;

import com.example.entity.Fair;
import com.example.entity.TicketCategory;

import java.util.List;

public class FairDataBase {
    public static final List<Fair> database = List.of(
            new Fair(
                    101,
                    TicketCategory.STANDARD,
                    12,
                    45,
                    24.50,
                    true
            ),
            new Fair(
                    102,
                    TicketCategory.ECONOMY,
                    5,
                    88,
                    120.00,
                    true
            ),
            new Fair(
                    103,
                    TicketCategory.ECONOMY,
                    67,
                    12,
                    15.75,
                    false
           ),
            new Fair(
                    104,
                    TicketCategory.ECONOMY,
                    34,
                    76,
                    85.50,
                    true
           ),
            new Fair(
                    105,
                    TicketCategory.STANDARD,
                    91,
                    23,
                    32.00,
                    true
                )
    );
}

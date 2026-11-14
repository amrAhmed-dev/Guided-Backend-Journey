package com.example.repository;

import com.example.entity.TicketCategory;
import com.example.entity.TicketEntity;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketsDataBase {
    public static  List<TicketEntity> database = new ArrayList<>();
    static {
        Collections.addAll(database,
                new TicketEntity(
                        1,
                        TicketCategory.VIP,
                        "Cairo",
                        "Alexandria",
                        750.00,
                        true,
                        "Mohamed Ahmed",
                        "QR-A1B2C3D4",
                        LocalDateTime.now()
                ),
                new TicketEntity(
                        2,
                        TicketCategory.ECONOMY,
                        "Cairo",
                        "Luxor",
                        450.50,
                        true,
                        "Maryam Khaled",
                        "QR-E5F6G7H8",
                        LocalDateTime.now()
                ),
                new TicketEntity(
                        3,
                        TicketCategory.ECONOMY,
                        "Giza",
                        "Aswan",
                        250.00,
                        false,
                        "Ahmed Ali",
                        "QR-I9J0K1L2",
                        LocalDateTime.now()
                ),
                new TicketEntity(
                        4,
                        TicketCategory.STANDARD,
                        "Alexandria",
                        "Hurghada",
                        380.00,
                        true,
                        "Fatma Saeed",
                        "QR-M3N4O5P6",
                        LocalDateTime.now()
                ),
                new TicketEntity(
                        5,
                        TicketCategory.VIP,
                        "Mansoura",
                        "Cairo",
                        600.00,
                        true,
                        "Youssef Mahmoud",
                        "QR-Q7R8S9T0",
                        LocalDateTime.now()
                )
        );
    }

}

package org.example.practice_1.repositories;

import org.example.practice_1.entities.Seat;
import org.example.practice_1.entities.SeatRow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRowRepository extends JpaRepository<SeatRow, Long> {
    List<SeatRow> findSeatRowById(long kw);
}

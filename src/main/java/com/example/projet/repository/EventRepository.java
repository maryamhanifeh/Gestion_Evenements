package com.example.projet.repository;

import com.example.projet.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // جستجو بر اساس عنوان رویداد
    List<Event> findByTitleContaining(String keyword);

    //  جستجو بر اساس تاریخ


    // EventRepository
    List<Event> findByStartDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);


    //  جستجو بر اساس مکان
    List<Event> findByLocationContaining(String location);
}

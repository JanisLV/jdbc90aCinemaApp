package lv.sdacademy.app.repository;

import lv.sdacademy.app.domain.Movie;
import lv.sdacademy.app.domain.Schedule;
import lv.sdacademy.app.utils.HibernateUtils;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

import static lv.sdacademy.app.utils.DateTimeUtils.convertFrom;

public class MovieRepository extends AbstractHibernateRepository<Movie, Integer> {
    public List<Movie> findAll() {
        return findAll(Movie.class);
    }

    public Movie findById(Integer id) {
        return findById(Movie.class, id);
    }

    public List<Movie> findRunningOn(LocalDate date) {
        return HibernateUtils.doInTransactionWithResult(session -> {
            LocalDateTime fromTime = LocalDateTime.of(date, LocalTime.MIDNIGHT);
            LocalDateTime tillTime = fromTime.plusDays(1);

            String scheduleHql = "select s from Schedule s join fetch s.movie where s.startTime > :fromTime and s.startTime < :tillTime";

            List<Schedule> schedules = session.createQuery(scheduleHql, Schedule.class)
                    .setParameter("fromTime", fromTime)
                    .setParameter("tillTime", tillTime)
                    .getResultList();

            return schedules.stream().map(schedule -> schedule.getMovie()).collect(Collectors.toList());

        });
    }
}

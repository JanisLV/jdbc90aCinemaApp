package lv.sdacademy.app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @Column(name = "scheduleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "startTime")
    private ZonedDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    public Integer getId() {
        return id;
    }

    public Schedule setId(Integer id) {
        this.id = id;
        return this;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public Schedule setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public Movie getMovie() {
        return movie;
    }

    public Schedule setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }
}

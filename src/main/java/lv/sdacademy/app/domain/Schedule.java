package lv.sdacademy.app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @Column(name = "scheduleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "startTime")
    private LocalDateTime startTime;

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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Schedule setStartTime(LocalDateTime startTime) {
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

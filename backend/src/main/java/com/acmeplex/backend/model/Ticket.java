import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
public class Ticket {
    private Integer id;
    private LocalDateTime purchaseDate;
    private boolean isCancelled;
    private LocalDateTime cancellationDate;

    @ManyToOne
    private User user;

    @OneToOne
    private Seat seat;

    // more getters and setters, constructor
}
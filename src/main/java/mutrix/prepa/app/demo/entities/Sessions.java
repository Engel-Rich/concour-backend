package mutrix.prepa.app.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mutrix.prepa.app.demo.enums.ActiveStatus;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Sessions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sessions {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    // @Column(name = "bg_color", nullable = false)
    // private String bgColor;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    ActiveStatus isActive;

    @ManyToOne
    @JoinColumn(name = "concours_id", nullable = false)
    private Concours concours;


    @JsonIgnore
    @OneToMany(mappedBy = "sessions", cascade = CascadeType.ALL)
    private List<Abonnements> abonnement;


    @Column(name = "photo_url")
    private  String photoUrl;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }



}

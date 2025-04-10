package mutrix.prepa.app.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mutrix.prepa.app.demo.enums.ActiveStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Cours")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Cours {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "bg_color", nullable = false)
    private String bgColor;

    @Column(name = "video_url", nullable = false)
    private String videoUrl;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    @Column(name = "is_active", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActiveStatus isActive;

    @ManyToOne
    @JoinColumn(name = "matiere_id", nullable = false)
    private Matieres matiere;

    @OneToMany (mappedBy = "cours", cascade = CascadeType.ALL)
    private List<Questions> questions;


    @PostPersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}

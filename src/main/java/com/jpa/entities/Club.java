package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name="coach_id")
    private Coach coach;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player> players;

    @ManyToOne(targetEntity = BasketballAssociation.class)
    private BasketballAssociation basketballAssociation;

    @ManyToMany(targetEntity = BasketballCompetition.class, fetch = FetchType.LAZY)
    @JoinTable(name="club_competition", joinColumns = @JoinColumn(name="club_id"), inverseJoinColumns = @JoinColumn(name ="competition_id"))
    private List<BasketballCompetition> basketballCompetitions;
}

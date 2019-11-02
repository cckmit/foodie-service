package com.foodie.portal.favourite.repository;

import com.foodie.portal.favourite.FavouriteType;
import com.foodie.portal.user.model.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "foodie_favourite")
public class FavouriteEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id;
    private String objectId;
    private User user;
    private FavouriteType type;
    private Instant createdAt;
}

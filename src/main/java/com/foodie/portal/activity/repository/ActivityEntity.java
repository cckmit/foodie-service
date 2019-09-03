package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.model.ActivityDateTime;
import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.city.repository.CityEntity;
import com.foodie.portal.user.repository.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "foodie_activity")
public class ActivityEntity {
    @Id
    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String category;
    private String duration;
    @Column(name = "maxPeopleCount")
    private String maxPeopleLimit;
    private String images;
    private String language;
    private String address;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private CityEntity city;
    @Column(columnDefinition = "text")
    @Convert(converter = PriceListConverter.class)
    private List<ActivityPrice> priceList;
    @Column(columnDefinition = "text")
    @Convert(converter = ServiceTimeConverter.class)
    private List<ActivityDateTime> serviceTime;
    @Enumerated(EnumType.STRING)
    private ActivityStatus status;
    @Enumerated(EnumType.STRING)
    private ActivityType type;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private MerchantEntity merchant;
}

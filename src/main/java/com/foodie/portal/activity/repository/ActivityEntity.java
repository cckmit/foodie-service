package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.model.ActivityPrice;
import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.city.repository.CityEntity;
import com.foodie.portal.user.repository.MerchantEntity;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
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
    private String duration;
    @Column(name = "maxPeopleCount")
    private String maxPeopleLimit;
    private String images;
    private String language;
    private String area;
    private String address;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private CityEntity city;
    @Column(columnDefinition = "text")
    @Convert(converter = PriceListConverter.class)
    private List<ActivityPrice> priceList;
    @Column(columnDefinition = "text")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "activityId")
    private List<ServiceSchedulingEntity> serviceSchedulingList;
    @Enumerated(EnumType.STRING)
    private ActivityStatus status;
    @Enumerated(EnumType.STRING)
    private ActivityType type;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private MerchantEntity merchant;
    private Long sort;
    private Instant createdAt;
}

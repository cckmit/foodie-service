package com.foodie.portal.webmanage.repository;

import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "foodie_activity")
public class ActivityRecommendEntity {
    @Id
    private String id;
    private String title;
    private String subTitle;
    private String description;
    private String images;
    private ActivityStatus status;
    private ActivityType type;
    private String merchantName;
    private boolean interestedRecommend;
    private boolean topRecommend;
}

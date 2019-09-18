package com.foodie.portal.webmanage.repository;

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
@Table(name = "foodie_recommend")
@IdClass(RecommendId.class)
@AllArgsConstructor
@NoArgsConstructor
public class RecommendEntity {
    /**
     * 推荐的活动、城市等ID
     */
    @Id
    private String id;
    @Id
    @Enumerated(EnumType.STRING)
    private RecommendType type;


}

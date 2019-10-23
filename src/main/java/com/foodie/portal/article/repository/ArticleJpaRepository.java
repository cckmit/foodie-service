package com.foodie.portal.article.repository;

import com.foodie.portal.article.ArticleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, String> {

    List<ArticleEntity> findByIdIn(List<String> ids);

    Page<ArticleEntity> findByCityIdAndType(String cityId, ArticleType type, Pageable pageable);

    Page<ArticleEntity> findByCityId(String cityId, Pageable pageable);
}

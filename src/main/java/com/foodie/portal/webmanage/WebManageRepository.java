package com.foodie.portal.webmanage;

import com.foodie.portal.webmanage.model.Banner;
import com.foodie.portal.webmanage.repository.BannerEntityMapper;
import com.foodie.portal.webmanage.repository.BannerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WebManageRepository {

    @Autowired
    private BannerJpaRepository bannerJpaRepository;
    private BannerEntityMapper bannerEntityMapper = BannerEntityMapper.instance;

    public void addBanner(Banner banner) {
        bannerJpaRepository.save(bannerEntityMapper.from(banner));
    }

    public void removeBanner(String bannerId) {
        bannerJpaRepository.deleteById(bannerId);
    }

    public List<Banner> findAllBanners() {
        return bannerEntityMapper.to(bannerJpaRepository.findAll());
    }
}

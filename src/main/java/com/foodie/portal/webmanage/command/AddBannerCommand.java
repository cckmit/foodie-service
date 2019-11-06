package com.foodie.portal.webmanage.command;

import lombok.Data;

@Data
public class AddBannerCommand {

    private String url;
    private String title;
    private String subTitle;
    private String link;

}

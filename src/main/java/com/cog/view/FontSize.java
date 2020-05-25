package com.cog.view;

public enum FontSize {
    SMALL("/view/css/fontSmall.css"),
    MEDIUM("/view/css/fontMedium.css"),
    BIG("/view/css/fontBig.css");

    private String cssPath;

    FontSize(String cssPath) {
        this.cssPath = cssPath;
    }

    public String getCSSPath() {
        return cssPath;
    }
}

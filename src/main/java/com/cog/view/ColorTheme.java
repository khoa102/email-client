package com.cog.view;

public enum ColorTheme {
    LIGHT("/view/css/themeLight.css"),
    DEFAULT("/view/css/themeDefault.css"),
    DARK("/view/css/themeDark.css");

    private String cssPath;
    ColorTheme(String cssPath) {
        this.cssPath = cssPath;
    }

    public String getCSSPath() {
        return this.cssPath;
    }
}

package com.sdr.carousel.model;

public class Slide {

    long id = 0;
    String title = null;
    String link = null;
    String imageUrl = null;
    String desc = null;
    String timeMillis = null;
    int order = 0;

    public Slide() {
    }

    public Slide(String id, String title, String link, String imageUrl, String desc, String timeMillis, int order) {

        id = id.replaceAll("slides_", "");
        id = id.substring(0, id.indexOf("_"));

        this.id = Long.parseLong(id);
        this.title = title;
        this.link = link;
        this.imageUrl = imageUrl;
        this.timeMillis = timeMillis;
        this.desc = desc;
        this.order = order;
    }

    public String getTimeMillis() {

        return timeMillis;
    }

    public void setTimeMillis(String timeMillis) {

        this.timeMillis = timeMillis;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public int getOrder() {

        return order;
    }

    public void setOrder(int order) {

        this.order = order;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getLink() {

        return link;
    }

    public void setLink(String link) {

        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
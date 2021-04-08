package com.harshit.wallpaperdownloader;

class ImageList {

    String id;
    String previewUrl;
    String webUrl;
    String largeUrl;
    String imageSize;
    String likes;
    String download;
    String views;
    String favorites;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public ImageList(String id, String previewUrl, String webUrl, String largeUrl, String imageSize, String likes, String download, String views, String favorites) {
        this.id = id;
        this.previewUrl = previewUrl;
        this.webUrl = webUrl;
        this.largeUrl = largeUrl;
        this.imageSize = imageSize;
        this.likes = likes;
        this.download = download;
        this.views = views;
        this.favorites = favorites;
    }
}

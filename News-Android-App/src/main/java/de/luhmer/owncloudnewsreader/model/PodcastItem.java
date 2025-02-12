package de.luhmer.owncloudnewsreader.model;

/**
 * Created by David on 21.06.2014.
 */
public class PodcastItem extends MediaItem {

    public PodcastItem() {

    }

    public PodcastItem(long itemId, String title, String link, String mimeType, boolean offlineCached, String favIcon, boolean isVideoPodcast) {
        this.itemId = itemId;
        this.title = title;
        this.link = link;
        this.mimeType = mimeType;
        this.offlineCached = offlineCached;
        this.favIcon = favIcon;
        this.isVideoPodcast = isVideoPodcast;
    }

    public String mimeType;
    public boolean offlineCached;
    public boolean isVideoPodcast;

    public Integer downloadProgress;

    public static Integer DOWNLOAD_COMPLETED = -1;
    public static Integer DOWNLOAD_NOT_STARTED = -2;
}

package me.seokju.dddstudy.catalog.domain.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image {
    protected InternalImage() {
    }

    public InternalImage(String path) {
        super(path);
    }

    @Override
    public String getUrl() {
        return "/images/original/" + getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return true;
    }

    @Override
    public String getThumbnailUrl() {
        return "/images/thumbnail/" + getPath();
    }
}

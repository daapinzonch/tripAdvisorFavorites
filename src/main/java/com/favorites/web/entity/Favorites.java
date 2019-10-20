package com.favorites.web.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Document(collection = "Favorites")
@Data


public class Favorites implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotBlank
    private String clientId;

    @NotBlank
    private String postId;

    private String updateDate;

    @NotNull
    private boolean stateFavorite;

    public Favorites() {
    }

    public Favorites(String id, @NotBlank String clientId, @NotBlank String providerId, String updateDate, boolean stateFavorite) {
        this.id = id;
        this.clientId = clientId;
        this.postId = providerId;
        this.updateDate = updateDate;
        this.stateFavorite = stateFavorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isStateFavorite() {
        return stateFavorite;
    }

    public void setStateFavorite(boolean stateFavorite) {
        this.stateFavorite = stateFavorite;
    }
}

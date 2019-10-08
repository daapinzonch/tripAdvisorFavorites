package com.favorites.web.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "Favorites")
@Data


public class Favorites implements Serializable {
    @Id
    @NotNull
    private long id;

    @NotBlank
    private String clientId;

    @NotBlank
    private String providerId;

    private String updateDate;

    @NotNull
    private boolean stateFavorite;

    public Favorites() {
    }

    public Favorites(long id, @NotBlank String clientId, @NotBlank String providerId, String updateDate, boolean stateFavorite) {
        this.id = id;
        this.clientId = clientId;
        this.providerId = providerId;
        this.updateDate = updateDate;
        this.stateFavorite = stateFavorite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
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

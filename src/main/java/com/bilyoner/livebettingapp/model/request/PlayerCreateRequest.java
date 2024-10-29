package com.bilyoner.livebettingapp.model.request;

import com.bilyoner.livebettingapp.model.entity.Player;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static com.bilyoner.livebettingapp.model.entity.Player.PlayerBuilder.aPlayer;


public class PlayerCreateRequest {
    private String name;
    private String surname;

    public Player toPlayer() {
        return aPlayer()
                .name(name)
                .surname(surname)
                .build();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PlayerCreateRequest that = (PlayerCreateRequest) o;

        return new EqualsBuilder().append(getName(), that.getName()).append(getSurname(), that.getSurname()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getName()).append(getSurname()).toHashCode();
    }

    public static final class PlayerCreateRequestBuilder {
        private String name;
        private String surname;

        private PlayerCreateRequestBuilder() {
        }

        public static PlayerCreateRequestBuilder aPlayerCreateRequest() {
            return new PlayerCreateRequestBuilder();
        }

        public PlayerCreateRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerCreateRequestBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public PlayerCreateRequest build() {
            PlayerCreateRequest playerCreateRequest = new PlayerCreateRequest();
            playerCreateRequest.setName(name);
            playerCreateRequest.setSurname(surname);
            return playerCreateRequest;
        }
    }
}

package com.bilyoner.livebettingapp.model.response;

import com.bilyoner.livebettingapp.model.entity.Player;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static com.bilyoner.livebettingapp.model.response.PlayerCreateResponse.PlayerCreateResponseBuilder.aPlayerCreateResponse;


public class PlayerCreateResponse {

    private Long id;
    private String name;
    private String surname;
    private float accountBalance;

    public static PlayerCreateResponse createFrom(Player player) {
        return aPlayerCreateResponse()
                .id(player.getId())
                .name(player.getName())
                .surname(player.getSurname())
                .accountBalance(player.getAccountBalance())
                .build();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PlayerCreateResponse that = (PlayerCreateResponse) o;

        return new EqualsBuilder().append(getAccountBalance(), that.getAccountBalance()).append(getId(), that.getId()).append(getName(), that.getName()).append(getSurname(), that.getSurname()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getName()).append(getSurname()).append(getAccountBalance()).toHashCode();
    }


    public static final class PlayerCreateResponseBuilder {
        private Long id;
        private String name;
        private String surname;
        private float accountBalance;

        private PlayerCreateResponseBuilder() {
        }

        public static PlayerCreateResponseBuilder aPlayerCreateResponse() {
            return new PlayerCreateResponseBuilder();
        }

        public PlayerCreateResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PlayerCreateResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerCreateResponseBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public PlayerCreateResponseBuilder accountBalance(float accountBalance) {
            this.accountBalance = accountBalance;
            return this;
        }

        public PlayerCreateResponse build() {
            PlayerCreateResponse playerCreateResponse = new PlayerCreateResponse();
            playerCreateResponse.setId(id);
            playerCreateResponse.setName(name);
            playerCreateResponse.setSurname(surname);
            playerCreateResponse.setAccountBalance(accountBalance);
            return playerCreateResponse;
        }
    }
}

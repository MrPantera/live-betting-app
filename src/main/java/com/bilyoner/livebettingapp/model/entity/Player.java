package com.bilyoner.livebettingapp.model.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "account_balance")
    private float accountBalance;

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

        Player player = (Player) o;

        return new EqualsBuilder().append(getId(), player.getId()).append(getName(), player.getName()).append(getSurname(), player.getSurname()).append(getAccountBalance(), player.getAccountBalance()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getName()).append(getSurname()).append(getAccountBalance()).toHashCode();
    }

    public static final class PlayerBuilder {
        private Long id;
        private String name;
        private String surname;
        private float accountBalance;

        public PlayerBuilder() {
        }

        public static PlayerBuilder aPlayer() {
            return new PlayerBuilder();
        }

        public PlayerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public PlayerBuilder accountBalance(float accountBalance) {
            this.accountBalance = accountBalance;
            return this;
        }

        public Player build() {
            Player Match = new Player();
            Match.setId(id);
            Match.setName(name);
            Match.setSurname(surname);
            Match.setAccountBalance(accountBalance);

            return Match;
        }
    }
}
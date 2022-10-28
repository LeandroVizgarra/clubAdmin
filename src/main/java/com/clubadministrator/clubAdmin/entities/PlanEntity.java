package com.clubadministrator.clubAdmin.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Long price;
    @OneToMany
    private Set<ClientEntity> clientEntitySet;

    public void addClient2Plan(ClientEntity client){
        this.clientEntitySet.add(client);
        client.setPlan(this);
    }
}

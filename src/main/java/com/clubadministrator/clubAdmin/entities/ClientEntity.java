package com.clubadministrator.clubAdmin.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Clients")
@SQLDelete(sql = "UPDATE clients SET isActive = false WHERE id=?")
@Where(clause = "isActive = true")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private Date startDate;
    private Date activeUntilDate;
    private Boolean isActive = Boolean.TRUE;
    @ManyToOne
    @JoinColumn(name="plan_id",insertable = false,updatable = false)
    private PlanEntity plan;


}

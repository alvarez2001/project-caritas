package org.caritas.caritas.project.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import org.caritas.caritas.project.domain.enumeration.Status;
import org.caritas.caritas.project.domain.enumeration.TypeMoney;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import org.caritas.caritas.face.domain.model.Face;
import org.caritas.caritas.item.domain.model.Item;

@Entity
@Table(name = "projects")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = true)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_money", nullable = false)
    private TypeMoney typeMoney;

    @Column(name = "available")
    private Float available;

    @Column(name = "request", nullable = false)
    private Float request;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "project")
    private List<Item> items;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "project")
    private List<Face> faces;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}

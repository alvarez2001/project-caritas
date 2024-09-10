package org.caritas.caritas.spent.domain.model;

import java.time.LocalDateTime;

import org.caritas.caritas.face.domain.model.Face;
import org.caritas.caritas.item.domain.model.Item;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "spends")
@Data
public class Spent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = true)
    private String code;

    @Column(name = "amount", nullable = false)
    private Float amount;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "quantity", nullable = false)
    private Float quantity;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "face_id", nullable = false)
    private Long faceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "face_id", insertable = false, updatable = false)
    private Face face;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}

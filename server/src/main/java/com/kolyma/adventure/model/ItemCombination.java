package com.kolyma.adventure.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item_combinations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCombination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource1_id", nullable = false)
    private Resource resource1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource2_id", nullable = false)
    private Resource resource2;

    @Column(name = "result_item", nullable = false)
    private String resultItem;

    @Column(name = "image_items")
    private String imageItems;
}
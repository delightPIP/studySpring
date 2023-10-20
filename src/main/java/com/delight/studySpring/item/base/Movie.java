package com.delight.studySpring.item.base;

import com.delight.studySpring.item.entity.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Entity
@Getter
@Setter
@DiscriminatorValue("M")
public class Movie extends Item {
    private String director;
    private String actor;
}


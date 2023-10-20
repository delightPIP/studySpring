package com.delight.studySpring.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by delightPIP on 2023/10/20.
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private int count;
    private T data;
}

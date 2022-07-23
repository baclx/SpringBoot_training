package com.example.springboot2.dto;

import lombok.Data;

@Data
public class SubjectCountBySem {
    private int sem;
    private long quantity;

    public SubjectCountBySem(int sem, long quantity) {
        this.sem = sem;
        this.quantity = quantity;
    }
}

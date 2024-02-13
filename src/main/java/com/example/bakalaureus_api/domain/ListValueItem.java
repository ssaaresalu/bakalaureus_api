package com.example.bakalaureus_api.domain;

import lombok.Data;

@Data
public class ListValueItem {
    String label;
    Double value;

    public ListValueItem(String label, Double value) {
        this.label = label;
        this.value = value;
    }
}

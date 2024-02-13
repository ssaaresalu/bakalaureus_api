package com.example.bakalaureus_api.domain;

import lombok.Data;

import java.util.List;

@Data
public class ListDTO {
    String listName;
    List<ListValueItem> emissionFactors;
}

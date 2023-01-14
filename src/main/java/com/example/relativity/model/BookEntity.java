package com.example.relativity.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Container(containerName = "books")
public class BookEntity {
    @Id
    @GeneratedValue
    private String id;
    private String title;
    private String author;
    private String isbn;
    private String description;

    @Reference
    private List<RatingEntity> ratingEntityList = new ArrayList<>();
}

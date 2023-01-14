package com.example.relativity.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Container
public class RatingEntity {
    @Id
    @GeneratedValue
    private String id;
    private String userId;
    private int rating;

    @Override
    public String toString() {
        return "Rating: " +
                "userId='" + userId + '\'' +
                ", rating=" + rating +
                '}';
    }
}

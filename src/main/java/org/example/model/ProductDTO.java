package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private Coordinates coordinates;
    private int price;
    private String partNumber;
    private UnitOfMeasure unitOfMeasure;
    private Organization manufacturer;

}

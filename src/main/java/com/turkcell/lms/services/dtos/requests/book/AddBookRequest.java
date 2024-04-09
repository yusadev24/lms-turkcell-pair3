package com.turkcell.lms.services.dtos.requests.book;

import com.turkcell.lms.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequest{
    @NotBlank(message = "Kitap ismi boş geçilemez.")
    @Size(min=2, max= 100, message = "Kitap ismi en az 2, en fazla 100 karakter olmalıdır.")
    private String name;
    @NotBlank
    private String author;
    private String publisher;
    private int numberOfPages;
    private List<Integer> categoryIds;
}

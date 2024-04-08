package com.turkcell.lms.services.dtos.requests.book;

import com.turkcell.lms.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookRequest {
    // TODO: category id üzerinden çağrılacak
  //  private List<Category> categories;
    private List<Integer> categoryIds;
}

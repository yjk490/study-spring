package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemEditForm {

    @NotNull
    private Integer id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 100, max = 1000000)
    private Integer price;

    private Integer quantity;


}

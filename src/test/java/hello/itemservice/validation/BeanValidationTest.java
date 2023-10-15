package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.util.Set;

public class BeanValidationTest {

    @Test
    void beanValidation() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Item item = new Item();
        item.setItemName(" "); // 공백
        item.setPrice(0);
        item.setQuantity(10000);

        Set<ConstraintViolation<Item>> violations = validator.validate(item);

        for (ConstraintViolation<Item> violation : violations) {
            System.out.println("violation: " +violation);
            System.out.println("violation.message = " + violation.getMessage());
        }
    }
}

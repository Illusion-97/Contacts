package ad.ya.contacts.generic;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public abstract class BaseDto {
    private long id;
}

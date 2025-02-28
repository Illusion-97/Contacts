package ad.ya.contacts.contact;

import ad.ya.contacts.generic.BaseDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Value
public class ContactDto  extends BaseDto implements Serializable {
    String name;
}

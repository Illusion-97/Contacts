package ad.ya.contacts.contact;

import ad.ya.contacts.generic.BaseDto;
import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link Contact}
 */
@Data
@Accessors(chain = true)
public class ContactDto  extends BaseDto implements Serializable {
    private String name;
    private String number;
    private Adresse adresse;
    private long userId;
}

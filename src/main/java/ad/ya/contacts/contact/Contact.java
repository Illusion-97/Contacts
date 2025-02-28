package ad.ya.contacts.contact;

import ad.ya.contacts.generic.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Contact  extends BaseEntity {
    private String name;
    private String number;
    @Embedded
    private Adresse adresse;
    private long userId;

}

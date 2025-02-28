package ad.ya.contacts.contact;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class Adresse {
    private String ville;
    private String CP;
}

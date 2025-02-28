package ad.ya.contacts.contact;

import ad.ya.contacts.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl
        extends GenericServiceImpl<
        Contact,
        ContactDto,
        ContactRepository,
        ContactMapper
        >
        implements ContactService {
    public ContactServiceImpl(ContactRepository repository, ContactMapper mapper) {
        super(repository, mapper);
    }
}

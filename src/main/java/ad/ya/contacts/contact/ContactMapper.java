package ad.ya.contacts.contact;

import ad.ya.contacts.generic.GenericMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ContactMapper extends GenericMapper<ContactDto,Contact> {
}

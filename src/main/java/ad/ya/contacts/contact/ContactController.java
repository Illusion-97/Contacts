package ad.ya.contacts.contact;

import ad.ya.contacts.auth.UserSecurity;
import ad.ya.contacts.generic.GenericController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts")
public class ContactController extends GenericController<ContactDto,ContactService> {

    public ContactController(ContactService service) {
        super(service);
    }

    @PreAuthorize("isAuthenticated()")
    @Override
    public ResponseEntity<ContactDto> getById(long id) {
        return super.getById(id);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ContactDto> saveOrUpdate(ContactDto dto) {
        dto.setUserId(getUserId());
        return super.saveOrUpdate(dto);
    }

    private long getUserId() {
        return ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}

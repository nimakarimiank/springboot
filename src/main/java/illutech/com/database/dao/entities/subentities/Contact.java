package illutech.com.database.dao.entities.subentities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Contact {

    private String countryCode;
    private String number;
    public Contact(){}
    public Contact(String countryCode,String number,contactType contactType){

        this.contactType=contactType;
        this.countryCode=countryCode;
        this.number=number;
    }

    @Enumerated(EnumType.STRING)
    private contactType contactType;

    public illutech.com.database.dao.entities.subentities.contactType getContactType() {
        return contactType;
    }

    public void setContactType(illutech.com.database.dao.entities.subentities.contactType contactType) {
        this.contactType = contactType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

package io.mahardi.springservisincostumersservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.core.style.ToStringCreator;

@Data
@Entity
@Table(name="cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "date_of_purchase")
    @Temporal(TemporalType.DATE)
    private Date dateOfPurchase;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CarType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private Owner owner;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", this.getId())
            .append("name", this.getName())
            .append("licensePlate", this.getLicensePlate())
            .append("dateOfPurchase", this.getDateOfPurchase())
            .append("type", this.getType().getName())
            .append("ownerFirstname", this.getOwner().getFirstName())
            .append("ownerLastname", this.getOwner().getLastName())
            .toString();
    }
}

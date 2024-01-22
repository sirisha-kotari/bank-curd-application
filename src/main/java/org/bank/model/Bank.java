package org.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Banks")
public class Bank {
    @Id
    @Column(name="IFSC_CODE")
    private String ifscCode;
    @Column(name="BANK_NAME")
    private String bankName;
    @Column(name="LOCATION")
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="FK_IFSC_CODE",referencedColumnName = "IFSC_CODE")
private List<Account> accounts;
}

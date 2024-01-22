package org.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name="ACCOUNT_HOLDER_NAME")
    private String accHolderName;
    @Column(name="PHONE_NUMBER")
    private String phoneNum;
    @Column(name="EMAIL",nullable = false)
    private String email;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="BALANCE")
    private double balance;

}

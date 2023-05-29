package com.bankmisr.irrigationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "plot", schema = "irregrationdb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class plot implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "description")
    private String plotDescription ;

    @Column(name = "plot_number")
    private Integer plotNumber;

    @Column(name = "location")
    private String plotLocation;

}

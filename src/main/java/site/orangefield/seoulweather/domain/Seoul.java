package site.orangefield.seoulweather.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seoul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String msrdt;
    private String msrrgn_nm;
    private String msrste_nm;
    private String pm10;
    private String pm25;
    private String o3;
    private String no2;
    private String co;
    private String so2;
    private String idex_nm;
    private String idex_mvl;
    private String arplt_main;

}

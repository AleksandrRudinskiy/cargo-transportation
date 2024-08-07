package com.cargotrasportation.transport;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transports", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type_id", nullable = false)
    private int type;
    @Column(name = "maintenance_date")
    private LocalDate maintenanceDate; // дата последего техобслуживания
}

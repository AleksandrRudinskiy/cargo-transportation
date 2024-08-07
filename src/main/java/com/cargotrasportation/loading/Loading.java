package com.cargotrasportation.loading;

import com.cargotrasportation.cargo.Cargo;
import com.cargotrasportation.transport.Transport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "loading", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Loading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;
    @ManyToOne
    @JoinColumn(name = "transport_id", nullable = false)
    @ToString.Exclude
    private Transport transport;

}

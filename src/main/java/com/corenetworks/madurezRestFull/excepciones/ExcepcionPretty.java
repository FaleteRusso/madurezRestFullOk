package com.corenetworks.madurezRestFull.excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcepcionPretty {
    private LocalDateTime fecha;
    private String mensaje;
    private String descripcion;

}

package com.example.demo.Controlador;

import com.example.demo.Entidad.Zona;
import com.example.demo.Servicio.ZonaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/zonas")
public class ZonaControlador {

    @Autowired
    private ZonaServicio zonaServicio;

    @PostMapping
    @Operation(summary = "Registrar zona en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "zona creada con exito"),
            @ApiResponse(responseCode = "400", description = "Error en el registro")
    })
    public ResponseEntity<Zona> registrar (@RequestBody Zona datos){
        try {
            Zona zonaRegistrada = zonaServicio.registrar(datos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(zonaRegistrada);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);

        }
    }

    @GetMapping
    @Operation(summary = "Listar zona en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "zona listada"),
            @ApiResponse(responseCode = "400", description = "Error en la busqueda")
    })
    public ResponseEntity<List<Zona>> buscarTodos(){
        try {
            List<Zona> zonas = zonaServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonas);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar zona en la base de datos por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "zona listada"),
            @ApiResponse(responseCode = "400", description = "Error en la busqueda")
    })
    public ResponseEntity<Zona> buscarPorId(@PathVariable Integer id){
        try {
            Zona zonaEncontrada = zonaServicio.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaEncontrada);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }
}

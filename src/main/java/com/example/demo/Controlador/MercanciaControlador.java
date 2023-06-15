package com.example.demo.Controlador;

import com.example.demo.Entidad.Mercancia;
import com.example.demo.Servicio.MercanciaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/mercancias")
@Tag(name = "Servicios mercancias", description = "Servicios que ofrecen CRUD basico en la entidad Mercancia")
public class MercanciaControlador {

    @Autowired
    private MercanciaServicio mercanciaServicio;

    @PostMapping
    @Operation(summary = "Registrar mercancia en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mercancia creada con exito"),
            @ApiResponse(responseCode = "400", description = "Error en el registro")
    })
    public ResponseEntity<Mercancia> registrar (@RequestBody Mercancia datos){
        try {
            Mercancia mercanciaRegistrada = mercanciaServicio.registrar(datos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(mercanciaRegistrada);
        }catch(Exception error){
            String mensaje = "Error al registrar" + error.getMessage();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);

        }
    }

    @GetMapping
    @Operation(summary = "Listar mercancia en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mercancia listada"),
            @ApiResponse(responseCode = "400", description = "Error en la busqueda")
    })
    public ResponseEntity<List<Mercancia>> buscarTodos(){
        try {
            List<Mercancia> mercancias = mercanciaServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancias);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar mercancia en la base de datos por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mercancia listada"),
            @ApiResponse(responseCode = "400", description = "Error en la busqueda")
    })
    public ResponseEntity<Mercancia> buscarPorId(@PathVariable Integer id){
        try {
            Mercancia mercanciaEncontrada = mercanciaServicio.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaEncontrada);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

    @PutMapping(value = "/{id}/actualizar")
    public ResponseEntity<Mercancia> actualizar(@RequestBody Mercancia datos, @PathVariable Integer id){
        try {
            Mercancia mercanciaActualizada = mercanciaServicio.actualizar();
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}

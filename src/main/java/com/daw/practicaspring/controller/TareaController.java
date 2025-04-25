package com.daw.practicaspring.controller;

import com.daw.practicaspring.model.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private List<Tarea> listaTareas = new ArrayList<>();

    public TareaController() {
        listaTareas.add(new Tarea(1, "Aprender Spring Boot", false));
        listaTareas.add(new Tarea(2, "Hacer la práctica de DAW", false));
        listaTareas.add(new Tarea(3, "Ir a Coyoacan y regresar en menos de 2 horas", true));
        listaTareas.add(new Tarea(4, "Comprar cosas en el michiverso", true));
        listaTareas.add(new Tarea(5, "Obsersionarme con el michi taquero", true));
        listaTareas.add(new Tarea(6, "Descansar las patas", false));
    }

    @GetMapping
    public List<Tarea> obtenerTodas() {
        return listaTareas;
    }

    @GetMapping("/{id}")
    public Tarea obtenerPorId(@PathVariable int id) {
        for (Tarea tarea : listaTareas) {
            if (tarea.getId() == id) {
                return tarea;
            }
        }
        return null;
    }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea nuevaTarea) {
        System.out.println("Tarea recibida: " + nuevaTarea);
        listaTareas.add(nuevaTarea);
        return nuevaTarea;
    }


    @DeleteMapping("/{id}")
    public String eliminarTarea(@PathVariable int id) {
        boolean removed = listaTareas.removeIf(t -> t.getId() == id);
        return removed ? "Tarea eliminada correctamente" : "Tarea no encontrada";
    }
}

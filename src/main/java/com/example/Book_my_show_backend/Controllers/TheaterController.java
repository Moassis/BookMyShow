package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.Dtos.TheaterRequestDto;
import com.example.Book_my_show_backend.Models.TheaterEntity;
import com.example.Book_my_show_backend.Service.TheaterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterRequestDto theaterRequestDto) {

        return theaterService.createTheater(theaterRequestDto);

    }

    // Get theaters by theaterId
    @GetMapping("/{id}")
    public TheaterEntity getTheaterById(@PathVariable int id) {
        TheaterEntity theater = theaterService.getTheaterById(id);
        return theater;
    }

    // Get all theaters
    @GetMapping
    public List<TheaterEntity> getAllTheaters() {
        List<TheaterEntity> theaters = theaterService.getAllTheaters();
        return theaters;
    }
}

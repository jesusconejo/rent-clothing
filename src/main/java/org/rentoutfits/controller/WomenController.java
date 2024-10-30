package org.rentoutfits.controller;

import org.rentoutfits.dto.request.WomenDressDTO;
import org.rentoutfits.service.Impl.WomanDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/women")
public class WomenController {
    private final WomanDressService womanDressService;
    @Autowired
    public WomenController(WomanDressService womanDressService) {
        this.womanDressService = womanDressService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveWomenDress(@RequestBody WomenDressDTO womenDress) {
        return womanDressService.saveWomenDress(womenDress);
    }

    @GetMapping("/getWomendressBySize")
    public ResponseEntity<?> getWomenDressBySize(@RequestParam String size) {
        return womanDressService.getWomenDressBySize(size);
    }

}

package org.rentoutfits.controller;

import org.rentoutfits.dto.request.SuitManDTO;
import org.rentoutfits.service.Impl.SuitManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suit")
public class SuitManController {

    private final SuitManService suitManService;
    @Autowired
    public SuitManController(SuitManService suitManService) {
        this.suitManService = suitManService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody SuitManDTO suitMan) {
        return suitManService.save(suitMan);
    }

    @GetMapping("/getSuitManBySize")
    public ResponseEntity<?> getSuitManBySize(@RequestParam String size) {
        return suitManService.getSuitManBySize(size);
    }
}

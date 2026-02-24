package com.logistrack.controller;

import com.logistrack.domain.Parcel;
import com.logistrack.service.ParcelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("queues", parcelService.getAllDispatchQueues());
        model.addAttribute("pendingParcels", parcelService.getPendingParcels());
        model.addAttribute("pendingCount", parcelService.getPendingParcels().size());
        model.addAttribute("dispatchedCount", parcelService.getTotalDispatched());
        model.addAttribute("zoneCount", parcelService.getAllDispatchQueues().size());
        return "index";
    }

    @PostMapping("/add")
    public String addParcel(@RequestParam String id,
            @RequestParam String zone,
            @RequestParam double weight,
            @RequestParam Parcel.Priority priority) {

        Parcel parcel = new Parcel(id, "H1", zone, weight, priority);
        parcelService.acceptParcel(parcel);
        return "redirect:/";
    }

    @PostMapping("/sort")
    public String sortParcel() {
        parcelService.sortNextParcel();
        return "redirect:/";
    }
}

package edu.miu.cs544.eHotelReserve.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs544.eHotelReserve.amqpconfigJava.AmqpConfiguration;
import edu.miu.cs544.eHotelReserve.model.Address;
import edu.miu.cs544.eHotelReserve.model.Booking;
import edu.miu.cs544.eHotelReserve.model.Payment;
import edu.miu.cs544.eHotelReserve.model.Room;
import edu.miu.cs544.eHotelReserve.model.RoomType;
import edu.miu.cs544.eHotelReserve.model.User;
import edu.miu.cs544.eHotelReserve.service.IRoomTypeService;
import edu.miu.cs544.eHotelReserve.service.impl.BookingService;

@RequestMapping("/hotel/admin/roomTypes")
@Controller
public class RoomTypeController {

    @Autowired
    private IRoomTypeService roomTypeService;

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "")
    public ModelAndView manageRoomTypes() {

        ModelAndView modelAndView = new ModelAndView();
        List<RoomType> roomTypes = roomTypeService.findAll();
        modelAndView.addObject("roomTypes", roomTypes);
        modelAndView.setViewName("admin/roomTypes/roomTypes");
        return modelAndView;

    }

    @GetMapping(value = "/add")
    public String newCategoryForm(Model model) {
        model.addAttribute("roomType", new RoomType());
        return "admin/roomTypes/newroomTypesform";
    }

    @PostMapping(value = "/add/save")
    public String addNewCategory(@Valid @ModelAttribute("roomType") RoomType roomType, BindingResult bindingResult,
            Model model) {
        System.out.println("roomytpe" + roomType.getRoomTypeName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/roomTypes/newroomTypesform";
        }
        roomType = roomTypeService.save(roomType);
        return "redirect:/hotel/admin/roomTypes";
    }

    @GetMapping(value = "/edit/{roomTypeId}")
    public String editCategoryForm(@PathVariable("roomTypeId") Long roomTypeId, Model model) {
        RoomType roomType = roomTypeService.findById(roomTypeId);
        if (roomType != null) {
            model.addAttribute("roomType", roomType);
            return "admin/roomTypes/editroomTypesform";
        }
        return "admin/roomTypes/roomTypes";
    }

    @GetMapping(value = "/delete/{roomTypeId}")
    public String deleteCategory(@PathVariable("roomTypeId") Long id, Model model) {
        roomTypeService.delete(id);
        return "redirect:/hotel/admin/roomTypes";
    }

}

package org.example.practice_1.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.example.practice_1.entities.Customer;
import org.example.practice_1.entities.Seat;
import org.example.practice_1.entities.SeatRow;
import org.example.practice_1.repositories.CustomerRepository;
import org.example.practice_1.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class SeatController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SeatRepository seatRepository;

    static int num=0;

    @GetMapping("/index")
    public String seats(Model model){
        List<Seat> seats;
        List<SeatRow> seatsList = new ArrayList<>();

        seats=seatRepository.findAll();

        SeatRow row1 = new SeatRow();
        row1.setName1(seats.get(0).getSeatName());
        row1.setName2(seats.get(1).getSeatName());
        row1.setName3(seats.get(2).getSeatName());
        row1.setName4(seats.get(3).getSeatName());
        row1.setName5(seats.get(4).getSeatName());

        SeatRow row2 = new SeatRow();
        row1.setName1(seats.get(5).getSeatName());
        row1.setName2(seats.get(6).getSeatName());
        row1.setName3(seats.get(7).getSeatName());
        row1.setName4(seats.get(8).getSeatName());
        row1.setName5(seats.get(9).getSeatName());

        SeatRow row3 = new SeatRow();
        row1.setName1(seats.get(10).getSeatName());
        row1.setName2(seats.get(11).getSeatName());
        row1.setName3(seats.get(12).getSeatName());
        row1.setName4(seats.get(13).getSeatName());
        row1.setName5(seats.get(14).getSeatName());

        SeatRow row4 = new SeatRow();
        row1.setName1(seats.get(15).getSeatName());
        row1.setName2(seats.get(16).getSeatName());
        row1.setName3(seats.get(17).getSeatName());
        row1.setName4(seats.get(18).getSeatName());
        row1.setName5(seats.get(19).getSeatName());

        seatsList.add(row1);
        seatsList.add(row2);
        seatsList.add(row3);
        seatsList.add(row4);

        model.addAttribute("rowList",seatsList);

        List<Seat> availableSeats = seatRepository.findByReservedFalse();
        model.addAttribute("availableSeats", availableSeats.size());


        return "SeatIndex";
    }



    @GetMapping("/")
    public String seats2(Model model){
        List<Seat> seats;
        List<SeatRow> seatsList = new ArrayList<>();

        seats=seatRepository.findAll();

        SeatRow row1 = new SeatRow();
        row1.setName1(seats.get(0).getSeatName());
        row1.setName2(seats.get(1).getSeatName());
        row1.setName3(seats.get(2).getSeatName());
        row1.setName4(seats.get(3).getSeatName());
        row1.setName5(seats.get(4).getSeatName());

        SeatRow row2 = new SeatRow();
        row1.setName1(seats.get(5).getSeatName());
        row1.setName2(seats.get(6).getSeatName());
        row1.setName3(seats.get(7).getSeatName());
        row1.setName4(seats.get(8).getSeatName());
        row1.setName5(seats.get(9).getSeatName());

        SeatRow row3 = new SeatRow();
        row1.setName1(seats.get(10).getSeatName());
        row1.setName2(seats.get(11).getSeatName());
        row1.setName3(seats.get(12).getSeatName());
        row1.setName4(seats.get(13).getSeatName());
        row1.setName5(seats.get(14).getSeatName());

        SeatRow row4 = new SeatRow();
        row1.setName1(seats.get(15).getSeatName());
        row1.setName2(seats.get(16).getSeatName());
        row1.setName3(seats.get(17).getSeatName());
        row1.setName4(seats.get(18).getSeatName());
        row1.setName5(seats.get(19).getSeatName());

        seatsList.add(row1);
        seatsList.add(row2);
        seatsList.add(row3);
        seatsList.add(row4);

        model.addAttribute("rowList",seatsList);

        List<Seat> availableSeats = seatRepository.findByReservedFalse();
        model.addAttribute("availableSeats", availableSeats.size());


        return "SeatIndex";

    }

    @PostMapping("/reserve")
    public String save(Model model, @ModelAttribute Customer customer) {
        // Save customer
        customerRepository.save(customer);

        // Find and update seat
        Seat selectedSeat = seatRepository.findBySeatNumber(customer.getSeatNo());
        if (selectedSeat != null) {
            selectedSeat.setSeatName(customer.getCustomerName());
            seatRepository.save(selectedSeat);
        } else {
            model.addAttribute("error", "Seat not found");
            return "errorPage"; // Redirect or forward to an error page
        }

        return "SeatIndex";
    }


}

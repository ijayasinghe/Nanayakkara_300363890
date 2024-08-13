package org.example.practice_1;

import org.example.practice_1.entities.Seat;
import org.example.practice_1.repositories.SeatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practice1Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice1Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SeatRepository seatRepository){
        return args -> {
            seatRepository.save(new Seat(null,"1A","1A",false));
            seatRepository.save(new Seat(null,"1B","1B",false));
            seatRepository.save(new Seat(null,"1C","1C",false));
            seatRepository.save(new Seat(null,"1D","1D",false));
            seatRepository.save(new Seat(null,"1E","1E",false));


            seatRepository.save(new Seat(null,"2A","2A",false));
            seatRepository.save(new Seat(null,"2B","2B",false));
            seatRepository.save(new Seat(null,"2C","2C",false));
            seatRepository.save(new Seat(null,"2D","2D",false));
            seatRepository.save(new Seat(null,"2E","2E",false));

            seatRepository.save(new Seat(null,"3A","3A",false));
            seatRepository.save(new Seat(null,"3B","3B",false));
            seatRepository.save(new Seat(null,"3C","3C",false));
            seatRepository.save(new Seat(null,"3D","3D",false));
            seatRepository.save(new Seat(null,"3E","3E",false));

            seatRepository.save(new Seat(null,"4A","4A",false));
            seatRepository.save(new Seat(null,"4B","4B",false));
            seatRepository.save(new Seat(null,"4C","4C",false));
            seatRepository.save(new Seat(null,"4D","4D",false));
            seatRepository.save(new Seat(null,"4E","4E",false));



            seatRepository.findAll().forEach(p->{
                System.out.println(p.getSeatNumber());
            });
        };
    }

}

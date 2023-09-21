package com.xv.consumeapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class GuessController {
    private Guess guess = new Guess();

    @GetMapping("/guess")
    public String mostrarguess(Model model) {
        model.addAttribute(guess);
        System.out.println(guess.getRandomNumber());
        return "guess";
    }

    @GetMapping("/guess/reset")
    public String resetGame() {
        guess.reset();
        return "redirect:/guess";
    }


    @PostMapping("/guess")
    public String procesarFormularioGuess(Model model,@RequestParam String numero) {
        if(numero!=null){
            guess.setUserNumber(Integer.parseInt(numero));
        }
        model.addAttribute(guess);
        if (guess.win()){
            return "resultado";
        }else{
            System.out.println(guess.getRandomNumber());
            return "guess";
        }
    }
}

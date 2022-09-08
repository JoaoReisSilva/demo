package application.rest;

import application.calculator.Calculator;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
class CalculatorAPI {

    int id;
    @GetMapping("/calculator/{operation}/{firstNumber}/{secondNumber}")
    ResponseEntity<String> operation(@PathVariable String operation, @PathVariable double firstNumber, @PathVariable double secondNumber) throws JSONException {
        Calculator calculator = new Calculator();
        JSONObject json = new JSONObject();
        id++;
        if(operation.equalsIgnoreCase("SUM")){
            return ResponseEntity.ok()
                    .header("ID", ""+id)
                    .body(String.valueOf(json.put("result", calculator.sum(firstNumber, secondNumber))));
        }else if(operation.equalsIgnoreCase("SUB")){
            return ResponseEntity.ok()
                    .header("ID", ""+id)
                    .body(String.valueOf(json.put("result", calculator.sub(firstNumber, secondNumber))));
        }else if(operation.equalsIgnoreCase("DIVIDE")){
            return ResponseEntity.ok()
                    .header("ID", ""+id)
                    .body(String.valueOf(json.put("result", calculator.divide(firstNumber, secondNumber))));
        }else if(operation.equalsIgnoreCase("MULTIPLY")){
            return ResponseEntity.ok()
                    .header("ID", ""+id)
                    .body(String.valueOf(json.put("result", calculator.multiply(firstNumber, secondNumber))));
        }
        json.put("result", "OPERATION NOT VALID, TRY 'SUM', 'SUB', 'DIVIDE', 'MULTIPLY'");
        return ResponseEntity.ok()
                .header("ID", ""+id)
                .body(String.valueOf(json));
    }
}


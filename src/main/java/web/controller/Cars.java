package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class Cars {

    private String brand;
    private String model;
    private int year;

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(name = "count", defaultValue = "5") int num, ModelMap model) {

        List<Cars> cars = new ArrayList<Cars>();

        cars.add(new Cars("Toyota", "Tundra", 2023));
        cars.add(new Cars("Lada", "Priora", 2008));
        cars.add(new Cars("Audi", "Q3", 2012));
        cars.add(new Cars("Shkoda", "Yeti", 2008));
        cars.add(new Cars("Uaz", "Patriot", 2001));

        List<Cars> result = new ArrayList<Cars>();
        if (num > 5) {
            num = 5;
        }

        for (int i = 0; i < num; i++) {
            result.add(cars.get(i));
        }

        model.addAttribute("cars", result);

        return "cars";
    }

    public Cars() {
    }

    public Cars(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
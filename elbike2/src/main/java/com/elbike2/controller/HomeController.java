package com.elbike2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.elbike2.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.elbike2.dao.UserDAO;
import com.elbike2.model.Bike;

@Controller
public class HomeController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/")
    public ModelAndView listUser(ModelAndView model) throws IOException {
        List<User> listUser = userDAO.list();
        model.addObject("listUser", listUser);
        List<Bike> listBike = userDAO.listBike();
        model.addObject("listBike", listBike);
        model.setViewName("home");

        return model;
    }

    //@RequestMapping(value = "/")
//    public ModelAndView listBike(ModelAndView model) throws IOException {
//        List<Bike> listBike = userDAO.listBike();
//        model.addObject("listBike", listBike);
//        model.setViewName("home");
//        return model;
//    }
    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newEmployee(ModelAndView model) {
        User newUser = new User();
        model.addObject("user", newUser);
        model.setViewName("EmployeeForm");
        return model;
    }

    @RequestMapping(value = "/newBike", method = RequestMethod.GET)
    public ModelAndView newBike(ModelAndView model) {
        Bike newBike = new Bike();
        model.addObject("bike", newBike);
        model.setViewName("BikeForm");
        return model;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user) {
        userDAO.saveOrUpdate(user);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/saveBike", method = RequestMethod.POST)
    public ModelAndView saveBike(@ModelAttribute Bike bike) {
        userDAO.saveOrUpdateBike(bike);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(userId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteBike", method = RequestMethod.GET)
    public ModelAndView deleteBike(HttpServletRequest request) {
        int bikeId = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteBike(bikeId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.get(userId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("user", user);

        return model;
    }

    @RequestMapping(value = "/editBike", method = RequestMethod.GET)
    public ModelAndView editBike(HttpServletRequest request) {
        int bikeId = Integer.parseInt(request.getParameter("id"));
        Bike bike = userDAO.getBike(bikeId);
        ModelAndView model = new ModelAndView("BikeForm");
        model.addObject("bike", bike);

        return model;
    }
}

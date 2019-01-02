package com.elbike2.dao;

import java.util.List;

import com.elbike2.model.User;
import com.elbike2.model.Bike;
import java.util.ArrayList;

public interface UserDAO {

    public void saveOrUpdate(User user);

    public void newEmployee(User user);

    public void delete(int userId);

    public User get(int userId);

    public List<User> list();

    public List<User> optionUser();

    public void saveOrUpdateBike(Bike bike);

    public void deleteBike(int bikeId);

    public void removeBike(int userId);

    public Bike getBike(int bikeId);

    public List<Bike> listBike();

    public List<Bike> listAvailable();

    public List<Bike> optionBike();

    public void saveBikeEmployee(User user);

}

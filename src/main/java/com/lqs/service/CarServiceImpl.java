package com.lqs.service;

import com.lqs.dao.CarDao;
import com.lqs.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lqs
 * @date 2022/3/2 19:03
 */
@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao carDao;



    @Override
    public List<Car> getCarList() {
        List<Car> cars = carDao.getCarList();
        return cars;
    }

    /**
     * \通过Id查询车辆
     * @param carId
     * @return
     */
    @Override
    public Car getCarById(String carId) {
        return carDao.getCarById(carId);
    }

    /**
     * 可能会喜欢的车
     * @return
     */
    @Override
    public List<Car>  getCarLike() {
        return carDao.getCarLike();
    }

    @Override
    public List<Car> getContrastList() {
        return carDao.getContrastList();
    }

    @Override
    public int cancelContrast(String carId) {
        return carDao.cancelContrast(carId);
    }

    @Override
    public int addContrast(String carId) {
        return carDao.addContrast(carId);
    }

    @Override
    public int collcetCar(String username, String carId) {
        return carDao.collectCar(username,carId);
    }

    @Override
    public List<Car> selectCollect(String username) {
        return carDao.selectCollect(username);
    }

    @Override
    public int delCollet(String username, String carId) {
        return carDao.delCollect(username,carId);
    }

    @Override
    public List<Car> findCarByBrandname(String condition) {
        return carDao.findCarByBrandname(condition);
    }

    @Override
    public List<Car> findCarByType(String condition) {
        return carDao.findCarByType(condition);
    }

    @Override
    public List<Car> getCarListByPrice30() {
        return carDao.getCarListByPrice30();
    }

    @Override
    public List<Car> getCarListByPrice3050() {
        return carDao.getCarListByPrice3050();
    }

    @Override
    public List<Car> getCarListByPrice50100() {
        return carDao.getCarListByPrice50100();
    }

    @Override
    public List<Car> getCarListByPrice100() {
        return carDao.getCarListByPrice100();
    }

    @Override
    public int updateCar(Car car) {
        return carDao.updateCar(car);
    }

    @Override
    public int addCar(Car car) {
        return carDao.addCar(car);
    }

    @Override
    public int delCarById(String carId) {
        return carDao.delCarById(carId);
    }


}

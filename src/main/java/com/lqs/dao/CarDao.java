package com.lqs.dao;

import com.lqs.model.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lqs
 * @date 2022/3/2 19:05
 */
@Mapper
public interface CarDao {

    List<Car> getCarList();

    Car getCarById(String carId);

    List<Car>  getCarLike();

    List<Car> getContrastList();

    int cancelContrast(String carId);

    int addContrast(String carId);

    int collectCar(String username, String carId);

    List<Car> selectCollect(String username);

    int delCollect(String username, String carId);

    List<Car> findCarByBrandname(String condition);

    List<Car> findCarByType(String condition);

    List<Car> getCarListByPrice30();

    List<Car> getCarListByPrice3050();

    List<Car> getCarListByPrice100();

    List<Car> getCarListByPrice50100();

    int updateCar(Car car);

    int addCar(Car car);

    int delCarById(String carId);
}

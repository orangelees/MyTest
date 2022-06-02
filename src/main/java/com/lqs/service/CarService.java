package com.lqs.service;

import com.lqs.model.Car;

import java.util.List;

/**
 * @author lqs
 * @date 2022/3/2 18:34
 */
public interface CarService {
    /**
     *
     * @param
     * @return
     */
    List<Car> getCarList();

    /**
     * 通过carId查询车辆
     * @param carId
     * @return
     */
    Car getCarById(String carId);


    /**
     * 获取carhtml页面中的 可能喜欢的车辆
     * @param
     * @return
     */
    List<Car>  getCarLike();

    /**
     * 查询对比车辆信息
     * @param
     * @return
     */
    List<Car> getContrastList();

    /**
     * 获取carId取消车辆对比
     * @param carId
     * @return
     */
    int cancelContrast(String carId);

    /**
     * 加入对比
     * @param carId
     * @return
     */
    int addContrast(String carId);

    /**
     * 加入收藏
     * @param username
     * @param carId
     * @return
     */
    int collcetCar(String username, String carId);

    /**
     * 查询收藏车辆
     * @param username
     */
    List<Car> selectCollect(String username);

    /**
     * 取消收藏
     * @param username
     * @param carId
     * @return
     */
    int delCollet(String username, String carId);

    /**
     * 通过汽车品牌搜索车辆
     * @param condition
     * @return
     */
    List<Car> findCarByBrandname(String condition);

    /**
     * 通过汽车类型搜索车辆
     * @param condition
     * @return
     */
    List<Car> findCarByType(String condition);

    /**
     * 通过汽车价格
     * 30以下
     * 30-50
     * 50-100
     * 100以上
     * @return
     */
    List<Car> getCarListByPrice30();

    List<Car> getCarListByPrice3050();

    List<Car> getCarListByPrice50100();

    List<Car> getCarListByPrice100();


    /**
     * 修改车辆
     * @param car
     * @return
     */
    int updateCar(Car car);

    /**
     * 增加车辆
     * @param car
     * @return
     */
    int addCar(Car car);

    int delCarById(String carId);
}

package com.lqs.model;

/**
 * @author lqs
 * @date 2022/3/2 18:18
 */
public class Car {
    private int i;
    private String brandName;//品牌
    private String model;//型号
    private String edition;//版本
    private double price;//价格
    private String carType;//车型
    private String color;//颜色
    private String displacement;//排量
    private String emissionStandard;//排放标准
    private String dateOfManufacture;//出厂日期
    private String longwidehigh;//长宽高
    private String wheelbase;//轴距
    private String tire;//轮胎规格
    private String tankVolume;//油箱容积
    private String quality;//质量
    private String img1;//1-6展示
    private String img2;
    private String img3;
    private String img4;
    private String img5;
    private String img6;
    private String mainimg;//车辆主照片
    private String carId;//车辆ID



    //private String edition;//型号
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Car(int i, String brandName, String model) {
        this.i = i;
        this.brandName = brandName;
        this.model = model;
    }

    public String getEdition() {
        return edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getDisplacement() {
        return displacement;
    }
    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }
    public String getEmissionStandard() {
        return emissionStandard;
    }
    public void setEmissionStandard(String emissionStandard) {
        this.emissionStandard = emissionStandard;
    }
    public String getDateOfManufacture() {
        return dateOfManufacture;
    }
    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
    public String getLongwidehigh() {
        return longwidehigh;
    }
    public void setLongwidehigh(String longwidehigh) {
        this.longwidehigh = longwidehigh;
    }
    public String getWheelbase() {
        return wheelbase;
    }
    public void setWheelbase(String wheelbase) {
        this.wheelbase = wheelbase;
    }
    public String getTire() {
        return tire;
    }
    public void setTire(String tire) {
        this.tire = tire;
    }
    public String getTankVolume() {
        return tankVolume;
    }
    public void setTankVolume(String tankVolume) {
        this.tankVolume = tankVolume;
    }
    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }



    public String getImg1() {
        return img1;
    }
    public void setImg1(String img1) {
        this.img1 = img1;
    }


    public String getImg2() {
        return img2;
    }
    public void setImg2(String img2) {
        this.img2 = img2;
    }
    public String getImg3() {
        return img3;
    }
    public void setImg3(String img3) {
        this.img3 = img3;
    }
    public String getImg4() {
        return img4;
    }
    public void setImg4(String img4) {
        this.img4 = img4;
    }
    public String getImg5() {
        return img5;
    }
    public void setImg5(String img5) {
        this.img5 = img5;
    }
    public String getImg6() {
        return img6;
    }
    public void setImg6(String img6) {
        this.img6 = img6;
    }


    public String getMainimg() {
        return mainimg;
    }
    public void setMainimg(String mainimg) {
        this.mainimg = mainimg;
    }
    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public Car(int i, String brandName, String model, String edition, double price, String carType, String color,
               String displacement, String emissionStandard, String dateOfManufacture, String longwidehigh,
               String wheelbase, String tire, String tankVolume, String quality) {
        this.i = i;
        this.brandName = brandName;
        this.model = model;
        this.edition = edition;
        this.price = price;
        this.carType = carType;
        this.color = color;
        this.displacement = displacement;
        this.emissionStandard = emissionStandard;
        this.dateOfManufacture = dateOfManufacture;
        this.longwidehigh = longwidehigh;
        this.wheelbase = wheelbase;
        this.tire = tire;
        this.tankVolume = tankVolume;
        this.quality = quality;
    }
    public Car() {
    }

    public Car(String brandName) {
        this.brandName = brandName;
    }




    public Car(int i, String brandName, String model, String edition, double price, String carType, String color,
               String displacement, String emissionStandard, String dateOfManufacture, String longwidehigh,
               String wheelbase, String tire, String tankVolume, String quality, String img1, String img2, String img3,
               String img4, String img5, String img6, String mainimg) {
        this.i = i;
        this.brandName = brandName;
        this.model = model;
        this.edition = edition;
        this.price = price;
        this.carType = carType;
        this.color = color;
        this.displacement = displacement;
        this.emissionStandard = emissionStandard;
        this.dateOfManufacture = dateOfManufacture;
        this.longwidehigh = longwidehigh;
        this.wheelbase = wheelbase;
        this.tire = tire;
        this.tankVolume = tankVolume;
        this.quality = quality;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.img5 = img5;
        this.img6 = img6;
        this.mainimg = mainimg;
    }
    public Car(String brandName, String model, String edition, double price, String carType, String color,
               String displacement, String emissionStandard, String dateOfManufacture, String longwidehigh,
               String wheelbase, String tire, String tankVolume, String quality, String mainimg) {
        this.brandName = brandName;
        this.model = model;
        this.edition = edition;
        this.price = price;
        this.carType = carType;
        this.color = color;
        this.displacement = displacement;
        this.emissionStandard = emissionStandard;
        this.dateOfManufacture = dateOfManufacture;
        this.longwidehigh = longwidehigh;
        this.wheelbase = wheelbase;
        this.tire = tire;
        this.tankVolume = tankVolume;
        this.quality = quality;
        this.mainimg = mainimg;
    }
    public Car(String brandName, String model, String edition, double price, String carType, String color,
               String displacement, String emissionStandard, String dateOfManufacture, String longwidehigh,
               String wheelbase, String tire, String tankVolume, String quality, String mainimg, String carId) {
        super();
        this.brandName = brandName;
        this.model = model;
        this.edition = edition;
        this.price = price;
        this.carType = carType;
        this.color = color;
        this.displacement = displacement;
        this.emissionStandard = emissionStandard;
        this.dateOfManufacture = dateOfManufacture;
        this.longwidehigh = longwidehigh;
        this.wheelbase = wheelbase;
        this.tire = tire;
        this.tankVolume = tankVolume;
        this.quality = quality;
        this.mainimg = mainimg;
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "i=" + i +
                ", brandName='" + brandName + '\'' +
                ", model='" + model + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                ", carType='" + carType + '\'' +
                ", color='" + color + '\'' +
                ", displacement='" + displacement + '\'' +
                ", emissionStandard='" + emissionStandard + '\'' +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                ", longwidehigh='" + longwidehigh + '\'' +
                ", wheelbase='" + wheelbase + '\'' +
                ", tire='" + tire + '\'' +
                ", tankVolume='" + tankVolume + '\'' +
                ", quality='" + quality + '\'' +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                ", img3='" + img3 + '\'' +
                ", img4='" + img4 + '\'' +
                ", img5='" + img5 + '\'' +
                ", img6='" + img6 + '\'' +
                ", mainimg='" + mainimg + '\'' +
                ", carId='" + carId + '\'' +
                '}';
    }
}

package com.lqs.controller;

import com.lqs.model.Car;
import com.lqs.model.Reserve;
import com.lqs.model.User;
import com.lqs.service.CarService;
import com.lqs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lqs
 * @date 2022/3/2 18:24
 */
@Controller
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;



    /**
     * 进入主页
     * @return
     */
    @RequestMapping("/homepage")
    public String homepage(HttpServletRequest request){
        contrastCarSize(request);
        return "homepage";
    }

    /**
     * 进入个人中心
     */
    @RequestMapping("/personalPage")
    public String personalPage(HttpServletRequest request,Model model){
        String link = "personalCenter";
        User user= (User) request.getSession().getAttribute("user");
        personData(model,user.getUsername(),user.getPhone());
        if (user.getUsername().equals("admin")){
            link = "administrator";
        }
        return link;
    }

    /**
     * 获取个人中心数据
     * @param model
     * @param username
     * @param phone
     */
    public void personData(Model model,String username,String phone){
        List<Car> cars = null;
        List<Reserve> reserves = null;
        if (username.equals("admin")){//
            reserves = userService.adminReserve();//管理员获取全部预约信息
            cars = carService.getCarList();
        }else {
            reserves =   userService.getReserve(phone);
            cars = carService.selectCollect(username);
        }
        model.addAttribute("cars",cars);
        model.addAttribute("reserves",reserves);
    }
    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 进行登录操作，成功后进入主页homepage
     * @return
     */
    @ResponseBody
    @RequestMapping("/userLogin")
    public int userLogin(HttpServletRequest request,Model model) {
        int i = -1;
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = (userService.login(username, password));
        if (user != null) {
            session.setAttribute("user",user);
            session.setAttribute("username",user.getUsername());
            i=1;//登陆成功
        }
        return i;
    }


    /**
     * 退出账号
     */
    @ResponseBody
    @RequestMapping("/signOut")
    public int signOut(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return 1;
    }
    /**
     * 跳转至注册界面
     * @return
     */
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }

    /**
     * 用户注册
     * @param
     * @return
     */
    @RequestMapping("/userRegister")
    public String register(User user) {
        int a =  userService.userRegister(new User(user.getId(),user.getUsername(),user.getPassword(),user.getPhone()));
        if (a>0){
            return "login";
        }else {
            return "register";
        }
    }

    /**
     * 通过carId进行搜索车辆并跳转该车详细界面
     * @return
     */
    @RequestMapping("/carQuery")
    public String carQuery(HttpServletRequest request,Model model){
        String username = request.getParameter("username");
        String carId = request.getParameter("carId");
        Car car = carService.getCarById(carId);
        List<Car> carlist=carService.getCarLike();//拿取可能喜欢的车
        contrastCarSize(request);
        List<Car> collectCars = carService.selectCollect(username);
        model.addAttribute("collectCars",collectCars);
        model.addAttribute("car",car);
        model.addAttribute("cars",carlist);
        return "car";
    }


    /**
     * 按类型搜索车辆
     * Condition1 品牌
     * Condition2 类型
     * Condition3 价格
     * @return
     */
    @RequestMapping("/findCarByCondition")
    public String findCarByCondition(HttpServletRequest request,Model model){
        String condition = request.getParameter("condition");
        String type = request.getParameter("brandname");
        List<Car> cars = null;
        if (condition.equals("1")){
            cars = carService.findCarByBrandname(type);
        }else if (condition.equals("2")){
            cars = carService.findCarByType(type);
        }else if (condition.equals("3")){
            if (type.equals("30万以下")) {
                cars=carService.getCarListByPrice30();
            }else if (type.equals("30-50万")) {
                cars=carService.getCarListByPrice3050();
            }else if (type.equals("50-100万")) {
                cars=carService.getCarListByPrice50100();
            }else if (type.equals("100万以上")) {
                cars=carService.getCarListByPrice100();
            }
        }
        model.addAttribute("cars",cars);
        return "carList";
    }

    /**
     * 跳转至车辆对比界面
     */
    @RequestMapping("/contrast")
    public String contrastPage(Model model){
       List<Car> cars = carService.getContrastList();
       model.addAttribute("cars",cars);
       model.addAttribute("carsize",cars.size());
        return "contrast";
    }

    /**
     * 加入对比
     * @return
     */
    @ResponseBody
    @RequestMapping("/addContrast")
    public int addContrast(HttpServletRequest request,Model model){
        String carId = request.getParameter("carId");
        int count = 0;
        int contrastCarSize = contrastCarSize(request);
        if (contrastCarSize>=4) {//对比车辆最多为四辆，如超过返回-
            count =-1;
        }
        List<Car> cars = carService.getContrastList();
        for (Car car : cars) {
            if (carId.equals(car.getCarId())){
                count = -2;//-2表示已经收藏过该车辆了
            }
        }
        if (count==0){
            count = carService.addContrast(carId);
            contrastCarSize(request);//更新对比数量
        }
        return count;
    }

    /**
     * 取消对比
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/cancelContrast")
    public String cancelContrast(HttpServletRequest request,Model model){
        String carId=request.getParameter("carId");
        int a =  carService.cancelContrast(carId);
        List<Car> cars = carService.getContrastList();
        model.addAttribute("cars",cars);
        model.addAttribute("carsize",cars.size());
        contrastCarSize(request);
        return "contrast";
    }

    /**
     * 跳转至我的收藏界面
     */
    @RequestMapping("/collectPage")
    public String collectPage(HttpServletRequest request,Model model){
        contrastCarSize(request);
        String username = request.getParameter("username");
        List<Car> cars = carService.selectCollect(username);
        model.addAttribute("cars",cars);
        return "collectCar";
    }

    /**
     * 加入收藏
     */
    @ResponseBody
    @RequestMapping("/addCollect")
    public int collectCar(HttpServletRequest request,Model model){
        String username = request.getParameter("username");
        String carId = request.getParameter("carId");
        int count = 0;
        List<Car> cars = carService.selectCollect(username);
        for (Car car : cars) {
            if (carId.equals(car.getCarId())){
                count = -1;//已加收藏过该车辆
            }
        }
        if (count==0){
            count = carService.collcetCar(username,carId);
        }
        return count;
    }

    /**
     * 取消收藏
     */
    @RequestMapping("/delCollect")
    public String delCollcet(HttpServletRequest request,Model model){
        String carId = request.getParameter("carId");
        String username = request.getParameter("username");
        String page = request.getParameter("page");
        String link = "collectCar";
        if (page!=null){
            link = "personalCenter";
        }
        int a = carService.delCollet(username,carId);
        contrastCarSize(request);
        List<Car> cars = carService.selectCollect(username);
        model.addAttribute("cars",cars);
        return link;
    }

    /**
     * 获取车辆对比数量
     * @param request
     */
    public int contrastCarSize(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Car> cars = carService.getContrastList();
        session.setAttribute("contrastCarSize",cars.size());
        return cars.size();
    }




    /**
     * 更新用户数据
     */
    @ResponseBody
    @RequestMapping("/updateUserMsg")
    public int updateUserMsg(User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        int count = userService.updateUserMsg(user);
        if (count>0){
           User user1 = userService.getUser(user.getUsername());
            session.setAttribute("user",user1);
        }
        return count;
    }

    @ResponseBody
    @RequestMapping("/updatePassword")
    public int updatePassword(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        int count = userService.updatePassword(username,password);
        return count;
    }

    /**
     * 添加预约信息
     * @param reserve
     * @return
     */
    @ResponseBody
    @RequestMapping("/addReserve")
    public int addReserve(Reserve reserve){
        long reserveId = System.currentTimeMillis();
        reserve.setReserveId(reserveId);
        int count = userService.addReserve(reserve);
        return count;
    }

    /**
     * 更改预约状态
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/cancelReserve")
    public String cancelReserve(HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        String reserveId = request.getParameter("reserveId");
        String reserveType = request.getParameter("reserveType");
        String state = null;
        switch (reserveType){
            case "1":state="已取消";break;
            case "2":state="已通过";break;
            case "3":state="已拒绝";break;
        }
        int count = userService.cancelReserve(reserveId,state);
        personData(model,user.getUsername(),user.getPhone());
        return "personalCenter";
    }

    /**
     * 管理员删除预约信息
     */
    @RequestMapping("/delReserve")
    public String delReserve(HttpServletRequest request, Model model){
        String reserveId= request.getParameter("reserveId");
        int count = userService. delReserve(reserveId);
        User user= (User) request.getSession().getAttribute("user");
        personData(model,user.getUsername(),user.getPhone());
        return "personalCenter";
    }

    /**
     * 跳转至修改车辆界面
     */
    @RequestMapping("/carMsg")
    public String carMsg(HttpServletRequest request,Model model){
        String carId= request.getParameter("carId");
        String type= request.getParameter("type");
        if (type!=null){
            model.addAttribute("type",type);
        }else {
            Car car = carService.getCarById(carId);
            model.addAttribute("car",car);
        }

        return "carMsg";
    }

    /**
     * 增加车辆
     * @param car
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCar")
    public int addCar(Car car, @RequestParam("file") MultipartFile[] files){
        upload(car,files);
        int count = carService.addCar(car);
        return count;
    }

    /**
     * 更新车辆信息
     * @param car
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateCar")
    public int updateCar(Car car,@RequestParam("file") MultipartFile[] files){
        upload(car,files);
        int count = carService.updateCar(car);
        return count;
    }

    /**
     * 车辆上传文件
     */
    public void upload(Car car,@RequestParam("file") MultipartFile[] files){
        String dir="D:/ideafile/zoomCar/src/main/resources/static/images";
        if (files!=null){
            long time=System.currentTimeMillis();//存入的时间
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                System.out.println(file.getOriginalFilename());
                if (!file.isEmpty()){
                    String newImgName = time + files[i].getOriginalFilename();
                    File copyfile = new File(dir+"/"+newImgName);
                    try {
                        file.transferTo(copyfile);//保存到目标文件夹中
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    switch (i){
                        case 0:car.setImg1("images/"+newImgName);break;
                        case 1:car.setImg2("images/"+newImgName);break;
                        case 2:car.setImg3("images/"+newImgName);break;
                        case 3:car.setImg4("images/"+newImgName);break;
                        case 4:car.setImg5("images/"+newImgName);break;
                        case 5:car.setImg6("images/"+newImgName);break;
                        case 6:car.setMainimg("images/"+newImgName);break;
                    }
                }
            }
        }
    }
    /**
     * 删除车辆信息
     */
    @RequestMapping("/delCar")
    public String delCar(HttpServletRequest request,Model model){
        String carId =  request.getParameter("carId");
        int cout = carService.delCarById(carId);
        User user= (User) request.getSession().getAttribute("user");
        personData(model,user.getUsername(),user.getPhone());
        return "administrator";
    }

}
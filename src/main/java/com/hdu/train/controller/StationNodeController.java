package com.hdu.train.controller;

import com.hdu.train.pojo.StationNode;
import com.hdu.train.pojo.Train;
import com.hdu.train.pojo.Vo.AdvancedSearchVo;
import com.hdu.train.pojo.Vo.DisplayVo;
import com.hdu.train.pojo.Vo.TrainTemp;
import com.hdu.train.pojo.Vo.Transfer;
import com.hdu.train.service.StationNodeService;
import com.hdu.train.service.StationService;
import com.hdu.train.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:56 18-1-7
 * @Modified By:
 */

@Controller
@RequestMapping("/search")
public class StationNodeController {
    @Resource
    private StationService stationService;
    @Resource
    private TrainService trainService;
    @Resource
    private StationNodeService stationNodeService;

    List<TrainTemp> trainTemps;
    List<TrainTemp> departureTemps;
    List<TrainTemp> destinationTemps;

    String departure;
    String destination;
    int stationId1;
    int stationId2;

    @RequestMapping("/direct")
    public ModelAndView direct(HttpServletRequest requests) {
        ModelAndView modelAndView = new ModelAndView();
        this.departure = requests.getParameter("departure");
        this.destination = requests.getParameter("destination");
        this.stationId1 = stationService.getStationId(departure);
        this.stationId2 = stationService.getStationId(destination);

        List<DisplayVo> displayVos = new ArrayList<>();
        //获取包含stationId1,stationId2的信息
        List<StationNode> stationNodes = stationNodeService.getDirectStation(stationId1, stationId2);
        if (0 >= stationNodes.size()) {
            modelAndView.addObject("NODirect", "请使用高级查询");
        }

        Calendar calendar = new GregorianCalendar();

        for (StationNode s : stationNodes
                ) {
            //数据库中只有时间没有日期，所以利用Calendar获取日期
            s.setArriveTime(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), s.getArriveTime().getHours(), s.getArriveTime().getMinutes(), s.getArriveTime().getSeconds()));
            s.setLeaveTime(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), s.getLeaveTime().getHours(), s.getLeaveTime().getMinutes(), s.getLeaveTime().getSeconds()));
            displayVos.add(new DisplayVo(
                    stationService.getStationName(s.getStationId1()),
                    stationService.getStationName(s.getStationId2()),
                    trainService.getTrainName(s.getTrainId()),
                    s.getArriveTime(),
                    s.getLeaveTime(),
                    s.getPrice1(),
                    s.getRestSite1(),
                    s.getPrice2(),
                    s.getRestSite2(),
                    s.getPrice3(),
                    s.getRestSite3()
            ));
        }
        modelAndView.addObject("TrainRoute", displayVos);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/advanced")
    public ModelAndView advanced() {
        List<StationNode> stationNodes = new ArrayList<>();
        List<DisplayVo> displayVos = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView();
        //获取所有列车信息
        getAllTrain();
        //获取包含出发站的车次信息
        getAllDeparture(stationId1);
        //获取包含目的站的车次信息
        getAllDestination(stationId2);
        if (getMiddleStation(stationId1, stationId2).size() > 0) {
            for (AdvancedSearchVo ad : getMiddleStation(stationId1, stationId2)
                    ) {
                if (!(stationNodeService.getTransferTrain(ad.getStationId1(), ad.getStationId2(), ad.getTrainId()).equals("0"))) {
                    stationNodes.add(stationNodeService.getTransferTrain(ad.getStationId1(), ad.getStationId2(), ad.getTrainId()));
                    System.out.println(ad.toString());
                }

            }
        }
        Calendar calendar = Calendar.getInstance();
        if (stationNodes.size() > 0) {
            for (StationNode s : stationNodes
                    ) {
                Date date = new Date();
                s.setArriveTime(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), s.getArriveTime().getHours(), s.getArriveTime().getMinutes(), s.getArriveTime().getSeconds()));
                s.setLeaveTime(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), s.getLeaveTime().getHours(), s.getLeaveTime().getMinutes(), s.getLeaveTime().getSeconds()));
                displayVos.add(new DisplayVo(
                        stationService.getStationName(s.getStationId1()),
                        stationService.getStationName(s.getStationId2()),
                        trainService.getTrainName(s.getTrainId()),
                        s.getArriveTime(),
                        s.getLeaveTime(),
                        s.getPrice1(),
                        s.getRestSite1(),
                        s.getPrice2(),
                        s.getRestSite2(),
                        s.getPrice3(),
                        s.getRestSite3()
                ));
            }
        }
        modelAndView.addObject("TrainRoute", displayVos);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    //对所有的列车信息进行处理，并存入List<TrainTemp>中
    private List<TrainTemp> getAllTrain() {
        List<Train> trains = trainService.getAllTrain();
        trainTemps = new ArrayList<>();
        for (Train t : trains) {
            Integer ret[] = new Integer[t.getTrainRoute().split(",").length];
            for (int i = 0, j = 0; i < t.getTrainRoute().split(",").length; i++, j++) {
                ret[j] = Integer.parseInt(t.getTrainRoute().split(",")[i]);
            }
            trainTemps.add(new TrainTemp(t.getTrainId(), ret));
        }
        return trainTemps;
    }

    private void getAllDeparture(int stationId) {
        departureTemps = new ArrayList<>();
        int flag = 0;
        int index = 0;
        for (TrainTemp t : trainTemps
                ) {
            for (int i = 0; i < t.getTrainRoute().length; i++) {
                if (t.getTrainRoute()[i].equals(stationId)) {
                    flag = 1;
                    index = i;
                    break;
                }
            }
            if (flag == 1) {
                Integer[] ret = new Integer[t.getTrainRoute().length - index];
                for (int j = index, k = 0; j < t.getTrainRoute().length; j++, k++) {
                    ret[k] = t.getTrainRoute()[j];
                }
                departureTemps.add(new TrainTemp(t.getTrainId(), ret));
            }
            flag = 0;
            index = 0;
        }
        for (TrainTemp t : departureTemps
                ) {
            System.out.println(t.getTrainId());
            System.out.println(Arrays.toString(t.getTrainRoute()));
        }
    }

    private void getAllDestination(int stationId) {
        destinationTemps = new ArrayList<>();
        int flag = 0;
        int index = 0;
        for (TrainTemp t : trainTemps
                ) {
            for (int i = 0; i < t.getTrainRoute().length; i++) {
                if (t.getTrainRoute()[i].equals(stationId)) {
                    flag = 1;
                    index = i;
                    break;
                }
            }
            if (flag == 1) {
                Integer[] ret = new Integer[index + 1];
                for (int j = 0, k = 0; j <= index; j++, k++) {
                    ret[k] = t.getTrainRoute()[j];
                }
                destinationTemps.add(new TrainTemp(t.getTrainId(), ret));
            }
            flag = 0;
            index = 0;
        }
        for (TrainTemp t : destinationTemps
                ) {
            System.out.println(t.getTrainId());
            System.out.println(Arrays.toString(t.getTrainRoute()));
        }
    }
    private List<AdvancedSearchVo> getMiddleStation(int stationId1, int stationId2) {
        List<AdvancedSearchVo> advancedSearchVos = new ArrayList<>();
        List<Transfer> transferList = new ArrayList<>();
        for (TrainTemp t1 : departureTemps
                ) {
            for (TrainTemp t2 : destinationTemps
                    ) {
                if (intersect(t1.getTrainRoute(), t2.getTrainRoute()).length > 0) {
                    transferList.add(new Transfer(stationId1, stationId2, intersect(t1.getTrainRoute(), t2.getTrainRoute()), t1.getTrainId(), t2.getTrainId()));
                }
            }

        }
        for (Transfer t : transferList
                ) {
            for (Integer integer : t.getMiddle()
                    ) {
                advancedSearchVos.add(new AdvancedSearchVo(stationId1, integer, t.getTrainId()));
                advancedSearchVos.add(new AdvancedSearchVo(integer, stationId2, t.getTrainId2()));
            }

        }
        return advancedSearchVos;
    }

    private static Integer[] intersect(Integer[] arr1, Integer[] arr2) {
        Set<Integer> result = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(arr2));
        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        Integer[] arr = new Integer[result.size()];
        return result.toArray(arr);
    }


}

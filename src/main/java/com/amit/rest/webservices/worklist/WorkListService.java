package com.amit.rest.webservices.worklist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkListService {
    private static List<Work> workList = new ArrayList<>();
    private static int idCounter = 0;
    static {
        workList.add(new Work(++idCounter,"Yoga Class","Yoga is Good for Mind and Body",new Date(),false));
        workList.add(new Work(++idCounter,"Football","Football is Good for health fitness hahahah",new Date(),true));
        workList.add(new Work(++idCounter,"Microservice","Microservice need to know now",new Date(),false));
        workList.add(new Work(++idCounter,"Angular","Angular is awesome",new Date(),false));
    }

    public List<Work> getWorkList() {
        System.out.println("worklist...");
        for(Work work: workList) {
            System.out.println(work.getName());
        }
        return workList;
    }

    public Work deleteById(int id) {
       Work work =  findWorkById(id);
       if(work != null) {
           workList.remove(work);
       }
       return work;
    }

    public Work findWorkById(int id) {
        for(Work work: workList) {
            if(work.getId() == id)
                return work;
        }
        return null;
    }

    public Work addWork(Work work) {
        System.out.println("work id..."+work.getId());
        if(work != null && work.getId() == 0){
            work.setId(++idCounter);
            workList.add(work);
            System.out.println(work.getName()+" added now");
        }
        System.out.println(work.getName()+" added successfully");
        return work;
    }
    public Work updateWork(Work work,int id) {
        System.out.println("work id..."+work.getId());
        if(work != null){
            deleteById(id);
            work.setId(id);
            workList.add(work);
        }
        System.out.println(work.getName()+" updated successfully");
        return work;
    }
}

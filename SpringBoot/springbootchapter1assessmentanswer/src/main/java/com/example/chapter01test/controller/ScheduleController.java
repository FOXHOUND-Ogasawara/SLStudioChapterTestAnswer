package com.example.chapter01test.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chapter01test.Schedule;
import com.example.chapter01test.dto.ScheduleForm;

@Controller
@RequestMapping("/question2")
public class ScheduleController {
    List<Schedule> scheduleList = new ArrayList<>(
            List.of(
                    new Schedule(1, "Lunch", LocalDateTime.parse("2019-01-22T12:00:00"), 1.0, "Shibuya"),
                    new Schedule(2, "Meeting", LocalDateTime.parse("2019-01-22T15:00:00"), 3.0, "Shinjuku"),
                    new Schedule(3, "Dinner", LocalDateTime.parse("2019-01-22T19:00:00"), 8.0, "Kichijoji")));

    @RequestMapping("/index")
    public String showSchedule(Model model) {
        model.addAttribute("schedules", scheduleList);
        return "index";
    }

    @RequestMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Schedule schedule = null;
        for (Schedule s : scheduleList) {
            if (s.getId() == id) {
                schedule = s;
                break;
            }
        }
        model.addAttribute("schedule", schedule);
        return "detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "location", required = false) String location, Model model) {
        List<Schedule> filteredSchedules = scheduleList.stream()
                .filter(s -> (name == null || s.getName().contains(name))
                        && (location == null || s.getLocation().contains(location)))
                .collect(Collectors.toList());
        model.addAttribute("schedules", filteredSchedules);
        return "result";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("scheduleForm", new ScheduleForm());
        return "register";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ScheduleForm scheduleForm, Model model) {
        Schedule newSchedule = new Schedule(scheduleForm.getId(), scheduleForm.getName(),
                scheduleForm.getStartDateTime(), scheduleForm.getDuration(), scheduleForm.getLocation());
        scheduleList.add(newSchedule);
        return "success";
    }
}

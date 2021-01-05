package dam.tam4.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Schedule;
import dam.tam4.service.ScheduleService;

@Controller
public class ScheduleController {
		
		private final ScheduleService sService;
		
		public ScheduleController(ScheduleService sService) {
			this.sService = sService;
		}

		//definim tipul de request si in interiorul metodei create, chemam metoda din service
		@PostMapping("/schedule/createSchedule") //terminatie URL
		public void createSchedule(HttpServletRequest request, Schedule s){
			sService.addSchedule(request, s);
		}

		@GetMapping("/schedule/getAllSchedules")
		public ModelAndView getAllSchedules() {
			ModelAndView mv = new ModelAndView("schedule");
			List<Schedule> schedules = new ArrayList<>();
			
			Schedule mySchedule=new Schedule();
			mySchedule.setScheduleId(10L);
			mySchedule.setDate(LocalDate.of(2021, 1, 1));
			mySchedule.setTasks(null);
			
			schedules.add(mySchedule);
			mv.addObject("schedules", schedules);
			return mv;
		}
		@GetMapping("/schedule/getSchedule")
		public ModelAndView getSchedule(@RequestParam(name = "id") Long id){
			return null;
		}
}

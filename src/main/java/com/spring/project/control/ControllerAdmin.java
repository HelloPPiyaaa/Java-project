package com.spring.project.control;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.project.model.AllRepository;
import com.spring.project.model.Games;
import com.spring.project.model.Games_has_category;
import com.spring.project.model.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Path;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class ControllerAdmin {
	private EntityManager entityManager;
	
	@Autowired
	private AllRepository repo;
	
	
	@GetMapping("/admin_register")
	public String admin_register() {
		return "/admin_register";
	}
	
	
	
	
	
////////////////------admin-----///////////////////
@GetMapping("/admin_index")
public String admin_index(Model model) {
	List<Games> findAll_Games_Admin = repo.findAll_Games_Admin();
	model.addAttribute("findAll_Games_Admin", findAll_Games_Admin);
	System.out.println(findAll_Games_Admin);
return "/admin_index";
}


@GetMapping("/admin_add")
public String admin_add(Model model) {
	
//	List<Games> findAll_Games_Admin = repo.findAll_Games_Admin();
//	model.addAttribute("findAll_Games_Admin", findAll_Games_Admin);
//	System.out.println(findAll_Games_Admin);
return "/admin_add";
}
//---------------------------------------------------------------------------------------------
//@GetMapping("/test")
//public String test1() {
//	System.out.println();
//	return "/test";
//}
@GetMapping("/form_test")
public String testdd(@RequestParam("myArray") Integer[] myArrayValues) {
	System.out.println("--------------------------------------------------"+myArrayValues[0]);
	return null;
}
//---------------------------------------------------------------------------------------------
@PostMapping("/form_admin_add")
public String form_admin_add(
		Model model,
		HttpSession session,
		@RequestParam("game_name") String game_name,
		@RequestParam("category") String[] category,
		@RequestParam("game_content") String game_content,
		@RequestParam("deverlopBy") String deverlopBy,
		@RequestParam("distributorsBy") String distributorsBy,
		@RequestParam("plat") String[] plat,
		@RequestParam("price") Integer[] price,
		
//		@RequestParam("price1") Integer price1,
//		@RequestParam("price2") Integer price2,
//		@RequestParam("price3") Integer price3,
//		@RequestParam("price4") Integer price4,
//		@RequestParam("price5") Integer price5,
		@RequestParam("os") String[] os,
		@RequestParam("link_image") String link_image
		)
{
	//เพิ่มข้อมูลตาราง games
	Games addGame = new Games();
	addGame.setGame_name(game_name);
	addGame.setGame_content(game_content);
	addGame.setImage(link_image);
	addGame.setGame_view(0);
	addGame.setDevelopBy(deverlopBy);
	addGame.setDistributorsBy(distributorsBy);
	addGame.setUser_id((Integer)session.getAttribute("id"));
	repo.add_game(addGame);
	
	//เรียกใช้ repo ค้นหา game_id ล่าสุด ****
	Games find_latest_game_id = repo.find_latest_game_id();
	Integer last_game_id = find_latest_game_id.getGame_id();
	System.out.println("---------------"+last_game_id);
	
	
	//set sql insert game_has_category";
	String set_sql_IGHC= "" ;
	for (String category_list : category) {
		set_sql_IGHC = set_sql_IGHC + ",(" + last_game_id  + ","+ category_list  +")"  ;
			//System.out.println("INSERT INETO "+category_list);
	}
	String set_sql_add_game_has_category = "INSERT INTO Games_has_category VALUES " +(set_sql_IGHC.substring(1)) ;
	repo.games_has_category_save(set_sql_add_game_has_category);
	System.out.println(set_sql_add_game_has_category);


	//set sql insert os";
	String set_sql_insert_OS= "" ;
	for (String os_list : os) {
		set_sql_insert_OS = set_sql_insert_OS + ",('" + os_list  + "',"+ last_game_id  +")"  ;
			//System.out.println("INSERT INETO "+category_list);
	}
	String set_sql_add_os = "INSERT INTO Os(os_name, game_id) VALUES " +(set_sql_insert_OS.substring(1)) ;
	System.out.println(set_sql_add_os);
	repo.os_save(set_sql_add_os);
	
	
	 

	String set_sql_insert_Plat= "" ;
	for (String plat_list : plat) {
		Integer number = Integer.parseInt(plat_list.split(" ")[0]);
		String name_plate = plat_list.split(" ")[1];
		System.out.println(plat_list +" ----- " + price[number] );
		set_sql_insert_Plat = set_sql_insert_Plat + ",('" + name_plate  + "',"+ price[number] + ","+last_game_id +")"  ;
}
	String set_sql_add_Plat = "INSERT INTO Platform(name, price,game_id) VALUES " +(set_sql_insert_Plat.substring(1)) ;
	repo.plat_save(set_sql_add_Plat);
	System.out.println(set_sql_add_Plat);


	System.out.println(link_image);	
	//System.out.println(price);

return "redirect:/admin_index";
}

@GetMapping("/admin_edit")
public String admin_edit(@RequestParam("game_id") Integer game_id,HttpSession session,Model model,HttpServletResponse response) {
	Games one_games_edit = repo.findByGame_Id(game_id);
	model.addAttribute("one_games_edit", one_games_edit);
	return "/admin_edit";
}


@GetMapping("/form_admin_edit")
public String form_admin_edit(
		@RequestParam("game_id") String game_id,
		@RequestParam("game_name") String game_name,
		@RequestParam("game_content") String game_content,
		@RequestParam("deverlopBy") String deverlopBy,
		@RequestParam("distributorsBy") String distributorsBy,
		@RequestParam("link_image") String link_image
		) {
	System.out.println(game_id);
	Games one_games_edit = repo.findByGame_Id(Integer.parseInt(game_id));
	
	one_games_edit.setGame_name(game_name);
	one_games_edit.setGame_content(game_content);
	one_games_edit.setDevelopBy(deverlopBy);
	one_games_edit.setDistributorsBy(distributorsBy);
	one_games_edit.setImage(link_image);
	
	repo.edit_game(one_games_edit);

	return "redirect:/admin_index";
}

@GetMapping("/admin_delete")
public String admin_delete(@RequestParam("game_id") Integer game_id,HttpSession session,Model model,HttpServletResponse response) {
	//Games one_games_edit = repo.findByGame_Id(game_id);
	
	//model.addAttribute("one_games_edit", one_games_edit);
	repo.delete_game(game_id);
	
	return "redirect:/admin_index";
}


	
}

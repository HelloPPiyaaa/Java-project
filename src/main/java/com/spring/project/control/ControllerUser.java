package com.spring.project.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.project.model.AllRepository;
import com.spring.project.model.Comment;
import com.spring.project.model.CommentGamesUsers;
import com.spring.project.model.Users;
import com.spring.project.model.Games;
import com.spring.project.model.Games_has_categoryGame;
import com.spring.project.model.Likes;
import com.spring.project.model.Os;
import com.spring.project.model.Platform;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerUser {
	private EntityManager entityManager;

	@Autowired
	private AllRepository repo;
	
	
	private Integer update_view  ;
	
////////////////------index-----///////////////////

//	@GetMapping("/user_index_no")
//	public String user_index_no() {
//		return "/user_index_no";
//	}
	
	@GetMapping("/user_index")
	public String user_index(HttpSession session, Model model) {
		List<Games> find3Game= repo.find3_Games();
		if (session.getAttribute("status") == null) {
			model.addAttribute("set_nav","user_nav_no.jsp" );
			model.addAttribute("find3Game",find3Game);
			
			return "/user_index";
			
		}else if (session.getAttribute("status").equals("user")) {
	
			 model.addAttribute("find3Game",find3Game);
			String hello = "สวัสดีคุณ" +  (String) session.getAttribute("username");
			model.addAttribute("set_nav","user_nav_yes.jsp" );
			model.addAttribute("hello",hello );
			return "user_index";
			
		}else if (session.getAttribute("status").equals("admin")) {
			//model.addAttribute("hello","สวัสดีคุณ " );
			model.addAttribute("find3Game",find3Game);
			model.addAttribute("set_nav","admin_nav_yes.jsp" );
			return "redirect:/admin_index";
		}else {
			return "/user_index";
		}
		
		
		
	}
	
	
	
////////////////------login-----///////////////////
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	@PostMapping("/form_login")
	public String form_login(@RequestParam("username") String username, @RequestParam("password") String password,Model model, HttpSession session) {
		
		//เรียกใช้ class repository  return ค่าที่ได้ 
		Users users = repo.findByUsernameAndPassword(username, password);
	
		//เช็คว่า users ที่ได้จาก query เป็น null ไหม
		if(users == null) {
			model.addAttribute("message", "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง");
			return "/login";
		}else {
			
			//set session
			session.setAttribute("users", users);
			session.setAttribute("id", users.getUser_id());
			session.setAttribute("username", users.getUsername());
			session.setAttribute("password", users.getPassword());
			session.setAttribute("status", users.getStatus());
			
			//เช็ค status เพื่อแยกผู้ใช้งาน
			if(users.getStatus().equals("user")) {
				return "redirect:/user_index";
			}else {
				return "redirect:/admin_index";
			}
			
		}
	
	}
	

	
	
////////////////------register-----///////////////////
	@GetMapping("/register")
	public String register() {
		return "/register";
	}
	
	@GetMapping("/form_register")
	public String form_register(@ModelAttribute Users users,Model model,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("password2") String password2) {
	boolean password_validate  ;
		if(password.equals(password2)) {
			password_validate = true ;
		}else {
			password_validate = false ;
			//model.addAttribute("password_validate","password ไม่ตรงกัน" );
		}
		
		Users check_username = repo.findByUsername(username);
		
		
		if(check_username==null & password_validate == true ) {
			repo.save(users);
			return "/login";
	
		}else if (check_username==null & password_validate == false ) {
			String[ ] message = {"ชื่อผู้ใช้นี้สามารถใช้ได้",username,"green", "รหัสผ่านไม่ตรงกัน","red"};
			model.addAttribute("message",message);
			return "/register";
			
		}else if (check_username!=null & password_validate == true ) {
			String[ ] message = {"มีชื่อผู้ใช้นี้แล้ว",username,"red", "รหัสผ่านตรงกัน","green"};
			model.addAttribute("message",message);
			return "/register";
			
		}else if (check_username!=null & password_validate == false ) {
			String[ ] message = {"มีชื่อผู้ใช้นี้แล้ว",username,"red","รหัสผ่านไม่ตรงกัน","red"};
			model.addAttribute("message",message);
			return "/register";
		}else {
			return "/error";
		}
		
		
		//return "/register";
//		if(check_username.getUsername().equals(username)) {
//			return "/register";
//		}else {
//			UsersRepo.save(users);
//			return "/index";
//		}
		
	}
	
	
	@GetMapping("/user_AllGame")
	public String user_AllGame(Model model,HttpServletResponse response,HttpSession session) {
		//return "/user_AllGame";
		
		List<Games> game_all = repo.findAll_Games();
		model.addAttribute("game_all", game_all);
		System.out.println(game_all.get(0));
		
		if (session.getAttribute("status") == null) {
			model.addAttribute("set_nav","user_nav_no.jsp" );
			
			return "/user_AllGame";
			
		}else if (session.getAttribute("status").equals("user")) {
			//String hello = "สวัสดีคุณ" +  (String) session.getAttribute("username");
			model.addAttribute("set_nav","user_nav_yes.jsp" );
			
			
			return "user_AllGame";
			
		}else if (session.getAttribute("status").equals("admin")) {
			//model.addAttribute("hello","สวัสดีคุณ " );
			model.addAttribute("set_nav","admin_nav_yes.jsp" );
			return "admin_index";
		}else {
			return "/user_AllGame";
		}
	}
	
	
	@GetMapping("/user_OneGame") 
	public String oneGame(@RequestParam("game_id") Integer game_id,@RequestParam("icon") String icon, Model model,HttpServletResponse response,HttpSession session,@ModelAttribute Comment comment,@RequestParam("action") String action) { 
		
		//save comment
		if(action.equals("save_comment")) {
			repo.save_formComment(comment);
		}
		
		//ถ้ามีการกดปุ่มไลค์ (action == like)
		if(action.equals("like")) {
			// System.out.println("---------------------------------------------------LIKE " + likes.getLike_YN());
			 Likes likes =  repo.findByGame_idAndUser_id(game_id, (Integer)(session.getAttribute("id")));
			 if(likes == null) {
				 //repo.like_add((Integer)(session.getAttribute("id")), game_id);
				 Likes insert_like = new Likes();
				 insert_like.setLike_YN("Y");
				 insert_like.setUser_id((Integer)(session.getAttribute("id")));
				 insert_like.setGame_id(game_id);
				 repo.like_add(insert_like);
				 
			 }else {
				 if(likes.getLike_YN().equals("Y")) {
					 likes.setLike_YN("N");
					 repo.save_update_like(likes);
					 
				 }else if(likes.getLike_YN().equals("N")) {
					 likes.setLike_YN("Y");
					 repo.save_update_like(likes);
				 }else {
					
				 }
			 }
			
			 
			
		}else {
			
		}
		
		
		
		
		Games one_games = repo.findByGame_Id(game_id);
		
		List <Platform> platform = repo.findPlatformByGame_Id(game_id);
		System.out.println(platform);
		
		List<CommentGamesUsers>  all_comment = repo.AllComment(game_id);
		
		
		List<Likes> check_like = repo.findLikeByGame_idAndByUser_id_Y(game_id,(Integer) (session.getAttribute("id")));
		
		List <Games_has_categoryGame> list_category = repo.findCategoryBYGame_id(game_id);
		
		List <Os> list_os = repo.findOsByGame_Id(game_id);
		
		
		//update view
			update_view = one_games.getGame_view();
			update_view+=1;
			one_games.setGame_view(update_view);
			repo.save_update_view(one_games);
			
			
			System.out.println("comment----->" + action);
			
		
		System.out.println(list_category);
		//System.out.println("TEST-------------"+(session.getAttribute("id")) );
		
		//เช็ค user คนปัจจุบันว่า ไลค์เกมหรือยัง
		String Like_yes = "" ;
		if(check_like.size() == 1 ) {
			//รูปกดหัวใจแล้ว
			 Like_yes = "https://cdn-icons-png.flaticon.com/512/2589/2589175.png" ;
		}else {
			//รูปยังไม่กดหัวใจแล้ว
			Like_yes = "https://cdn-icons-png.flaticon.com/512/2589/2589197.png" ;
		}
		System.out.println(check_like.size());
		//System.out.println("------------->" + all_comment);
		
		if (session.getAttribute("status") == null) {
			model.addAttribute("set_nav","user_nav_no.jsp" );
			model.addAttribute("one_games", one_games);
			model.addAttribute("all_comment", all_comment);
			
			List<Likes>  all_likes = repo.findLikeByGame_id(game_id);
			model.addAttribute("all_like", all_likes.size());
			model.addAttribute("Like_yes", Like_yes);
			
			model.addAttribute("platform",platform );
			model.addAttribute("list_category",list_category);
			model.addAttribute("list_os",list_os);
			return "/user_OneGame";
			
		}else if (session.getAttribute("status").equals("user")) {
			//String hello = "สวัสดีคุณ" +  (String) session.getAttribute("username");
			model.addAttribute("set_nav","user_nav_yes.jsp" );
			model.addAttribute("one_games", one_games);
			model.addAttribute("all_comment", all_comment);
			
			List<Likes>  all_likes = repo.findLikeByGame_id(game_id);
			model.addAttribute("all_like", all_likes.size());
			model.addAttribute("Like_yes", Like_yes);
			model.addAttribute("platform",platform );
			model.addAttribute("list_category",list_category);
			model.addAttribute("list_os",list_os);
			//เช็คว่าเป็น icon กดหัวใจแล้ว
//			if(icon.equals("https://cdn-icons-png.flaticon.com/512/2589/2589175.png")) {
//				
//			}else {
//				
//			}
			
			
			
			
			return "user_OneGame";
			
		}else if (session.getAttribute("status").equals("admin")) {
			//model.addAttribute("hello","สวัสดีคุณ " );
			
			model.addAttribute("set_nav","admin_nav_yes.jsp" );
			model.addAttribute("one_games", one_games);
			
			List<Likes>  all_likes = repo.findLikeByGame_id(game_id);
			model.addAttribute("all_like", all_likes.size());
			model.addAttribute("Like_yes", Like_yes);
			model.addAttribute("plateform",platform );
			model.addAttribute("list_category",list_category);
			model.addAttribute("list_os",list_os);
			return "admin_index";
		}else {
			
			return "/error";
		}
	
		//นับ

		

		//return "/user_OneGame";
	}
	
	
//	@GetMapping("/update_like")
//	public String update_like(@RequestParam("icon") String icon,@RequestParam("game_id") Integer game_id,HttpSession session) {
//		//List<Likes> check_like = repo.findLikeByGame_idAndByUser_id(game_id,(Integer) (session.getAttribute("user_id")));
//		//Likes action_update = repo.save_update_like(null)
//		//String Like_yes = "" ;
//		System.out.println(game_id);
//		//รูปกดหัวใจแล้ว
//		if(icon.equals("https://cdn-icons-png.flaticon.com/512/2589/2589175.png")) {
//			
//			
//		}else {
//			//รูปยังไม่กดหัวใจแล้ว
//			
//		}
//	return "redirect:/user_OneGame&game_id=1";
//}
	
	@GetMapping("/form_comment")
	public String form_comment(@ModelAttribute Comment comment) {
		repo.save_formComment(comment);
		 
		
		//return "user_index" ;
		return "redirect:/user_OneGame" ;
	}
	
	
	@GetMapping("/user_profile")
	public String user_profile() {
		return "/user_profile";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate(); // Invalidate session
		//model.addAttribute("set_nav", "nav_user_login_no");
		return "login"; // Redirect to login page
	}
	
	
	

	
	
	
}

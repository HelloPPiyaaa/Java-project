package com.spring.project.model;
import java.util.List;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class AllRepository {

	@PersistenceContext
	private EntityManager entityManager;

	
////////////////------login-----//////////////////
	//เช็ค user name ในฐานข้อมูล 
	public Users findByUsername(String username) {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM users WHERE username = ? ", Users.class);
			query.setParameter(1, username);
			Users result = (Users) query.getSingleResult();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	//เช็ค user name และ password ที่ login เข้ามา
	public Users findByUsernameAndPassword(String username, String password) {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM users WHERE username = ? AND password = ?",Users.class);
			query.setParameter(1, username);
			query.setParameter(2, password);
			return (Users) query.getSingleResult();
		}catch (Exception e) {
			return null;
		}
		
	}

	
	// save register
	@Transactional
	public Users save(Users users) {
		entityManager.persist(users); 
		return users;
	}
	
	
	//ค้นหาเกมทั้งหมด
	public List<Games> findAll_Games() {
		Query query = entityManager.createQuery("from Games");
		return query.getResultList();
	}
	
	//ค้นหาเกมทั้งหมด 3 อันดับเรียงตามยอดเข้าชมสูงสุด
	public List<Games> find3_Games() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Games ORDER BY game_view DESC limit 3 ; ");
		return query.getResultList();
	}

	//ค้นหาเกมโดยใช้ game_id
	public Games findByGame_Id(Integer game_id) {
		return entityManager.find(Games.class, game_id); 
	}
	
	
	public  List <Platform> findPlatformByGame_Id(Integer game_id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM Platform WHERE game_id = ? ");
		query.setParameter(1, game_id);
		return query.getResultList();
	}

	public  List <Games_has_categoryGame> findCategoryBYGame_id(Integer game_id) {
		Query query = entityManager.createNativeQuery(
				"SELECT games_has_category.game_id ,category.category_name\r\n"
				+ "FROM games_has_category \r\n"
				+ "INNER JOIN category ON (games_has_category.category_id=category.category_id ) \r\n"
				+ "WHERE games_has_category.game_id = ?\r\n"
				+ ";");
		query.setParameter(1, game_id);
		return query.getResultList();
	}
	
	
	public  List <Os> findOsByGame_Id(Integer game_id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM Os WHERE game_id = ? ");
		query.setParameter(1, game_id);
		return query.getResultList();
	}
	
	
	
	
	//หาจำนวนไลค์ โดยนับ ตามจำนวนตามแถวที่ query ได้
	public List <Likes> findLikeByGame_id(Integer game_id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM Likes WHERE game_id = ? AND like_YN = 'Y' ");
		query.setParameter(1, game_id);
		//List<CommentGamesUsers>  result =
		return query.getResultList();
		//return entityManager.find(Likes.class, game_id); 
	}
	
	//เช็ค ถ้า likeYN = Y 
	public List <Likes> findLikeByGame_idAndByUser_id_Y(Integer game_id,Integer user_id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM Likes WHERE game_id = ? AND user_id = ? AND like_YN = ?");
		query.setParameter(1, game_id);
		query.setParameter(2, user_id);
		query.setParameter(3, "Y" );
		//List<CommentGamesUsers>  result =
		return query.getResultList();
		//return entityManager.find(Likes.class, game_id); 
	}
	
	//เช็ค user name ในฐานข้อมูล 
	public Likes findByGame_idAndUser_id(Integer game_id,Integer user_id) {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM Likes WHERE game_id = ? AND user_id = ?", Likes.class);
			query.setParameter(1, game_id);
			query.setParameter(2, user_id);
			Likes result = (Likes) query.getSingleResult();
			//System.out.println(result);
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	@Transactional
	public Games save_update_view(Games games) {
		entityManager.persist(games); // insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
		return games;
	}
	
	
//	public Likes save_update_like(Integer game_id) {
//		return entityManager.find(Games.class, game_id); // ค ้นหา Customer ตาม id
//	}
	
	@Transactional
	public Likes save_update_like(Likes like) {
		entityManager.persist(like); // insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
		return like;
	}
	
	//insert like
//	@Transactional
//	public Likes like_add(Integer user_id,Integer game_id) {
//		//String sql = "INSERT INTO "
//		Query query = entityManager.createNativeQuery("INSERT INTO Likes(Like_YN,user_id,game_id) VALUES (?,?,?)");
//		query.setParameter(1, "Y");
//		query.setParameter(2, user_id);
//		query.setParameter(3,game_id );
//		query.executeUpdate();
//		return null;
//	}
	
	@Transactional
	public Likes like_add(Likes like) {
		entityManager.persist(like); // insert กรณีไม่มีค่า id ใน object หรือ update กรณีมีค่า id ใน object
		return like;
	}
	
	
	
	public List<CommentGamesUsers>AllComment(Integer game_id) {
		System.out.println("----------------------------------"+game_id);
		try {
			String sql = "SELECT comment.game_id,users.username,comment.comment_content\r\n"
					+ "FROM comment \r\n"
					+ "INNER JOIN users ON (users.user_id = comment.user_id) \r\n"
					+ "where comment.game_id = ?" ;
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, game_id);
			//List<CommentGamesUsers>  result =
			
			return query.getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// form_comment
	@Transactional
	public Comment save_formComment(Comment comment) {
		entityManager.persist(comment); 
		return comment;
	}
	
	
	//-----------------------------------------------------Admin-----------------------------------------------------------//
	
	//แสดงเกมทั้งหมด แอดมิน
	public List<Games> findAll_Games_Admin() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Games ;");
		return query.getResultList();
	}
	
	
	// form_add_game
	@Transactional
	public Games add_game(Games games) {
		entityManager.persist(games); 
		return games;
	}
	
	//ค้าหา game_id ล่าสุด ที่พึ่งเพิ่มไป
	public Games find_latest_game_id() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Games WHERE game_id =  (SELECT Max(game_id) FROM Games) ;",Games.class);
		return (Games) query.getSingleResult();
	}
	
	
	// เพิ่มข้อมูลประเภทของเกม
	@Transactional
	public Games_has_category add_has_category(Games_has_category games_has_category) {
		entityManager.persist(games_has_category); 
		return games_has_category;
	}
	
	//add Games_has_category
	@Transactional
	public Games_has_category games_has_category_save(String sql) {
		Query query = entityManager.createNativeQuery(sql);
		query.executeUpdate();
		return null;
	}
	
	//add os
	@Transactional
	public Os os_save(String sql) {
		Query query = entityManager.createNativeQuery(sql);
		query.executeUpdate();
		return null;
	}
	
	//add plat
	@Transactional
	public Os plat_save(String sql) {
		Query query = entityManager.createNativeQuery(sql);
		query.executeUpdate();
		return null;
	}
	
	// form_edit_game
	@Transactional
	public Games edit_game(Games games) {
		entityManager.persist(games); 
		return games;
	}
	
	@Transactional
	public void delete_game(Integer id) {
		Games games = entityManager.find(Games.class, id); // ค ้นหาตาม id ทีGต ้องการลบ
	entityManager.remove(games); // เริ่มลบจริง
	}
	
	
}


package com.paipai.server.service.rest.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paipai.server.domain.Customer;
import com.paipai.server.domain.Reservation;
import com.paipai.server.domain.ReservationStatus;
import com.paipai.server.domain.Restaurant;
import com.paipai.server.domain.basic.Gender;
import com.paipai.server.domain.basic.Location;
import com.paipai.server.domain.table.Table;
import com.paipai.server.domain.table.TableCategory;
import com.paipai.server.domain.table.TableCategoryStrategy;


@Path("/queue")
public class QueueServiceMock {

	/**
	 * 到店刷二维码，申请开始排队
	 * @param id 用户ID
	 * @param count 申请就餐人数
	 * @param code 餐馆二维码
	 * @return 返回空表示申请失败，需要重试；否则返回队列情况，预估时间等等
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/{user}/{diner_count}/{bar_code}")
	public ReservationStatus requestReservation(@PathParam("user") long id, 
			@PathParam("diner_count") int count, 
			@PathParam("bar_code") String code) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(123);
		restaurant.setName("全聚德（清华科技园店）");
		restaurant.setContactPerson("刘经理");
		restaurant.setBarCode(code);
		
		Location location = new Location(1L, "北京", "北京", "海淀区", "成府路清华科技园");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, count);
		ReservationStatus rs = new ReservationStatus(reservation);
		return rs;
	}
	
	/**
	 * 返回指定排队申请详细信息
	 * @param id 申请ID
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/{id}")
	public Reservation getReservation(@PathParam("id") long id) {
		Customer customer = new Customer();
		customer.setId(10000);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(123);
		restaurant.setName("全聚德（清华科技园店）");
		restaurant.setContactPerson("刘经理");
		restaurant.setBarCode("barcode");
		
		Location location = new Location(1L, "北京", "北京", "海淀区", "成府路清华科技园");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, 8);
		reservation.setId(id);
		
		return reservation;
	}
	
	/**
	 * 返回指定餐馆的所有排队申请（按顺序）
	 * @param restaurantId 餐馆ID
	 * @return 所有申请
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/restaurant/{id}")
	public List<Reservation> getReservationsByRestaurantId(@PathParam("id") long restaurantId) {
		List<Reservation> reservationList = new ArrayList<Reservation>();
		
		Customer customer = new Customer();
		customer.setId(10000);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(restaurantId);
		restaurant.setName("全聚德（清华科技园店）");
		restaurant.setContactPerson("刘经理");
		restaurant.setBarCode("barcode");
		
		Location location = new Location(1L, "北京", "北京", "海淀区", "成府路清华科技园");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, 8);
		reservation.setId(1);

		reservationList.add(reservation);
		return reservationList;
	}
	
	/**
	 * 返回指定排队申请的状态，如预估时间等等
	 * @param reservationId 申请ID
	 * @return 排队申请的状态信息
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/{id}/status")
	public ReservationStatus getReservationStatus(@PathParam("id") long reservationId) {
		Customer customer = new Customer();
		customer.setId(1091);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(123);
		restaurant.setName("全聚德（清华科技园店）");
		restaurant.setContactPerson("刘经理");
		restaurant.setBarCode("barcode");
		
		Location location = new Location(1L, "北京", "北京", "海淀区", "成府路清华科技园");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, 5);
		reservation.setId(reservationId);
		ReservationStatus rs = new ReservationStatus(reservation);
		return rs;
	}
	
	/**
	 * 修改就餐人数
	 * @param reservationId
	 * @param count
	 * @return
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/reservation/{id}/diners/{dinerCount}")
	public ReservationStatus changeDinerCount(@PathParam("id") long reservationId, 
			@PathParam("dinerCount") int count) {
		Customer customer = new Customer();
		customer.setId(1091);
		customer.setBirthday(new Date());
		customer.setEmail("zh_bjut@163.com");
		customer.setGender(Gender.Male);
		customer.setMobilePhoneNumber("18600017039");
		customer.setNickname("Huan");
		customer.setPassword("password");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setId(123);
		restaurant.setName("全聚德（清华科技园店）");
		restaurant.setContactPerson("刘经理");
		restaurant.setBarCode("barcode");
		
		Location location = new Location(1L, "北京", "北京", "海淀区", "成府路清华科技园");
		location.setLatitude(-109.09f);
		location.setLongitude(191.09f);
		
		restaurant.setLocation(location);
		restaurant.setMobileNumber("15877619875");
		restaurant.setTelPhoneNumber("010-231231");
		restaurant.setType(null);
		
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table(TableCategory.Peer, 10));
		tables.add(new Table(TableCategory.Small, 20));
		tables.add(new Table(TableCategory.Medium, 12));
		tables.add(new Table(TableCategory.Large, 4));
		restaurant.setTables(tables);
		
		TableCategoryStrategy strategy = new TableCategoryStrategy(2, 4, 6, 10);
		restaurant.setTableStrategy(strategy);
		
		Reservation reservation = new Reservation(
				customer, restaurant, count);
		reservation.setId(reservationId);
		ReservationStatus rs = new ReservationStatus(reservation);
		return rs;
	}
}
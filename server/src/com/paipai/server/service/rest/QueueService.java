package com.paipai.server.service.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paipai.server.domain.Reservation;
import com.paipai.server.domain.ReservationStatus;

@Path("/queue")
public class QueueService {

	/**
	 * 到店刷二维码，申请开始排队
	 * @param id 用户ID
	 * @param count 申请就餐人数
	 * @param code 餐馆二维码
	 * @return 返回空表示申请失败，需要重试；否则返回队列情况，预估时间等等
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/reservation/{user}/{diner_count}/{bar_code}")
	public ReservationStatus requestReservation(@PathParam("user") long id, 
			@PathParam("diner_count") int count, 
			@PathParam("bar_code") String code) {
		return null;
	}
	
	/**
	 * 返回指定排队申请详细信息
	 * @param id 申请ID
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/reservation/{id}")
	public Reservation getReservation(@PathParam("id") long id) {
		return null;
	}
	
	/**
	 * 返回指定餐馆的所有排队申请（按顺序）
	 * @param restaurantId 餐馆ID
	 * @return 所有申请
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/reservation/restaurant/{id}")
	public List<Reservation> getReservationsByRestaurantId(@PathParam("id") long restaurantId) {
		return null;
	}
	
	/**
	 * 返回指定排队申请的状态，如预估时间等等
	 * @param reservationId 申请ID
	 * @return 排队申请的状态信息
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/reservation/{id}/status")
	public ReservationStatus getReservationStatus(@PathParam("id") long reservationId) {
		return null;
	}
	
	/**
	 * 修改就餐人数
	 * @param reservationId
	 * @param count
	 * @return
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/reservation/{id}/diners/{dinerCount}")
	public ReservationStatus changeDinerCount(@PathParam("id") long reservationId, 
			@PathParam("dinerCount") int count) {
		return null;
	}
}

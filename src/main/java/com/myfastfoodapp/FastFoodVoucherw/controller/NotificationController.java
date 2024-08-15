package com.myfastfoodapp.FastFoodVoucherw.controller;

import com.myfastfoodapp.FastFoodVoucherw.dto.NotificationDTO;
import com.myfastfoodapp.FastFoodVoucherw.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@GetMapping
	public ResponseEntity<List<NotificationDTO>> getAllNotifications() {
    	List<NotificationDTO> notifications = notificationService.getAllNotifications();
    	return new ResponseEntity<>(notifications, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id) {
    	NotificationDTO notification = notificationService.getNotificationById(id);
    	return new ResponseEntity<>(notification, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notificationDTO) {
    	NotificationDTO createdNotification = notificationService.createNotification(notificationDTO);
    	return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<NotificationDTO> updateNotification(@PathVariable Long id, @RequestBody NotificationDTO notificationDTO) {
    	NotificationDTO updatedNotification = notificationService.updateNotification(id, notificationDTO);
    	return new ResponseEntity<>(updatedNotification, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
    	notificationService.deleteNotification(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

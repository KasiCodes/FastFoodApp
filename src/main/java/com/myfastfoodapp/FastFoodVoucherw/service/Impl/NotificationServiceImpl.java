package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import com.myfastfoodapp.FastFoodVoucherw.dto.NotificationDTO;
import com.myfastfoodapp.FastFoodVoucherw.model.Notification;
import com.myfastfoodapp.FastFoodVoucherw.repository.NotificationRepository;
import com.myfastfoodapp.FastFoodVoucherw.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public List<NotificationDTO> getAllNotifications() {
    	return notificationRepository.findAll().stream()
            	.map(this::convertToDTO)
            	.collect(Collectors.toList());
	}

	@Override
	public NotificationDTO getNotificationById(Long id) {
    	Notification notification = notificationRepository.findById(id)
            	.orElseThrow(() -> new RuntimeException("Notification not found"));
    	return convertToDTO(notification);
	}

	@Override
	public NotificationDTO createNotification(NotificationDTO notificationDTO) {
    	Notification notification = convertToEntity(notificationDTO);
    	Notification savedNotification = notificationRepository.save(notification);
    	return convertToDTO(savedNotification);
	}

	@Override
	public NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO) {
    	Notification notification = notificationRepository.findById(id)
            	.orElseThrow(() -> new RuntimeException("Notification not found"));
    	notification.setMessage(notificationDTO.getMessage());
    	Notification updatedNotification = notificationRepository.save(notification);
    	return convertToDTO(updatedNotification);
	}

	@Override
	public void deleteNotification(Long id) {
    	if (!notificationRepository.existsById(id)) {
        	throw new RuntimeException("Notification not found");
    	}
    	notificationRepository.deleteById(id);
	}

	private NotificationDTO convertToDTO(Notification notification) {
    	return new NotificationDTO(notification.getId(), notification.getMessage());
	}

	private Notification convertToEntity(NotificationDTO notificationDTO) {
    	return new Notification(notificationDTO.getId(), notificationDTO.getMessage());
	}
}

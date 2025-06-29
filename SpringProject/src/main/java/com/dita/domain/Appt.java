package com.dita.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//완성 후 검사할 것
@Entity
@Table(name = "appt") // 예약
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder// 빌더 방식으로 사용
public class Appt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appt_id", nullable = false)
	private Integer apptId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Patient patient;// 환자아이디 
	
	@ManyToOne
	@JoinColumn(name = "users_id", nullable = false)
	private User doctor;// 의사 아이디
	
	@Column(name = "scheduled_at", nullable = false)
	private LocalDateTime scheduledAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status",nullable = false)
	private Status status = Status.대기;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "room")
	private String room;

}

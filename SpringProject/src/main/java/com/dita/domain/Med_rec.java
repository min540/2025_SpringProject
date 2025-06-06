package com.dita.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Entity
@Table(name = "Med_rec") // 진료기록
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder// 빌더 방식으로 사용
public class Med_rec {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "record_id", nullable = false)
	private int recordId;//진료기록 아이디
	
	@ManyToOne
	@JoinColumn(name = "users_id", nullable = false)
	private User doctor;// 의사 아이디
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;//환자 아이디
	
	@Column(name = "chief_complaint")
	private String chiefComplaint;// 증상
	
	@Column(name = "diagnosis")
	private String diagnosis;// 진단명
	
	@Column(name = "notes")
	private String notes;// 추가 메모
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;//작성 일시
	
}

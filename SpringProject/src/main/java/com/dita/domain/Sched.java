package com.dita.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="Sched")//근무 스케줄 테이블
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sched {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id", nullable = false)
	private int scheduleId;//스케줄 고유 번호
	
	@ManyToOne
	@JoinColumn(name = "users_id", nullable = false)
	private User user;// 직원 ID
	
	@Column(name = "start_time", nullable = false)
	private LocalTime startTime;// 근무 시작 시각(출근)
	
	@Column(name = "end_time", nullable = false)
	private LocalTime endTime;//근무 종료 시각(퇴근)
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private Type type;// 스케줄 유형
	
	@ElementCollection
	@CollectionTable(name = "sched_workdays", joinColumns = @JoinColumn(name = "schedule_id"))
	@Column(name = "work_day")
	private List<String> workDays;

}

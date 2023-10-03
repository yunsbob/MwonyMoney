package com.ntt.mwonimoney.domain.account.entity;

import com.ntt.mwonimoney.domain.account.model.dto.FinAccountDto;

import com.ntt.mwonimoney.domain.member.entity.Member;
import com.ntt.mwonimoney.global.common.entity.CommonEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "fin_account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FinAccount extends CommonEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fin_account_idx")
	private Long idx;

	@Column(name = "fin_account_number")
	private String number;

	@Column(name = "fin_account_fin_acno")
	private String finAcno;

	@Enumerated(EnumType.STRING)
	@Column(name = "fin_account_status")
	private FinAccountStatus status;

	@Enumerated(EnumType.STRING)
	@Column(name = "fin_account_type")
	private FinAccountType type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_idx")
	private Member member;

	@OneToMany(mappedBy = "finAccount")
	@Builder.Default
	private List<FinAccountTransaction> finAccountTransactionList = new ArrayList<>();

	public FinAccountDto convertToDto(){
		return FinAccountDto.builder()
				.idx(this.idx)
				.number(this.number)
				.status(this.status)
				.type(this.type)
				.build();
	}

	public void addMember(Member member){
		this.member = member;
//		member.addFinAccount(this);
	}
}


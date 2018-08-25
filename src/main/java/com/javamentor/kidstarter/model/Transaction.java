package com.javamentor.kidstarter.model;

import com.javamentor.kidstarter.model.user.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "fromaccount", foreignKey = @ForeignKey(name = "transaction_fromaccount_fk"))
	private Account fromAccount;

	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "toaccount", foreignKey = @ForeignKey(name = "transaction_toaccount_fk"))
	private Account toAccount;

	@Column (name = "amount")
	private Long amount;

	@Column (name = "transactiondate")
	private LocalDateTime transactionDate;

	@Enumerated (EnumType.STRING)
	private TransactionTypes transactionType;

	@Enumerated (EnumType.STRING)
	private TransactionStatus transactionStatus;

	public enum TransactionTypes {
		ADD,
		TRANSFER,
		REMOVE
	}

	public enum TransactionStatus {
		SUCCESS,
		FAILED,
		IN_PROGRESS,
		CANCELED,
		ROLLBACK
	}
}
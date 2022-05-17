package ai.jobiak.lombok.model;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = {"custId"})
//@EqualsAndHashCode
//@ReqArgsConstructor
@Data
public class Customer {

	@Setter
	@Getter
	private long custId;
	@Setter
	@Getter
	//@NonNull
	private String name;
	@Setter
	@Getter
	private double balance;
	
}

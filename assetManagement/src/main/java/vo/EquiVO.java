package vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EquiVO {
	private int equipmentId;
	private EquiTypeVO equiType;
	private EquiCompanyVO equiCompany;
	private String model;
	private String serialNo;
	private Date purchaseDate;
	private int price;
}
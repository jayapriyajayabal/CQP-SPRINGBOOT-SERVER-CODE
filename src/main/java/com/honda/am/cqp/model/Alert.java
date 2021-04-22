package  com.honda.am.cqp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alerts")
public class Alert {

	private String id;
	private String Supplier;
	private String Status;
	private String alert_test;

   public Alert() {
		
	}

	public Alert(String Supplier, String Status, String alert_test) {
		this.Supplier = Supplier;
		this.Status = Status;
		this.alert_test = alert_test; 
		
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	@Column(name = "Supplier", nullable = true)
	public String getSupplier() {
		return Supplier;
	}

	public void setSupplier(String supplier) {
		Supplier = supplier;
	}

	@Column(name = "Status", nullable = true)
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Column(name = "alert_test", nullable = true)
	public String getAlert_test() {
		return alert_test;
	}

	public void setAlert_test(String alert_test) {
		this.alert_test = alert_test;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", Supplier=" + Supplier + ", Status=" + Status + ", alert_test=" + alert_test
				+ "]";
	}
	
}

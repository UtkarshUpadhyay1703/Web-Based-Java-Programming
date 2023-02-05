package pojos;

import javax.persistence.*;

@MappedSuperclass//To tell the Hibernate that this is baseentity not to create table
public class BaseEntity {
	@Id//To tell the Hibernate that this is the pk 
	@GeneratedValue(strategy=GenerationType.IDENTITY)//for auto incrementation
	private Long Id;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

}

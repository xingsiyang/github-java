package xsy.lab3;

@Table("user")
public class User 
{
	@Column("id")
    private Integer id;

	@Column("username")
    private String username;
    
	@Column("age")
    private Integer age;

    @Column("email")
    private String email;

    @Column("telephone")
    private String telephone;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}


	public void setAge(Integer age) 
	{
		this.age = age;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}
}

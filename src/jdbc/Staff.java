package jdbc;

/**
 * @author ZTF
 * @version 创建时间：2018年7月11日 上午11:44:42 类说明
 */
public class Staff {

	private int id;
	private String name;
	private String sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}

}

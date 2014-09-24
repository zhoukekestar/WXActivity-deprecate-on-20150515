package App;

import java.io.File;
import java.util.UUID;

import com.otovc.dao._BaseDao;
import com.otovc.dao.impl._BaseDaoImpl;
import com.otovc.model.User;
import com.toomao.wx.utils.HttpRequest;

public class App {

	private static _BaseDao base = _BaseDaoImpl.getInstance();
	
	public static void main(String[] args) {
		
		//insert();
		
		/*File file = new File("D:/abc/a.jpg");
		createDir(file);*/
		/*HttpRequest
		.get("http://h.hiphotos.baidu.com/image/pic/item/6f061d950a7b02083c5ed37660d9f2d3562cc896.jpg")
		.receive(file);*/
		
		System.out.println("over");
		get();
	}
	
	public static void insert()
	{
		User user = new User();
		user.setOpenid(UUID.randomUUID().toString());
		base.add(user);
	}
	
	public static void update()
	{
		
	}
	
	public static void del()
	{
		
	}
	
	public static void get()
	{
		User a = base.findById(User.class, 666600);
		System.out.println(a.getOpenid());
	}
	
	public static void download()
	{
		
	}
	
	public static void createDir(File file)
	{
		String filename = file.getName();
		//String filePath = filename.lastIndexOf("/")
	}
}

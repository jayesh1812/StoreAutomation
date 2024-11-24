package api.endpoints;

public class Routes {

	
	public static String base_URL = "https://petstore.swagger.io/v2";
	
	public static String post_URL = base_URL+"/user/createWithList";
	public static String get_URL = base_URL+"/user/{username}";
	public static String put_URL = base_URL+"/user/{username}";
	public static String delete_URL = base_URL+"/user/{username}";
	
	
	//  API template paths
	public static String userPostTemp = System.getProperty("user.dir")+"/src/test/resources/APITemplate/userPost.txt";
	public static String userPutTemp = System.getProperty("user.dir")+"/src/test/resources/APITemplate/userPut.txt";
}

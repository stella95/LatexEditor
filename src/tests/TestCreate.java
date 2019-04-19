package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import controller.Command;
import controller.CommandsFactory;
import model.Document;
import model.DocumentManager;

public class TestCreate {
	private Document doc;
	private DocumentManager manager;
	private String info;
	private Command com;
	private CommandsFactory factory;
	private HashMap<String,Document> map;
	
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}
	
	public void setUp() throws Exception {
		doc = manager.createDocument(info);
		factory = new CommandsFactory();
		com = factory.create("CreateCommand");
		map=new HashMap<String,Document>();
	}
	
	@Test
	public void testAcceptance() {
		map=manager.getMap();
		com.execute(doc,"Article");
		assertEquals("Create fail, contents aren't equals!", map.get("Article"), doc.getContents());
	}

}
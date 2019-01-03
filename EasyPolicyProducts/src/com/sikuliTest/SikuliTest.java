package com.sikuliTest;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliTest {
	public static void main(String[] args) throws FindFailed {
		Screen s=new Screen();
		Pattern pr = new Pattern("./screenshots/Cross.PNG");
		s.click(pr);
		s.type(s, "hello");
		 }

}

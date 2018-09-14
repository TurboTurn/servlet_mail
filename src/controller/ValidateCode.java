package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateCode
 */
@WebServlet(name = "ValidateCode.do", urlPatterns = { "/ValidateCode.do" })
public class ValidateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置输出类型和浏览器不保存缓存
				response.setContentType("image/jpeg");
				response.setHeader("Cache-Control", "no-cache");

				// 创建图片对象
				int width = 60, height = 25;
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);

				Graphics g = image.getGraphics();

				// 生成随机数
				Random random = new Random();
				String s = "";
				for (int i = 0; i < 4; i++) {
					s += random.nextInt(10);
				}

				//System.out.println(s);

				// 把随机数存到Session里面，便于等下比较
				HttpSession session = request.getSession();
				session.setAttribute("code", s);

				// 随机生成颜色 Color color = new Color(255,255,255) ;
				// random.nextInt(256)的值范围是0~255
				Color color = new Color(random.nextInt(256), random.nextInt(256),
						random.nextInt(256));

				// 把随机数写到图片上
				String a = null;
				Font font = new Font(a, Font.ITALIC, 18);
				g.setColor(color);
				g.setFont(font);
				g.drawString(s, 10, height - 5);
				g.dispose(); // 关闭画笔

				// 把图片送到客户端
				ServletOutputStream output = response.getOutputStream();
				ImageIO.write(image, "JPEG", output);
				output.flush(); // 关闭输出流
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

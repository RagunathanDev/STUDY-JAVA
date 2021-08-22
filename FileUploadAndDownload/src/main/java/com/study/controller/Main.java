package com.study.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@RequestMapping(method = RequestMethod.GET, path = "/")
	private ModelAndView mainController() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	private ModelAndView uploadFile(@RequestParam("file") List<MultipartFile> files, HttpSession session) {
		if (null != files && files.size() > 0) {
			for (MultipartFile file : files) {

				String fileName = file.getOriginalFilename();
				System.out.println(fileName);
				try {
					file.transferTo(
							new File("C:\\users\\training5\\desktop" + File.separator + file.getOriginalFilename()));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return new ModelAndView("success");

	}

	@RequestMapping(path = "/download", method = RequestMethod.POST, produces = { "*/*" })
	private void downloadFile(HttpServletRequest req, HttpServletResponse res) throws IOException {

		FileInputStream in = null;
		PrintWriter out = null;

		try {

			String filename = "Test.txt";
			String filepath = "D:\\";
			out = res.getWriter();

			res.setContentType("APPLICATION/OCTET-STREAM");
			res.setHeader("Content-Disposition", "attachment; filename=\"" + "Test.txt" + "\"");
			in = new FileInputStream(filepath + filename);

			if (in != null) {

				int c;
				while ((c = in.read()) != -1)
					out.write(c);

			}
			in.close();

			out.close();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (in != null) {
				in.close();
			}

			if (out != null) {

				out.close();
			}
		}

		/*
		 * try (BufferedInputStream inputStream = new BufferedInputStream( new URL(new
		 * File(urlStr).toURI().toURL().toString()).openStream()); FileOutputStream
		 * fileOS = new
		 * FileOutputStream("C:\\Users\\training5\\Documents\\Main45.java")) { byte
		 * data[] = new byte[1024]; int byteContent; while ((byteContent =
		 * inputStream.read(data, 0, 1024)) != -1) { fileOS.write(data, 0, byteContent);
		 * } } catch (IOException e) { // handles IO exceptions }
		 */
		/*
		 * System.out.println(url); try (InputStream in = url.openStream();
		 * ReadableByteChannel rbc = Channels.newChannel(in); FileOutputStream fos = new
		 * FileOutputStream(outputFileName)) { fos.getChannel().transferFrom(rbc, 0,
		 * Long.MAX_VALUE); }
		 */

	}

}

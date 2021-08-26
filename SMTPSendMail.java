package com.cqxxty.security.admin.utils;

/**
 * 代发邮件
 * @ClassName SMTPSendMail
 * @Author lei
 * @Date 2021/8/25 11:04
 * @Version 1.0
 */
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SMTPSendMail {
    public static void main(String[] args) {
        String realAddressee  = "t260931352@tom.com"; //<- 收件人邮箱
//        String loginUsername = "260931352@qq.com"; //<- 登录邮箱，这里仅为示例
//        String loginPassword = "oabylfzkctbacajg"; //<- 16位授权密码
//        String smtpServer = "smtp.qq.com"; //<- smtp服务器地址

        String loginUsername = "15223409889@163.com"; //<- 登录邮箱，这里仅为示例
        String loginPassword = "JVNENKJFUWOIUCUQ"; //<- 16位授权密码
        String smtpServer = "smtp.163.com"; //<- smtp服务器地址

        int port = 25;

        String b64Username = Base64.getEncoder().encodeToString(loginUsername.getBytes(StandardCharsets.UTF_8));
        String b64Password = Base64.getEncoder().encodeToString(loginPassword.getBytes(StandardCharsets.UTF_8));

        try {
            Socket socket = new Socket(smtpServer, port);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //发送'helo'命令， 读取输出
            pw.println("helo " + "Stephen");
            System.out.println(bfr.readLine());

            //发送'auth login'命令
            pw.println("auth login");
            System.out.println(bfr.readLine());
            pw.println(b64Username); // 用户名base64
            System.out.println(bfr.readLine());
            pw.println(b64Password); // 授权密码base64
            System.out.println(bfr.readLine());

            //设置'mail from' 和 'rcpt to'
            pw.println("mail from:<"+loginUsername+">");
            System.out.println(bfr.readLine());
            pw.println("rcpt to:<" + realAddressee + ">");
            System.out.println(bfr.readLine());

            //设置'data'
            pw.println("data");
            System.out.println(bfr.readLine());

            /* 正文主体 */
            pw.println("subject:" + "sdfsssss"); // 主题
            // “伪造”发信人
            pw.println("from:" + "389943100@qq.com");  //格式：昵称 <显示的发件人邮箱>（伪发件人）
            pw.println("to:" + "管理员 <" + realAddressee + ">"); //指定收件人名称，有的smtp服务器可以把收件人显示的邮箱也改了
            // 这里smtp.163.com会"554 DT:SPM"退信
            pw.println("Content-Type:text/html;charset=\"utf-8\""); // 这里采用的是html类型，可换为纯文本plain类型
            pw.println();
            String text = "test";
            pw.println(text);
            pw.println();
            pw.println("."); //内容部分结束
            System.out.println(bfr.readLine());

            //发送结束，退出
            pw.println("rset");
            System.out.println(bfr.readLine());
            pw.println("quit");
            System.out.println(bfr.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

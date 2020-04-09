package com.shu.labrary.pojo.SsmPojo;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class SmsCodeProvider {
    public static SmsCodePojo createSmsCode() {
        int width=67;
        int height=23;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics=image.getGraphics();
        Random random=new Random();
        graphics.setColor(getRandColor(200,250));
        graphics.fillRect(0,0,width,height);
        graphics.setFont(new Font("Times New Roman",Font.ITALIC,20));
        graphics.setColor(getRandColor(160,200));
        for (int i=0;i<155;i++)
        {
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(12);
            int y1=random.nextInt(12);
            graphics.drawLine(x,y,x+x1,y+y1);
        }
        String sRand="";

        for (int i=0;i<4;i++)
        {
            String rand=String.valueOf(random.nextInt(10));
            sRand+=rand;
            graphics.setColor(new Color(20+random.nextInt(110)
                    ,20+random.nextInt(110),20+random.nextInt(110)));
            graphics.drawString(rand,13*i+6,16);

        }
        graphics.dispose();
        return new SmsCodePojo(sRand);
    }

    private static Color getRandColor(int fc,int bc)
    {
        Random random=new Random();
        if(fc>255) fc=255;
        if (bc>255) bc=255;

        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }


}

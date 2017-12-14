package com.NGEmobi.main;

import com.NGEmobi.dao.CommonDao;
import com.NGEmobi.model.Content;
import com.NGEmobi.model.Strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat format =new SimpleDateFormat("HH");
        String hour =format.format(date);
        System.out.println("Time:"+hour);
        switch (hour) {
            case "16":doAction(0);break;
            case "19":doAction(1);break;
            case "22":doAction(2);break;
            case "01":doAction(3);break;
            default:doAction(1);
        }
    }
    public static void  doAction(Integer index){
        CommonDao dao = new CommonDao();
        Strategy strategy = dao.selectStrategy(1);

        String nBackNewAdxBannerKey = strategy.getnBackNewAdxBannerKey();
        String nBackNewAwdxNativeKeyEcpm = strategy.getnBackNewAdxNativeKeyEcpm();






        String appName = strategy.getAppName();
        Content content = dao.selectContent(appName);
        String contentText = content.getContent();
        System.out.println(contentText);
        if(!nBackNewAdxBannerKey.isEmpty()){
            String[] bannerKeyList = nBackNewAdxBannerKey.split(";");
            contentText = ReplaceField(contentText,"n_back_new_adx_banner_key",bannerKeyList[index]);
        }
        if(!nBackNewAwdxNativeKeyEcpm.isEmpty()) {
            String[] nativeKeyEcpmList = nBackNewAwdxNativeKeyEcpm.split(";");
            contentText = ReplaceField(contentText, "n_back_new_adx_native_key_ecpm", nativeKeyEcpmList[index]);
        }
        System.out.println(contentText);

        content.setContent(contentText);
        System.out.println("AppName:"+content.getName());
        System.out.println("result:"+dao.updateContent(content));

        dao.sessionClose();

    }

    public static  String ReplaceField(String contentText,String field,String subKey){
        int fieldIndex = field.length()+"\":\"".length();
        String newContent = contentText.substring(contentText.indexOf(field) + fieldIndex);
        String Value = newContent.substring(0, newContent.indexOf("\""));
        contentText = contentText.replace("\""+field+"\":\"" + Value + "\"", "\""+field+"\":\""+subKey+"\"");
        return contentText;
    }
}

package twijava;
import twijava.net.TwiJavaHttpRequest;
import java.util.Map;
import java.util.TreeMap;
/**
 * Twitter four API token for authentication
 * @param consumerKey
 * @param consumerSecretKey
 * @param accessToken
 * @param accessTokenSecret
 */
public class TwiJava{

    private String consumerKey;
    private String consumersecretKey;
    private String accessToken;
    private String accessTokenSecret;

    private static final String TIMELINE_URL="statuses/home_timeline.json";
    private static final String USER_TIMELINE_URL="statuses/user_timeline.json";
    private static final String USER_UPDATESTATUS_URL="statuses/update.json";

    private TwiJavaHttpRequest httpRequest=new TwiJavaHttpRequest();

    public static class TwiJavaToken { //APIトークンの設定クラス

        private String ck,cks,at,ats;

        public TwiJavaToken setConsumerKey(String key){
            ck=key;
            return this;
        }
        public TwiJavaToken setConsumerSecretKey(String key){
            cks=key;
            return this;
        }
        public TwiJavaToken setAccessToken(String key){
            at=key;
            return this;
        }
        public TwiJavaToken setAccessTokenSecret(String key){
            ats=key;
            return this;
        }
        public TwiJava buildTokens(){
            return new TwiJava(ck,cks,at,ats);
        }
     }
     private TwiJava(String consumerKey,String consumersecretKey,
                    String accessToken,String accessTokenSecret) {
        this.consumerKey = consumerKey;
        this.consumersecretKey = consumersecretKey;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
     }
    public String tweet(String text) throws Exception{
        Map<String,String>data=new TreeMap<>();
        data.put("status",text);
        data.put("trim_user","1");

        if(text.length()>140){
            System.out.println("[Request Error:You cant this tweet because the content charactor over 140]");
            System.exit(0);
        }
        return httpRequest.post(USER_UPDATESTATUS_URL,data,consumerKey,accessToken,
               consumersecretKey,accessTokenSecret);
    }
    private String JsonHomeTimeline(Integer counter) throws Exception{
       Map<String,String>hometimelineData=new TreeMap<>();
       hometimelineData.put("count",counter.toString());
       hometimelineData.put("trim_user","1");

       return httpRequest.get(TIMELINE_URL,hometimelineData,consumerKey,accessToken,
               consumersecretKey,accessTokenSecret);
   }
   public void getHomeTimeLine(Integer counter) throws Exception{
        String resultRespone=JsonHomeTimeline(counter);
        System.out.println(resultRespone);
   }
   private String JsonUserTimeline(Integer counter)throws Exception{
        Map<String,String>usertimelineData=new TreeMap<>();
        usertimelineData.put("count",counter.toString());
        usertimelineData.put("trim_user","1");

        return httpRequest.get(USER_TIMELINE_URL,usertimelineData,consumerKey,accessToken,
                consumersecretKey,accessTokenSecret);
    }
    public void getUserTimeLine(Integer counter)throws Exception{
        String resultRespone=JsonUserTimeline(counter);
        System.out.println(resultRespone);
    }
}
